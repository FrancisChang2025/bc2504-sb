package com.bootamp.demo.demo_coin_app.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootamp.demo.demo_coin_app.controller.CoinOperation;
import com.bootamp.demo.demo_coin_app.dto.CoinTableDTO;
import com.bootamp.demo.demo_coin_app.dto.mapper.DTOMapper;
import com.bootamp.demo.demo_coin_app.service.CoinGeckoService;
import com.bootamp.demo.demo_coin_app.service.CoinService;

@RestController
public class CoinController implements CoinOperation {
  @Autowired
  private CoinService coinService;
  @Autowired
  private CoinGeckoService coinGeckoService;
  @Autowired
  private DTOMapper dtoMapper;

  @Override
  public Boolean submit(List<CoinTableDTO> coinTableDTOs) {
    System.out.println("coins=" + coinTableDTOs);
    if (coinTableDTOs == null)
      throw new RuntimeException("Invalid Coin List.");
    return this.coinService.saveAll(coinTableDTOs) != null;
  }

  @Override
  public List<CoinTableDTO> getAll() {
    return this.coinGeckoService.fetchCoinData().stream() //
      .map(e -> this.dtoMapper.map(e)) //
      .collect(Collectors.toList());
  }
}
