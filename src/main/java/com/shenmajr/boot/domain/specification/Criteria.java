package com.shenmajr.boot.domain.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

public class Criteria<T> implements Specification<T> {

	private List<Criterion> criterions = new ArrayList<Criterion>();
	/**
	 * Description: 将查询条件组合起来。
	 * @param root
	 * @param query
	 * @param cb
	 * @return
	 * Created by fujianjian 2016年1月29日
	 */
	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		if (!criterions.isEmpty()) {
			List<Predicate> predicates = new ArrayList<Predicate>();
			for (Criterion c : criterions) {
				predicates.add(c.toPredicate(root, query, cb));
			}
			// 将所有条件用 and 联合起来
			if (predicates.size() > 0) {
				return cb.and(predicates.toArray(new Predicate[predicates.size()]));
			}
		}
		return cb.conjunction();
	}
	public void add(Criterion criterion) {
		if (criterion != null) {
			criterions.add(criterion);
		}
	}
}
