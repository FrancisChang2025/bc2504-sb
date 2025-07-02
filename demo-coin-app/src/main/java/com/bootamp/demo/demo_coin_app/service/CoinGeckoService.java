package com.bootamp.demo.demo_coin_app.service;

import java.util.List;
import com.bootamp.demo.demo_coin_app.dto.CoinTableDTO;
import com.bootamp.demo.demo_coin_app.entity.ButtonEntity;
import com.bootamp.demo.demo_coin_app.model.CoinData;

public interface CoinGeckoService {
  List<CoinData> fetchCoinData();

  List<ButtonEntity> saveAll(List<CoinTableDTO> coinDTOs);
}
