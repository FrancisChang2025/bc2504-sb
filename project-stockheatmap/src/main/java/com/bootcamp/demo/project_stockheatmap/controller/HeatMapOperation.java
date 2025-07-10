package com.bootcamp.demo.project_stockheatmap.controller;

import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;
import org.springframework.ui.Model;

public interface HeatMapOperation {
  @GetMapping
  String getHeatMap(Model model);

  @GetMapping(value = "stock/stockData")
  List<StockNode> getStockData(@)

}
