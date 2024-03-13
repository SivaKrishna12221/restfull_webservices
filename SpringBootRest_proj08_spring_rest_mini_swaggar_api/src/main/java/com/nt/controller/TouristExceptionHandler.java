package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.exceptions.TouristNotFoundException;
import com.nt.model.ExceptionClass;

@RestControllerAdvice
public class TouristExceptionHandler {

	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ExceptionClass> touristNotFound(
			TouristNotFoundException tnf) {

		ExceptionClass ec = new ExceptionClass(LocalDateTime.now(),
				tnf.getMessage(), "500-error");
		return new ResponseEntity<ExceptionClass>(ec,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionClass> allExceptions(Exception e) {
		ExceptionClass ec = new ExceptionClass(LocalDateTime.now(),
				e.getMessage(), "500_error");
		return new ResponseEntity<ExceptionClass>(ec,
				HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
