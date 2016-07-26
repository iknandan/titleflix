package io.titleflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="No Title Found with such Id")
public class TitleNotFound extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4170662081289343976L;

}
