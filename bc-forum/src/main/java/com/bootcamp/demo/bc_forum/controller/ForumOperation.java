package com.bootcamp.demo.bc_forum.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.bootcamp.demo.bc_forum.dto.ForumUserCommentListDTO;
import com.bootcamp.demo.bc_forum.dto.ForumUserDTO;
import com.bootcamp.demo.bc_forum.dto.request.PostReqDTO;
import com.bootcamp.demo.bc_forum.dto.response.ForumPostDTO2;
import com.bootcamp.demo.bc_forum.entity.PostEntity;

public interface ForumOperation {
  // ! Exercise 2 Task 3A
  @ResponseStatus(value = HttpStatus.OK)
  @GetMapping(value = "/forum/users")
  List<ForumUserDTO> getForumUsers();

  // ! Exercise 2 Task 3B
  @ResponseStatus(value = HttpStatus.OK)
  @GetMapping(value = "/forum/user/{id}/comments")
  ForumUserCommentListDTO getForumComments(
      @PathVariable(value = "id") String userId);

  // PostEntity -> Not used for controller
  @PostMapping(value = "/forum/user/{id}/post")
  PostEntity createPost(@PathVariable Long id,
        @RequestBody PostReqDTO postReqDTO);

  @GetMapping(value = "/forum/user/{id}/posts")
  List<ForumPostDTO2> getPostByUserId(
    @PathVariable Long id);

}
