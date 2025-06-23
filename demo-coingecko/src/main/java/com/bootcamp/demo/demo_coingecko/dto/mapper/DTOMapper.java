package com.bootcamp.demo.demo_coingecko.dto.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_coingecko.dto.CoinDTO;
import com.bootcamp.demo.demo_coingecko.model.dto.MarketDTO;

@Component
public class DTOMapper {
  // from MarketDTO to CoinDTO
  public CoinDTO map(MarketDTO marketDTO) {
    return CoinDTO.builder() //
      .id(marketDTO.getId()) //
      .image(marketDTO.getImage()) //
      .name(marketDTO.getName()) //
        .marketCap(marketDTO.getMarketCap()) //
        .marketCapRank(marketDTO.getMarketCapRank()) //
        .currentPrice(marketDTO.getCurrentPrice()) //
        .symbol(marketDTO.getSymbol()) //
        .high24h(marketDTO.getHigh24h()) //
        .low24h(marketDTO.getLow24h()) //
        .build();
  }
}
