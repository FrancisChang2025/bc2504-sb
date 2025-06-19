package com.bootcamp.demo.demo_mtr_caller.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_mtr_caller.model.dto.ABCDTO;


public interface MTROperation {
  // http://localhost:8081/test
  @GetMapping(value = "/test")
  ABCDTO getEarliestSchedule(@RequestParam(value = "sta") String stationCode);
}
