package com.bootamp.demo.demo_coin_app.entity;

import java.time.LocalDateTime;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "coinlist")
@AllArgsConstructor
@Getter
@Builder
public class ButtonEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Setter
  @Column(name = "submit_datatime")
  private LocalDateTime submitDateTime;

  private String coingecko_id;

  @Column(name = "coin_name")
  private String name;

  @Column(name = "coin_price")
  private Double currentPrice;
}
