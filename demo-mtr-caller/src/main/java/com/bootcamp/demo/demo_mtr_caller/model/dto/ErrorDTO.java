package com.bootcamp.demo.demo_mtr_caller.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class ErrorDTO {
  private String code; // "000001"
  private String message;
}
