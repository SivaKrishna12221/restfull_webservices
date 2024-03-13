package com.nt.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.MobileInfo;
import com.nt.model.Telivison;
import com.nt.model.TvCompany;

@RestController
@RequestMapping("/mobile")
public class ExchangeMethodControllerClass {

	@PostMapping("/register")
	public ResponseEntity<String> registerMobileInfo(
			@RequestBody MobileInfo minfo) {

		return new ResponseEntity<String>(
				"registerMobile info method is getting executed",
				HttpStatus.OK);
	}
	@GetMapping("/reportById/{id}")
	public ResponseEntity<MobileInfo> reportMobileData(
			@PathVariable Integer id) {
		MobileInfo info = new MobileInfo(101, "oppoA57", 13000d, "3gb");
		return new ResponseEntity<MobileInfo>(info, HttpStatus.OK);
	}
	@GetMapping("/tvReport")
	public ResponseEntity<List<Telivison>> telivisonReport() {
		TvCompany tvc = new TvCompany("TATA", "Hyderabad", Integer.valueOf(10));
		Telivison tv1 = new Telivison(101, "LG", 7800d,
				LocalDate.of(2007, 10, 02), new String[]{"lg", "samsung"}, tvc);

		Telivison tv2 = new Telivison(103, "lcd", 17800d,
				LocalDate.of(2010, 10, 23), new String[]{"lcd", "realme"}, tvc);
		List<Telivison> tvlist = new ArrayList();
		tvlist.add(tv1);
		tvlist.add(tv2);
		return new ResponseEntity<List<Telivison>>(tvlist, HttpStatus.OK);

	}

}
