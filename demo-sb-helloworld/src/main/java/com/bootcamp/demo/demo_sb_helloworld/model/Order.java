package com.bootcamp.demo.demo_sb_helloworld.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Order {
  private Long id;
  private List<Order> orders;
}
