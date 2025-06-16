package com.bootcamp.demo.bc_forum.service;

import java.util.List;
import com.bootcamp.demo.bc_forum.entity.PostEntity;
import com.bootcamp.demo.bc_forum.model.dto.PostDTO;

public interface PostService {
  List<PostDTO> getPosts();
  List<PostDTO> getPosts(Long userId);
  List<PostEntity> saveAll(List<PostEntity> postEntities);
  PostEntity save(PostEntity postEntity);
  void deleteAll();
  List<PostEntity> getPostsByUserId(Long userId);
}
