package com.nt.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Student;
import com.nt.model.TouristInfo;

@RestController
@RequestMapping("/student")
public class RequestBodyControllerForMultipleTypeValues {

	@PostMapping("/register")
	public String registerStudentInfo(@RequestBody Student stud) {
		return stud.toString();
	}
	@PostMapping("/tourist")
	public String registerTouristData(@RequestBody TouristInfo tourist) {
		return tourist.toString();
	}

}
