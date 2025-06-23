package com.bootcamp.demo.demo_mtr_caller.dto;

import java.time.LocalDateTime;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class IJKDTO {
  private LocalDateTime currTime;
  private LocalDateTime sysTime;
  private String currentStation;
  private List<Train> trains;

  @Getter
  @Builder
  @AllArgsConstructor
  public static class Train {
    private String destination;
    private LocalDateTime arrivalTime;
    private String direction;
  }
}
