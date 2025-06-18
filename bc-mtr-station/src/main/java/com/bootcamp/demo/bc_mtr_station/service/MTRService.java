package com.bootcamp.demo.bc_mtr_station.service;

import com.bootcamp.demo.bc_mtr_station.dto.response.EarliestScheduleDTO;
import com.bootcamp.demo.bc_mtr_station.model.dto.ScheduleDTO;

public interface MTRService {
  // call api
  // ScheduleDTO
  ScheduleDTO getSchedule(String line, String station);

  // earliest schedule
  EarliestScheduleDTO getEarliestSchedule(String station);
}
