package io.titleflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="No title found for the given Gnere")
public class NoTitleForGenre extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4241070095401266283L;

}
