package com.shenmajr.boot.sevices.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shenmajr.boot.domain.Star;
import com.shenmajr.boot.repo.StarRepo;
import com.shenmajr.boot.sevices.StarServices;

@Service
public class StarServiceImp implements StarServices {

	@Autowired
	private StarRepo starRepo;
	
	@Override
	public int create(Star entity) {
		starRepo.save(entity);
		return 0;
	}

	@Override
	public int update(Star entity) {
		return 0;
	}

	@Override
	public int del(String id) {
		return 0;
	}

	@Override
	public List<Star> getAll() {
		return starRepo.findAll();
	}
	
}
