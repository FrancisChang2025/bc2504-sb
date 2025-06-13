package com.bootcamp.demo.demo_sb_restful.controller.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restful.controller.CatOperation;
import com.bootcamp.demo.demo_sb_restful.entity.CatEntity;
import com.bootcamp.demo.demo_sb_restful.model.Cat;
import com.bootcamp.demo.demo_sb_restful.service.CatService;

// ! Controller per resource
// @Controller
// @ResponseBody
@RestController // @Controller + @ResponseBody
public class CatController implements CatOperation {
  // ! depedency injection
  @Autowired // ! A command to ask "Spring Manager" to look up for a bean from Context.
  private CatService catService;

  private static int x = 0;

  public void sleep() {
    x++; // read (0) + write (1)
  }

  public void eat() {
    x--; // read (0) + write (-1)
  }
   
  @Override
  public CatEntity create(Integer zooId, Cat cat) {
    return this.catService.save(zooId, cat);
  }

  @Override
  public List<CatEntity> getAll(Long zooId) {
    return this.catService.findAll().stream() //
        .filter(e -> e.getZooEntity().getId() == zooId) //
        .collect(Collectors.toList());
  }

  @Override
  public CatEntity update(Long id, Cat cat) {
    return this.catService.updateById(id, cat);
  }

  // Spring convert object -> String (JSON)
  @Override
  public CatEntity getById(Long id) {
    Optional<CatEntity> catEntity = this.catService.findById(id);
    if (catEntity.isPresent()) {
      return catEntity.get();
    }
    return null;
  }
  
  @Override
  public void deleteById(Long id) {
    this.catService.deleteById(id);
  }

  @Override
  public List<CatEntity> getByName(String name) {
    return this.catService.findByName(name);
  }
}