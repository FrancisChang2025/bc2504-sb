package com.bootcamp.demo.demo_sb_restful.service;

import java.util.List;
import com.bootcamp.demo.demo_sb_restful.model.Cat;

public interface CatService {
  Cat save(Cat cat);

  Cat findById(Long id);

  List<Cat> findAll();

  Cat deleteById(Long id);

  Cat updateById(Long id, Cat cat);
}