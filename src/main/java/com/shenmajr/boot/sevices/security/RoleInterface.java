package com.shenmajr.boot.sevices.security;

import java.util.List;

import com.shenmajr.boot.domain.security.Role;

public interface RoleInterface {

	public Role addRole(Role role); //添加一个用户角色，返回持久化对象
	
	public Role updateRole(Role role); //更新有一个用户角色，返回更新后对象
	
	public Role delRole(String _id); //通过id删除一个用户角色，返回被删除对象
	
	public Role findById(String _id); //通过id加载一个用户角色
	public Role findByName(String name); //通过角色名称加载一个用户角色
	public List<Role> findAllByUserId(String userId); // 通过用户id加载用户所有的角色
	public List<Role> findAllByUserName(String useruame); //通过用户名称加载用户所有的角色
}
