package io.titleflix.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_REQUEST,reason="Any field present in the Title CANNOT be Null or Empty, instaed use'N/A'")
public class TitleFieldValidation extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
