package com.shenmajr.boot.repo.security;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.shenmajr.boot.domain.security.User;

public interface UserRepo extends JpaRepository<User, String> {
	
	public User findBy_id(String _id);
	public User findByUsernameAndPassword(String Username, String password);

	public User findByUsername(String username);

    public Page<User> findByUsernameLikeOrderByCreateTimeDesc(String username, Pageable page);

    @Query(value = "SELECT u FROM User u WHERE u.username like :username")
    public Page<User> searchByName(@Param(value = "username") String username, Pageable page);
    
}
