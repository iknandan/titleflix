package io.titleflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="No Titles are present in the Database")
public class NoTitlesPresent extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8950222863951684522L;

}
