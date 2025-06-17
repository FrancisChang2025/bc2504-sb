package com.bootcamp.gov.data.demo_gov_data.controller;

import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.gov.data.demo_gov_data.model.dto.WeatherDTO;

public interface WeatherOperation {
  @GetMapping(value = "/weather/nineday")
  WeatherDTO getWeatherDTO();
}
