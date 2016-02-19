package com.shenmajr.boot.sevices.security;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.shenmajr.boot.domain.security.User;

public interface UserInterface extends UserDetailsService {
	public User addUser(User user);
	public User updateUser(User user);
	public User delUser(String _id);

	public User findById(String _id);
	public User findByUsernameAndPassword(String Username, String password);

	public User findByUsername(String username);

    public Page<User> findByUsernameLikeOrderByCreateTimeDesc(String username, Pageable page);

    @Query(value = "SELECT u FROM User u WHERE u.username like :username  ")
    public Page<User> searchByName(@Param(value = "username") String username, Pageable page);
}
