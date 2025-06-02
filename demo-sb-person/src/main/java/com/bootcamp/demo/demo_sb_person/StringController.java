package com.bootcamp.demo.demo_sb_person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@ResponseBody

public class StringController {
  // Given two strings, return concat value.
  // https//localhost:8080/concat/hello/world
  @GetMapping("/concat/{x}/{y}")
  public String concat(@PathVariable String x, @PathVariable String y) {
    return x.concat(y);
  }

  // http://localhost:8080/sum2/hello/world
  // throw excepton -> NumberFormatExcetpion, why?
  // x = hello -> Integer.parse("hello") -> NumberFormatExcetpion
  @GetMapping(value = "/sum2/{x}/{y}")
  public Integer sum(@PathVariable String x, @PathVariable String y) {
    try {
      return Integer.parseInt(x) + Integer.parseInt(y);
    } catch (NumberFormatException e) {
      return -1;
    }
  }
  
}
