package com.shenmajr.boot.domain.specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 * ClassName: Criterion
 * Description: 条件接口
 * 			用户提供条件表达式接口
 * Author: fujianjian
 * Date: 2016年1月28日
 */
public interface Criterion {

	public enum Operator{
		EQ, NE, LIKE, GT, LT, GTE, LTE, AND, OR
	}
	public Predicate toPredicate(Root<?> root, CriteriaQuery<?> query,
			CriteriaBuilder builder);
}
