package com.bootcamp.demo.demo_crypto.service;

import java.util.List;
import com.bootcamp.demo.demo_crypto.model.dto.CoinDTO;

public interface CoinGeckoService {
  List<CoinDTO> getCoins(List<String> targetCoins);
}
