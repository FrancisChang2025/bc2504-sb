package com.bootcamp.demo.bc_forum.service;

import java.util.List;
import java.util.Optional;
import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.model.dto.UserDTO;

public interface UserService {
  List<UserDTO> getUsers();
  Optional<UserEntity> getUserByCity(String city);

  List<UserEntity> saveAll(List<UserEntity> userEntities);
  Optional<UserEntity> findById(Long id);
  void deleteAll();
}
