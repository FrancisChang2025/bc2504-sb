package com.bootcamp.demo.demo_bc_calculator.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class RespDTO {
  private String x;
  private String y;
  private String operation;
  private String result;
}
