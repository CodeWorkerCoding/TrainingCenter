package com.shenmajr.boot.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeAction {

	private Logger logger = LoggerFactory.getLogger(HomeAction.class);
	
	@RequestMapping("/home")
	public String greet() {
		logger.info("this is greet Method");
		return "home";
	}
	
	@RequestMapping(value="/login" ,method=RequestMethod.GET)
	public String sendLogin(){
		if (logger.isInfoEnabled()) {
			logger.info("send the login Page to clients");
		}
		return "login";
	}
	@RequestMapping(value="/login" ,method=RequestMethod.POST)
	public String handleLogin(HttpServletRequest request){
		if (logger.isInfoEnabled()) {
			logger.info("request the system login modules");
		}
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		if (("admin" == username) && ("admin" == password)) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
		}
		return "redirect:/home";
	}
}
