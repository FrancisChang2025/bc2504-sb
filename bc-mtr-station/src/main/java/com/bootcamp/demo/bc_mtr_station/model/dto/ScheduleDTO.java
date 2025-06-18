package com.bootcamp.demo.bc_mtr_station.model.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ScheduleDTO {
  @JsonProperty(value = "sys_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime systemTime;

  @JsonProperty(value = "curr_time")
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  private LocalDateTime currTime;

  // private ScheduleData data;
  private Map<String, StationSchedule> data;

  @JsonProperty(value = "isdelay")
  private String isDelay;
  private Integer status;
  private String message;

  @Getter
  public static class StationSchedule {
    @JsonProperty(value = "sys_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime systemTime;

    @JsonProperty(value = "curr_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime currTime;

    @JsonProperty(value = "UP")
    private List<TrainData> upTrainDatas;
    @JsonProperty(value = "DOWN")
    private List<TrainData> downTrainDatas;

    @Getter
    public static class TrainData {
      private String seq;
      private String dest;
      private String plat;
      @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
      private LocalDateTime time;
      private String ttnt;
      private String valid;
      private String source;
    }
  }
}
