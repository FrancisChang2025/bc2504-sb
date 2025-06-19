package com.bootcamp.demo.bc_mtr_station.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.bc_mtr_station.dto.response.EarliestScheduleDTO;
import com.bootcamp.demo.bc_mtr_station.model.ApiResp;
import com.bootcamp.demo.bc_mtr_station.model.dto.ScheduleDTO;

public interface MTROperation {
  @GetMapping(value = "/line/{lineCode}/station/{stationCode}")
  ApiResp<ScheduleDTO> getSchedule(@PathVariable String lineCode,
    @PathVariable String stationCode);

  // ! Exercise 4: Part 2
  // http://localhost:8080/earliestschedule?sta=TKO
  @GetMapping(value = "/earliestschedule")
  ApiResp<EarliestScheduleDTO> getEarliestSchedule(
      @RequestParam("sta") String stationCode);
}
