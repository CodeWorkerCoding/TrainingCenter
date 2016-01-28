package com.shenmajr.boot.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shenmajr.boot.domain.Star;

public interface StarRepo extends JpaRepository<Star, String> {
	@Query("SELECT s FROM Star s WHERE s.recordStatus != 1")
	public List<Star> getAll();
	/**
	 * Description: 带条件的分页查询
	 * @param specification
	 * @param page
	 * @return
	 * Created by fujianjian 2016年1月28日
	 */
	public Page<Star> findAll(Specification<Star> specification, Pageable page);
}
