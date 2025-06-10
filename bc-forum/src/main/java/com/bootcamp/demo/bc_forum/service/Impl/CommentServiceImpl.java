package com.bootcamp.demo.bc_forum.service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.bc_forum.model.dto.CommentDTO;
import com.bootcamp.demo.bc_forum.service.CommentService;

// Scan classes -> bean (@Component, @Controller, @Service, @Respository, @Configuration)
// @Configuration: Built-in class -> bean
@Service
public class CommentServiceImpl implements CommentService {
  @Value("${service-url.comments}")
  private String url;

  @Autowired
  private RestTemplate restTemplate;

  // ! Call Open API (Internet)
  @Override
  public List<CommentDTO> getComments() {
    // String url = "https://jsonplaceholder.typicode.com/comments";
    CommentDTO[] dtos = this.restTemplate.getForObject(this.url, CommentDTO[].class); // >100ms
    return new ArrayList<>(Arrays.asList(dtos));
  }

  @Override
  public List<CommentDTO> getComments(Long postId) {
    return this.getComments().stream() //
      .filter(c -> c.getPostId() == postId) //
      .collect(Collectors.toList());
  }
}
