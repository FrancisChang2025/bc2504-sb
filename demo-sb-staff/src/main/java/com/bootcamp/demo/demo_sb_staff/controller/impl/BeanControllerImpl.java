package com.bootcamp.demo.demo_sb_staff.controller.impl;

import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_staff.DemoSbStaffApplication;
import com.bootcamp.demo.demo_sb_staff.controller.BeanOperation;

@RestController
public class BeanControllerImpl implements BeanOperation {
  @Override
  public String[] getAllBeans(){
    return DemoSbStaffApplication.context.getBeanDefinitionNames();
  }
}
