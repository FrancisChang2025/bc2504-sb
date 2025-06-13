package com.bootcamp.demo.bc_forum.service;

import java.util.List;
import com.bootcamp.demo.bc_forum.entity.CommentEntity;
import com.bootcamp.demo.bc_forum.model.dto.CommentDTO;

public interface CommentService {
  List<CommentDTO> getComments();
  List<CommentDTO> getComments(Long postId);
  List<CommentEntity> saveAll(List<CommentEntity> postEntities);
}
