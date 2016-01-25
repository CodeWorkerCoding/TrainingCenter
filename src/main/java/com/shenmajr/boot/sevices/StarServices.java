package com.shenmajr.boot.sevices;

import java.util.List;

import com.shenmajr.boot.domain.Star;

public interface StarServices extends BaseSevices<Star, String> {
	public List<Star> getAll();
}
