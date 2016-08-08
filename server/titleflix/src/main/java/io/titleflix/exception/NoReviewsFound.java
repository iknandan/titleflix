package io.titleflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.NOT_FOUND,reason="No Comments or Ratings found for this Title")
public class NoReviewsFound extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8974349484102893488L;

}
