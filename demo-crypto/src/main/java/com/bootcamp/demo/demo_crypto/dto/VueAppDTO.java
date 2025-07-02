package com.bootcamp.demo.demo_crypto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class VueAppDTO {
  @JsonProperty(value = "id")
  private String coingeckoId;
  private String symbol;
  private String name;
  private String image;
  @JsonProperty(value = "current_price")
  private Double currentPrice;
  @JsonProperty(value = "market_cap")
  private Double marketCap;
  @JsonProperty(value = "market_cap_rank")
  private Integer marketCapRank;
  @JsonProperty(value = "total_volume")
  private Long totalVolume;
  @JsonProperty(value = "price_chang_percentage_24h")
  private Double priceChangePercentage24h;
}
