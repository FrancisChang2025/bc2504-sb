package com.bootcamp.demo.bc_forum.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.bootcamp.demo.bc_forum.dto.ForumUserCommentListDTO;
import com.bootcamp.demo.bc_forum.dto.ForumUserDTO;

public interface ForumOperation {
  @GetMapping(value = "/forum/users")
  List<ForumUserDTO> getForumUsers();

  @GetMapping(value = "/forum/users/{id}")
  ForumUserCommentListDTO getForumComments(
    @PathVariable(value = "id") Long userId);
}