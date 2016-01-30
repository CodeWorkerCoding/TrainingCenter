package com.shenmajr.boot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
//@EnableWebSecurity
//@ImportResource(value="classpath:/security/*.xml")
public class GlobalAuthtionConfigurer {
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}
}
