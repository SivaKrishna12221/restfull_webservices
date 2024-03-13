package com.nt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Entity
@Table(name = "spring_boot_rest_tourist")
@NoArgsConstructor
@AllArgsConstructor
public class Tourist implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "tid_seq1", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer tid;
	@Column(length = 20, name = "tourist_name")
	@NonNull
	private String name;
	@Column(length = 20, name = "places_to_visit")
	@NonNull
	private String place;
	@Column(length = 20, name = "tourist_package")
	@NonNull
	private String touristPackage;
	@NonNull
	private Double budget;

}
