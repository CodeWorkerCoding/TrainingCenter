package com.shenmajr.boot.action.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.shenmajr.boot.domain.security.Role;
import com.shenmajr.boot.domain.security.User;
import com.shenmajr.boot.sevices.security.RoleInterface;
import com.shenmajr.boot.sevices.security.UserInterface;

@Controller
@RequestMapping("/sec")
public class UserAndRoleAction {

	private Logger logger = LoggerFactory.getLogger(UserAndRoleAction.class);
	
	@Autowired
	private UserInterface userServices;
	@Autowired
	private RoleInterface roleServices;
	
	@RequestMapping(value="/user/add", method=RequestMethod.GET)
	public String addUser(){
		logger.info("请求添加系统用户页面...");
		return "security/user/add";
	}
	@RequestMapping(value="/user/save",method=RequestMethod.POST)
	public String addUser(User user) {
		userServices.addUser(user);
		return "forword:/login";
	}
	
	@RequestMapping(value="/role/add", method=RequestMethod.GET)
	public String addRole(){
		logger.info("请求添加系统角色页面...");
		return "security/role/add";
	}
	
	@RequestMapping(value="/role/save",method=RequestMethod.POST)
	public String addRole(Role role) {
		roleServices.addRole(role);
		return "";
	}
	
}
