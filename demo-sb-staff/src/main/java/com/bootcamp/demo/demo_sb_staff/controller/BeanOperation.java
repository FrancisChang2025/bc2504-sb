package com.bootcamp.demo.demo_sb_staff.controller;

import org.springframework.web.bind.annotation.GetMapping;

public interface BeanOperation {
  @GetMapping(value = "/beans")
  String[] getAllBeans();
}
