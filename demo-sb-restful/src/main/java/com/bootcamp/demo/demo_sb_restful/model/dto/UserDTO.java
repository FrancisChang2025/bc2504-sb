package com.bootcamp.demo.demo_sb_restful.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

// ! For Deserialization
@AllArgsConstructor
@Getter
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
  public static class Address {
    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
  }

  @AllArgsConstructor
  @Getter
  public static class Geo {
    private String lat;
    private String lng;
  }

  @AllArgsConstructor
  @Getter
  public static class Company {
    private String name;
    private String catchPhrase;
    private String bs;
  }
}

