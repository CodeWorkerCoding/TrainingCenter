package com.shenmajr.boot.domain.specification.imp;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;

import com.shenmajr.boot.domain.specification.Criterion;

public class SimpleExpression implements Criterion {

	private String fieldName;
	private Object value;
	private Operator operator;
	
	public SimpleExpression(String fieldName, Object value, Operator operator) {
		this.fieldName = fieldName;
		this.operator = operator;
		this.value = value;
	}
	
	public String getFieldName() {
		return fieldName;
	}
	public Object getValue() {
		return value;
	}
	public Operator getOperator() {
		return operator;
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public Predicate toPredicate(Root<?> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
		Path expression = null;
		if (fieldName.contains(".")) {
			String[] names = StringUtils.split(fieldName,".");
			for (int i = 0; i < names.length; i++) {
				expression = root.get(names[i]);
			}
		} else {
			expression = root.get(fieldName);
		}
		switch (operator) {
		case EQ:
			return builder.equal(expression, value);
		case NE:
			return builder.notEqual(expression, value);
		case LIKE:
			return builder.like((Expression<String>) expression, "%" + value + "%");
		case LT:
			return builder.lessThan(expression, (Comparable) value);
		case GT:
			return builder.greaterThan(expression, (Comparable) value);
		case LTE:
			return builder.lessThanOrEqualTo(expression, (Comparable) value);
		case GTE:
			return builder.greaterThanOrEqualTo(expression, (Comparable) value);
		default:
			return null;
		}
	}

}
