package com.bootcamp.gov.data.demo_gov_data.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.gov.data.demo_gov_data.model.dto.WeatherDTO;
import com.bootcamp.gov.data.demo_gov_data.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public WeatherDTO getNineDayWeather() {
    String url = "https://data.weather.gov.hk/weatherAPI/opendata/weather.php?dataType=fnd&lang=en";
    return this.restTemplate.getForObject(url, WeatherDTO.class);
  }
}
