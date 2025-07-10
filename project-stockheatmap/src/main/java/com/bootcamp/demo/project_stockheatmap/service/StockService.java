package com.bootcamp.demo.project_stockheatmap.service;

import java.util.List;
import com.bootcamp.demo.project_stockheatmap.model.StockNode;

public interface StockService {
  List<StockNode> getStockData();
}
