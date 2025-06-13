package com.bootcamp.demo.demo_sb_staff.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "staffs")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder

public class StaffEntity {
  @Id
  private Long id;
  @Column(name = "staff_name")
  private String name;
  @Column(name = "staff_age")
  private Integer age;
}
