package com.bootcamp.demo.demo_crypto.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class CoinDTO {
  private String id;
  private String symbol;
  private String name;
  private String image;
  private Double currentPrice;
  private Double marketCap;
  private Integer marketCapRank;
  private Long totalVolume;
  private Double priceChange24h;
  private Double priceChangePercentage24h;
}
