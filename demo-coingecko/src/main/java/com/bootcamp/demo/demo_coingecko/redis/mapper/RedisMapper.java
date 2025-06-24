package com.bootcamp.demo.demo_coingecko.redis.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_coingecko.entity.CoinEntity;
import com.bootcamp.demo.demo_coingecko.redis.dto.RedisCoinDTO;

@Component
public class RedisMapper {
  public RedisCoinDTO map(CoinEntity entity) {
    return RedisCoinDTO.builder() //
      .currentPrice(entity.getCurrentPrice()) //
      .name(entity.getName()) //
      .image(entity.getImage()) //
      .symbol(entity.getSymbol()) //
      .pricechange24h(entity.getPricechange24h()) //
      .pricechangePercentage24h(entity.getPriceCapchangePercentage24h()) //
      .coingeckoId(entity.getCoingeckoId()) //
      .marketCap(entity.getMarketCap()) //
      .build();
  }
}
