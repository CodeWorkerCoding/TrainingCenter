package com.shenmajr.boot.sevices;

import java.io.Serializable;
import java.util.List;

public interface BaseSevices<T, ID extends Serializable> {
	public T getObj(ID id);
	public T create(T entity);
	public T update(T entity);
	public boolean del(ID id);
	
	public List<T> getAll();
}
