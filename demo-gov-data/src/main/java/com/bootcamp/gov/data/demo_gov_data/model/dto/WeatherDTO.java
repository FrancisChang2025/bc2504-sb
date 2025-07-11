package com.bootcamp.gov.data.demo_gov_data.model.dto;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

// https://data.weather.gov.hk/weatherAPI/opendata/weather.php?dataType=fnd&lang=en
@AllArgsConstructor
@Getter
public class WeatherDTO {
  private String generalSituation;

  @JsonProperty(value = "weatherForecast")
  private List<Forecast> forecasts;

  private OffsetDateTime upDateTime; // String -> LocalDateTime/OffsetDateTime deserialization

  private Temperature2 seaTemp;

  private List<Temperature3> soilTemp;

  @AllArgsConstructor
  @Getter
  private static class Temperature2 {
    private String place;
    private Double value; 
    private String unit;
    private OffsetDateTime recordTime;
  }

  @AllArgsConstructor
  @Getter
  private static class Temperature3 {
    private String place;
    private Double value;
    private String unit;
    private OffsetDateTime recordTime;

    @AllArgsConstructor
    @Getter
    public static class Depth {
      private String unit;
      private Double value;
    }
  }
  
  @AllArgsConstructor
  @Getter
  public static class Forecast {
    @JsonProperty(value = "forecastDate")
    private String Date;
    private String week;
    @JsonProperty(value = "forecastWind")
    private String wing;
    @JsonProperty(value = "forecastWeather")
    private String weather;
    @JsonProperty(value = "ForecastIcon")
    private Long icon;
    @JsonProperty(value = "PSR")
    private String psr;
    @JsonProperty(value = "forecastMaxtemp")
    private Temperature maxTemp;
    @JsonProperty(value = "forecastMintemp")
    private Temperature minTemp;
    @JsonProperty(value = "forecastMaxrh")
    private Temperature maxHum;
    @JsonProperty(value = "forecastMinrh")
    private Temperature minHum;

    @AllArgsConstructor
    @Getter
    public static class Temperature {
      private Double value;
      private String unit;
    }
  }

   public static void main(String[] args) {
    OffsetDateTime offsetDateTime = OffsetDateTime
        .of(LocalDateTime.of(2025, 1, 30, 23, 59, 59), ZoneOffset.ofHours(8));
    
    //  OffsetDateTime -> LocalDateTime
    LocalDateTime localDateTime = offsetDateTime.toLocalDateTime();
    System.out.println(offsetDateTime.toString()); // 2025-01-30T23:59:59+08:00
    System.out.println(localDateTime);
  }
}
