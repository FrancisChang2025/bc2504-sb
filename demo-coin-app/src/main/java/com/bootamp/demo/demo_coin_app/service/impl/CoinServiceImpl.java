package com.bootamp.demo.demo_coin_app.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootamp.demo.demo_coin_app.dto.CoinTableDTO;
import com.bootamp.demo.demo_coin_app.entity.ButtonEntity;
import com.bootamp.demo.demo_coin_app.entity.mapper.EntityMapper;
import com.bootamp.demo.demo_coin_app.repository.ButtonRepository;
import com.bootamp.demo.demo_coin_app.service.CoinService;

@Service
public class CoinServiceImpl implements CoinService {
  @Autowired
  private ButtonRepository buttonRepository;
  @Autowired
  private EntityMapper entityMapper;

  @Override
  public List<ButtonEntity> saveAll(List<CoinTableDTO> coinTableDTOs) {
    List<ButtonEntity> buttonEntities = coinTableDTOs.stream() //
      .map(e -> {
        ButtonEntity buttonEntity = this.entityMapper.map(e);
        buttonEntity.setSubmitDateTime(LocalDateTime.now());
        return buttonEntity;
      })
      .collect(Collectors.toList());
    return this.buttonRepository.saveAll(buttonEntities);
  }
}
