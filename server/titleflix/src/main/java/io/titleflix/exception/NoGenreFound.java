package io.titleflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="No Gnere present in the database")
public class NoGenreFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1771849700262109467L;

}
