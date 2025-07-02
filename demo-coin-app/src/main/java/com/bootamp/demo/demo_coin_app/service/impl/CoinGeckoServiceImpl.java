package com.bootamp.demo.demo_coin_app.service.impl;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootamp.demo.demo_coin_app.dto.CoinTableDTO;
import com.bootamp.demo.demo_coin_app.entity.ButtonEntity;
import com.bootamp.demo.demo_coin_app.entity.mapper.EntityMapper;
import com.bootamp.demo.demo_coin_app.model.CoinData;
import com.bootamp.demo.demo_coin_app.repository.ButtonRepository;
import com.bootamp.demo.demo_coin_app.service.CoinGeckoService;

@Service
public class CoinGeckoServiceImpl implements CoinGeckoService {
  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private ButtonRepository buttonRepository;
  @Autowired
  private EntityMapper entityMapper;

  @Override
  public List<CoinData> fetchCoinData() {
    String apiUrl = "https://api.coingecko.com/api/v3/coins/markets?ids=bitcoin,ethereum,tether&vs_currency=usd";
    CoinData[] response = restTemplate.getForObject(apiUrl, CoinData[].class);
    return Arrays.asList(response);
  }

  @Override
  public List<ButtonEntity> saveAll(List<CoinTableDTO> coinDTOs) {
    List<ButtonEntity> buttonEntities = coinDTOs.stream() //
      .map(e -> {
        ButtonEntity buttonEntity = this.entityMapper.map(e);
        buttonEntity.setSubmitDateTime(LocalDateTime.now());
        return buttonEntity;
      })
      .collect(Collectors.toList());
    return this.buttonRepository.saveAll(buttonEntities);
  }
}
