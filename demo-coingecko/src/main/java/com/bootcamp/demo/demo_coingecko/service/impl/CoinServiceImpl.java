package com.bootcamp.demo.demo_coingecko.service.impl;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.bootcamp.demo.demo_coingecko.entity.CoinEntity;
import com.bootcamp.demo.demo_coingecko.model.Coin;
import com.bootcamp.demo.demo_coingecko.model.dto.MarketDTO;
import com.bootcamp.demo.demo_coingecko.model.mapper.ModelMapper;
import com.bootcamp.demo.demo_coingecko.redis.dto.RedisCoinDTO;
import com.bootcamp.demo.demo_coingecko.redis.mapper.RedisMapper;
import com.bootcamp.demo.demo_coingecko.repository.CoinRepository;
import com.bootcamp.demo.demo_coingecko.service.CoinService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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

  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private CoinRepository coinRepository;

  @Autowired
  private ModelMapper modelMapper;

  @Autowired
  private RedisMapper redisMapper;

  @Override
  public List<Coin> getMarketsWithCache(String currency,
      List<String> targetCoins) throws JsonProcessingException {
    // ! Read Through Pattern:
    List<Coin> coins = new ArrayList<>();
    for (String targetCoin : targetCoins) { 
    // ! Step 1: Find form cache, if found, return.
    String coinKey = "market-" + targetCoin;
    String json = this.redisTemplate.opsForValue().get(coinKey);
    if (json != null) {
      System.out.println("Redis Found: " + targetCoin);
      RedisCoinDTO redisCoinDTO =
        this.objectMapper.readValue(json, RedisCoinDTO.class);
      Coin coin = this.modelMapper.map(redisCoinDTO);
      coins.add(coin);
      continue;
    }
    // ! Step 2: Find the Database, if found, write into cache
    CoinEntity coinEntity = this.coinRepository.findByCoingeckoId(targetCoin) //
      .orElseThrow(() -> new RuntimeException("ID not found.")); //bitcoin, ethereum, tether
    System.out.println("DB Found: " + coinEntity.getCoingeckoId());
    // ! 2a: prepare the list return to client
    Coin coin = this.modelMapper.map(coinEntity);
    coins.add(coin);
    // ! 2b: write into cache
    RedisCoinDTO redisCoinDTO = this.redisMapper.map(coinEntity);
    // redisManager.write("xxx", redisCoinDTO, 30);
    String coinJsonStr = this.objectMapper.writeValueAsString(redisCoinDTO);
    this.redisTemplate.opsForValue().set(coinKey, coinJsonStr, Duration.ofSeconds(30));
  }
    // ! Step 3: return the result
    return coins;
  }

  @Override
  public List<CoinEntity> saveAll(List<CoinEntity> coinEntities) {
    return coinRepository.saveAll(coinEntities);
  }

  @Override
  public void deleteAll() {
    this.coinRepository.deleteAll();
  }  

  // https://xxx.com? 
  // vs_currency=usd
  // ids=bitcoins,xxx
  // 
  @Override
  public List<MarketDTO> getMarkets(String currency, List<String> coins) {
    String coinsList = String.join(",", coins);
    String url = UriComponentsBuilder.newInstance() //
      .scheme("https") //
      .host(host)
      .pathSegment(version) //
      .path(endpoint)
      .queryParam("vs_currency", currency)
      .queryParam("ids", coinsList)
      .queryParam(apiKeyName, apiKeyValue)
      .build()
      .toUriString();
    System.out.println("url=" + url);
    MarketDTO[] marketDTOs = 
      this.restTemplate.getForObject(url, MarketDTO[].class);
    return List.of(marketDTOs);
  }
}
