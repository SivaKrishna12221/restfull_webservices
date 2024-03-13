package com.nt.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.model.ErrorHandler;
import com.nt.service.TouristNotFoundException;

//@ControllerAdvice
@RestControllerAdvice
public class TouristExceptionHandler {

	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorHandler> touristDataNotFoundException(
			TouristNotFoundException tnf) {
		System.out.println(
				"TouristExceptionHandler.touristDataNotFoundException()");
		ErrorHandler error = new ErrorHandler(LocalDateTime.now(),
				tnf.getMessage(), "404-tourist not found ");
		return new ResponseEntity<ErrorHandler>(error,
				HttpStatus.INTERNAL_SERVER_ERROR);

	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorHandler> handleAllException(Exception e) {
		System.out.println("TouristExceptionHandler.handleAllException()");
		ErrorHandler error = new ErrorHandler(LocalDateTime.now(),
				e.getLocalizedMessage(), "404-error");
		return new ResponseEntity<ErrorHandler>(error,
				HttpStatus.INTERNAL_SERVER_ERROR);

	}

}
