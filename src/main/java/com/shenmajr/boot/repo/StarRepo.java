package com.shenmajr.boot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shenmajr.boot.domain.Star;

public interface StarRepo extends JpaRepository<Star, String> {
	@Query("SELECT s FROM Star s WHERE s.recordStatus != 1")
	public List<Star> getAll();
}
