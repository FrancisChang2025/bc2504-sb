package com.bootcamp.demo.bc_mtr_station.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_mtr_station.controller.StationOperation;
import com.bootcamp.demo.bc_mtr_station.dto.mapper.DTOMapper;
import com.bootcamp.demo.bc_mtr_station.dto.request.StationReqDTO;
import com.bootcamp.demo.bc_mtr_station.dto.response.StationRespDTO;
import com.bootcamp.demo.bc_mtr_station.entity.LineEntity;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;
import com.bootcamp.demo.bc_mtr_station.entity.mapper.EntityMapper;
import com.bootcamp.demo.bc_mtr_station.service.LineService;
import com.bootcamp.demo.bc_mtr_station.service.StationService;

@RestController
public class StationController implements StationOperation {
  @Autowired
  private StationService stationService;

  @Autowired
  private LineService lineService;

  // entity -> responseDTO (DTOMapper)
  @Autowired
  private DTOMapper dtoMapper;

  @Autowired
  private EntityMapper entityMapper;

  @Override
  public List<StationRespDTO> getStationById(Long id) {
    LineEntity lineEntity = this.lineService.findById(id) //
        .orElseThrow(() -> new RuntimeException("Line ID Not Found."));

    return this.stationService.findStations(lineEntity.getId()).stream() //
        .map(se -> this.dtoMapper.map(se, lineEntity)) //
        .collect(Collectors.toList());
  }

  @Override
  public List<StationRespDTO> getStations() {
    return this.stationService.findStations().stream() //
      .map(stationEntity -> this.dtoMapper.map(stationEntity)) //
      .collect(Collectors.toList());
  }

  @Override
  public StationEntity createStationByLineId(Long lindId, StationReqDTO stationReqDTO) {
    StationEntity stationEntity = this.entityMapper.map(stationReqDTO);
    return this.stationService.save(lindId, stationEntity);
  }

  // @Override
  // public StationEntity deleteStationById(Long stationId, StationReqDTO stationReqDTO) {
  //   StationEntity stationEntity = this.entityMapper.map(stationReqDTO);
  //   return this.stationService.deleteStationById(stationId, stationReqDTO);
  // }


}
