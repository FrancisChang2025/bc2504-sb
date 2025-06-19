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
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.bc_mtr_station.dto.mapper.DTOMapper;
import com.bootcamp.demo.bc_mtr_station.dto.response.EarliestScheduleDTO;
import com.bootcamp.demo.bc_mtr_station.dto.response.EarliestScheduleDTO.TrainInfo;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;
import com.bootcamp.demo.bc_mtr_station.model.Scheme;
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
    String url = UriComponentsBuilder.newInstance()
      .scheme(Scheme.HTTPS.getName()) //
      .host(this.host) //
      .pathSegment(this.serviceVer) // ! given a slash
      .path(serviceEndpoint) //
      .queryParam("Line", line) //
      .queryParam("sta", station) //
      .build() //
      .toUriString();

    System.out.println("url:" + url);
    return this.restTemplate.getForObject(url, ScheduleDTO.class);
  }

  @Override
  public EarliestScheduleDTO getEarliestSchedule(String stationCode) {
    List<StationEntity> stationEntities =
        this.stationRepository.findByCode(stationCode);

    if (stationEntities.isEmpty()) {
      throw new RuntimeException("Invalid Station Code.");
    }
    // .orElseThrow(() -> new RuntimeException("Invalid Station Code."));

    List<TrainInfo> trainInfos = new ArrayList<>();
    for (StationEntity stationEntity : stationEntities) {
      String lineCode = stationEntity.getLineEntity().getCode();
      List<TrainInfo> infos = this.getEarliestSchedule(lineCode, stationCode);
      trainInfos.addAll(infos); // ! call MTR API
    }

    return EarliestScheduleDTO.builder() //
        .currTime(LocalDateTime.now()) //
        .sysTime(LocalDateTime.now()) //
        .currentStation(stationCode) //
        .trains(trainInfos) //
        .build();
  }

  // ! 2 times call for 2 lines
  private List<TrainInfo> getEarliestSchedule(String lineCode,
      String stationCode) {
    ScheduleDTO scheduleDTO = this.getSchedule(lineCode, stationCode);
    List<EarliestScheduleDTO.TrainInfo> allTrainInfos = new ArrayList<>();

    // ! Find earliest trains for the station
    StationSchedule stationSchedule =
        scheduleDTO.getData().get(lineCode + "-" + stationCode);

    if (stationSchedule != null) {
      List<TrainData> upTrainDatas = stationSchedule.getUpTrainDatas();
      if (upTrainDatas != null) {
        List<EarliestScheduleDTO.TrainInfo> upTrainInfos =
            this.getTrainInfos(upTrainDatas, "UP");
        allTrainInfos.addAll(upTrainInfos);
      }
      List<TrainData> downTrainDatas = stationSchedule.getDownTrainDatas();
      if (downTrainDatas != null) {
        List<EarliestScheduleDTO.TrainInfo> downTrainInfos =
            this.getTrainInfos(downTrainDatas, "DOWN");
        allTrainInfos.addAll(downTrainInfos);
      }
    }
    // Comparator<TrainData> earlierTrainFormula = (t1, t2) -> t1.getTime().compareTo(t2.getTime());
    return allTrainInfos;
  }

  private List<TrainInfo> getTrainInfos(List<TrainData> trainDatas,
      String direction) {
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
