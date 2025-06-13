package com.bootcamp.demo.bc_forum.entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "users")
@Builder
public class UserEntity implements Serializable { // Object -> JSON
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private String username;
  private String email;
  private String phone;
  private String website;
  private String street;
  private String zipcode;
  private String suite;
  private String city;
  @Column(name = "latutide")
  private String lat;
  @Column(name = "longuite")
  private String lng;
  @Column(name = "company_name")
  private String companyName;
  @Column(name = "catch_phrase")
  private String catchPhrase;
  private String bs;
}
