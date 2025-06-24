package com.bootcamp.demo.demo_coingecko.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_coingecko.controller.CoinOperation;
import com.bootcamp.demo.demo_coingecko.dto.CoinDTO;
import com.bootcamp.demo.demo_coingecko.dto.mapper.DTOMapper;
import com.bootcamp.demo.demo_coingecko.service.CoinService;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
public class CoinController implements CoinOperation {
  @Autowired
  private CoinService coinService;
  @Autowired
  private DTOMapper dtoMapper;

  @Override
  public List<CoinDTO> getCoinDatas(String currency, String coins) 
        throws JsonProcessingException {
    String[] coinArray = coins.split(",");
    return this.coinService.getMarketsWithCache(currency, List.of(coinArray)) //
      .stream() //
      .map(m -> this.dtoMapper.map(m)) //
      .collect(Collectors.toList());
  }
}
