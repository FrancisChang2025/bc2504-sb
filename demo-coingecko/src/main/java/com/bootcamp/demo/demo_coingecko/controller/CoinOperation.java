package com.bootcamp.demo.demo_coingecko.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_coingecko.dto.CoinDTO;

public interface CoinOperation {
  @GetMapping(value = "/coin/quotation")
  List<CoinDTO> getCoinData(@RequestParam String currency, 
    @RequestParam String coins);
}
