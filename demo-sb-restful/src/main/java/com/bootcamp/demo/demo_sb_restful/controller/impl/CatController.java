package com.bootcamp.demo.demo_sb_restful.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restful.controller.CatOperation;
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
   
  public Cat create(Cat cat) {
    return this.catService.save(cat);
  }

  public List<Cat> getAll() {
    return this.catService.findAll();
  }

  public Cat update(Long id, Cat cat) {
    return this.catService.updateById(id, cat);
  }

  public Cat getById(Long id) {
    return this.catService.findById(id);
  }

  public Cat deleteById(Long id) {
     return this.catService.deleteById(id);
  }
}