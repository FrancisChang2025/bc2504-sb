package com.bootcamp.demo.demo_coingecko.service;

import java.util.List;
import com.bootcamp.demo.demo_coingecko.model.dto.MarketDTO;

public interface CoinService {
  List<MarketDTO> getMarkets(String currency, List<String> coins);
}
