package com.bootcamp.demo.demo_sb_restful.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.demo_sb_restful.dto.UserRespDTO;

public interface UserOperation {
  @GetMapping(value = "/jph/users")
  List<UserRespDTO> getUsers();
  
}
