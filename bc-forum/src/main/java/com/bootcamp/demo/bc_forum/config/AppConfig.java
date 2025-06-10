package com.bootcamp.demo.bc_forum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

// Java Build-in Class

@Configuration
public class AppConfig {
  // ! created at Spring Context after server start
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
