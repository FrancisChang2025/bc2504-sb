package com.bootcamp.demo.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import com.bootcamp.demo.bc_forum.dto.ForumUserCommentListDTO;
import com.bootcamp.demo.bc_forum.dto.ForumUserDTO;

public interface ForumOperation {
  @GetMapping(value = "/forum/users")
  List<ForumUserDTO> getForumUsers();

  @GetMapping(value = "/forum/user/{id}/comments")
  ForumUserCommentListDTO getForumComments(Long userId);
}
