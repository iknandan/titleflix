package io.titleflix.exception;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="Incorrect Credentials for the Email and Password")
public class IncorrectCredentials extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6486759023891514799L;

}