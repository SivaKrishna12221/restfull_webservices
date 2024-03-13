package com.nt.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Telivison {

	private Integer tid;

	private String tvName;

	private Double price;

	private LocalDate availbleFrom;

	private String[] aliasNames;
	private TvCompany companyDateils;
}
