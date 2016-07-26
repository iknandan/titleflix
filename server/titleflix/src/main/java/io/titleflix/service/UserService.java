package io.titleflix.service;

import java.util.List;

import io.titleflix.entity.User;
import io.titleflix.exception.IncorrectCredentials;
import io.titleflix.exception.UserAlreadyExists;
import io.titleflix.exception.UserNotFound;

public interface UserService {
	
	public User signIn(User user) throws UserNotFound, IncorrectCredentials;
	public User signUp(User user) throws UserAlreadyExists;
	public List<User> findAllUsers();
}
