package com.bootcamp.demo.bc_mtr_station.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
  // ! maven(pom.xml) -> External Class -> object (bean)
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  // ! mapper (custom class) -> @Component
}
