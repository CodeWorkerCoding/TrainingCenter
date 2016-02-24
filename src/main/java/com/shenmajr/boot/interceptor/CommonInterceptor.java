package com.shenmajr.boot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * ClassName: CommonInterceptor  
 * Description: 为了解决spring security出于安全考虑设置
 * 				response的'X-Frame-Options'值为'DENY'后页面不能frame.
 * Author: fujianjian
 * Date: 2016年2月18日
 */
@Repository(value="commonInterceptor")
public class CommonInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		/**
		 * X-Frame-Options 有三个可选的值：	
		 * DENY：浏览器拒绝当前页面加载任何Frame页面
		 * SAMEORIGIN：frame页面的地址只能为同源域名下的页面
		 * ALLOW-FROM：origin为允许frame加载的页面地址
		 */
		response.setHeader("X-Frame-Options", "SAMEORIGIN");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub

	}

}
