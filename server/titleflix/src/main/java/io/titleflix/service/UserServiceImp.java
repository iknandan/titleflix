package io.titleflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.titleflix.entity.User;
import io.titleflix.exception.IncorrectCredentials;
import io.titleflix.exception.UserAlreadyExists;
import io.titleflix.exception.UserNotFound;
import io.titleflix.exception.ValidEmail;
import io.titleflix.exception.ValidPassword;
import io.titleflix.exception.ValidUserName;
import io.titleflix.repository.UserRepository;
import io.titleflix.validation.UserValidation;

/**
 * This is a User service layer where all the business logic is implemented and
 * exceptions are thrown
 * 
 * @author nandan
 *
 */
@Service
@Transactional
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private UserValidation userValidation;

	// This method is used as a User signIn functionality
	@Override
	public User signIn(User user) throws UserNotFound, IncorrectCredentials, ValidEmail, ValidPassword {

		// Method used to validate User Object
		User validUser = userValidation.validateUserSignIn(user);
		// Checks, User exists with the Email provided
		User existing = userRepository.findByEmail(validUser.getEmail());
		// Validation to check the user present in the data base.
		if (existing != null) {
			// The signIn functionality to check credentials
			User checkUser = userRepository.signIn(user);
			if (checkUser != null) {
				return checkUser;
			} else {
				throw new IncorrectCredentials();
			}
		} else {
			throw new UserNotFound();
		}

	}

	// This method is used as a User signUp functionality
	@Override
	public User signUp(User user) throws UserAlreadyExists, ValidUserName, ValidEmail, ValidPassword {
		// Method used to validate User Object
		User validUser = userValidation.validateUserSignUp(user);
		// Checks, User exists with the Email provided
		User existing = userRepository.findByEmail(validUser.getEmail());
		if (existing == null) {
			// Implement SignUp functionality
			User registeredUser = userRepository.signUp(user);
			return registeredUser;
		} else {
			throw new UserAlreadyExists();
		}

	}

	//This method is used to find all user present in the DataBase 
	@Override
	public List<User> findAllUsers() {
		// Method to find All users
		List<User> findAllUsers = userRepository.findAllUsers();
		return findAllUsers;
	}

}
