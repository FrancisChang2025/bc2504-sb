package com.bootcamp.demo.demo_sb_restful.service;

import java.util.List;
import java.util.Optional;
import com.bootcamp.demo.demo_sb_restful.entity.ZooEntity;

public interface ZooService {
  ZooEntity create(ZooEntity zooEntity);

  Optional<ZooEntity> findById(Long id);

  List<ZooEntity> findByName(String name);

  List<ZooEntity> findAll();

  void deleteById(Long id);

  ZooEntity updateById(Long id, ZooEntity zooEntity);
  
}
