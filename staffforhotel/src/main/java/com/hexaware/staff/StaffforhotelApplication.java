package com.hexaware.staff;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StaffforhotelApplication {

	public static void main(String[] args) {
		SpringApplication.run(StaffforhotelApplication.class, args);
	}
	
	@Bean
	public RestTemplate  getRestTemplate() {
		
		return new RestTemplate();
		
	}
}
