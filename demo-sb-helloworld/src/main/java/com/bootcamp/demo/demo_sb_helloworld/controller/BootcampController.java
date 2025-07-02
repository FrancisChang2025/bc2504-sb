package com.bootcamp.demo.demo_sb_helloworld.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_helloworld.model.Customer;
import com.bootcamp.demo.demo_sb_helloworld.model.Order;
import com.bootcamp.demo.demo_sb_helloworld.model.Person;

@RestController
public class BootcampController {

  @GetMapping(value = "/bootcamp/hello")
  public Customer getCustomer(int Order) {
    List<Order> orders = List.of(Order.builder().id(10L).build());

    return Customer.builder() //
      .id(1L)
      .orders(orders)
      .build();
  }
  @GetMapping(value = "/bootcamp/goodbye")
  public Person getPerson() {
    return Person.builder()
      .age(17)
      .name("John")
      .build();
  }
  
}

