package com.shenmajr.boot.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shenmajr.boot.domain.Star;

public interface StarRepo extends JpaRepository<Star, String> {
	
}
