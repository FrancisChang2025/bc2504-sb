package com.bootcamp.demo.bc_forum.config;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.bootcamp.demo.bc_forum.model.dto.UserDTO;
import com.bootcamp.demo.bc_forum.service.UserService;

// ! Spring Program: being triggered during server starts
// @Autowired (required = false)
// private CommandLineRunner commandLineRunner;

// if (commandLineRunner != null { commandLineRunner.run();})

@Component
public class AppStartRunner implements CommandLineRunner{
  @Autowired
  private UserService userService;

  @Override
  public void run(String... args) throws Exception {
    // System.out.println("Hello world !!!!!!");
    // Step 1: Call JsonPlaceHolder.com
    List<UserDTO> userDTOs = userService.getUsers();
    // Step 2: Convert Entity from DTO to Entity by mapper (3 Entity and 3 Repository)
    // Step 3: Insert into DB (Users, Posts, Comments)
  }
}
