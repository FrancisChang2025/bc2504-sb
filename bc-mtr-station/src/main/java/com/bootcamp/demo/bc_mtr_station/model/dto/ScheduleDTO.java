package com.bootcamp.demo.bc_mtr_station.model.dto;

import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class ScheduleDTO {
  @JsonProperty(value = "sys_time")
  private String systemTime;
  @JsonProperty(value = "curr_time")
  private String currTime;

  // private ScheduleData data;
  private Map<String, StationSchedule> data;

  @JsonProperty(value = "isdelay")
  private String isDelay;
  private Integer status;
  private String message;

  @Getter
  public static class StationSchedule {
  @JsonProperty(value = "sys_time")
  private String systemTime;
  @JsonProperty(value = "curr_time")
  private String currTime;
  @JsonProperty(value = "UP")
  private List<TrainData>upTrainDatas;
  @JsonProperty(value = "DOWN")
  private List<TrainData>downTrainDatas;

  @Getter
  public static class TrainData {
    private String seq;
    private String dest;
    private String plat;
    private String time;
    private String ttnt;
    private String valid;
    private String source;
  }
  }

}
