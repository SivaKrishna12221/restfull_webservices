package com.nt.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/path")
public class PathVariableTestClass {

	@GetMapping("/request")
	@ResponseBody
	// if we put required =false it doesn't throw error even send or not send
	// http://localhost:3143/request_param/path/request?no=43&name=siva(wright)
//http://localhost:3143/request_param/path/request?no=43&name=siva&name=344(valid) we can pass more than required request param values
	public String requestParamTest(@RequestParam(required = false) Integer no,
			@RequestParam(required = false) String name) {
		return "number:" + no + " name:" + name;
	}

	@GetMapping("/register/{no}/{name}/{addr}")

	// here we need to pass every value even though if we put required false .it
	// going to work out.if we put required=false it can accept values
	public String pathVariable(@PathVariable(required = false, name = "no") Integer sno,
			@PathVariable(required = false, name = "name") String sname,
			@PathVariable(required = false, name = "addr") String address) {
		return sno + "==>" + sname + "==>" + address;
	}

	@GetMapping("/register/sno/name")
	public String fetchdata1() {
		return "fetchdata1 executed";
	}

//even we keep required =false it is not going to work out it is mondatary to  pass required path variable
	@GetMapping("/register/sno/{sname}")
	public String fetchdata2(@PathVariable(required = false) String sname) {
		return "fetchdata2 executed" + sname;
	}

	@GetMapping("/register/{sno}/sname")
	public String fetchdata3(@PathVariable("sno") Integer no) {
		return "fetchdata3 executed=>" + no;
	}

	@GetMapping("/register/sno/name/{name}/") // here we get ambigous problem
	public String fetchdata4(@PathVariable(name = "name") String sname) {
		return "fetch data 4 executed " + sname;
	}

	@GetMapping("/register/sno/raja")
	public String fetchdata5() {
		return "fetch data 5";
	}
}
