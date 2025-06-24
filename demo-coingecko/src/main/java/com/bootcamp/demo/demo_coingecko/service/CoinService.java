package com.bootcamp.demo.demo_coingecko.service;

import java.util.List;
import com.bootcamp.demo.demo_coingecko.entity.CoinEntity;
import com.bootcamp.demo.demo_coingecko.model.Coin;
import com.bootcamp.demo.demo_coingecko.model.dto.MarketDTO;
import com.fasterxml.jackson.core.JsonProcessingException;

public interface CoinService {
  // read and write from cache
  List<Coin> getMarketsWithCache(String currency, List<String> coins)
    throws JsonProcessingException;

  // call coingecko api
  List<MarketDTO> getMarkets(String currency, List<String> coins);

  List<CoinEntity> saveAll(List<CoinEntity> coinEntities);
  
  void deleteAll();
}
