package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootRestProj11MvcConsumerAppApplication {

	@Bean("restTemplate")
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication
				.run(SpringBootRestProj11MvcConsumerAppApplication.class, args);
	}

}
