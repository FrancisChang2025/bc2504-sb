package com.bootcamp.demo.demo_sb_restful.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// Zoo zoo1 = new Zoo();
// zoo1.add(new Cat());(
// zoo1.getId() // 1

// Zoo zoo2 = new Zoo();
// zoo2.getId() // 2

@Getter
@Setter
@ToString
public class Zoo {
  private static long counter = 0;

  private Long id;
  private List<Cat> cats;

  public Zoo() {
    this.id = ++counter;
    this.cats = new ArrayList<>();
  }

  public boolean add(Cat cat) {
    return this.cats.add(cat);
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!(obj instanceof Zoo))
      return false;
    Zoo zoo = (Zoo) obj;
    return Objects.equals(this.id, zoo.getId());
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.id);
  }
}
