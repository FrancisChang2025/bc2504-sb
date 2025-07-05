package com.bootcamp.demo.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.model.dto.CoinDTO;
import com.bootcamp.demo.service.CoinService;

// @RestController
@Controller
public class CoinPageController {
  @Autowired
  private CoinService coinService;

  @GetMapping("/coins")
  public String getCoins(Model model) {
    List<CoinDTO> coins = this.coinService.getCoins();
    model.addAttribute("coinList", coins);
    return "coin";
  }
}
