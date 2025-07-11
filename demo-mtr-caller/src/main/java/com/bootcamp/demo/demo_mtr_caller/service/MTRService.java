package com.bootcamp.demo.demo_mtr_caller.service;

import com.bootcamp.demo.demo_mtr_caller.model.dto.ABCDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface MTRService {
  // ! purpose: call http://localhost:8080/earliestschedule
  ABCDTO getEarliestSchedule(String stationCode) throws JsonProcessingException;
}
