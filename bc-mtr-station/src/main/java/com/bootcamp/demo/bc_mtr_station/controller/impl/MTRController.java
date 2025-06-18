package com.bootcamp.demo.bc_mtr_station.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_mtr_station.controller.MTROperation;
import com.bootcamp.demo.bc_mtr_station.dto.response.EarliestScheduleDTO;
import com.bootcamp.demo.bc_mtr_station.model.dto.ScheduleDTO;
import com.bootcamp.demo.bc_mtr_station.service.MTRService;

@RestController
public class MTRController implements MTROperation {
  @Autowired
  private MTRService mtrService;

  @Override
  public ScheduleDTO getSchedule(String lineCode, String stationCode) {
    return this.mtrService.getSchedule(lineCode, stationCode);
  }

  @Override
  public EarliestScheduleDTO getEarliestSchedule(String stationCode) {
    return this.getEarliestSchedule(stationCode);
  }
}
