package com.bootcamp.demo.bc_forum.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ForumPostDTO2 {
  private Long postId;
  private String title;
  private String body;
}
