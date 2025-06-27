package com.bootcamp.demo.demo_sb_helloworld.model;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Person {
  private String name;
  private int age;

  public Person(String name, int age) {
    this.name = name;
    this.age = age;
  }

}
