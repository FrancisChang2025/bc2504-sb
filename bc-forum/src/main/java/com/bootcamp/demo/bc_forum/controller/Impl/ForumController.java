package com.bootcamp.demo.bc_forum.controller.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_forum.controller.ForumOperation;
import com.bootcamp.demo.bc_forum.dto.ForumCommentDTO;
import com.bootcamp.demo.bc_forum.dto.ForumPostDTO;
import com.bootcamp.demo.bc_forum.dto.ForumUserCommentListDTO;
import com.bootcamp.demo.bc_forum.dto.ForumUserCommentListDTO.ForumUserComment;
import com.bootcamp.demo.bc_forum.dto.mapper.DTOMapper;
import com.bootcamp.demo.bc_forum.exception.NotFoundException;
import com.bootcamp.demo.bc_forum.exception.SysError;
import com.bootcamp.demo.bc_forum.dto.ForumUserDTO;
import com.bootcamp.demo.bc_forum.model.dto.CommentDTO;
import com.bootcamp.demo.bc_forum.model.dto.PostDTO;
import com.bootcamp.demo.bc_forum.model.dto.UserDTO;
import com.bootcamp.demo.bc_forum.service.CommentService;
import com.bootcamp.demo.bc_forum.service.PostService;
import com.bootcamp.demo.bc_forum.service.UserService;

@RestController
public class ForumController implements ForumOperation {
  @Autowired
  private UserService userService;
  @Autowired
  private PostService postService;
  @Autowired
  private CommentService commentService;
  @Autowired
  private DTOMapper dtoMapper;

  // ! Task 3A
  @Override
  public List<ForumUserDTO> getForumUsers() {
    List<UserDTO> userDTOs = this.userService.getUsers();
    List<PostDTO> postDTOs = this.postService.getPosts();
    List<CommentDTO> commentDTOs = this.commentService.getComments();

    List<ForumUserDTO> forumUserDTOs = new ArrayList<>();
    for (UserDTO userDTO : userDTOs) {
      List<ForumPostDTO> forumPostDTOs = new ArrayList<>();
      for (PostDTO postDTO : postDTOs) {
        if (postDTO.getUserId() == userDTO.getId()) {

          List<ForumCommentDTO> forumCommentDTOs = new ArrayList<>();
          for (CommentDTO commentDTO : commentDTOs) {
            if (commentDTO.getPostId() == postDTO.getId()) {
              ForumCommentDTO forumCommentDTO = this.dtoMapper.map(commentDTO);
              forumCommentDTOs.add(forumCommentDTO);
            }  
          }
          ForumPostDTO forumPostDTO = this.dtoMapper.map(postDTO, forumCommentDTOs);
          forumPostDTOs.add(forumPostDTO);
        }
      }
      ForumUserDTO forumUserDTO = this.dtoMapper.map(userDTO, forumPostDTOs);
      forumUserDTOs.add(forumUserDTO);
    }
    return forumUserDTOs;
  }

  // ! Task 3B
  @Override
  public ForumUserCommentListDTO getForumComments(String userId) {

    long uId = Long.parseLong(userId);

    List<UserDTO> userDTOs = this.userService.getUsers(); // Internet
    System.out.println(userDTOs);
    List<CommentDTO> commentDTOs = this.commentService.getComments(); // Internet

    UserDTO userDTO = userDTOs.stream() //
        .filter(dto -> dto.getId() == uId) //
        .findAny() // return Optional
        .orElseThrow(() -> new NotFoundException(SysError.USER_NOT_FOUND));

    List<ForumUserCommentListDTO.ForumUserComment> forumUserComments =
        this.postService.getPosts(uId).stream() //
            .flatMap(postDTO -> commentDTOs.stream() //
                .filter(c -> c.getPostId() == postDTO.getId()) //
                .map(c -> ForumUserComment.builder() //
                    .name(c.getName()) //
                    .email(c.getEmail()) //
                    .body(c.getBody()) //
                    .build()))
            .collect(Collectors.toList());

    return ForumUserCommentListDTO.builder() //
        .userId(userDTO.getId()) //
        .username(userDTO.getUsername()) //
        .comments(forumUserComments) //
        .build();
  }
}
