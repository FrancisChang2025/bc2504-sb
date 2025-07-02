package com.bootamp.demo.demo_coin_app.entity.mapper;

import org.springframework.stereotype.Component;
import com.bootamp.demo.demo_coin_app.dto.CoinTableDTO;
import com.bootamp.demo.demo_coin_app.entity.ButtonEntity;

@Component
public class EntityMapper {
  public ButtonEntity map(CoinTableDTO coinTableDTO) {
    return ButtonEntity.builder() //
      .coingecko_id(coinTableDTO.getId()) //
      .name(coinTableDTO.getName()) //
      .currentPrice(coinTableDTO.getCurrentPrice()) //
      .build();
  }
}
