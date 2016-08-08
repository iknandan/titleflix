package io.titleflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="Please provide valid emailId and Password")
public class ValidateEmailAndPassword extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8431942643376487069L;

}
