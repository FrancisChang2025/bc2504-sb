package com.bootamp.demo.demo_coin_app.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootamp.demo.demo_coin_app.dto.CoinTableDTO;

public interface CoinOperation {
  @PostMapping(value = "/coinpage/coins")
  Boolean submit(@RequestBody List<CoinTableDTO> coinTableDTOs);

  @GetMapping(value = "/coinpage/coins")
  List<CoinTableDTO> getAll();
}
