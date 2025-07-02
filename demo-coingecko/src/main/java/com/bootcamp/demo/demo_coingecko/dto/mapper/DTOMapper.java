package com.bootcamp.demo.demo_coingecko.dto.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_coingecko.dto.CoinDTO;
import com.bootcamp.demo.demo_coingecko.model.Coin;
import com.bootcamp.demo.demo_coingecko.model.dto.MarketDTO;

@Component
public class DTOMapper {

  // from Coin to CoinDTO
  public CoinDTO map(Coin coin) {
    return CoinDTO.builder() //
        .id(coin.getCoingeckoId()) //
        .image(coin.getImage()) //
        .name(coin.getName()) //
        .marketCap(coin.getMarketCap()) //
        .marketCapRank(coin.getMarketCapRank()) //
        .totalVolume(coin.getTotalVolume()) //
        .currentPrice(coin.getCurrentPrice()) //
        .symbol(coin.getSymbol()) //
        .pricechange24h(coin.getPricechange24h()) //
        .pricechangePercentage24h(coin.getPricechangePercentage24h()) //
        .build();
  }

  // from MarketDTO to CoinDTO
  public CoinDTO map(MarketDTO marketDTO) {
    return CoinDTO.builder() //
        .id(marketDTO.getId()) //
        .image(marketDTO.getImage()) //
        .name(marketDTO.getName()) //
        .marketCap(marketDTO.getMarketCap()) //
        .marketCapRank(marketDTO.getMarketCapRank()) //
        .totalVolume(marketDTO.getTotalVolume()) //
        .currentPrice(marketDTO.getCurrentPrice()) //
        .symbol(marketDTO.getSymbol()) //
        .pricechange24h(marketDTO.getPricechange24h()) //
        .pricechangePercentage24h(marketDTO.getPricechangePercentage24h()) //
        .build();
  }
}
