package com.shenmajr.boot.sevices;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Pageable;

public interface BaseSevices<T, ID extends Serializable> {
	public T getObj(ID id);
	public T create(T entity);
	public T update(T entity);
	public boolean del(ID id);
	
	public List<T> getAll();
	
	/**
	 * Description: 带条件的查询
	 * @param pageRequest 分页
	 * @param request
	 * @return
	 * Created by fujianjian 2016年1月28日
	 */
	public Map<String, Object> findByPage(Pageable pageRequest, HttpServletRequest request);
}
