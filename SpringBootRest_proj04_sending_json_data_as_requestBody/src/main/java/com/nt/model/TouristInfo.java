package com.nt.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TouristInfo {

	private String name;
	private LocalDate dob;
	private LocalDateTime startJourney;
	private LocalDateTime endJourney;
}
