package com.shenmajr.boot.utils;

import java.util.UUID;

/**
 * ClassName: UUIDUtil
 * Description: 生成UUID的工具类
 * Author: fujianjian
 * Date: 2016年1月25日
 */
public class UUIDUtil {
	public static String genUUID(){
		return UUID.randomUUID().toString().replace("-", "").toLowerCase();
	}
}
