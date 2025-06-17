package com.bootcamp.gov.data.demo_gov_data.service;

import java.util.List;
import com.bootcamp.gov.data.demo_gov_data.entity.WeatherEntity;
import com.bootcamp.gov.data.demo_gov_data.model.dto.WeatherDTO;

public interface WeatherService {
  WeatherDTO getNineDayWeather();
  List<WeatherEntity> loadNineDayWeather();
}
