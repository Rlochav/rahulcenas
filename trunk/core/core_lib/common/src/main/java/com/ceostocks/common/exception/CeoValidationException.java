package com.ceostocks.common.exception;

public class CeoValidationException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6758582918792721508L;

	public CeoValidationException() {
		super();
	}

	public CeoValidationException(String message) {
		super(message);
	}

	public CeoValidationException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
