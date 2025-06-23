package com.bootcamp.demo.demo_coingecko.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_coingecko.controller.CoinOperation;
import com.bootcamp.demo.demo_coingecko.dto.CoinDTO;
import com.bootcamp.demo.demo_coingecko.dto.mapper.DTOMapper;
import com.bootcamp.demo.demo_coingecko.service.CoinService;

@RestController
public class CoinController implements CoinOperation {
  @Autowired
  private CoinService coinService;

  @Autowired
  private DTOMapper dtoMapper;

  @Override
  public List<CoinDTO> getCoinData(String currency, String coins) {
    String[] coinArray = coins.split(",");
    return this.coinService.getMarkets(currency, List.of(coinArray)).stream() //
      .map(m -> this.dtoMapper.map(m)) //
      .collect(Collectors.toList());
  }
}
