package io.titleflix.repository;

import java.util.List;

import io.titleflix.entity.User;

public interface UserRepository {
	
	public User signIn(User user);
	public User signUp(User user);
	public User findByEmail(String email);
	public List<User> findAllUsers();
	public User findByUserId(String userId);
	
}
