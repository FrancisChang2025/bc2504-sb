package com.bootcamp.demo.demo_sb_helloworld.model;

import java.util.List;
import org.springframework.core.annotation.Order;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Customer {
  private Long id;
  private List<Order> orders;
}
