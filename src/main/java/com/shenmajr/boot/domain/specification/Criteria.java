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
	@Override
	public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
		return null;
	}
	public void add(Criterion criterion) {
		if (criterion != null) {
			criterions.add(criterion);
		}
	}
}
