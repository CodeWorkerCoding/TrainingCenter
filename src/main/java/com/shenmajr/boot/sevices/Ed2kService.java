package com.shenmajr.boot.sevices;

import java.util.List;

import com.shenmajr.boot.domain.Ed2k;

public interface Ed2kService {
	public int creat(Ed2k ed2k);
	public int update(Ed2k ed2k);
	public int del(String _id);
	public Ed2k getOne(String _id);
	public List<Ed2k> getAll();
	public List<Ed2k> getAllByStar();
}
