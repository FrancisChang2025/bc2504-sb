package com.bootcamp.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// ! Going to return static html page.
public class HelloworldController {
  @GetMapping("/hello")
  public String sayHello(Model model) {
    model.addAttribute("message", "Hello !!!!");
    return "abc"; // abc.html
  }
}
