package com.bootcamp.demo.bc_forum.entity.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_forum.dto.request.PostReqDTO;
import com.bootcamp.demo.bc_forum.entity.CommentEntity;
import com.bootcamp.demo.bc_forum.entity.PostEntity;
import com.bootcamp.demo.bc_forum.entity.UserEntity;
import com.bootcamp.demo.bc_forum.model.dto.CommentDTO;
import com.bootcamp.demo.bc_forum.model.dto.PostDTO;
import com.bootcamp.demo.bc_forum.model.dto.UserDTO;

// Usage: Map something to Entity

@Component
public class EntityMapper {
  // DTO to Entity
  public PostEntity map(PostReqDTO postReqDTO, UserEntity userEntity) {
    return PostEntity.builder()  //
        .title(postReqDTO.getTitle()) //
        .body(postReqDTO.getBody())  //
        .userEntity(userEntity)  // ! FK in Java
        .build();
  }

  public CommentEntity map(CommentDTO commentDTO, PostEntity postEntity) {
    return CommentEntity.builder() //
        .name(commentDTO.getName()) //
        .body(commentDTO.getBody()) //
        .postEntity(postEntity) // ! FK in Java
        .build();
  }

  public PostEntity map(PostDTO postDTO, UserEntity userEntity) {
    return PostEntity.builder() //
        .title(postDTO.getTitle()) //
        .body(postDTO.getBody()) //
        .userEntity(userEntity) // ! FK in Java
        .build();
  }

  public UserEntity map(UserDTO userDTO) {
    return UserEntity.builder() //
    .lat(userDTO.getAddress().getGeo().getLat()) //
    .lng(userDTO.getAddress().getGeo().getLng()) //
    .catchPhrase(userDTO.getCompany().getCatchPhrase()) //
    .bs(userDTO.getCompany().getBs()) //
    .companyName(userDTO.getCompany().getName()) //
    .name(userDTO.getName()) //
    .email(userDTO.getEmail()) //
    .website(userDTO.getWebsite()) //
    .username(userDTO.getUsername()) //
    .phone(userDTO.getPhone()) //
    .city(userDTO.getAddress().getCity()) //
    .zipcode(userDTO.getAddress().getZipcode()) //
    .suite(userDTO.getAddress().getSuite()) //
    .street(userDTO.getAddress().getStreet()) //
    .build();
  }
}
