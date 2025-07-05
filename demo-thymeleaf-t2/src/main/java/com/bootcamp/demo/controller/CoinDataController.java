package com.bootcamp.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.model.dto.CoinDTO;
import com.bootcamp.demo.service.CoinService;

@RestController
public class CoinDataController {
  @Autowired
  private CoinService coinService;

  @GetMapping("/coinlist")
  public List<CoinDTO> getCoins() {
    return this.coinService.getCoins();
  }
}
