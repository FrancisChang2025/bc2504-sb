package com.bootamp.demo.demo_coin_app.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Getter;
import lombok.ToString;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@Getter
@ToString
public class CoinData {
    private String id;
    private String symbol;
    private String name;
    private String image;
    private Double currentPrice;
    private Double marketCap;
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
    private Double circulatingSupply;
    private Double totalSupply;
    private Double maxSupply;
    private Double ath;
    private Double athChangePercentage;
    private LocalDateTime athDate;
    private Double atl;
    private Double atlChangePercentage;
    private LocalDateTime atlDate;
    private ROI roi;
    private LocalDateTime lastUpdated;

    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    @Getter
    public static class ROI {
        private Double times;
        private String currency;
        private Double percentage;
    }
}
