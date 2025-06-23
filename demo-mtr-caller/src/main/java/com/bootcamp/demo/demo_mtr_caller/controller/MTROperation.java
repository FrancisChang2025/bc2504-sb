package com.bootcamp.demo.demo_mtr_caller.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_mtr_caller.dto.IJKDTO;
import com.bootcamp.demo.demo_mtr_caller.model.ApiResp;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface MTROperation {
  // http://localhost:8081/test
  @GetMapping(value = "/test")
  ApiResp<IJKDTO> getEarliestSchedule(@RequestParam(value = "sta") String stationCode)
      throws JsonProcessingException;
}
