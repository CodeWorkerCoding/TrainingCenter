package com.shenmajr.boot.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeAction {

	private Logger logger = LoggerFactory.getLogger(HomeAction.class);
	
	@RequestMapping("/")
	public String greet() {
		logger.info("this is greet Method");
		return "home";
	}
	@RequestMapping("/greet")
	@ResponseBody
	public String sayHi() {
		return "fuck you";
	}
	
}
