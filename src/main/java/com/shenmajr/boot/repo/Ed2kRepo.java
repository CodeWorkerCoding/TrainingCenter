package com.shenmajr.boot.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.shenmajr.boot.domain.Ed2k;

public interface Ed2kRepo extends JpaRepository<Ed2k, String> {
	@Query("SELECT e FROM Ed2k e WHERE e.recordStatus != 1")
	public List<Ed2k> getAll();
	
	/**
	 * Description: 带条件的分页查询
	 * @param specification
	 * @param page
	 * @return
	 * Created by fujianjian 2016年1月29日
	 */
	public Page<Ed2k> findAll(Specification<Ed2k> specification, Pageable page);
}
