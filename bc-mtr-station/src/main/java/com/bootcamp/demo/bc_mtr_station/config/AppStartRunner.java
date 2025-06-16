package com.bootcamp.demo.bc_mtr_station.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_mtr_station.entity.LineEntity;
import com.bootcamp.demo.bc_mtr_station.entity.StationEntity;
import com.bootcamp.demo.bc_mtr_station.service.LineService;
import com.bootcamp.demo.bc_mtr_station.service.StationService;

// Server Start
@Component
public class AppStartRunner implements CommandLineRunner {
  @Autowired
  private LineService lineService;
  @Autowired
  private StationService stationService;

  @Override
  public void run(String... args) throws Exception {
    LineEntity aelEntity = LineEntity.builder().code("AEL").description("Airport Express").build();

    List<StationEntity> stationEntities = new ArrayList<>();

    StationEntity hokEntity = 
      StationEntity.builder().code("HOK").description("Hong Kong").build();
    StationEntity kowEntity = 
      StationEntity.builder().code("KOW").description("Kowloon").build();
    StationEntity tsyEntity = 
      StationEntity.builder().code("TSY").description("Tsing Yi").build();
    StationEntity airEntity = 
      StationEntity.builder().code("AIR").description("Airport").build(); 
    StationEntity aweEntity = 
      StationEntity.builder().code("AWE").description("AsiaWorld Expo").build();

    stationEntities.add(hokEntity);
    stationEntities.add(kowEntity);
    stationEntities.add(tsyEntity);
    stationEntities.add(airEntity);
    stationEntities.add(aweEntity);

    this.lineService.save(aelEntity);
    this.stationService.saveAll(stationEntities);  // @Nonnull -> check if fields are null
  }
}
