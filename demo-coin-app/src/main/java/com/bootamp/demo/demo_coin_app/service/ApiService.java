package com.bootamp.demo.demo_coin_app.service;

import java.util.List;
import com.bootamp.demo.demo_coin_app.model.CoinData;

public interface ApiService {
  List<CoinData> fetchCoinData();
}
