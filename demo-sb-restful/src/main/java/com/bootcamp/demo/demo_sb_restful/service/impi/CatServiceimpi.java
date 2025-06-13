package com.bootcamp.demo.demo_sb_restful.service.impi;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.demo_sb_restful.entity.CatEntity;
import com.bootcamp.demo.demo_sb_restful.entity.ZooEntity;
import com.bootcamp.demo.demo_sb_restful.model.Cat;
import com.bootcamp.demo.demo_sb_restful.repository.CatRepository;
import com.bootcamp.demo.demo_sb_restful.repository.ZooRepository;
import com.bootcamp.demo.demo_sb_restful.service.CatService;

// ! CRUD -> insert, read, update, delete

@Service
public class CatServiceimpi implements CatService {
  // ! Hibernate already generate a bean for interface CatRepository BEFORE SERVER START
  @Autowired
  private CatRepository catRepository;
  @Autowired
  private ZooRepository zooRepository;

  

  @Override
  public CatEntity save(Integer zooId, Cat cat) {
    // return Cat.cats.add(cat) ? cat : null;
    // real DB

    // 0. check if zoo found
    Optional<ZooEntity> zooEntity = this.zooRepository.findById(Long.valueOf(zooId));
    if (!zooEntity.isPresent())
      return null;
    // 1. convert Cat object to CatEntity object
    // ! java world: cat object associate with zoo object
    CatEntity catEntity = CatEntity.builder()//
        .name(cat.getName()) //
        .age(cat.getAge()) //
        .zooEntity(zooEntity.get()) // set FK 🔑
        .build();
    // 2. insert cat into table
    return catRepository.save(catEntity);
  }

  @Override
  public Optional<CatEntity> findById(Long id) {
     return this.catRepository.findById(id);
  }

  @Override
  public List<CatEntity> findAll() {
    return this.catRepository.findAll();
  }

  @Override
  public void deleteById(Long id) {
    this.catRepository.deleteById(id);
  }

  // PUT
  @Override
  public CatEntity updateById(Long id, Cat cat) {
    if (!this.catRepository.existsById(id) || id != cat.getId())
      return null;
    // save -> create or replace
    // But in PUT api, we check if the resource exists, do nothing if not exists.
    CatEntity catEntity = CatEntity.builder() //
      .id(cat.getId())
      .name(cat.getName())
      .age(cat.getAge())
      .build();
    return this.catRepository.save(catEntity);
  }

  @Override
  public List<CatEntity> findByName(String name) {
    return this.catRepository.findByName(name);
  }
  
  // ! findAll -> we can filter in java, not a must findByXXX in JPA
  @Override
  public List<CatEntity> findByNameAndAge(String name, Integer age) {
    return this.catRepository.findAll().stream() //
      .filter(e -> e.getName().equals(name) && e.getAge() == age) //
      .collect(Collectors.toList());
  }
 }