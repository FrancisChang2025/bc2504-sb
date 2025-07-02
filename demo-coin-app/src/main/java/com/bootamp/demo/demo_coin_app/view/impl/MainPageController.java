package com.bootamp.demo.demo_coin_app.view.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import com.bootamp.demo.demo_coin_app.dto.CoinTableDTO;
import com.bootamp.demo.demo_coin_app.dto.mapper.DTOMapper;
import com.bootamp.demo.demo_coin_app.model.CoinData;
import com.bootamp.demo.demo_coin_app.service.CoinGeckoService;
import com.bootamp.demo.demo_coin_app.view.MainPageOperation;

@Controller  // ! return html
public class MainPageController implements MainPageOperation {
  @Autowired
  private CoinGeckoService coinGeckoService;
  @Autowired
  private DTOMapper dtoMapper;

  @Override
  public String init() {
    return "hello"; // ! the name of html file
  }

  @Override
  public String loadCoinPage(Model model) {
    List<CoinData> coinDataList = this.coinGeckoService.fetchCoinData();
    model.addAttribute("coinList", coinDataList);
    return "coindata";
}

  @Override
  public String loadCoinTable(Model model) {
    List<CoinTableDTO> coinDataList = this.coinGeckoService //
      .fetchCoinData().stream() //
      .map(e -> this.dtoMapper.map(e)) //
      .peek(e -> System.out.println(e)) // for debug only!
      .collect(Collectors.toList());
    model.addAttribute("coinList", coinDataList);
    return "cointable";
  }
}