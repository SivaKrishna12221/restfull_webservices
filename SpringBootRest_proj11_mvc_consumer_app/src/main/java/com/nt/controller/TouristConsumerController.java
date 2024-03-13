package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nt.entity.Tourist;

@Controller
@RequestMapping("/touristInfo")
public class TouristConsumerController {

	@Autowired
	private RestTemplate template;

	@GetMapping("/home")
	public String showTouristHome() {
		return "tourist";
	}
	@GetMapping("/list_of_tourist")
	public String listOfTourist(Map<String, Object> map) throws Exception {
		// url/uri="http://localhost:4133/rest_crud_operation/tourist/report
		String serviceUrl = "http://localhost:4134/rest_exception_handler/tourist/report";
		ResponseEntity<String> response = template.exchange(serviceUrl,
				HttpMethod.GET, null, String.class);
		String jsonBody = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		List<Tourist> listoftourist = mapper.readValue(jsonBody,
				new TypeReference<List<Tourist>>() {
				});
		map.put("touristList", listoftourist);
		return "tourist_list";
	}

	@GetMapping("/add_new_tourist")
	public String addNewTourist(@ModelAttribute("tourist") Tourist tourist) {
		return "add_new_tourist";
	}
	@PostMapping("/save_tourist")
	public String enrollNewTourist(@ModelAttribute("tourist") Tourist tourist,
			RedirectAttributes attri /* ,Map<String, Object> map */)
			throws Exception {
		String serviceUrl = "http://localhost:4134/rest_exception_handler/tourist/register";
		ObjectMapper mapper = new ObjectMapper();
		String jsonData = mapper.writeValueAsString(tourist);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonData, headers);
		ResponseEntity<String> response = template.exchange(serviceUrl,
				HttpMethod.POST, entity, String.class);
		String message = response.getBody();
		attri.addFlashAttribute("msg", attri);
		// map.put("msg", message);
		return "redirect:list_of_tourist";
	}
	@GetMapping("/edit_tourist")
	public String modifyTouristData(@RequestParam("tid") Integer tid,
			@ModelAttribute("tourist") Tourist tourist) throws Exception {
		String serviceUrl = "http://localhost:4134/rest_exception_handler/tourist/findTouristById/{id}";
		ResponseEntity<String> response = template.exchange(serviceUrl,
				HttpMethod.GET, null, String.class, tid);
		String json_body = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		Tourist tourist2 = mapper.readValue(json_body, Tourist.class);
		BeanUtils.copyProperties(tourist2, tourist);
		return "tourist_edit";
	}

	@GetMapping("/delete_tourist")
	public String deleteTouristById(@RequestParam("id") Integer id,
			RedirectAttributes attri) throws Exception {
		String serviceUrl = "http://localhost:4134/rest_exception_handler/tourist/delete/{id}";
		ResponseEntity<String> response = template.exchange(serviceUrl,
				HttpMethod.DELETE, null, String.class);
		String jsonBody = response.getBody();
		ObjectMapper mapper = new ObjectMapper();
		String result = mapper.readValue(jsonBody, String.class);
		attri.addFlashAttribute("msg", result);
		return "redirect:list_of_tourist";
	}
}
