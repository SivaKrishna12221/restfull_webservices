package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ExchangeMethodForPost implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {
		String serviceUrl = "http://localhost:4141/mini_proj_03_producer_app/mobile/register";
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		String jsonBody = "{\"name\":\"realme\",\"mid\":100,\"price\":20000,\"memory\":\"12gb\"}";
		HttpEntity entity = new HttpEntity<String>(jsonBody, header);
		ResponseEntity<String> response = template.exchange(serviceUrl,
				HttpMethod.POST, entity, String.class);
		System.out.println("response status code:" + response.getStatusCode());
		System.out.println("response body:" + response.getBody());

	}
}
