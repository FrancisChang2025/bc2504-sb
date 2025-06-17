package com.bootcamp.gov.data.demo_gov_data.entity;

import java.time.LocalDate;
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

// date max_temp, min_temp, max_rh, min_rh

@AllArgsConstructor
@Getter
@Entity
@Table(name = "weathers")
@Builder
@NoArgsConstructor
public class WeatherEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private LocalDate date;
  @Column(name = "max_temp")
  private Double maxTemp;
  @Column(name = "min_temp")
  private Double minTemp;
  @Column(name = "max_rh")
  private Double maxRh;
  @Column(name = "min_rh")
  private Double minRh;
}
