package com.bootcamp.demo.bc_forum.service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.bc_forum.model.dto.PostDTO;
import com.bootcamp.demo.bc_forum.service.PostService;

@Service
public class PostServiceImpl implements PostService {
  @Value("${service-url.posts}") // similar to autowired
  private String url;

  @Override
  public List<PostDTO> getPosts() {
    // String url = "https://jsonplaceholder.typicode.com/posts";
    PostDTO[] dtos = new RestTemplate().getForObject(url, PostDTO[].class);
    return new ArrayList<>(Arrays.asList(dtos));
  }

  @Override
  public List<PostDTO> getPosts(Long userId) {
    return this.getPosts().stream() //
      .filter(p -> p.getUserId() == userId) //
      .collect(Collectors.toList());
  }
}


