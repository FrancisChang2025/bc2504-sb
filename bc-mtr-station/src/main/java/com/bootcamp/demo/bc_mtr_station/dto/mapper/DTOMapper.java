package com.bootcamp.demo.bc_mtr_station.dto.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_mtr_station.dto.response.StationRespDTO;
import com.bootcamp.demo.bc_mtr_station.entity.LineEntity;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;

@Component
public class DTOMapper {
  public StationRespDTO map(StationEntity stationEntity) {
    return StationRespDTO.builder()  //
      .code(stationEntity.getCode()) //
      .stationDesc(stationEntity.getDescription())  //
      .lineDesc(stationEntity.getLineEntity().getDescription()) //
      .build();
  }

  public StationRespDTO map(StationEntity stationEntity, LineEntity lineEntity) {
    return StationRespDTO.builder()  //
      .code(stationEntity.getCode()) //
      .stationDesc(stationEntity.getDescription())  //
      .lineDesc(lineEntity.getDescription()) //
      .build();
  }
}
