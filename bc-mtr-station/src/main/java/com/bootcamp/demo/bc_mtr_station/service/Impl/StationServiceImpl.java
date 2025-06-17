package com.bootcamp.demo.bc_mtr_station.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.bc_mtr_station.entity.LineEntity;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;
import com.bootcamp.demo.bc_mtr_station.repository.LineRepository;
import com.bootcamp.demo.bc_mtr_station.repository.StationRepository;
import com.bootcamp.demo.bc_mtr_station.service.StationService;

@Service
public class StationServiceImpl implements StationService {
  @Autowired
  private StationRepository stationRepository;
  @Autowired
  private LineRepository lineRepository;
  
  @Override
  public List<StationEntity> saveAll(List<StationEntity> stationEntities) {
    return this.stationRepository.saveAll(stationEntities);
  }

  @Override
  public List<StationEntity> findStations(Long lineId) {
    return this.stationRepository.findByLineEntityId(lineId);
  }

  @Override
  public List<StationEntity> findStations() { 
    return this.stationRepository.findAll();
  }

  @Override
  public StationEntity save(StationEntity stationEntity) {
    return this.stationRepository.save(stationEntity);
  }
  
  @Override
  public StationEntity save(Long lineId, StationEntity stationEntity) {
    // Find LineEntity by lineId
    LineEntity lineEntity = this.lineRepository.findById(lineId) //
        .orElseThrow(() -> new RuntimeException("Line ID not found."));
    // set FK for StationEntity (LineEntity)
    stationEntity.setLineEntity(lineEntity);
    // save StationEntity
    return this.stationRepository.save(stationEntity);
  }
}
