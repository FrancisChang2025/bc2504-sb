package com.bootcamp.demo.bc_mtr_station.exception.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ErrorDTO {
  private String code; // "000001"
  private String message;
}
