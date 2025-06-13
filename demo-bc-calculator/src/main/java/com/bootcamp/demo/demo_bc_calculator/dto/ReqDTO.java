package com.bootcamp.demo.demo_bc_calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ReqDTO {
  private String x;
  private String y;
  private String operation;
}
