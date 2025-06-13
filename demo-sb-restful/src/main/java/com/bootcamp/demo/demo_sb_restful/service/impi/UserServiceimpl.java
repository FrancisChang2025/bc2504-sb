package com.bootcamp.demo.demo_sb_restful.service.impi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.demo_sb_restful.model.dto.UserDTO;
import com.bootcamp.demo.demo_sb_restful.service.UserService;

@Service
public class UserServiceimpl implements UserService {

  @Override
  public List<UserDTO> getUsers() {
    String url = "https://jsonplaceholder.typicode.com/users";
    UserDTO[] dtos = new RestTemplate().getForObject(url, UserDTO[].class);  // Risky
    // ! RestTemplate().getForObject()
    // 1. Connect Internet -> url -> invoke API
    // 2. API (url) -> return JSON (String)
    // 3. Convert JSON to Object (You defined as UserDTO[].class) -> Deserialization (Risky)

    return new ArrayList<>(Arrays.asList(dtos));
    
  }
}
