package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.model.Telivison;

@Component
public class TvlistTestRestTemplateRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;
	@Override
	public void run(String... args) throws Exception {
		String serviceUrl = "http://localhost:4141/mini_proj_03_producer_app/mobile/tvReport";
		ResponseEntity<String> response = template.exchange(serviceUrl,
				HttpMethod.GET, null, String.class);
		System.out.println("Response body:" + response.getBody());// it return
																	// json body

		System.out.println("==========***********===========");
		System.out.println("Converting json text data to class obj");
		String jsonBody = response.getBody();
		ObjectMapper mapper = new ObjectMapper();

		// List tv = mapper.readValue(jsonBody, List.class); it is working
		// System.out.println("Telivison class object:" + tv);
		/*
		 * Telivison[] tv2 = mapper.readValue(jsonBody, Telivison[].class);//not
		 * working return // array
		 * 
		 * List<Telivison> listOfTvs = Arrays.asList(tv2);
		 * listOfTvs.forEach(System.out::println);
		 */
		List<Telivison> listOfTourist = mapper.readValue(jsonBody,
				new TypeReference<List<Telivison>>() {
				});
		listOfTourist.forEach(System.out::println);
	}
}
