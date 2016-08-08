package io.titleflix.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.titleflix.entity.User;
import io.titleflix.exception.IncorrectCredentials;
import io.titleflix.exception.UserAlreadyExists;
import io.titleflix.exception.UserNotFound;
import io.titleflix.exception.ValidEmail;
import io.titleflix.exception.ValidPassword;
import io.titleflix.exception.ValidUserName;
import io.titleflix.exception.ValidateEmailAndPassword;
import io.titleflix.service.UserService;

/**
 * This controller has the functionalities specific to the user such as SignIn and SignUp
 * @author nandan
 *
 */
@RestController
@RequestMapping(path = "/user")
public class UserController {

	@Autowired
	private UserService userService;
	// This is a signIn functionality with a POST requestMethod used for use Login.
	@RequestMapping(path = "/signIn", method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User signIn(@RequestBody User user)
			throws UserNotFound, IncorrectCredentials, ValidateEmailAndPassword, ValidEmail, ValidPassword {
		User existing = userService.signIn(user);
		return existing;
	}

	// This is a SignUp functionality used for the user Registeration.
	@RequestMapping(path = "/signUp", method = RequestMethod.POST, consumes = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE, produces = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public User signUp(@RequestBody User user) throws UserAlreadyExists, ValidUserName, ValidEmail, ValidPassword {
		User registeredUser = userService.signUp(user);
		return registeredUser;
	}

	// SinOut functionality is going to be implemented in the front End
	public void SignOut() {
		// Likely to be implemented on the front end using JWT
	}
	
	// This functionality is used to find all users avaliable in the database.It is used as a demo purpose only.
	@RequestMapping(path = "/findAllUsers", method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<User> findAll() {
		List<User> allUsers = userService.findAllUsers();
		return allUsers;
	}
}