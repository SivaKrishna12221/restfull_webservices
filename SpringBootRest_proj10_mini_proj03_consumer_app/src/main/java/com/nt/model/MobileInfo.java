package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MobileInfo {

	private Integer mid;
	private String name;
	private Double price;
	private String memory;
}
