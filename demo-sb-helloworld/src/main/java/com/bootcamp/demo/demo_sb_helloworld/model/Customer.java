package com.bootcamp.demo.demo_sb_helloworld.model;

import java.util.List;
import org.springframework.core.annotation.Order;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString

public class Customer {
  private Long id;
  private List<Order> orders;
}
