package com.bootcamp.demo.demo_sb_restful.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ZooReqDTO {
  private String name;
  private List<String> cats;  // List of cat names
}
