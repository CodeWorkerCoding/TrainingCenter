package com.shenmajr.boot.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shenmajr.boot.domain.Ed2k;

public interface Ed2kRepo extends JpaRepository<Ed2k, String> {
	@Query("SELECT e FROM Ed2k e WHERE e.recordStatus != 1")
	public List<Ed2k> getAll();
}
