package io.titleflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="Comment field cannot be Emty or null")
public class ValidComment extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2929946946891124569L;

}
