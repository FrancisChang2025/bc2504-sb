package com.bootcamp.demo.bc_mtr_station.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.bc_mtr_station.model.dto.ScheduleDTO;
import com.bootcamp.demo.bc_mtr_station.service.MTRService;

@Service
public class MTRServiceImpl implements MTRService {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${service-url.mtr.host}")
  private String host;

  @Value("${service-url.mtr.api.mtr-schedule.version}")
  private String serviceVer;

  @Value("${service-url.mtr.api.mtr-schedule.endpoint}")
  private String serviceEndpoint;

  @Override
  public ScheduleDTO getSchedule(String line, String station) {
    String url = "https://" + this.host + this.serviceVer + this.serviceEndpoint
        + "?line=" + line + "&sta=" + station;
    return this.restTemplate.getForObject(url, ScheduleDTO.class);
  }
}
