package com.shenmajr.boot.sevices.imp;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shenmajr.boot.domain.Ed2k;
import com.shenmajr.boot.domain.Star;
import com.shenmajr.boot.repo.StarRepo;
import com.shenmajr.boot.sevices.StarServices;

@Service
public class StarServiceImp implements StarServices {

	@Autowired
	private StarRepo starRepo;
	
	@Override
	public Star create(Star entity) {
		return starRepo.save(entity);
	}

	@Override
	public Star update(Star entity) {
		return starRepo.saveAndFlush(entity);
	}

	@Override
	public boolean del(String id) {
		return true;
	}

	@Override
	public List<Star> getAll() {
		return starRepo.getAll();
	}

	@Override
	public Set<Ed2k> getStarAllEd2k(String _id) {
		Star star = starRepo.getOne(_id);
		return star.getEd2ks();
	}

	@Override
	public Star getObj(String id) {
		return starRepo.getOne(id);
	}

	@Override
	public Map<String, Object> findByPage(Pageable pageRequest, HttpServletRequest request) {
		return null;
	}
	
}
