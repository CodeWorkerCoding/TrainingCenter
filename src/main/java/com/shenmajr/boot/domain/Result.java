package com.shenmajr.boot.domain;
/**
 * ClassName: Result
 * Description: 通用的响应结果类
 * Author: fujianjian
 * Date: 2016年1月28日
 */
public class Result {
	/**
	 * 响应结果代码
	 */
	private String code;
	/**
	 * 响应结果信息
	 */
	private String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Result(){
		this.code=ResultCode.FAILED;
		this.message="";
	}
}
