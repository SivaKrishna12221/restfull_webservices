package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	private Integer custId;
	private String custName;
	private String address;
	private String[] items;
	private List<Double> prices;
	private Set<String> vegitables;
	private Map<String, Object> personalDetails;
	private Company company;

}
