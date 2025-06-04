package com.bootcamp.demo.demo_sb_restful.service.impi;

import java.util.List;
import com.bootcamp.demo.demo_sb_restful.model.Cat;
import com.bootcamp.demo.demo_sb_restful.service.CatService;

// ! Conext cannot contains more than one bean, which fulfill CatService Interface
// @Service
public class SmallCatServiceImpl implements CatService {
  @Override
  public Cat save(Cat cat) {
    return Cat.cats.add(cat) ? cat : null;
  }

  @Override
  public Cat findById(Long id) {
    for (Cat cat : Cat.cats) {
      if (cat.getId().equals(id)) {
        return cat;
      }
    }
    return null; // throw
  }

  @Override
  public List<Cat> findAll() {
    return Cat.cats;
  }

  @Override
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

  @Override
  public Cat updateById(Long id, Cat cat) {
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
}