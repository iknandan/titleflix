package io.titleflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="UserID should not be NUll or Empty")
public class ValidUserID extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6813857518425577056L;

}
