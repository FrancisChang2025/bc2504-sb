package com.bootcamp.demo.bc_mtr_station.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_mtr_station.controller.MTROperation;
import com.bootcamp.demo.bc_mtr_station.dto.response.EarliestScheduleDTO;
import com.bootcamp.demo.bc_mtr_station.model.ApiResp;
import com.bootcamp.demo.bc_mtr_station.model.dto.ScheduleDTO;
import com.bootcamp.demo.bc_mtr_station.service.MTRService;

@RestController
public class MTRController implements MTROperation {
  @Autowired
  private MTRService mtrService;

  @Override
  public ApiResp<ScheduleDTO> getSchedule(String lineCode, String stationCode) {
    ScheduleDTO scheduleDTO =
        this.mtrService.getSchedule(lineCode, stationCode);
    return ApiResp.<ScheduleDTO>builder() //
        .data(scheduleDTO) //
        .build();
  }

  @Override
  public ApiResp<EarliestScheduleDTO> getEarliestSchedule(String stationCode) {
    EarliestScheduleDTO earliestScheduleDTO =
        this.mtrService.getEarliestSchedule(stationCode);
    return ApiResp.<EarliestScheduleDTO>builder() //
        .data(earliestScheduleDTO) //
        .build();
  }
}
