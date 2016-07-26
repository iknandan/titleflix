package io.titleflix.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="User already exists with the Email provided")
public class UserAlreadyExists extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8276553052617601147L;

}
