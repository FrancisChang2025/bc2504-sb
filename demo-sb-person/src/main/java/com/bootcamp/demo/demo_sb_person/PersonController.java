package com.bootcamp.demo.demo_sb_person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bootcamp.demo.demo_sb_person.Customer.CustomerBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody

public class PersonController {
  
 /* @GetMapping(value = "/person")
  public String person() {
    String p = "Hello Everybody!!  Welcome to Spring Boot.";
    return p;
  } */

  // create a new spring boot project
  // "http://localhost:8080/person"
  // create a API to return a person (Person.class) -> John, 18
  @GetMapping("/person")
  public Person getPerson() {
     return new Person("John", 18);
  }

  // persons ->
  @GetMapping("/persons")
  public List<Person> getPersons() {
      return new ArrayList<>(
        Arrays.asList(new Person("Mary", 5), new Person("Peter", 10)));
  }
  
  // customer, order
  @GetMapping("/orders")
  public List<Order> getOrder() {
      return new ArrayList<>(Arrays.asList(new Order(1L), new Order(3L)));
  }


  @GetMapping("/customers")
  public List<Customer> getCustomers() {
    List<Order> orders1 =
      new ArrayList<>(Arrays.asList(new Order(1L), new Order(2L)));
    Customer c1 = Customer.builder().id(1L).orders(orders1).build();
    Customer c2 = Customer.builder().id(2L).build();
    Customer c3 = Customer.builder().id(3L).build();


    List<Customer> customers = new ArrayList<>(Arrays.asList(c1));
    // System.out.println(customers);  // ~ 0.001 sec (1ms), for debug only
    return customers;
  }
  
  // HashMap, 3 entries
  @GetMapping(value = "/nameMap")
  public Map<String, String> getNameMap() {
    Map<String, String> nameMap = new HashMap<>();
    nameMap.put("J", "John");
    nameMap.put("P", "Peter");
    nameMap.put("A", "Alex");
    return nameMap;
 }
}
