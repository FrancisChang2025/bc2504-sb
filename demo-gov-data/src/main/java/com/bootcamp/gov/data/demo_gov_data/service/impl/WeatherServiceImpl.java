package com.bootcamp.gov.data.demo_gov_data.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.gov.data.demo_gov_data.entity.WeatherEntity;
import com.bootcamp.gov.data.demo_gov_data.entity.mapper.EntityMapper;
import com.bootcamp.gov.data.demo_gov_data.model.dto.WeatherDTO;
import com.bootcamp.gov.data.demo_gov_data.repository.WeatherRepository;
import com.bootcamp.gov.data.demo_gov_data.service.WeatherService;

@Service
public class WeatherServiceImpl implements WeatherService {
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private EntityMapper entityMapper;
  @Autowired
  private WeatherRepository weatherRepository;

  @Override
  public WeatherDTO getNineDayWeather() {
    String url =
        "https://data.weather.gov.hk/weatherAPI/opendata/weather.php?dataType=fnd&lang=en";
    return this.restTemplate.getForObject(url, WeatherDTO.class);
  }

  @Override
  public List<WeatherEntity> loadNineDayWeather() {
    List<WeatherEntity> weatherEntities = this.getNineDayWeather().getForecasts().stream() //
        .map(forecast -> this.entityMapper.map(forecast)) //
        .collect(Collectors.toList());
    this.weatherRepository.deleteAll();
    return this.weatherRepository.saveAll(weatherEntities);
  }
}