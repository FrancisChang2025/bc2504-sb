package com.bootcamp.demo.bc_mtr_station.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bootcamp.demo.bc_mtr_station.model.dto.ScheduleDTO;

public interface MTROperation {
  @GetMapping(value = "/line/{lineCode}/station/{stationCode}")
  ScheduleDTO getSchedule(@PathVariable String lineCode,
    @PathVariable String stationCode);

}
