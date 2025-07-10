package com.bootcamp.demo.project_stockheatmap.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.project_stockheatmap.controller.HeatMapOperation;
import com.bootcamp.demo.project_stockheatmap.model.StockNode;
import com.bootcamp.demo.project_stockheatmap.service.StockService;

@RestController
public class HeatMapController implements HeatMapOperation{
  @Autowired
  private StockService stockService;
  
  @Override
  public String getHeatMap(Model model) {
    List<StockNode> stocks = stockService.getStockData(); // ticker, sector, change%, marketCap
    model.addAttribute("stockData", stocks);
    return "heatMap";
  }

  
}
