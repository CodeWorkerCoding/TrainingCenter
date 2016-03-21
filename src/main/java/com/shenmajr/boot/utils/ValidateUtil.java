package com.shenmajr.boot.utils;

import javax.validation.Validation;
import javax.validation.Validator;

import org.springframework.validation.annotation.Validated;

@Validated
public class ValidateUtil {

	/**
	 * Description: 校验一个对象
	 * @param object
	 * @return
	 * Created by fujianjian 2016年3月17日
	 */
	public static String validateModel(Object object){
		StringBuffer buffer = new StringBuffer();
		Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		return "";
	}
}
