package com.bootcamp.demo.bc_mtr_station.model;

import lombok.Getter;

@Getter
public enum Scheme {
  HTTPS("https"), //
  HTTP("http"), //
  ;
  
  private final String name;

  private Scheme (String name) {
    this.name = name;
  }
}
