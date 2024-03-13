package com.nt.restcontroller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;

@RestController
// @Controller
@RequestMapping("/json_data")
public class JsonDataControllerClas {

	/*
	 * //if the return type is not ResponseEntity obj even if you
	 * write @ResponseBody annotation it wont work ..but if provide Rest
	 * Controller it is working
	 * 
	 * @GetMapping("/show_cust_report") public Customer showCustomer() {
	 * Customer cust = new Customer(10, "raju", "jp"); return cust; }
	 */
	// @ResponseBody
	@GetMapping("/show_cust_report")
	public ResponseEntity<Customer> showCustomer() {
		String[] items = new String[]{"laptop", "mobile", "charger"};
		ArrayList<Double> prices = new ArrayList();
		prices.add(68000.0);
		prices.add(34500.0);
		prices.add(500.0);
		List priceList = prices;
		Set<String> vegitables = Set.of("potato", "brinjal", "ladysfinger");
		Map<String, Object> pinfo = Map.of("adhar", 353768203807l, "pancard",
				"mkmpk5768m");
		Company com = new Company(12, "tata", "hyd");
		Customer cust = new Customer(10, "raju", "jp", items, priceList,
				vegitables, pinfo, com);
		return new ResponseEntity<Customer>(cust, HttpStatus.OK);
	}
}
