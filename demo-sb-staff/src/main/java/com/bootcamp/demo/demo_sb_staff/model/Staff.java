package com.bootcamp.demo.demo_sb_staff.model;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class Staff {
  public static List<Staff> staffs = new ArrayList<>();

  private Long id;
  private String name;
  private int age;
}
