package com.bootcamp.demo.bc_forum.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class UserDTO {
  private Long id;
  private String name;
  private String username;
  private String email;
  private Address address;
  private String phone;
  private String website;
  private Company company;

  @AllArgsConstructor
  @Getter
  @Setter
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;

    @AllArgsConstructor
    @Getter
    @Setter
    public static class Geo {
      private String lat;
      private String lng;
    }
  }

  @AllArgsConstructor
  @Getter
  @Setter
  public static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}
