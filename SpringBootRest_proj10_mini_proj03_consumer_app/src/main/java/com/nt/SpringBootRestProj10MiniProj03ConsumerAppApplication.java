package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringBootRestProj10MiniProj03ConsumerAppApplication {

	@Bean("createTemplate")
	public RestTemplate createRestTemplate() {
		return new RestTemplate();
	}
	public static void main(String[] args) {
		SpringApplication.run(
				SpringBootRestProj10MiniProj03ConsumerAppApplication.class,
				args);
	}

}
