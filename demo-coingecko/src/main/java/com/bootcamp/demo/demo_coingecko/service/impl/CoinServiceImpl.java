package com.bootcamp.demo.demo_coingecko.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.demo_coingecko.model.dto.MarketDTO;
import com.bootcamp.demo.demo_coingecko.service.CoinService;

@Service
public class CoinServiceImpl implements CoinService {
  @Autowired
  private RestTemplate restTemplate;

  @Value("${service.coingecko.host.demo}")
  private String host;

  @Value("${service.coingecko.api.markets.version}")
  private String version;

  @Value("${service.coingecko.api.markets.endpoint}")
  private String endpoint;

  @Value("${service.coingecko.api.key-name}")
  private String apiKeyName;

  @Value("${service.coingecko.api.key-value}")
  private String apiKeyValue;

  // https://xxx.com? 
  // vs_currency=usd
  // ids=bitcoins,xxx
  // 
  @Override
  public List<MarketDTO> getMarkets(String currency, List<String> coins) {
    String coinsList = String.join(",", coins);
    String url = UriComponentsBuilder.newInstance() //
      .scheme("https") //
      .host(coinsList)
      .pathSegment(version) //
      .path(endpoint)
      .queryParam("vs_currency", currency)
      .queryParam("ids", coinsList)
      .queryParam(apiKeyName, apiKeyValue)
      .build()
      .toUriString();
    System.out.println("url=" + url);
    MarketDTO[] marketDTOs = this.restTemplate.getForObject(url, MarketDTO[].class);
    return List.of(marketDTOs);
  }
}
