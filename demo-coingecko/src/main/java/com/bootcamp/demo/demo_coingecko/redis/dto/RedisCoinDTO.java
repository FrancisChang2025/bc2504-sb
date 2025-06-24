package com.bootcamp.demo.demo_coingecko.redis.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Builder
@NoArgsConstructor
public class RedisCoinDTO {
  private String symbol;
  private String name;
  private String image;
  private Double currentPrice;
  private Double marketCap;
  private Double pricechange24h;
  private Double pricechangePercentage24h;
  private String coingeckoId;
}
