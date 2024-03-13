package com.nt.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.MobileInfo;

@Component
public class ExchangeMethodTestRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {

		RestTemplate template = new RestTemplate();
		String serviceUrl = "http://localhost:4141/mini_proj_03_producer_app/mobile/reportById/{id}";
		HttpHeaders header = new HttpHeaders();
		header.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<String> response = template.exchange(serviceUrl,
				HttpMethod.GET, null, String.class, 100);// here nulll is
															// request
		// body
		System.out.println("response body:" + response.getBody());
		System.out.println("response status:" + response.getStatusCode());

		System.out.println("***********************");
		// converting json text into java class object
		String jsonBody = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		MobileInfo mobile = mapper.readValue(jsonBody, MobileInfo.class);
		System.out.println("response body as the mobile data" + mobile);

	}
}
