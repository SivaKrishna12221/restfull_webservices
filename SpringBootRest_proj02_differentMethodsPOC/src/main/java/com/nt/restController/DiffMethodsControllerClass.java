package com.nt.restController;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/methods")
public class DiffMethodsControllerClass {

	@GetMapping("/report") // allow the request from the browser
	public ResponseEntity<String> showReport() {
		String body = "From get show method report";
		HttpStatus status = HttpStatus.OK;
		ResponseEntity entity = new ResponseEntity<String>(body, status);
		return entity;
	}

	@PostMapping("/register") // doesn't allow the request comes from the
								// browser
	public ResponseEntity<String> saveReport() {
		return new ResponseEntity<String>("From post save method",
				HttpStatus.OK);
	}
	@PutMapping("/update") // put is used to update the data
	public ResponseEntity<String> updateData() {
		return new ResponseEntity<String>("From put update data",
				HttpStatus.OK);
	}
	@PatchMapping("/modify")
	public ResponseEntity<String> updateDataUsingSno() {
		return new ResponseEntity<String>("From patch updateDataUsingSno",
				HttpStatus.OK);
	}
	@DeleteMapping("/delete") // delete the record
	public ResponseEntity<String> deleteTheRecord() {
		return new ResponseEntity<String>("From delete data", HttpStatus.OK);
	}

}
