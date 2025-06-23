package com.bootcamp.demo.demo_mtr_caller.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@NoArgsConstructor
public class ABCDTO {
  // @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
  private LocalDateTime currTime;
  // @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSSSS")
  private LocalDateTime sysTime;
  private String currentStation;
  private List<Train> trains;

  @AllArgsConstructor
  @Getter
  @NoArgsConstructor
  public static class Train {
    private String destination;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime arrivalTime;
    private String direction;
  }
}
