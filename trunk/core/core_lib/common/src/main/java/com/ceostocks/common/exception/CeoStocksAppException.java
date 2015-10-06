package com.ceostocks.common.exception;

public class CeoStocksAppException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1860777654135236264L;

	public CeoStocksAppException(String message) {
		super(message);
	}

	public CeoStocksAppException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
