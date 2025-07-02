package com.bootcamp.demo.demo_crypto.dto.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_crypto.dto.VueAppDTO;
import com.bootcamp.demo.demo_crypto.model.dto.CoinDTO;

@Component
public class DTOMapper {
  public VueAppDTO map(CoinDTO coinDTO) {
    return VueAppDTO.builder() //
        .coingeckoId(coinDTO.getId()) //
        .image(coinDTO.getImage()) //
        .symbol(coinDTO.getSymbol()) //
        .name(coinDTO.getName()) //
        .currentPrice(coinDTO.getCurrentPrice()) //
        .marketCap(coinDTO.getMarketCap()) //
        .marketCapRank(coinDTO.getMarketCapRank()) //
        .priceChangePercentage24h(coinDTO.getPriceChangePercentage24h()) //
        .totalVolume(coinDTO.getTotalVolume()) //
        .build();
  }
}
