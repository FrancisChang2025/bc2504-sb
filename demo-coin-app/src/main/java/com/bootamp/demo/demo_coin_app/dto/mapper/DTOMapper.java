package com.bootamp.demo.demo_coin_app.dto.mapper;

import org.springframework.stereotype.Component;
import com.bootamp.demo.demo_coin_app.dto.CoinTableDTO;
import com.bootamp.demo.demo_coin_app.model.CoinData;

@Component
public class DTOMapper {
  public CoinTableDTO map(CoinData coinData) {
    return CoinTableDTO.builder()
        .id(coinData.getId())
        .symbol(coinData.getSymbol())
        .name(coinData.getName())
        .image(coinData.getImage())
        .currentPrice(coinData.getCurrentPrice())
        .marketCap(coinData.getMarketCap())
        .priceChangePercent24h(coinData.getPriceChangePercentage24h())
        .lastUpdated(coinData.getLastUpdated())
        .build();
  }
}
