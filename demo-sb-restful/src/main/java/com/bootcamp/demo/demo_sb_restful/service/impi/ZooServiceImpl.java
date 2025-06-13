package com.bootcamp.demo.demo_sb_restful.service.impi;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_restful.entity.ZooEntity;
import com.bootcamp.demo.demo_sb_restful.repository.ZooRepository;
import com.bootcamp.demo.demo_sb_restful.service.ZooService;

@Service
public class ZooServiceImpl implements ZooService {
  @Autowired
  private ZooRepository zooRepository;


  
  @Override
  public ZooEntity create(ZooEntity zooEntity) {
    return this.zooRepository.save(zooEntity);
  }

  @Override
  public Optional<ZooEntity> findById(Long id) {
   return this.zooRepository.findById(id);
  }

  @Override
  public List<ZooEntity> findByName(String name) {
    return this.zooRepository.findByName(name);
  }

  @Override
  public List<ZooEntity> findAll() {
    return this.zooRepository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    this.zooRepository.deleteById(id);
  }

  @Override
  public ZooEntity updateById(Long id, ZooEntity zooEntity) {
    if (!this.zooRepository.existsById(id) || id != zooEntity.getId())
      return null;
    ZooEntity.builder() //
        .id(zooEntity.getId())
        .name(zooEntity.getName())
        .build();
    return this.zooRepository.save(zooEntity);
  }
}
