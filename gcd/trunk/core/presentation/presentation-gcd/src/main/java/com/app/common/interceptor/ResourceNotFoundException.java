package com.app.common.interceptor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
	@Override
	public String getMessage() {
		System.out.println(super.getMessage());
		return super.getMessage();
	}
}