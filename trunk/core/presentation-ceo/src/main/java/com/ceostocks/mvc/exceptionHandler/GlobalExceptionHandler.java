package com.ceostocks.mvc.exceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceostocks.common.ResourceNotFoundException;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.fasterxml.jackson.core.JsonProcessingException;

@ControllerAdvice
public class GlobalExceptionHandler extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7749647000386503448L;

	@ExceptionHandler(ResourceNotFoundException.class)
	@ResponseBody
	public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException ex) throws JsonProcessingException {
		Error error = new Error();
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity<String>(mapper.writeValueAsString(error), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	@ResponseBody
	public ResponseEntity<String> genericException(HttpMessageNotReadableException ex) throws JsonProcessingException {
		Error error = new Error();
		error.setErrorMessage("Invalid request parameter.");
		return new ResponseEntity<String>(mapper.writeValueAsString(error), HttpStatus.NOT_ACCEPTABLE);
	}

	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ResponseEntity<String> genericException(Exception ex) throws JsonProcessingException {		
		ex.printStackTrace();
		Error error = new Error();
		error.setErrorMessage(ex.getMessage());
		return new ResponseEntity<String>(mapper.writeValueAsString(error), HttpStatus.NOT_FOUND);
	}

	/**
	 * Error class to return error message in response.
	 * 
	 * @author Arun
	 *
	 */
	public class Error {
		private String errorMessage;
		private String errorCode;

		/**
		 * @return the errorMessage
		 */
		public String getErrorMessage() {
			return errorMessage;
		}

		/**
		 * @param errorMessage
		 *            the errorMessage to set
		 */
		public void setErrorMessage(String errorMessage) {
			this.errorMessage = errorMessage;
		}

		/**
		 * @return the errorCode
		 */
		public String getErrorCode() {
			return errorCode;
		}

		/**
		 * @param errorCode
		 *            the errorCode to set
		 */
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}

	}
}
