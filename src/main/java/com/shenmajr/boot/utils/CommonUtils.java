package com.shenmajr.boot.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.util.Assert;

public class CommonUtils {
	
	public static Integer[] stringToInt(String[] strs){
		Integer[] its = new Integer[strs.length] ;
		for (int i = 0; i < strs.length; i++) {
			its[i] = Integer.parseInt(strs[i]);
		}
		return its;
	}
	
	public static String subImageUrl(String url){
		return url.substring(42);
	}
	public static String formate(Date date, String pattern){
		Assert.notNull(date,"日期不能为空");
		Assert.hasLength(pattern,"时间模式不能为空");
		SimpleDateFormat sdf = new  SimpleDateFormat(pattern, Locale.CHINA);
		return sdf.format(date);
	}
}
