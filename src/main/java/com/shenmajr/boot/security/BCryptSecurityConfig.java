package com.shenmajr.boot.security;
import org.aspectj.lang.annotation.Before;

//@Component
//@Aspect
public class BCryptSecurityConfig {

//	@Resource(name = "userBCryptService")
//	private UserService userBCryptService;

//	@Before("execution (*  com.shenma007.user.action.init())")
	public void postinit() {
		System.out.println("******************----------*************");
	}
}
