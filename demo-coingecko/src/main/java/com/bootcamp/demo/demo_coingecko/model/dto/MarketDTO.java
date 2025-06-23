package com.bootcamp.demo.demo_coingecko.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
public class MarketDTO {
  private String id;
  private String symbol;
  private String name;
  private String image;
  private Double currentPrice;
  private Long marketCap;
  private Integer marketCapRank;
  private Long fullyDilutedValuation;
  private Long totalVolume;
  @JsonProperty(value = "high_24h")
  private Double high24h;
  @JsonProperty(value = "low_24h")
  private Double low24h;
  @JsonProperty(value = "price_change_24h")
  private Double priceChange24h;
  @JsonProperty(value = "price_change_percentage_24h")
  private Double priceChangePercentage24h;
  @JsonProperty(value = "market_cap_change_24h")
  private Long marketCapChange24h;
  @JsonProperty(value = "market_cap_change_percentage_24h")
  private Double marketCapChangePercentage24h;
  private Long circulatingSupply;
  private Long totalSupply;
  private Long maxSupply;
  private Double ath;
  private Double athChangePercentage;
  private String athDate;
  private Double atl;
  private Double atlChangePercentage;
  private String atlDate;
  private Double roi; // Nullable
  private String lastUpdated;
}
