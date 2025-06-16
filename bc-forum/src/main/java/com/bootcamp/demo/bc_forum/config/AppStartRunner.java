package com.bootcamp.demo.bc_forum.config;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_forum.entity.CommentEntity;
import com.bootcamp.demo.bc_forum.entity.PostEntity;
import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.entity.mapper.EntityMapper;
import com.bootcamp.demo.bc_forum.model.dto.CommentDTO;
import com.bootcamp.demo.bc_forum.model.dto.PostDTO;
import com.bootcamp.demo.bc_forum.model.dto.UserDTO;
import com.bootcamp.demo.bc_forum.service.CommentService;
import com.bootcamp.demo.bc_forum.service.PostService;
import com.bootcamp.demo.bc_forum.service.UserService;

// ! Spring Program: being triggered during server starts
// @Autowired (required = false)
// private CommandLineRunner commandLineRunner;

// if (commandLineRunner != null { commandLineRunner.run();})

@Component
public class AppStartRunner implements CommandLineRunner {
  @Autowired
  private UserService userService;
  @Autowired
  private PostService postService;
  @Autowired
  private CommentService commentService;
  @Autowired
  private EntityMapper entityMapper;


  // ! Server start: Spring Context Manager trigger run()
  @Override
  public void run(String... args) throws Exception {
    // System.out.println("Hello world !!!!!!");
    // Step 1: Call JsonPlaceHolder.com
    List<UserDTO> userDTOs = this.userService.getUsers();
    List<PostDTO> postDTOs = this.postService.getPosts();
    List<CommentDTO> commentDTOs = this.commentService.getComments();
    
    // Step 2: Convert from DTO to Entity by mapper (3 Entity and 3 Repository)
    List<UserEntity> userEntities = new ArrayList<>();
    List<PostEntity> postEntities = new ArrayList<>();
    List<CommentEntity> commentEntities = new ArrayList<>();

    UserEntity userEntity = null;
    PostEntity postEntity = null;
    CommentEntity commentEntity = null;
    for (UserDTO userDTO : userDTOs) {
      userEntity = this.entityMapper.map(userDTO);
      userEntities.add(userEntity);
      for (PostDTO postDTO : postDTOs) {
        if (postDTO.getUserId().equals(userDTO.getId())) {
          postEntity = this.entityMapper.map(postDTO, userEntity); // ! FK
          postEntities.add(postEntity);
          for (CommentDTO commentDTO : commentDTOs) {
            if (commentDTO.getPostId().equals(postDTO.getId())) {
              commentEntity = this.entityMapper.map(commentDTO, postEntity); // ! FK
              commentEntities.add(commentEntity);
            }
          }
        }
      }
    }
    // Step 3: Insert into DB (Users, Posts, Comments)
    this.commentService.deleteAll(); // require empty constructor
    this.postService.deleteAll(); // require empty constructor
    this.userService.deleteAll(); // require empty constructor

    this.userService.saveAll(userEntities);
    this.postService.saveAll(postEntities);
    this.commentService.saveAll(commentEntities);
  }
}