package kr.inek.tanbbang01.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DeptNotFoundException extends RuntimeException {

	public DeptNotFoundException(String message) {
		super(message);
	}
	
}
