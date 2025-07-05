package com.bootcamp.demo.model.dto;

import java.time.LocalDateTime;
import com.bootcamp.demo.util.CustomTimestamDeserializer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Builder
@ToString
@NoArgsConstructor
public class CoinDTO {
  private String id;
  private String symbol;
  private String name;
  private String image;
  @JsonProperty("current_price")
  private Double currentPrice;
  @JsonProperty("market_cap")
  private Long marketCap;
  @JsonProperty("price_change_percentage_24h")
  private Double priceChangePercent24h;
  @JsonProperty("last_updated")
  @JsonDeserialize(using = CustomTimestamDeserializer.class)
  private LocalDateTime lastUpdated;
}
