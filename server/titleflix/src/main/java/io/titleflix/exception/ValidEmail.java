package io.titleflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="Please enter a Valid Email. Example: nandhan@gmail.com")
public class ValidEmail extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2729319295892425835L;

}
