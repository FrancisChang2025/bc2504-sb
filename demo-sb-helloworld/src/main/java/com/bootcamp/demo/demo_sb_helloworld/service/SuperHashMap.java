package com.bootcamp.demo.demo_sb_helloworld.service;

import com.bootcamp.demo.demo_sb_helloworld.model.Dog;

public class SuperHashMap<K, V> {
  // ! update
  private K k;
  private V v;

  public SuperHashMap() {

  }

  public SuperHashMap(K k, V v) {
    this.k = k;
    this.v = v;
  }

  public void put(K k, V v) {

  }

  public static class SuperEntry<K, V> {

  }

  public static void main(String[] args) {
    SuperHashMap<String, Dog> dogMap = new SuperHashMap<>();
    dogMap.put("john", new Dog(13));
  }
}
