package com.shenmajr.boot.sevices.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shenmajr.boot.domain.Ed2k;
import com.shenmajr.boot.repo.Ed2kRepo;
import com.shenmajr.boot.sevices.Ed2kService;

@Service
public class Ed2kServiceImp implements Ed2kService {

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
}
