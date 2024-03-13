package com.nt.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Tourist;

public interface CustomTouristRepository
		extends
			JpaRepository<Tourist, Integer> {

}
