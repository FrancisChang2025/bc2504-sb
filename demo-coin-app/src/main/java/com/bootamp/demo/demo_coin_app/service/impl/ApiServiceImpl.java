package com.bootamp.demo.demo_coin_app.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootamp.demo.demo_coin_app.model.CoinData;
import com.bootamp.demo.demo_coin_app.service.ApiService;

@Service
public class ApiServiceImpl implements ApiService{
  @Autowired
  private RestTemplate restTemplate;

  public List<CoinData> fetchCoinData() {
    String apiUrl = "https://api.coingecko.com/api/v3/coins/markets?ids=bitcoin,ethereum,tether&vs_currency=usd";
    CoinData[] response = restTemplate.getForObject(apiUrl, CoinData[].class);
    return Arrays.asList(response);
  }
}
