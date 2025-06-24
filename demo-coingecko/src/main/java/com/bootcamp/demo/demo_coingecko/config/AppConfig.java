package com.bootcamp.demo.demo_coingecko.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.ObjectMapper;

@Configuration
public class AppConfig {
  @Bean
  RestTemplate restTemplate() {
    return new RestTemplate();
  }

  // pom.xml -> dependency -> class file
  // get key -> return vale (similar hashmap)

  // ! The bean of RedisTemplate depends on RedisConnectionFactory and ObjectMapper
  // You spring context by default contains the bean of RedisConnectonFactory
  // But ObjectMapper need to be created by youself
  @Bean
  RedisTemplate<String, String> redisTemplate(RedisConnectionFactory factory, 
      ObjectMapper objectMapper) {
    RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
    redisTemplate.setConnectionFactory(factory);
    redisTemplate.setKeySerializer(RedisSerializer.string());
    redisTemplate.setValueSerializer(RedisSerializer.json());
    redisTemplate.afterPropertiesSet();
    return redisTemplate;
  }

  @Bean
  ObjectMapper objectMapper() {
    return new ObjectMapper();
  }
}
