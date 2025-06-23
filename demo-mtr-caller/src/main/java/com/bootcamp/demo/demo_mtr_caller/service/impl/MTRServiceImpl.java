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
import com.bootcamp.demo.demo_mtr_caller.exception.ServiceException;
import com.bootcamp.demo.demo_mtr_caller.model.ApiResp;
import com.bootcamp.demo.demo_mtr_caller.model.ErrorCode;
import com.bootcamp.demo.demo_mtr_caller.model.dto.ABCDTO;
import com.bootcamp.demo.demo_mtr_caller.model.dto.ErrorDTO;
import com.bootcamp.demo.demo_mtr_caller.service.MTRService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

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

  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public ABCDTO getEarliestSchedule(String stationCode) 
      throws JsonProcessingException {
    String url = UriComponentsBuilder.newInstance() //
        .scheme("http") //
        .host(this.host) //
        .path(this.serviceEndpoint) //
        .queryParam("sta", stationCode) //
        .build() //
        .toUriString();

    // ! getForObject does not support generic, using another method
    // this.restTemplate.getForObject(url, ApiResp<ABCDTO>.class);

    System.out.println("url=" + url);

    ResponseEntity<ApiResp<JsonNode>> responseEntity =
        this.restTemplate.exchange(url, //
            HttpMethod.GET, //
            null, //
            new ParameterizedTypeReference<ApiResp<JsonNode>>() {} // JSON String
        );

    if (responseEntity.getStatusCode() == HttpStatus.OK) { // 200
      JsonNode data = responseEntity.getBody().getData();

      if (responseEntity.getBody().getCode().equals("000000")) {
        // Object -> Object
        ABCDTO abcdto = this.objectMapper.treeToValue(data, ABCDTO.class); // serialization
        return abcdto;
      }

      ErrorDTO errorDTO = this.objectMapper.treeToValue(data, ErrorDTO.class); // serialization
      throw ServiceException.of(ErrorCode.MTR_SERVICE_EXCEPTION, errorDTO.getMessage());
    }
    return null;
  }
}
