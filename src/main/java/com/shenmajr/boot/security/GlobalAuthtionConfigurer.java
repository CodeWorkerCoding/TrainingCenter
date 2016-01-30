package com.shenmajr.boot.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
//@EnableWebSecurity
//@ImportResource(value="classpath:/security/*.xml")
public class GlobalAuthtionConfigurer {
	
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		
	}
}
