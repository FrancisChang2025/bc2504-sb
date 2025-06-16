package com.bootcamp.demo.bc_forum.controller.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.bc_forum.controller.ForumOperation;
import com.bootcamp.demo.bc_forum.dto.ForumCommentDTO;
import com.bootcamp.demo.bc_forum.dto.ForumPostDTO;
import com.bootcamp.demo.bc_forum.dto.ForumUserCommentListDTO;
import com.bootcamp.demo.bc_forum.dto.ForumUserCommentListDTO.ForumUserComment;
import com.bootcamp.demo.bc_forum.dto.mapper.DTOMapper;
import com.bootcamp.demo.bc_forum.dto.request.PostReqDTO;
import com.bootcamp.demo.bc_forum.dto.response.ForumPostDTO2;
import com.bootcamp.demo.bc_forum.entity.CommentEntity;
import com.bootcamp.demo.bc_forum.entity.PostEntity;
import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.entity.mapper.EntityMapper;
import com.bootcamp.demo.bc_forum.exception.NotFoundException;
import com.bootcamp.demo.bc_forum.exception.SysError;
import com.bootcamp.demo.bc_forum.dto.ForumUserDTO;
import com.bootcamp.demo.bc_forum.model.dto.CommentDTO;
import com.bootcamp.demo.bc_forum.model.dto.PostDTO;
import com.bootcamp.demo.bc_forum.model.dto.UserDTO;
import com.bootcamp.demo.bc_forum.repository.PostRepository;
import com.bootcamp.demo.bc_forum.service.CommentService;
import com.bootcamp.demo.bc_forum.service.PostService;
import com.bootcamp.demo.bc_forum.service.UserService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PostRemove;

@RestController
public class ForumController implements ForumOperation {
  // @Autowired
  // private final PostRepository postRepository;
  @Autowired
  private UserService userService;
  @Autowired
  private PostService postService;
  @Autowired
  private CommentService commentService;
  @Autowired
  private DTOMapper dtoMapper;
  @Autowired
  private EntityMapper entityMapper;

    // ForumController(PostRepository postRepository) {
    //     this.postRepository = postRepository;
    // }

  // ! Task 3A
  @Override
  public List<ForumUserDTO> getForumUsers() {
    // ! Revise to call DB
    List<CommentEntity> commentEntities = this.commentService.findAll();
    Map<Long, ForumUserDTO> userMap = new HashMap<>();

    for (CommentEntity commentEntity : commentEntities) {
      PostEntity postEntity = commentEntity.getPostEntity();
      UserEntity userEntity = postEntity.getUserEntity();

      if (!userMap.containsKey(userEntity.getId())) {
        // add entry: ForumUserDTO (posts list + curret comment)


        userMap.put(userEntity.getId(), );
        continue;
      }
      List<ForumPostDTO> forumPostDTOs userMap.get(userEntity.getId().getPosts();
      for

      // TODO commentEntity -> ForumCommentDTO
      for (ForumPostDTO forumPostDTOs : forumPostDTOs) {
        
      }
    }





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

  // One to Many, Create Child object to Database
  @Override
  public PostEntity createPost(Long id, PostReqDTO postReqDTO) {
    // Step 1: postReqDTO -> postEntity (Controller) (PK of PostEntity)
    UserEntity userEntity = this.userService.findById(id)  //
        .orElseThrow(() -> new NotFoundException(SysError.USER_NOT_FOUND));
    // Step 2: model -> postEntity (Services)
    PostEntity postEntity = this.entityMapper.map(postReqDTO, userEntity);
    // Step 3: save PostEntity
    return this.postService.save(postEntity);
  }

  @Override
  public List<ForumPostDTO2> getPostsByUserId(Long id) {
    return this.postService.getPostsByUserId(id) // return List<PostEntity>
        .stream() // return Stream<PostEntity>
        .map(e -> this.dtoMapper.map(e)) // return Stream<ForumPostDTO2>
        .collect(Collectors.toList()); // return List<ForumPostDTO2>
  }
}
