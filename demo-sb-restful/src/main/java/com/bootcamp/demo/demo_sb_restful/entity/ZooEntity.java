package com.bootcamp.demo.demo_sb_restful.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Zoos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ZooEntity {
  @Id  // PK
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;
  private LocalDateTime createDate;

  @PrePersist
  protected void onCreate() {
    this.createDate = LocalDateTime.now();
  }
}
