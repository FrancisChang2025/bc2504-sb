package com.bootcamp.demo.bc_mtr_station.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.bc_mtr_station.entity.LineEntity;
import com.bootcamp.demo.bc_mtr_station.service.LineService;

@Service
public class LineServiceImpl implements LineService {
  @Autowired
  private com.bootcamp.demo.bc_mtr_station.repository.LineRepository lineRepository;

  @Override
  public LineEntity save(LineEntity lineEntity) {
    return this.lineRepository.save(lineEntity);
  }

}
