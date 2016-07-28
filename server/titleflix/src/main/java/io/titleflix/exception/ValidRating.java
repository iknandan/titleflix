package io.titleflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="Rating Should be from 0 and 5")
public class ValidRating extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 762513071168022271L;

}
