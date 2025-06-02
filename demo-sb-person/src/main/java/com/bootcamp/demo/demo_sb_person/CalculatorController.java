package com.bootcamp.demo.demo_sb_person;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@ResponseBody

public class CalculatorController {
  // http://localhost:8080/sum/3/4
  @GetMapping(value = "/sum/{x}/{y}")
  public Integer sum(@PathVariable(name = "x") Integer basicSalary, 
    @PathVariable(name = "y") Integer bonus) {
    return basicSalary + bonus;
  }

  // subtract
  /* @GetMapping("/subtract/{a}/{b}")
  public Integer subtract(@PathVariable(name = "a") Integer basicSalary, 
  @PathVariable(name = "b") Integer bonus) {
  return basicSalary - bonus;
  } */

  @GetMapping("/subtract/{x}/{y}")
  public Integer subtract(@PathVariable Integer x, @PathVariable Integer y) {
    return x - y;
  }

  // http://localhost:8080/multiply?a=5&b=6
  @GetMapping(value = "/multiply")  
  public Integer multiply(@RequestParam Integer a,
    @RequestParam Integer b) {
    return a * b;
  }

    // http://localhost:8080/average?total=10&quan=2
    @GetMapping(value = "/average")
    public Integer average(@RequestParam(value = "total") Integer a, 
      @RequestParam(value = "quan") Integer b) {
      return a / b;
    }
}
