package com.bootcamp.demo.bc_mtr_station.entity.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_mtr_station.dto.request.StationReqDTO;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;

@Component
public class EntityMapper {
  public StationEntity map(StationReqDTO stationReqDTO) {
    return StationEntity.builder() //
      .code(stationReqDTO.getCode()) //
      .description(stationReqDTO.getDesc())//
      .build();
  }
}
