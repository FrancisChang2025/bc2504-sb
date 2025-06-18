package com.bootcamp.demo.bc_mtr_station.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Builder
public class EarliestScheduleDTO {
  private LocalDateTime currTime;
  private LocalDateTime sysTime;
  private String currentStation;
  private List<TrainInfo> trains;
  
  @AllArgsConstructor
  @Getter
  @Builder
  public static class TrainInfo {
    @JsonProperty("destination")
    private String dest;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalTime;
    @Setter
    private String direction;
  }
}
