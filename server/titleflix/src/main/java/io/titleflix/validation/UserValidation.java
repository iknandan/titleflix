package io.titleflix.validation;

import org.springframework.stereotype.Component;

import io.titleflix.entity.User;
import io.titleflix.exception.ValidEmail;
import io.titleflix.exception.ValidPassword;
import io.titleflix.exception.ValidUserName;

/**
 * This Class is used to validate all the User inputs of an API
 * 
 * @author nandan
 *
 */
@Component
public class UserValidation {
	// This functionality is used to validate the null an empty checks of the user SignIn inputs
	public User validateUserSignIn(User user) throws ValidEmail, ValidPassword {

		if (user.getEmail() == null || user.getEmail() == "") {
			throw new ValidEmail();
		} else if (user.getPassword() == null || user.getPassword() == "") {
			throw new ValidPassword();
		}
		return user;
	}
	//This functionality is used to validate the null an empty checks of the user SignUp inputs
	public User validateUserSignUp(User user) throws ValidUserName, ValidEmail, ValidPassword {

		if (user.getUserName() == null || user.getUserName() == "") {
			throw new ValidUserName();
		} else if (user.getEmail() == null || user.getEmail() == "") {
			throw new ValidEmail();
		} else if (user.getPassword() == null || user.getPassword() == "") {
			throw new ValidPassword();
		}
		return user;
	}

}
