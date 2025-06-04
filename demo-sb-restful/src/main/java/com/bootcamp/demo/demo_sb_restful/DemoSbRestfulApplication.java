package com.bootcamp.demo.demo_sb_restful;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoSbRestfulApplication {
	// ! After server start, we got the spring context memory location
	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(DemoSbRestfulApplication.class, args);  // 7x24
	}

}
