package com.bootcamp.demo.bc_forum.dto;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ForumUserCommentListDTO {
  @JsonProperty(value = "id")
  private Long userId;

  private String username;
  private List<ForumUserComment> comments;

  @AllArgsConstructor
  @Getter
  @Builder
  public static class ForumUserComment {
    private String name;
    private String email;
    private String body;
  }
}
