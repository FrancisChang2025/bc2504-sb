package com.bootcamp.demo.bc_mtr_station.dto.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_mtr_station.dto.response.StationRespDTO;
import com.bootcamp.demo.bc_mtr_station.dto.response.EarliestScheduleDTO.TrainInfo;
import com.bootcamp.demo.bc_mtr_station.entity.LineEntity;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;
import com.bootcamp.demo.bc_mtr_station.model.dto.ScheduleDTO.StationSchedule.TrainData;

@Component
public class DTOMapper {
  public TrainInfo map(TrainData trainData, String direction) {
    return TrainInfo.builder() //
      .arrivalTime(trainData.getTime()) //
      .dest(trainData.getDest()) //
      .direction(direction) //
      .build();
  }

  public StationRespDTO map(StationEntity stationEntity) {
    return StationRespDTO.builder()  //
      .code(stationEntity.getCode()) //
      .stationDesc(stationEntity.getDescription())  //
      .lineDesc(stationEntity.getLineEntity().getDescription()) //
      .build();
  }

  public StationRespDTO map(StationEntity stationEntity,
       LineEntity lineEntity) {
    return StationRespDTO.builder()  //
      .code(stationEntity.getCode()) //
      .stationDesc(stationEntity.getDescription())  //
      .lineDesc(lineEntity.getDescription()) //
      .build();
  }
}
