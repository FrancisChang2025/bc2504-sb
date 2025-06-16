package com.bootcamp.demo.bc_forum.dto.request;

import lombok.Getter;

// Caller (JSON) -> Spring boot (Java Object)
@Getter
public class PostReqDTO {
  private String title;
  private String body;
}
