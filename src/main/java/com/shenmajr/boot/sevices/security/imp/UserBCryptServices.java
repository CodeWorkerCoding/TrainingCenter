package com.shenmajr.boot.sevices.security.imp;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import com.shenmajr.boot.domain.security.User;

/**
 * 当对系统用户进行操作时，加密存储用户密码
 * @author fujianjian
 */
@Transactional
@Service(value="userDetailsService")
public class UserBCryptServices extends UserServices {

	private final PasswordEncoder passwordEncoder = 
			new BCryptPasswordEncoder();

	@Override
	public User addUser(final User user) {
		Assert.notNull(user, "不能添加空用户对象");
		Assert.hasLength(user.getPassword(), "密码不能为空");
		final String encoded = passwordEncoder
				.encode(user.getPassword());
		user.setPassword(encoded);
		return super.addUser(user);
	}

	@Override
	public User updateUser(final User user) {
		Assert.notNull(user,"不能更新空用户对象");
		Assert.hasLength(user.getPassword(), "密码不能为空");
		final String encoded = passwordEncoder
				.encode(user.getPassword());
		user.setPassword(encoded);
		return super.updateUser(user);
	}
	
}
