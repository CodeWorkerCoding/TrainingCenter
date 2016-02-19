package com.shenmajr.boot.repo.security;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.shenmajr.boot.domain.security.Role;

public interface RoleRepo extends JpaRepository<Role, String> {

	Role findBy_id(String _id);
	Role findByName(String name);
	@Query("select r from Role r where r.name like :name")
	List<Role> searchByName(@Param(value = "name") String name);
	@Query("SELECT r FROM Role r JOIN r.users ru WHERE ru._id=:userId")
	List<Role> findAllByUserId(@Param(value = "userId") String userId);
	@Query("SELECT r FROM Role r JOIN r.users ru WHERE ru.username=:username")
	List<Role> findAllByUserName(@Param(value = "username") String useruame);

}
