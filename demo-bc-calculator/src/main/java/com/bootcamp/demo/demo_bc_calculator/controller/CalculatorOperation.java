package com.bootcamp.demo.demo_bc_calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_bc_calculator.dto.ReqDTO;
import com.bootcamp.demo.demo_bc_calculator.dto.RespDTO;

public interface CalculatorOperation {
  @GetMapping(value = "/operation")
  RespDTO operate1(@RequestParam String x, @RequestParam String y,
      @RequestParam String operation);

  @GetMapping(value = "/operation/{x}/{y}/{operation}")
  RespDTO operate2(@PathVariable String x, @PathVariable String y,
      @PathVariable String operation);

  @PostMapping(value = "/operation")
  RespDTO operate3(@RequestBody ReqDTO reqDTO);
}
