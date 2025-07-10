package com.bootcamp.demo.project_stockheatmap.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bootcamp.demo.project_stockheatmap.model.StockNode;
import com.bootcamp.demo.project_stockheatmap.service.StockService;

@Service
public class StockServiceImpl implements StockService {
  @Autowired
  private RestTemplate restTemplate;

  @Override
  public List<StockNode> getStockData() {
    String apiUrl = "";
    StockNode[] response = restTemplate.getForObject(apiUrl, StockNode[].class);
    return Arrays.asList(response);
  }
}
