package com.shenmajr.boot.sevices;

import java.io.Serializable;
import java.util.List;

public interface BaseSevices<T, ID extends Serializable> {
	public T getObj(ID id);
	public int create(T entity);
	public int update(T entity);
	public int del(ID id);
	
	public List<T> getAll();
}
