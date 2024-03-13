package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@Component
public class TestRestTemplateCricketer implements CommandLineRunner {
	@Override
	public void run(String... args) throws Exception {
		// create rest template object
		RestTemplate temp = new RestTemplate();
		// define service url
		String serviceUrl = "http://localhost:4138/mini_proj_provider/cricketer/register";
		// prepare json data
		String jsonBody = "{\"name\":\"Dhoni\",\"age\":40,\"jersy\":7,\"typeOfPlayer\":\"rightHandBatsman\"}";
		// prepare header
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		// prepare http request as httpentity obj having head ,body
		HttpEntity<String> request = new HttpEntity<String>(jsonBody, header);
		// prepare http request call in post type mode
		ResponseEntity<String> response = temp.postForEntity(serviceUrl,
				request, String.class);
		System.out.println("response body:" + response.getBody());
		System.out.println("response status code:" + response.getStatusCode());
		System.out.println(
				"response status headers:" + response.getHeaders().toString());
		System.out.println("response status code:" + response.getStatusCode());
		System.exit(0);// optional
	}

}
