package com.shenmajr.boot.sevices.imp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.shenmajr.boot.domain.Ed2k;
import com.shenmajr.boot.domain.Status;
import com.shenmajr.boot.domain.specification.Criteria;
import com.shenmajr.boot.domain.specification.Restrictions;
import com.shenmajr.boot.repo.Ed2kRepo;
import com.shenmajr.boot.sevices.Ed2kService;

@Service
public class Ed2kServiceImp implements Ed2kService {

	private Logger logger = LoggerFactory.getLogger(Ed2kServiceImp.class);
	@Autowired
	private Ed2kRepo ed2kRepo;

	@Override
	public Ed2k update(Ed2k ed2k) {
		return ed2kRepo.saveAndFlush(ed2k);
	}

	@Override
	public boolean del(String _id) {
		return true;
	}

	@Override
	public List<Ed2k> getAll() {
		return ed2kRepo.getAll();
	}

	@Override
	public Ed2k getObj(String id) {
		return ed2kRepo.getOne(id);
	}

	@Override
	public Ed2k create(Ed2k entity) {
		return ed2kRepo.save(entity);
	}

	@Override
	public Map<String, Object> findByPage(Pageable pageRequest, HttpServletRequest request) {
		Map<String, Object> model = new HashMap<String, Object>();
		
		Criteria<Ed2k> criteria = new Criteria<Ed2k>();
		criteria.add(Restrictions.ne("recordStatus", Status.DELETE, true));
		Page<Ed2k> pages = ed2kRepo.findAll(criteria, pageRequest);
		model.put("pages", pages);
		model.put("ed2ks", pages.getContent());
		if (logger.isInfoEnabled()) {
			logger.info(String.format("作品分页查询成功..."));
		}
		return model;
	}
}
