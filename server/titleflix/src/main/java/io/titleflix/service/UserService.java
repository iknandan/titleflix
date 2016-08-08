package io.titleflix.service;

import java.util.List;

import io.titleflix.entity.User;
import io.titleflix.exception.IncorrectCredentials;
import io.titleflix.exception.UserAlreadyExists;
import io.titleflix.exception.UserNotFound;
import io.titleflix.exception.ValidEmail;
import io.titleflix.exception.ValidPassword;
import io.titleflix.exception.ValidUserName;

public interface UserService {
	
	public User signIn(User user) throws UserNotFound, IncorrectCredentials, ValidEmail, ValidPassword;
	public User signUp(User user) throws UserAlreadyExists, ValidUserName, ValidEmail, ValidPassword;
	public List<User> findAllUsers();
}
