package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/stud")
// @RestController

public class RequestParamClass {

	@GetMapping("/register")
	public String requestParamValues(@RequestParam("no") Integer sno, @RequestParam(required = true) String sname) {
		return sno + "==**pathvaribles**===>" + sname;
	}
}
