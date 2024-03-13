package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Tourist;
import com.nt.service.ITouristServiceMgmt;

@RestController
@RequestMapping("/tourist")
public class TouristControllerClass {

	@Autowired
	private ITouristServiceMgmt service;
	@PostMapping("/register")
	public ResponseEntity<String> saveTouristData(
			@RequestBody Tourist tourist) {
		try {
			String result = service.enrollTouristData(tourist);
			return new ResponseEntity<String>(result, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("internal server error",
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping("/report")
	public ResponseEntity<?> displayTouristData() {
		try {
			List<Tourist> data = service.fetchTouristData();
			return new ResponseEntity<List<Tourist>>(data, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/reportById/{id}")
	public ResponseEntity<?> displayTouristDataById(
			@PathVariable("id") Integer id) {
		try {
			Tourist tourist = service.fetchTouristDataById(id);
			return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		} catch (Exception e) {
			// e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PutMapping("/modify")
	public ResponseEntity<String> updateTouristData(
			@RequestBody Tourist tourist) {
		try {
			String message = service.modifyTouristData(tourist);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> eliminateTouristData(
			@PathVariable("id") Integer id) {
		try {
			String message = service.removeTouristData(id);
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),
					HttpStatus.NOT_FOUND);
		}
	}

	@PatchMapping("/updating/{id}/{hkp}")
	public ResponseEntity<String> modifyTouristDataById(
			@PathVariable("id") Integer id, @PathVariable("hkp") Float hkp) {
		try {
			String message = service.updateBudgetByPercentage(id, hkp);
			ResponseEntity<String> entity = new ResponseEntity<String>(message,
					HttpStatus.OK);

			return entity;
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),
					HttpStatus.NOT_FOUND);
		}
	}
}
