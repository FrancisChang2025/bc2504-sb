package com.bootcamp.demo.demo_coingecko.model.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_coingecko.entity.CoinEntity;
import com.bootcamp.demo.demo_coingecko.model.Coin;
import com.bootcamp.demo.demo_coingecko.redis.dto.RedisCoinDTO;

@Component
public class ModelMapper {
  
  public Coin map(RedisCoinDTO dto) {
    return Coin.builder() //
        .currentPrice(dto.getCurrentPrice()) //
        .coingeckoId(dto.getCoingeckoId()) //
        .image(dto.getImage()) //
        .marketCap(dto.getMarketCap()) //
        .name(dto.getName()) //
        .symbol(dto.getSymbol()) //
        .pricechange24h(dto.getPricechange24h()) //
        .pricechangePercentage24h(dto.getPricechangePercentage24h()) //
        .build();
  }

  public Coin map(CoinEntity dto) {
    return Coin.builder() //
        .currentPrice(dto.getCurrentPrice()) //
        .coingeckoId(dto.getCoingeckoId()) //
        .image(dto.getImage()) //
        .marketCap(dto.getMarketCap()) //
        .name(dto.getName()) //
        .symbol(dto.getSymbol()) //
        .pricechange24h(dto.getPricechange24h()) //
        .pricechangePercentage24h(dto.getPriceCapchangePercentage24h()) //
        .build();
  }
}
