package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RequestMapping("/message")
@RestController
public class RestControllerClass {

	// @ResponseBody // if we declare this annot this handler method doest not
	// involving the view components
	// instead of taking response body in every handler method take
	// @RestController on the top of the class
	@GetMapping("/wish")
	public ResponseEntity<String> wishMessage() {
		LocalDateTime ldt = LocalDateTime.now();
		int hour = ldt.getHour();
		String body = null;
		if (hour < 12) {
			body = "Good Morning friend...!";
		}
		if (hour < 16) {
			body = "Good Afternoon friend..!";
		} else if (hour < 18) {
			body = "Good Evening friend..!";
		} else {
			body = "Good night friend..!";
		}

		HttpStatus status = HttpStatus.OK;// all are perfect //correct
		return new ResponseEntity<String>(body, status);
	}

}
