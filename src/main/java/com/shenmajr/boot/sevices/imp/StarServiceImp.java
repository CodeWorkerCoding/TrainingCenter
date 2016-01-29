package com.shenmajr.boot.sevices.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shenmajr.boot.domain.Ed2k;
import com.shenmajr.boot.domain.Star;
import com.shenmajr.boot.domain.Status;
import com.shenmajr.boot.domain.specification.Criteria;
import com.shenmajr.boot.domain.specification.Restrictions;
import com.shenmajr.boot.repo.StarRepo;
import com.shenmajr.boot.sevices.StarServices;

@Service
public class StarServiceImp implements StarServices {

	private Logger logger = LoggerFactory.getLogger(StarServiceImp.class);
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
		Map<String, Object> model = new HashMap<String, Object>();
		Map<String, Object> param = new HashMap<String, Object>();
		
		Criteria<Star> criteria = new Criteria<Star>();
		criteria.add(Restrictions.ne("recordStatus", Status.DELETE, true));
		Page<Star> pages = starRepo.findAll(criteria, pageRequest);
		model.put("pages", pages);
		model.put("stars", pages.getContent());
		model.putAll(param);
		if (logger.isInfoEnabled()) {
			logger.info(String.format("明星分页查询成功..."));
		}
		return model;
	}
	
}
