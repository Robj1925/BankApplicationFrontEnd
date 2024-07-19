package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class RestclientDemoApplication {
	private final String EMPLOYEE_BASE_URL = "http://localhost:8082";

	public static void main(String[] args) {
		SpringApplication.run(RestclientDemoApplication.class, args);
	}

	@Bean
	public WebClient.Builder webClientBuilder() {
		return WebClient.builder();
	}

	@Bean
	public WebClient employeeWebClient(WebClient.Builder builder) {
		return builder.baseUrl(EMPLOYEE_BASE_URL)
				.defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE).build();
	}

}
