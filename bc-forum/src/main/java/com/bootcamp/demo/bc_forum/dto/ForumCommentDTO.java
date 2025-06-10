package com.bootcamp.demo.bc_forum.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ForumCommentDTO {
  private Long id;
  private String name;
  private String email;
  private String body;
}
