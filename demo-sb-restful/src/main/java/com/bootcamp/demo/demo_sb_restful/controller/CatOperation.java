package com.bootcamp.demo.demo_sb_restful.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootcamp.demo.demo_sb_restful.entity.CatEntity;
import com.bootcamp.demo.demo_sb_restful.model.Cat;

public interface CatOperation {
  @PostMapping(value = "/zoo/{id}/cat")
  CatEntity create(@PathVariable(value = "id") Integer zooId,
    @RequestBody Cat cat);

  @GetMapping(value = "/zoo/{id}/cats")  // all cats
  List<CatEntity> getAll(@PathVariable(value = "id") Long zooId);

  @GetMapping(value = "/cat/id/{id}")
  CatEntity getById(@PathVariable Long id);

  @PutMapping(value = "/cat/{id}")
  CatEntity update(@PathVariable Long id, @RequestBody Cat cat);

  @DeleteMapping(value = "/cat/{id}")
  void deleteById(@PathVariable Long id);

  @GetMapping(value = "/cat/name/{name}")
  List<CatEntity> getByName(@PathVariable String name);
}