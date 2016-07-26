package io.titleflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="No User exists with such Email id")
public class UserNotFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4708361969370395043L;

}