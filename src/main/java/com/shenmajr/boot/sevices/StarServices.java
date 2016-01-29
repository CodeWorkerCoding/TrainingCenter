package com.shenmajr.boot.sevices;

import java.util.Set;

import com.shenmajr.boot.domain.Ed2k;
import com.shenmajr.boot.domain.Star;

public interface StarServices extends BaseSevices<Star, String> {
	public Set<Ed2k> getStarAllEd2k(String _id);
	 
}
