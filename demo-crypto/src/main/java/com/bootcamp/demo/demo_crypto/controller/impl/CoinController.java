package com.bootcamp.demo.demo_crypto.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_crypto.controller.CoinOperation;
import com.bootcamp.demo.demo_crypto.dto.VueAppDTO;
import com.bootcamp.demo.demo_crypto.dto.mapper.DTOMapper;
import com.bootcamp.demo.demo_crypto.model.dto.CoinDTO;
import com.bootcamp.demo.demo_crypto.service.CoinGeckoService;

@RestController
public class CoinController implements CoinOperation {
  @Autowired
  private CoinGeckoService coinGeckoService;
  @Autowired
  private DTOMapper dtoMapper;

  @Override
  public List<VueAppDTO> getCoins(List<String> coins) {
    List<CoinDTO> coinDTOs = this.coinGeckoService.getCoins(coins);
    System.out.println("coinDTOs=" + coinDTOs);
    return coinDTOs.stream() //
        .map(e -> this.dtoMapper.map(e)) //
        .collect(Collectors.toList());
  }

  @Override
  public List<VueAppDTO> getAllCoins() {
    List<String> coins = List.of("bitcoin", "ethereum" //
        , "binancecoin", "aptos" //
        , "ripple", "solana" //
        , "tron", "dogecoin" //
        , "staked-ether", "cardano" //
        , "wrapped-bitcoin", "hyperliquid" //
        , "aave", "sui" //
        , "chainlink", "stellar" //
        , "whitebit", "weth" //
        , "litecoin", "monero" //
        , "polkadot", "uniswap" //
    );
    List<CoinDTO> coinDTOs = this.coinGeckoService.getCoins(coins);
    System.out.println("coinDTOs=" + coinDTOs);
    return coinDTOs.stream() //
        .map(e -> this.dtoMapper.map(e)) //
        .collect(Collectors.toList());
  }
}
