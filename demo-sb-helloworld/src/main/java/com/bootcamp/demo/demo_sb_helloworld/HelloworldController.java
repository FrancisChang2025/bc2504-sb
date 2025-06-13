package com.bootcamp.demo.demo_sb_helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@ResponseBody
public class HelloworldController {

  // ! Spring Boot default is 8080
  // http://127.0.0.1:8080/helloworld
  // Broswer (Client) -> Spring boot app (Server)
  // Step 1: Compile Java Project (Spring Boot)
  // Step 2: Jar
  // Step 3: Start Server

  // API
  @GetMapping(value = "/helloworld")
  public String helloworld() {
    String s = "Hello World, welcome to Spring Boot.";
    return s;
  }

  // create a new spring boot project
  // "http://localhost:8080/person"
  // creat a API to return a person (Person.class)-> John, 18
}
