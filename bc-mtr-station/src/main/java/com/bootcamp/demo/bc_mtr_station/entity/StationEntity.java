package com.bootcamp.demo.bc_mtr_station.entity;

import jakarta.annotation.Nonnull;   // ! jakarta DB
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

@Entity
@Table(name = "mtr_stations")
@AllArgsConstructor
@Getter
@Builder
public class StationEntity {
  @Id  // PK = non-null + unique
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "station_code", length = 3, nullable = false) // table column definition
  @Nonnull  // Safeguard java level
  private String code;

  @Column(name = "station_description", length = 100, nullable = false)
  @Nonnull
  private String description;

  @ManyToOne
  @JoinColumn(name = "line_id", nullable = false) // ! DB table column line_id
  @Nonnull
  private LineEntity lineEntity; // getLineEntity(), setLineEntity()
  
}
