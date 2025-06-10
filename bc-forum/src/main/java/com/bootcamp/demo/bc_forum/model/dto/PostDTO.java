package com.bootcamp.demo.bc_forum.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PostDTO {
  private Long userId;
  private Long id;
  private String title;
  private String body;
}
