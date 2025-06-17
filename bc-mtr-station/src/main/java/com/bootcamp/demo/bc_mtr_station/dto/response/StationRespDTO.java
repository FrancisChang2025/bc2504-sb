package com.bootcamp.demo.bc_mtr_station.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class StationRespDTO {
  @JsonProperty(value = "stationCode")
  private String code;
  private String stationDesc;
  private String lineDesc;
}
