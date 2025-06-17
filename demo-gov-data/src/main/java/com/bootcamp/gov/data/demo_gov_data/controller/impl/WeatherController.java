package com.bootcamp.gov.data.demo_gov_data.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.gov.data.demo_gov_data.controller.WeatherOperation;
import com.bootcamp.gov.data.demo_gov_data.model.dto.WeatherDTO;
import com.bootcamp.gov.data.demo_gov_data.service.WeatherService;

@RestController
public class WeatherController implements WeatherOperation{
  @Autowired
  private WeatherService weatherService;

  @Override
  public WeatherDTO getWeatherDTO(){
    return this.weatherService.getNineDayWeather();
  }
}
