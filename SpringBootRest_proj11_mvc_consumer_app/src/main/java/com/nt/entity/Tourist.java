package com.nt.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tourist implements Serializable {

	private Integer tid;
	private String name;
	private String place;
	private String touristPackage;
	private Double budget;
	private String status;

}
