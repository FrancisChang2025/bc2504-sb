package com.bootcamp.demo.demo_sb_restful.controller.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restful.controller.ZooOperation;
import com.bootcamp.demo.demo_sb_restful.dto.ZooReqDTO;
import com.bootcamp.demo.demo_sb_restful.entity.ZooEntity;
import com.bootcamp.demo.demo_sb_restful.service.ZooService;

@RestController
public class ZooController implements ZooOperation {
  @Autowired
  private ZooService zooService;
  

  @Override
  public ZooEntity create(ZooReqDTO dto) {
    // convert dto to entity
    ZooEntity zooEntity = ZooEntity.builder() //
        .name(dto.getName()) //
        .createDate(LocalDateTime.now()) //
        .build();
    return this.zooService.create(zooEntity);
  }

  @Override
  public ZooEntity findById(Long id) {
    return this.zooService.findById(id).orElse(null);
  }

  @Override
  public List<ZooEntity> findByName(String name) {
    return this.zooService.findByName(name);
  }
}
