package com.shenmajr.boot.utils;

public class CommonUtils {
	
	public static Integer[] stringToInt(String[] strs){
		Integer[] its = new Integer[strs.length] ;
		for (int i = 0; i < strs.length; i++) {
			its[i] = Integer.parseInt(strs[i]);
		}
		return its;
	}
}
