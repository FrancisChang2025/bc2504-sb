package com.bootcamp.demo.demo_crypto.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.demo_crypto.model.dto.CoinDTO;
import com.bootcamp.demo.demo_crypto.service.CoinGeckoService;

@Service
public class CoinGeckoServiceImpl implements CoinGeckoService {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${service.coingecko.host}")
  private String host;

  @Value("${service.coingecko.api.quotation.version}")
  private String version;

  @Value("${service.coingecko.api.quotation.endpoint}")
  private String endpoint;

  @Override
  public List<CoinDTO> getCoins(List<String> targetCoins) {
    String url = UriComponentsBuilder.newInstance() //
        .scheme("http") //
        .host(host) //
        // .pathSegment(version) //
        .path(endpoint) //
        .queryParam("currency", "usd")
        .queryParam("coins", String.join(",", targetCoins))
        .build() //
        .toUriString();
    System.out.println("url=" + url);
    return List.of(this.restTemplate.getForObject(url, CoinDTO[].class));
  }
}
