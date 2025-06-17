package com.bootcamp.demo.bc_mtr_station.service;

import java.util.Optional;
import com.bootcamp.demo.bc_mtr_station.entity.LineEntity;

public interface LineService {
  LineEntity save(LineEntity lineEntity);

  Optional<LineEntity> findById(Long id);
}
