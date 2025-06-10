package com.bootcamp.demo.bc_forum.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ForumPostDTO {
  private Long id;
  private String title;
  private String body;
  private List<ForumCommentDTO> comments;
}
