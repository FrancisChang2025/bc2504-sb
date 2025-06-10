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

  // ! Task 3A
  @Override
  public List<ForumUserDTO> getForumUsers() {
    List<UserDTO> userDTOs = this.userService.getUsers();
    List<PostDTO> postDTOs = this.postService.getPosts();
    List<CommentDTO> commentDTOs = this.commentService.getComments();

    List<ForumUserDTO> forumUserDTOs = new ArrayList<>();
    for (UserDTO userDTO : userDTOs) {

      ForumUserDTO.ForumUserAddressDTO.ForumUserGeoDTO forumUserGeoDTO =
          ForumUserDTO.ForumUserAddressDTO.ForumUserGeoDTO.builder() //
              .lat(userDTO.getAddress().getGeo().getLat()) //
              .lng(userDTO.getAddress().getGeo().getLng()) //
              .build();

      ForumUserDTO.ForumUserAddressDTO forumUserAddressDTO =
          ForumUserDTO.ForumUserAddressDTO.builder() //
              .city(userDTO.getAddress().getCity()) //
              .suite(userDTO.getAddress().getSuite()) //
              .street(userDTO.getAddress().getStreet()) //
              .zipcode(userDTO.getAddress().getZipcode()) //
              .geo(forumUserGeoDTO) //
              .build();

      ForumUserDTO.ForumUserCompanyDTO forumUserCompanyDTO =
          ForumUserDTO.ForumUserCompanyDTO.builder()//
              .bs(userDTO.getCompany().getBs()) //
              .catchPhrase(userDTO.getCompany().getCatchPhrase()) //
              .name(userDTO.getCompany().getName()) //
              .build();

      List<ForumPostDTO> forumPostDTOs = new ArrayList<>();
      for (PostDTO postDTO : postDTOs) {
        if (postDTO.getUserId() == userDTO.getId()) {

          List<ForumCommentDTO> forumCommentDTOs = new ArrayList<>();
          for (CommentDTO commentDTO : commentDTOs) {
            if (commentDTO.getPostId() == postDTO.getId()) {
              ForumCommentDTO forumCommentDTO = ForumCommentDTO.builder() //
                  .id(commentDTO.getId()) //
                  .email(commentDTO.getEmail()) //
                  .name(commentDTO.getName()) //
                  .body(commentDTO.getBody()) //
                  .build();
              forumCommentDTOs.add(forumCommentDTO);
            }
          }

          ForumPostDTO forumPostDTO = ForumPostDTO.builder() //
              .id(postDTO.getId()) //
              .title(postDTO.getTitle()) //
              .body(postDTO.getBody()) //
              .comments(forumCommentDTOs) //
              .build();
          forumPostDTOs.add(forumPostDTO);
        }
      }

      ForumUserDTO forumUserDTO = ForumUserDTO.builder().id(userDTO.getId()) //
          .name(userDTO.getName()) //
          .username(userDTO.getUsername()) //
          .website(userDTO.getWebsite()) //
          .email(userDTO.getEmail()) //
          .phone(userDTO.getPhone()) //
          .address(forumUserAddressDTO) //
          .company(forumUserCompanyDTO) //
          .posts(forumPostDTOs) //
          .build();
      forumUserDTOs.add(forumUserDTO);
    }
    return forumUserDTOs;
  }

  // ! Task 3B
  @Override
  public ForumUserCommentListDTO getForumComments(Long userId) {
    List<UserDTO> userDTOs = this.userService.getUsers(); // Internet
    List<CommentDTO> commentDTOs = this.commentService.getComments(); // Internet

    UserDTO userDTO = userDTOs.stream() //
        .filter(dto -> dto.getId() == userId) //
        .findAny() // return Optional
        .orElseThrow(
            () -> new IllegalArgumentException("No such user id:" + userId));

    List<ForumUserCommentListDTO.ForumUserComment> forumUserComments =
        this.postService.getPosts(userId).stream() //
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
