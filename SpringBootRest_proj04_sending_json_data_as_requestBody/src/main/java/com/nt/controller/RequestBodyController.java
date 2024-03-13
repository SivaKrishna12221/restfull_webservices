package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Employee;

@RestController
@RequestMapping("/employee")
public class RequestBodyController {

	@PostMapping("/register")
	public ResponseEntity<Employee> displayEmployee(@RequestBody Employee emp) {
		System.out.println("RequestBodyController.displayEmployee()");

		return new ResponseEntity<Employee>(emp, HttpStatus.OK);
	}

}
