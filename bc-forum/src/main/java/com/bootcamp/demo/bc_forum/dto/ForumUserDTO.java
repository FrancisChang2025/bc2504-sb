package com.bootcamp.demo.bc_forum.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class ForumUserDTO {
  private Long id;
  private String name;
  private String username;
  private String email;
  private ForumUserAddressDTO address;
  private String phone;
  private String website;
  private ForumUserCompanyDTO company;
  private List<ForumPostDTO> posts; // ! Important

  @AllArgsConstructor
  @Getter
  @Builder
  public static class ForumUserAddressDTO {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private ForumUserGeoDTO geo;

    @AllArgsConstructor
    @Getter
    @Builder
    public static class ForumUserGeoDTO {
      private String lat;
      private String lng;
    }
  }

  @AllArgsConstructor
  @Getter
  @Builder
  public static class ForumUserCompanyDTO {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}
