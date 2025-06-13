package com.bootcamp.demo.bc_forum.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class PostDTO {
  private Long id;
  private Long userId;
  private String title;
  private String body;
}
