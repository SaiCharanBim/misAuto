package com.example.apiTestting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration
public class ApiTesttingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiTesttingApplication.class, args);
	}
    @Bean
	public RestTemplate restTemplate (){ return new RestTemplate();}
}
