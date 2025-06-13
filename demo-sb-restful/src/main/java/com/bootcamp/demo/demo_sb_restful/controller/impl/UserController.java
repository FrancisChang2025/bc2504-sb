package com.bootcamp.demo.demo_sb_restful.controller.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restful.controller.UserOperation;
import com.bootcamp.demo.demo_sb_restful.dto.UserRespDTO;
import com.bootcamp.demo.demo_sb_restful.model.dto.UserDTO;
import com.bootcamp.demo.demo_sb_restful.service.UserService;

@RestController
public class UserController implements UserOperation {
  @Autowired
  private UserService userService;

  /*
  @Override
  public List<UserDTO> getUsers() {
    return this.userService.getUsers();
  }
  */

  @Override
  public List<UserRespDTO> getUsers() {
    List<UserDTO> userDTOs = this.userService.getUsers();
    return userDTOs.stream() //
       .map(u -> {
       // Geo
       UserRespDTO.Address.Geo geo = UserRespDTO.Address.Geo.builder() //
          .lat(u.getAddress().getGeo().getLat()) //
          .lng(u.getAddress().getGeo().getLng()) //
          .build();
       // Address
        UserRespDTO.Address address = UserRespDTO.Address.builder() //
          .city(u.getAddress().getCity()) //
          .street(u.getAddress().getStreet())
          .suite(u.getAddress().getSuite())
          .zipcode(u.getAddress().getZipcode())
          .geo(geo)
          .build();
       // UserRespDTO
        return UserRespDTO.builder() //
          .address(address)
          .id(u.getId())
          .email(u.getEmail())
          .name(u.getName())
          .username(u.getUsername())
          .build();
       }).collect(Collectors.toList());
  }
}
