package com.bootcamp.demo.demo_mtr_caller.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.demo_mtr_caller.model.dto.ABCDTO;
import com.bootcamp.demo.demo_mtr_caller.model.dto.ApiResp;
import com.bootcamp.demo.demo_mtr_caller.service.MTRService;

@Service
public class MTRServiceImpl implements MTRService {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${service.api.mtr.host}")
  private String host;

  @Value("${service.api.mtr.schedule.version}")
  private String serviceVer;

  @Value("${service.api.mtr.schedule.endpoint}")
  private String serviceEndpoint;

  @Override
  public ABCDTO getEarliestSchedule(String stationCode) {
    String url = UriComponentsBuilder.newInstance() //
        .scheme("http") //
        .host(this.host) //
        .path(this.serviceEndpoint) //
        .queryParam("sta", stationCode) //
        .build() //
        .toUriString();

    System.out.println("url=" + url);  // only for checking in Terminal

    // ! getForObject does not support generic, using another method
    // this.restTemplate.getForObject(url, ApiResp.<ABCDTO>.class);

    // exchange()
    ResponseEntity<ApiResp<ABCDTO>> responseEntity =
        this.restTemplate.exchange(url, //
            HttpMethod.GET, //
            null, //
            new ParameterizedTypeReference<ApiResp<ABCDTO>>() {} //
        );
    if (responseEntity.getStatusCode() == HttpStatus.OK) { // 200
      ABCDTO abcdto = responseEntity.getBody().getData();
      System.out.println("abcdto=" + abcdto);
      return abcdto;
    }
    return null;
  }
}
