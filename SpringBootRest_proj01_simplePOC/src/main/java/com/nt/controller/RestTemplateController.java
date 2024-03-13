package com.nt.controller;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/template")
public class RestTemplateController {

	@GetMapping("/rest_template")
	public String restTemplateMethod(Map<String, Object> map) {
		RestTemplate temp = new RestTemplate();
		String serviceUrl = "http://localhost:4145/employee_management_system/rest/";
		ResponseEntity<String> res = temp.getForEntity(serviceUrl, String.class);
		String message = res.getBody();
		map.put("message", message);
		return "message";

	}

	@GetMapping("/send_request_body")
	@ResponseBody
	public ResponseEntity<Employee> sendRequestBody() throws Exception {
		RestTemplate temp = new RestTemplate();
		String serviceUrl = "http://localhost:4132/request_body/employee/register";

		String body = "{ \"empno\":434, \"ename\":\"siva\", \"job\":\"software\",  \"sal\":5345}";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<String> entity = new HttpEntity<String>(body, headers);
		ResponseEntity<String> response = temp.exchange(serviceUrl, HttpMethod.POST, entity, String.class);

		String body2 = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		Employee readValue = mapper.readValue(body2, Employee.class);
		System.out.println(response.getBody());
		return ResponseEntity.ok(readValue);
	}

}
