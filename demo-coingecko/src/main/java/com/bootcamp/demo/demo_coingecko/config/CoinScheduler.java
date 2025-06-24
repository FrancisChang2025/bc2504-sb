package com.bootcamp.demo.demo_coingecko.config;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_coingecko.entity.CoinEntity;
import com.bootcamp.demo.demo_coingecko.entity.mapper.EntityMapper;
import com.bootcamp.demo.demo_coingecko.model.dto.MarketDTO;
import com.bootcamp.demo.demo_coingecko.service.CoinService;

@Component
public class CoinScheduler {
  @Autowired
  private CoinService coinService;
  @Autowired
  private EntityMapper entityMapper;

  // 5 mins
  @Scheduled(fixedRate = 300_000) // 5000ms = 5 seconds
  public void updateMarket() throws InterruptedException {
    // ! call api by coinService
    List<String> coins = List.of("bitcoin", "ethereum", "tether");
    List<MarketDTO> marketDTOs = this.coinService.getMarkets("usd", coins);

    // ! put into Database ()
    List<CoinEntity> coinEntities = marketDTOs.stream() //
        .map(dto -> this.entityMapper.map(dto)) //
        .collect(Collectors.toList());
    if (coinEntities.size() > 0) {
      this.coinService.deleteAll();
      this.coinService.saveAll(coinEntities);
    }
  }
}
