package com.bootcamp.demo.bc_mtr_station.service;

import com.bootcamp.demo.bc_mtr_station.model.dto.ScheduleDTO;

public interface MTRService {
  ScheduleDTO getSchedule(String line, String station);
}
