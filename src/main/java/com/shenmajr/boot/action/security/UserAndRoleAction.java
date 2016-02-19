package com.shenmajr.boot.action.security;

import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shenmajr.boot.domain.Status;
import com.shenmajr.boot.domain.security.Role;
import com.shenmajr.boot.domain.security.User;
import com.shenmajr.boot.sevices.security.RoleInterface;
import com.shenmajr.boot.sevices.security.UserInterface;

@Controller
@RequestMapping("/userandrole")
public class UserAndRoleAction {

	private Logger logger = LoggerFactory.getLogger(UserAndRoleAction.class);
	
	@Autowired
	private UserInterface userServices;
	@Autowired
	private RoleInterface roleServices;
	
	@RequestMapping("/adduser")
	@ResponseBody
	public String preAddUser(User user){
		logger.info("添加一个系统的用户....");
		Set<Role> roles = new HashSet<Role>();
		roles.add(roleServices.findByName("ROLE_USER"));
		user.setRoles(roles);
		user.setUsername("root");
		user.setPassword("root");
		user.setStatus(Status.NORMAL);
		user = userServices.addUser(user);
		return user.toString();
	}
	@RequestMapping("/addrole")
	@ResponseBody
	public String preAddRole(Role role){
		role.setName("ROLE_USER");
		role.setStatus(Status.NORMAL);
		role = roleServices.addRole(role);
		return role.toString();
	}
	
}
