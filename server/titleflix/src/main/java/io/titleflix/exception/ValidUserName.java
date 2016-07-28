package io.titleflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="Please provide a valid user name")
public class ValidUserName extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1351545900676121084L;

}
