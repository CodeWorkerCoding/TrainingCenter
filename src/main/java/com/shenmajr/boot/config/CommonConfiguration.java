package com.shenmajr.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.shenmajr.boot.interceptor.CommonInterceptor;
import com.shenmajr.boot.interceptor.LoggerInterceptor;

@Configuration
public class CommonConfiguration extends WebMvcConfigurerAdapter {

	@Autowired
	private CommonInterceptor commonInterceptor;
	@Autowired
	private LoggerInterceptor loggerInterceptor;
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		super.addInterceptors(registry);
		registry.addInterceptor(loggerInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns("/login**")
			.excludePathPatterns("/userandrole/**");
		registry.addInterceptor(commonInterceptor)
			.addPathPatterns("/**")
			.excludePathPatterns("/login**")
			.excludePathPatterns("/userandrole/**")
			.excludePathPatterns("/home/**");
	}
	
}
