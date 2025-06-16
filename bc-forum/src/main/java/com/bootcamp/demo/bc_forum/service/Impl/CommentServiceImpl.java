package com.bootcamp.demo.bc_forum.service.Impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.bc_forum.entity.CommentEntity;
import com.bootcamp.demo.bc_forum.model.dto.CommentDTO;
import com.bootcamp.demo.bc_forum.repository.CommentRepository;
import com.bootcamp.demo.bc_forum.service.CommentService;

// Scan classes -> bean (@Component, @Controller, @Service, @Repository, @Configuration)
// @Configuration: Bulit-in class -> bean
@Service
public class CommentServiceImpl implements CommentService {
  // @Value -> check dependency with yml file
  @Value("${service-url.comments}")
  private String url;

  @Autowired
  private RestTemplate restTemplate;
  @Autowired
  private CommentRepository commentRepository;

  // ! Call Open API (Internet)
  @Override
  public List<CommentDTO> getComments() {
    // String url = "https://jsonplaceholder.typicode.com/comments";
    CommentDTO[] dtos = this.restTemplate.getForObject(this.url, CommentDTO[].class); // >100ms
    // return new ArrayList<>(Arrays.asList(dtos));
    return List.of(dtos);
  }

  @Override
  public List<CommentDTO> getComments(Long postId) {
    return this.getComments().stream() //
        .filter(c -> c.getPostId() == postId) //
        .collect(Collectors.toList());
  }

  @Override
  public List<CommentEntity> saveAll(List<CommentEntity> commentEntities) {
    return this.commentRepository.saveAll(commentEntities);
  }

  @Override
  public void deleteAll() {
    this.commentRepository.deleteAll();
  }

  @Override
  public List<CommentEntity> findAll() {
    return this.commentRepository.findAll();
  }
}
