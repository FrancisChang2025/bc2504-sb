package com.bootcamp.demo.bc_forum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.demo.bc_forum.dto.ForumUserCommentListDTO;
import com.bootcamp.demo.bc_forum.dto.ForumUserDTO;

public interface ForumOperation {
  @ResponseStatus(value = HttpStatus.OK)
  @GetMapping(value = "/forum/users")
  List<ForumUserDTO> getForumUsers();

  @ResponseStatus(value = HttpStatus.OK)
  @GetMapping(value = "/forum/user/{id}/comments")
  ForumUserCommentListDTO getForumComments(
      @PathVariable(value = "id") String userId);

  // @ResponseStatus(value = HttpStatus.OK)
  // @PostMapping(value = "/forum/user/{id}/post")
  // ForumUserCommentListDTO getForumPosts(
  //   @PathVariable(value = "id") String postId);

}
