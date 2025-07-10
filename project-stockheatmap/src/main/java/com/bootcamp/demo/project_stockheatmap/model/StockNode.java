package com.bootcamp.demo.project_stockheatmap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StockNode {
  private String id;
  private String name;
  private String parent; // sector
  private double mktvalue; // market cap or weight
  private double change; // percent change
}
