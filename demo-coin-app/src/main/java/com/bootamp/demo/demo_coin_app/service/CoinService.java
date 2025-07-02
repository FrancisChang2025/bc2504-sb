package com.bootamp.demo.demo_coin_app.service;

import java.util.List;
import com.bootamp.demo.demo_coin_app.dto.CoinTableDTO;
import com.bootamp.demo.demo_coin_app.entity.ButtonEntity;

public interface CoinService {
  List<ButtonEntity> saveAll(List<CoinTableDTO> coinTableDTOs);
}
