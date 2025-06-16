package com.bootcamp.demo.bc_mtr_station.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;
import com.bootcamp.demo.bc_mtr_station.service.StationService;

@Service
public class StationServiceImpl implements StationService {
  @Autowired
  private com.bootcamp.demo.bc_mtr_station.repository.StationRepository stationRepository;

  @Override
  public List<StationEntity> saveAll(List<StationEntity> stationEntities) {
    return this.stationRepository.saveAll(stationEntities);
  }
}
