package com.shenmajr.boot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
/**
 * ClassName: LoggerInterceptor
 * Description: 日志相关的拦截器
 * Author: fujianjian
 * Date: 2016年2月18日
 */
@Repository(value="loggerInterceptor")
public class LoggerInterceptor implements HandlerInterceptor {

	private Logger logger = LoggerFactory.getLogger(LoggerInterceptor.class);
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		logger.info("request the url is {} by {} in {}",request.getPathInfo(),
				request.getUserPrincipal().getName(),
				request.getLocalAddr());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
	}

}
