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
import com.nt.exceptions.TouristNotFoundException;
import com.nt.service.ITouristServiceMgmt;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/tourist")
public class TouristControllerClass {

	@Autowired
	private ITouristServiceMgmt service;

	@PostMapping("/register")
	@ApiOperation("Tourist Registration")
	public ResponseEntity<String> saveTouristData(@RequestBody Tourist tourist) {
		String result = service.enrollTouristData(tourist);
		return new ResponseEntity<String>(result, HttpStatus.CREATED);
	}

	@GetMapping("/report")
	public ResponseEntity<?> displayTouristData() throws Exception {
		List<Tourist> data = service.fetchTouristData();
		return new ResponseEntity<List<Tourist>>(data, HttpStatus.OK);
	}

	@GetMapping("/findTouristById/{id}")
	public ResponseEntity<?> displayTouristDataById(@PathVariable("id") Integer id) throws Exception {
		System.out.println("TouristControllerClass.displayTouristDataById()==>before calling ");
		Tourist tourist = service.fetchTouristDataById(id);
		System.out.println("TouristControllerClass.displayTouristDataById()==>After calling");
		return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);

	}

	@PutMapping("/modify")
	public ResponseEntity<String> updateTouristData(@RequestBody Tourist tourist) throws Exception {
		String message = service.modifyTouristData(tourist);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> eliminateTouristData(@PathVariable("id") Integer id) throws Exception {
		String message = service.removeTouristData(id);
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}

	@PatchMapping("/hike/{id}/{hkp}")
	public ResponseEntity<String> modifyTouristDataById(@PathVariable("id") Integer id, @PathVariable("hkp") Float hkp)
			throws TouristNotFoundException {

		String message = service.updateBudgetByPercentage(id, hkp);
		ResponseEntity<String> entity = new ResponseEntity<String>(message, HttpStatus.OK);

		return entity;

	}

}
