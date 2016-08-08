package io.titleflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="Please provide valid password")
public class ValidPassword extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9118165346333381589L;

}
