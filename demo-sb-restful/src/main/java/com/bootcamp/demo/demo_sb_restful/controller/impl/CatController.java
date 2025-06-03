package com.bootcamp.demo.demo_sb_restful.controller.impl;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restful.controller.CatOperation;
import com.bootcamp.demo.demo_sb_restful.model.Cat;

// ! Controller per resource
// @Controller
// @ResponseBody
@RestController // @Controller + @ResponseBody
public class CatController implements CatOperation {
  
  public Cat create(Cat cat) {
    return Cat.cats.add(cat) ? cat : null;
  }

  @GetMapping(value = "/cats")
  public List<Cat> getAll() {
    return Cat.cats;
  }

  public Cat update(Cat cat, Long id) {
    if (id != cat.getId())
      return null; // throw
    for (int i = 0; i < Cat.cats.size(); i++) {
      if (Cat.cats.get(i).getId().equals(id)) {
        Cat.cats.set(i, cat);
        return cat;
      }
    }
    return null;
    // throw new NotFoundException();
  }

  public Cat getById(Long id) {
    // update
    // delete
    for (Cat cat : Cat.cats) {
      if (cat.getId().equals(id)) {
        return cat;
      }
    }
    return null; // throw
  }

  public Cat deleteById(Long id) {
    for (int i = 0; i < Cat.cats.size(); i++) {
      if (Cat.cats.get(i).getId().equals(id)) {
        Cat toBeRemoved = Cat.cats.get(i);
        Cat.cats.remove(toBeRemoved);
        return toBeRemoved;
      }
    }
    return null; // throw
  }

}