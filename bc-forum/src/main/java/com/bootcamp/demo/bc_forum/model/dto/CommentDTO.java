package com.bootcamp.demo.bc_forum.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CommentDTO {
  private Long id;
  private Long postId;
  private String name;
  private String email;
  private String body;
}
