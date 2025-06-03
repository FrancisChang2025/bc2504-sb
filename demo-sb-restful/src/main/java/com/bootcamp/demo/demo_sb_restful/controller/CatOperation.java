package com.bootcamp.demo.demo_sb_restful.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.bootcamp.demo.demo_sb_restful.model.Cat;

public interface CatOperation {
  @PostMapping(value = "/cat")
  public Cat create(@RequestBody Cat cat);

  @GetMapping(value = "/cats")
  public List<Cat> getAll();

  @PutMapping(value = "/cat/{id}")
  public Cat update(@RequestBody Cat cat, @PathVariable Long id);

  @GetMapping(value = "/cat/{id}")
  public Cat getById(@PathVariable Long id);

  @DeleteMapping(value = "/cat/{id}")
  public Cat deleteById(@PathVariable Long id);
}