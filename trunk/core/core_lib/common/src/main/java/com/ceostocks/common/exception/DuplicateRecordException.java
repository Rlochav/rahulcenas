package com.ceostocks.common.exception;

public class DuplicateRecordException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1168928645687261250L;

	public DuplicateRecordException(String message) {
		super(message);
	}

	public DuplicateRecordException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
