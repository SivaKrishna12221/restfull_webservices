package com.nt.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Cricketer;

@RestController
@RequestMapping("/cricketer")
public class CriketerControllerClass {

	@GetMapping("/getInfo/{id}/{name}")
	public ResponseEntity<String> getCricketInfo(@PathVariable Integer id,
			@PathVariable String name) {
		return new ResponseEntity<String>(
				"This is Criketer Rest Api cricketer id :" + id + " name:"
						+ name,
				HttpStatus.OK);
	}
	@PostMapping("/register")
	public ResponseEntity<String> registerCricketerInfo(
			@RequestBody Cricketer cric) {
		return new ResponseEntity<String>(cric.toString(),
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
