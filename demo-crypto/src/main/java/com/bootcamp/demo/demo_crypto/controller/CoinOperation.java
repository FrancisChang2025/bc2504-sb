package com.bootcamp.demo.demo_crypto.controller;

import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.bootcamp.demo.demo_crypto.dto.VueAppDTO;

public interface CoinOperation {
  @GetMapping(value = "/coin/quotation")
  List<VueAppDTO> getCoins(@RequestParam List<String> coins);

  @CrossOrigin
  @GetMapping(value = "/coins")
  List<VueAppDTO> getAllCoins();
}
