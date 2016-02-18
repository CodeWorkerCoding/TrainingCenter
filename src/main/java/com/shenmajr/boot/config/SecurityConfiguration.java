package com.shenmajr.boot.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@ImportResource(locations="classpath:security/spring-security.xml")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

}
