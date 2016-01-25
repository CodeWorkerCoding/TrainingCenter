package com.shenmajr.boot.sevices;

import java.io.Serializable;

public interface BaseSevices<T, ID extends Serializable> {
	public int create(T entity);
	public int update(T entity);
	public int del(ID id);
}
