package com.bootcamp.demo.demo_sb_staff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoSbStaffApplication {
	public static ConfigurableApplicationContext context;

	public static void main(String[] args) {
		context = SpringApplication.run(DemoSbStaffApplication.class, args);
	}

}
