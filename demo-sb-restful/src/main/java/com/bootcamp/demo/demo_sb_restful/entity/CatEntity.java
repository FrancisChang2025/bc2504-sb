package com.bootcamp.demo.demo_sb_restful.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// ! Use Java to write SQL (Create table) 
// create table cats (id bigint primary key auto_increment. cat_name varchar(50), cat_age numeric(3.0));

// In entity, we never use primitive. Instead, we use Wrapper Class.

@Entity
@Table(name = "cats")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CatEntity {
  @Id // Primary Key 🔑
  @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
  private Long id; 

  @Column(name = "cat_name", length = 50)
  private String name;

  @Column(name = "cat_age")
  private Integer age;

  @ManyToOne
  @JoinColumn(name = "zoo_id")  // cats.zoo_id(FK) join ZooEntity's PK
  private ZooEntity zooEntity;
}
