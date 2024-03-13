package com.nt.runner;

import java.util.Map;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TestRestTemplateClass implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:4138/mini_proj_provider/cricketer/getInfo/{id}/{name}";
		/*
		 * ResponseEntity<String> response = template.getForEntity(serviceUrl,
		 * String.class, Map.of("id", 10, "name", "siva")); System.out.println(
		 * "cricketer get mode for response body:" + response.getBody());
		 * System.out.println("get mode header:" + response.getHeaders());
		 * System.out.println( "response status values:" +
		 * response.getStatusCodeValue()); System.out.println("response code" +
		 * response.getStatusCode());
		 */
		Object response = template.getForObject(serviceUrl, String.class,
				Map.of("id", 21, "name", "siva"));
		System.out.println(response);
	}
}
