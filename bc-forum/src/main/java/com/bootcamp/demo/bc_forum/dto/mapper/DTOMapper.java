package com.bootcamp.demo.bc_forum.dto.mapper;

import java.util.List;
import org.springframework.stereotype.Component;
import com.bootcamp.demo.bc_forum.dto.ForumCommentDTO;
import com.bootcamp.demo.bc_forum.dto.ForumPostDTO;
import com.bootcamp.demo.bc_forum.dto.ForumUserDTO;
import com.bootcamp.demo.bc_forum.model.dto.CommentDTO;
import com.bootcamp.demo.bc_forum.model.dto.PostDTO;
import com.bootcamp.demo.bc_forum.model.dto.UserDTO;

// Map something to DTO
// Utility
@Component
public class DTOMapper {

  // POSTDTD -> ForumPOSTDTO
  public ForumPostDTO map(PostDTO postDTO,
      List<ForumCommentDTO> forumCommentDTOs) {
    return ForumPostDTO.builder() //
        .id(postDTO.getId()) //
        .title(postDTO.getTitle()) //
        .body(postDTO.getBody()) //
        .comments(forumCommentDTOs) //
        .build();
  }

  public ForumCommentDTO map(CommentDTO commentDTO) {
    return ForumCommentDTO.builder() //
        .id(commentDTO.getId()) //
        .email(commentDTO.getEmail()) //
        .name(commentDTO.getName()) //
        .body(commentDTO.getBody()) //
        .build();
  }

  public ForumUserDTO map(UserDTO userDTO, List<ForumPostDTO> forumPostDTOs) {
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
            .bs(userDTO.getCompany() //
                .getBs()) //
            .catchPhrase(userDTO.getCompany() //
                .getCatchPhrase()) //
            .name(userDTO.getCompany().getName()) //
            .build();

    return ForumUserDTO.builder().id(userDTO.getId()) //
        .name(userDTO.getName()) //
        .username(userDTO.getUsername()) //
        .website(userDTO.getWebsite()) //
        .email(userDTO.getEmail()) //
        .phone(userDTO.getPhone()) //
        .address(forumUserAddressDTO) //
        .company(forumUserCompanyDTO) //
        .posts(forumPostDTOs) //
        .build();
  }
}