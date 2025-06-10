package com.bootcamp.demo.bc_forum.service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.bc_forum.model.dto.UserDTO;
import com.bootcamp.demo.bc_forum.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  @Value("${service-url.users}")
  private String url;

  @Override
  public List<UserDTO> getUsers() {
    // String url = "https://jsonplaceholder.typicode.com/users";
    UserDTO[] dtos = new RestTemplate().getForObject(this.url, UserDTO[].class);
    return new ArrayList<>(Arrays.asList(dtos));
  }
}
