package com.bootcamp.demo.bc_mtr_station.service;

import java.util.List;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;

public interface StationService {
  List<StationEntity> saveAll(List<StationEntity> stationEntities);

  List<StationEntity> findStations(Long lineId);

  List<StationEntity> findStations();

  StationEntity save(StationEntity stationEntity);
  
  StationEntity save(Long lineId, StationEntity stationEntity);
}
