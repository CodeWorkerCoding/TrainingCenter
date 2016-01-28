package com.shenmajr.boot.sevices;

import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Pageable;

import com.shenmajr.boot.domain.Ed2k;
import com.shenmajr.boot.domain.Star;

public interface StarServices extends BaseSevices<Star, String> {
	public Set<Ed2k> getStarAllEd2k(String _id);
	/**
	 * Description: 带条件的查询
	 * @param pageRequest 分页
	 * @param request
	 * @return
	 * Created by fujianjian 2016年1月28日
	 */
	public Map<String, Object> findByPage(Pageable pageRequest, HttpServletRequest request); 
}
