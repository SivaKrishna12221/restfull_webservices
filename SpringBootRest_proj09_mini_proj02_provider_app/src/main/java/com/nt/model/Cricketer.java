package com.nt.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cricketer {
	private String name;
	private Integer age;
	private Integer jersy;
	private String typeOfPlayer;
}
