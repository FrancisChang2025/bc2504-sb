package com.bootcamp.demo.demo_coingecko.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Coin {
  private String symbol;
  private String name;
  private String image;
  private Double currentPrice;
  private Double marketCap;
  private Double pricechange24h;
  private Double pricechangePercentage24h;
  private String coingeckoId;
}
