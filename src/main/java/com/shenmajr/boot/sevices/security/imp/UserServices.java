package com.shenmajr.boot.sevices.security.imp;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.shenmajr.boot.domain.Status;
import com.shenmajr.boot.domain.security.Role;
import com.shenmajr.boot.domain.security.User;
import com.shenmajr.boot.repo.security.RoleRepo;
import com.shenmajr.boot.repo.security.UserRepo;
import com.shenmajr.boot.sevices.security.UserInterface;

@Transactional
public class UserServices implements UserInterface {
	
	private Logger logger = LoggerFactory.getLogger(UserServices.class);
	
	@Autowired
	private UserRepo userRepo;
	@Autowired
	private RoleRepo roleRepo;

	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (username == null || username.trim().equals("")) {
			if (logger.isErrorEnabled()) {
				logger.error("试图访问一个空用户名.");
			}
			throw new UsernameNotFoundException("用户不存在.");
		}
		String uname=username.trim(); 
		User user= userRepo.findByUsername(username);
		if (user==null) {
			throw new UsernameNotFoundException(uname);
		}
		List<Role> userRoles=roleRepo.findAllByUserId(user.get_id());
		Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();
		for (Role role : userRoles) {
			grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
		}
		user.setAuthorities(grantedAuthorities);
		return user;
	}

	@Override
	public User findByUsernameAndPassword(String Username, String password) {
		return userRepo.findByUsernameAndPassword(Username, password);
	}

	@Override
	public User findByUsername(String username) {
		return userRepo.findByUsername(username);
	}

	@Override
	public Page<User> findByUsernameLikeOrderByCreateTimeDesc(String username, Pageable page) {
		return userRepo.findByUsernameLikeOrderByCreateTimeDesc(username, page);
	}

	@Override
	public Page<User> searchByName(String username, Pageable page) {
		return userRepo.searchByName(username, page);
	}

	@Override
	public User addUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public User updateUser(User user) {
		return userRepo.saveAndFlush(user);
	}

	@Override
	public User delUser(String _id) {
		User user = findById(_id);
		user.setStatus(Status.DELETE);
		return updateUser(user);
	}

	@Override
	public User findById(String _id) {
		return userRepo.findBy_id(_id);
	}

}
