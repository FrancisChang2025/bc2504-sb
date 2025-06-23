package com.bootcamp.demo.demo_coingecko.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CoinDTO {
  private String id;
  private String symbol;
  private String name;
  private String image;
  private Double currentPrice;
  private Long marketCap;
  private Integer marketCapRank;
  private Double high24h;
  private Double low24h;
}
