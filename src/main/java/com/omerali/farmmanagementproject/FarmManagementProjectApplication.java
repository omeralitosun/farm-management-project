package com.omerali.farmmanagementproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class FarmManagementProjectApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FarmManagementProjectApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(FarmManagementProjectApplication.class);
	}
}
