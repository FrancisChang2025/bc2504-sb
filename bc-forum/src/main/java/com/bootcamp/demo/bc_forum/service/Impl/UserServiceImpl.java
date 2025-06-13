package com.bootcamp.demo.bc_forum.service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.model.dto.UserDTO;
import com.bootcamp.demo.bc_forum.repository.UserRepository;
import com.bootcamp.demo.bc_forum.service.UserService;

@Service
public class UserServiceImpl implements UserService {
  // @Value -> check dependency with yml file
  @Value("${service-url.users}")
  private String url;

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private UserRepository userRepository;

  @Override
  public List<UserDTO> getUsers() {
    // String url = "https://jsonplaceholder.typicode.com/users";
    UserDTO[] dtos = this.restTemplate.getForObject(this.url, UserDTO[].class);
    return new ArrayList<>(Arrays.asList(dtos));
  }

  @Override
  public Optional<UserEntity> getUserByCity(String city) {
    Optional<UserEntity> userEntity = this.userRepository.findByCity(city);
    System.out.println(userEntity);
    return userEntity;
  }

  @Override
  public List<UserEntity> saveAll(List<UserEntity> userEntities) {
    return this.userRepository.saveAll(userEntities);
  }

  @Override
  public Optional<UserEntity> findById(Long id) {
    return this.userRepository.findById(id);
  }

}
