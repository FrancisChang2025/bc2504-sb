package com.bootcamp.demo.demo_coingecko.entity;

import java.io.Serializable;
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
@Table(name = "coins")
@NoArgsConstructor
@Builder
public class CoinEntity implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String symbol;
  @Column(length = 100)
  private String name;
  private String image;
  @Column(name = "price")
  private Double currentPrice;
  @Column(name = "market_cap")
  private Double marketCap;
  @Column(name = "price_change_24h")
  private Double pricechange24h;
  @Column(name = "price_change_percentate_24h", columnDefinition = "DECIMAL(10,2)") // decimal(8,2)
  private Double priceCapchangePercentage24h;
  @Column(name = "coingecko_id")
  private String coingeckoId;
}
