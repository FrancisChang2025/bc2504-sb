package com.bootcamp.demo.bc_mtr_station.entity;

import jakarta.annotation.Nonnull;
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
import lombok.Setter;

@AllArgsConstructor
@Getter
@Entity
@Table(name = "mtr_stations")
@Builder
public class StationEntity {
  @Id  // ! PK = non-null + unique
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;  // safeguard java level

  @Column(name = "station_code", length = 3, nullable = false) // table column definition
  @Nonnull
  private String code;

  @Column(name = "station_desc", length = 100, nullable = false)
  @Nonnull
  private String description;

  @ManyToOne
  @JoinColumn(name = "line_id", nullable = false) // ! DB table column line_id
  @Nonnull
  @Setter
  private LineEntity lineEntity; // getLineEntity(), setLineEntity()
}
