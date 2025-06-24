package com.bootcamp.demo.demo_coingecko.entity.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_coingecko.entity.CoinEntity;
import com.bootcamp.demo.demo_coingecko.model.dto.MarketDTO;

@Component
public class EntityMapper {
  public CoinEntity map(MarketDTO marketDTO) {
    return CoinEntity.builder() //
      .currentPrice(marketDTO.getCurrentPrice()) //
      .symbol(marketDTO.getSymbol()) //
      .name(marketDTO.getName()) //
      .image(marketDTO.getImage()) //
      .marketCap(marketDTO.getMarketCap()) //
      .pricechange24h(marketDTO.getPricechange24h()) //
      .priceCapchangePercentage24h(marketDTO.getPricechangePercentage24h()) //
      .coingeckoId(marketDTO.getId()) //
      .build();
  }
}
