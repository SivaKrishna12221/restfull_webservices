package com.nt.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

	private Integer studno;
	private String sname;
	private Integer age;
	private Address addr;
	private String[] hobbies;
	private List<Company> companies;
	private Set<Long> phoneNumbers;
	private List<Map<String, Object>> familyDetails;

}
