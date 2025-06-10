package com.bootcamp.demo.bc_forum.config;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

// Java Built-in Class

@Configurable
public class AppConfig {
  @Bean // ! created at Spring Context after server start
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
