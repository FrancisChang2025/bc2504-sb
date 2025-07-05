package com.bootamp.demo.demo_coin_app.dto;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Builder
@ToString
public class CoinTableDTO {
  private String id;
  private String symbol;
  private String name;
  private String image;
  @JsonProperty("current_price")
  private Double currentPrice;
  @JsonProperty("market_cap")
  private Double marketCap;
  @JsonProperty("price_change_percentage_24h")
  private Double priceChangePercent24h;
  @JsonProperty("last_updated")

  // {"date" : "Jan, 01, 2025"}
  // @JsonDeserialize(using = CustomTimestampDeserializer.class)
  private LocalDateTime lastUpdated;
}
