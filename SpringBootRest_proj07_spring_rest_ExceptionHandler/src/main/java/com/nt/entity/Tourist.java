package com.nt.entity;

import java.io.Serializable;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "spring_boot_rest_tourist")
@NoArgsConstructor
@AllArgsConstructor
@SQLDelete(sql = "update spring_boot_rest_tourist set status='delete' where tid=?")
@Where(clause = "status <>'delete'")
public class Tourist implements Serializable {

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
	@Column(length = 20)
	private String status = "active";

}
