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

// Server start
@Component
public class AppStarRunner implements CommandLineRunner{
  @Autowired
  private LineService lineService;
  @Autowired
  private StationService stationService;

  @Override
  public void run(String... args) throws Exception {
    System.out.println("hello");
    
    // AEL
    LineEntity aelLineEntity = LineEntity.builder().code("AEL") //
        .description("Airport Express").build();

    List<StationEntity> aelStationEntities = new ArrayList<>();
    
    StationEntity hokEntity = StationEntity.builder().code("HOK") //
        .description("Hong Kong").lineEntity(aelLineEntity).build();
    StationEntity kowEntity = StationEntity.builder().code("KOW") //
        .description("Kowloon").lineEntity(aelLineEntity).build();
    StationEntity tsyEntity = StationEntity.builder().code("TSY") //
        .description("Tsing Yi").lineEntity(aelLineEntity).build();
    StationEntity airEntity = StationEntity.builder().code("AIR") //
        .description("Airport").lineEntity(aelLineEntity).build();
    StationEntity aweEntity = StationEntity.builder().code("AWE") //
        .description("AsiaWorld Expo").lineEntity(aelLineEntity).build();
    
    aelStationEntities.add(hokEntity);
    aelStationEntities.add(kowEntity);
    aelStationEntities.add(tsyEntity);
    aelStationEntities.add(airEntity);
    aelStationEntities.add(aweEntity);

    // ACL
    LineEntity aclLineEntity = 
        LineEntity.builder().code("ACL").description("Tung Chung Line").build();

    List<StationEntity> aclStationEntities = new ArrayList<>();

    aclStationEntities.add(StationEntity.builder().code("HOK") //
        .description("Hong Kong").lineEntity(aclLineEntity).build());
    aclStationEntities.add(StationEntity.builder().code("KOW") //
        .description("Kowloon").lineEntity(aclLineEntity).build());
    aclStationEntities.add(StationEntity.builder().code("OLY") //
        .description("Olympic").lineEntity(aclLineEntity).build());
    aclStationEntities.add(StationEntity.builder().code("NAC") //
        .description("Nam Cheong").lineEntity(aclLineEntity).build());
    aclStationEntities.add(StationEntity.builder().code("LAK") //
        .description("Lai King").lineEntity(aclLineEntity).build());
    aclStationEntities.add(StationEntity.builder().code("TSY") //
        .description("Tsing Yi").lineEntity(aclLineEntity).build());
    aclStationEntities.add(StationEntity.builder().code("SUN") //
        .description("Sunny Bay").lineEntity(aclLineEntity).build());
    aclStationEntities.add(StationEntity.builder().code("TUC") //
        .description("Tung Chung").lineEntity(aclLineEntity).build());

    // insert into database tables (mtr_lines and mtr_stations)
    this.lineService.save(aelLineEntity);
    this.lineService.save(aclLineEntity);
    this.stationService.saveAll(aelStationEntities);  // @Nonnull -> check if fields are null
    this.stationService.saveAll(aclStationEntities);

    // TML
    // TKL
    // EAL
    // SIL
    // TWL
    // ISL
    // KTL
    // DRL
  }
}
