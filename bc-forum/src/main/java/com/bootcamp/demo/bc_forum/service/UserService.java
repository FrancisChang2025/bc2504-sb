package com.bootcamp.demo.bc_forum.service;

import java.util.List;
import com.bootcamp.demo.bc_forum.model.dto.UserDTO;

public interface UserService {
  List<UserDTO> getUsers();
}
