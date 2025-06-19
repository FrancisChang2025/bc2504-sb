package com.bootcamp.demo.bc_mtr_station.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "mtr_lines")
@Builder
@NoArgsConstructor
public class LineEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "line_code", nullable = false)
  @Nonnull
  private String code;

  @Column(name = "line_desc", length = 100, nullable = false)
  @Nonnull
  private String description;
}
