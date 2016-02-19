package com.shenmajr.boot.sevices.security.imp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shenmajr.boot.domain.Status;
import com.shenmajr.boot.domain.security.Role;
import com.shenmajr.boot.repo.security.RoleRepo;
import com.shenmajr.boot.sevices.security.RoleInterface;

@Transactional
@Service
public class RoleServices implements RoleInterface {

	@Autowired
	private RoleRepo roleRepo;

	@Override
	public Role addRole(Role role) {
		return roleRepo.save(role);
	}

	@Override
	public Role updateRole(Role role) {
		return roleRepo.saveAndFlush(role);
	}

	@Override
	public Role delRole(String _id) {
		Role role = findById(_id);
		role.setStatus(Status.DELETE);
		return updateRole(role);
	}

	@Override
	public Role findById(String _id) {
		return roleRepo.findBy_id(_id);
	}

	@Override
	public Role findByName(String name) {
		return roleRepo.findByName(name);
	}

	@Override
	public List<Role> findAllByUserId(String userId) {
		return roleRepo.findAllByUserId(userId);
	}

	@Override
	public List<Role> findAllByUserName(String useruame) {
		return roleRepo.findAllByUserName(useruame);
	}
}
