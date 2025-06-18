package com.bootcamp.demo.bc_mtr_station.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.bc_mtr_station.dto.mapper.DTOMapper;
import com.bootcamp.demo.bc_mtr_station.dto.response.EarliestScheduleDTO;
import com.bootcamp.demo.bc_mtr_station.dto.response.EarliestScheduleDTO.TrainInfo;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;
import com.bootcamp.demo.bc_mtr_station.model.dto.ScheduleDTO;
import com.bootcamp.demo.bc_mtr_station.model.dto.ScheduleDTO.StationSchedule;
import com.bootcamp.demo.bc_mtr_station.model.dto.ScheduleDTO.StationSchedule.TrainData;
import com.bootcamp.demo.bc_mtr_station.repository.StationRepository;
import com.bootcamp.demo.bc_mtr_station.service.MTRService;

@Service
public class MTRServiceImpl implements MTRService {
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private StationRepository stationRepository;
  @Autowired
  private DTOMapper dtoMapper;


  @Value("${service-url.mtr.host}")
  private String host;

  @Value("${service-url.mtr.api.mtr-schedule.version}")
  private String serviceVer;

  @Value("${service-url.mtr.api.mtr-schedule.endpoint}")
  private String serviceEndpoint;


  @Override
  public ScheduleDTO getSchedule(String line, String station) {
    String url = "https://" + this.host + this.serviceVer + this.serviceEndpoint
        + "?line=" + line + "&sta=" + station;
    return this.restTemplate.getForObject(url, ScheduleDTO.class);
  }

  @Override
  public EarliestScheduleDTO getEarliestSchedule(String stationCode) {
    StationEntity stationEntity = this.stationRepository.findByCode(stationCode)
        .orElseThrow(() -> new RuntimeException("Invalid Station Code."));

    String lineCode = stationEntity.getLineEntity().getCode();
    return this.getEarliestSchedule(lineCode, stationCode);
  }

  private EarliestScheduleDTO getEarliestSchedule(String lineCode,
      String stationCode) {
    ScheduleDTO scheduleDTO = this.getSchedule(lineCode, stationCode);

    // ! Find earliest trains for the station
    StationSchedule stationSchedule =
        scheduleDTO.getData().get(lineCode + "-" + stationCode);
    List<TrainData> upTrainDatas = stationSchedule.getUpTrainDatas();
    List<TrainData> downTrainDatas = stationSchedule.getDownTrainDatas();

    // Comparator<TrainData> earlierTrainFormula = (t1, t2) -> t1.getTime().compareTo(t2.getTime());
    List<EarliestScheduleDTO.TrainInfo> upTrainInfos =
        this.getTrainInfos(upTrainDatas, "UP");
    List<EarliestScheduleDTO.TrainInfo> downTrainInfos =
        this.getTrainInfos(downTrainDatas, "DOWN");

    List<EarliestScheduleDTO.TrainInfo> allTrainInfos = new ArrayList<>();
    allTrainInfos.addAll(upTrainInfos);
    allTrainInfos.addAll(downTrainInfos);

    return EarliestScheduleDTO.builder() //
        .currTime(LocalDateTime.now()) //
        .sysTime(LocalDateTime.now()) //
        .currentStation(stationCode) //
        .trains(allTrainInfos) //
        .build();
  }

  private List<TrainInfo> getTrainInfos(
      List<TrainData> trainDatas, String direction) {
    Map<String, TrainData> eTrainMap = new HashMap<>();
    for (TrainData trainData : trainDatas) {
      TrainData trainInMap = eTrainMap.get(trainData.getDest());
      if (trainInMap == null) {
        eTrainMap.put(trainData.getDest(), trainData);
      } else {
        if (trainData.getTime().isBefore(trainInMap.getTime())) {
          eTrainMap.put(trainData.getDest(), trainData);
        }
      }
    }
    return eTrainMap.entrySet().stream() //
        .map(entry -> this.dtoMapper.map(entry.getValue(), direction))
        .collect(Collectors.toList());
  }
}
