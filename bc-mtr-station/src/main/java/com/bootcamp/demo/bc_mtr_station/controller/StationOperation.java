package com.bootcamp.demo.bc_mtr_station.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootcamp.demo.bc_mtr_station.dto.request.StationReqDTO;
import com.bootcamp.demo.bc_mtr_station.dto.response.StationRespDTO;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;

public interface StationOperation {
  // Get stations by line id
  @GetMapping(value = "/line/{id}/station")
  List<StationRespDTO> getStationById(@PathVariable(value = "id") Long lineId);
  
  // Get stations
  @GetMapping(value = "stations")
  List<StationRespDTO> getStations();

  // Post a new Station by line id
  @PostMapping(value = "/line/{id}/station")
  StationEntity createStationByLineId( //
    @PathVariable(value = "id") Long lineId, 
      @RequestBody StationReqDTO stationReqDTO);

  // delete station by station id
  @DeleteMapping(value = "/station/{id}")
  StationEntity deleteStationById(
    @PathVariable(value = "id") Long stationId);
}
