/**
 * 
 */
package com.app.commonexception;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

/**
 * This is the Base Exception class.
 * 
 * @author Piyush Pratap Singh
 * 
 */
public abstract class BaseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4029538241134114510L;
	public static String BUSSINESS_TYP = "business";
	public static String DATABASE_TYP = "database";
	public static String SERVICE_TYP = "service";
	
	protected Throwable cause;
	private String msgCode;
	private String type;
	private List<String> cumulatedErrors;

	public BaseException(String message, Throwable cause) {
		super();
		this.cause = cause;
	}
	
	public BaseException(String msgCode, String type) {
		super();
		this.msgCode = msgCode;
		this.type = type;
	}
	
	public BaseException(List<String> msgList, String type) {
		super();
		this.cumulatedErrors = msgList;
		this.type = type;
	}

	// Created to match the JDK 1.4 Throwable method.
	public Throwable initCause(Throwable cause) {
		this.cause = cause;
		return cause;
	}

	public String getMessage() {
		// Get this exception's message.
		String msg = super.getMessage();

		Throwable parent = this;
		Throwable child;

		// Look for nested exceptions.
		while ((child = getNestedException(parent)) != null) {
			// Get the child's message.
			String msg2 = child.getMessage();

			// If we found a message for the child exception,
			// we append it.
			if (msg2 != null) {
				if (msg != null) {
					msg += ": " + msg2;
				} else {
					msg = msg2;
				}
			}

			// Any nested ApplicationException will append its own
			// children, so we need to break out of here.
			if (child instanceof BaseException) {
				break;
			}
			parent = child;
		}

		// Return the completed message.
		return msg;
	}

	public void printStackTrace() {
		// Print the stack trace for this exception.
		super.printStackTrace();

		Throwable parent = this;
		Throwable child;

		// Print the stack trace for each nested exception.
		while ((child = getNestedException(parent)) != null) {
			if (child != null) {
				System.err.print("Caused by: ");
				child.printStackTrace();

				if (child instanceof BaseException) {
					break;
				}
				parent = child;
			}
		}
	}

	public void printStackTrace(PrintStream s) {
		// Print the stack trace for this exception.
		super.printStackTrace(s);

		Throwable parent = this;
		Throwable child;

		// Print the stack trace for each nested exception.
		while ((child = getNestedException(parent)) != null) {
			if (child != null) {
				s.print("Caused by: ");
				child.printStackTrace(s);

				if (child instanceof BaseException) {
					break;
				}
				parent = child;
			}
		}
	}

	public void printStackTrace(PrintWriter w) {
		// Print the stack trace for this exception.
		super.printStackTrace(w);

		Throwable parent = this;
		Throwable child;

		// Print the stack trace for each nested exception.
		while ((child = getNestedException(parent)) != null) {
			if (child != null) {
				w.print("Caused by: ");
				child.printStackTrace(w);

				if (child instanceof BaseException) {
					break;
				}
				parent = child;
			}
		}
	}

	private Throwable getNestedException(Throwable parent) {
		// TODO Auto-generated method stub
		return null;
	}

	public Throwable getCause() {
		return cause;
	}

	public String getMsgCode() {
		return msgCode;
	}

	

	public void setMsgCode(String msgCode) {
		this.msgCode = msgCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void add(Throwable t) {
		if (cumulatedErrors == null)
			cumulatedErrors = new LinkedList<String>();
		cumulatedErrors.add(t.getMessage());
	}

	public void add(String msgCode) {
		if (cumulatedErrors == null)
			cumulatedErrors = new LinkedList<String>();
		cumulatedErrors.add(msgCode);
	}

	public static void handleError() {

	}

	public static void handleFatal() {

	}

	public static void handleWarning() {

	}

	/**
	 * @return the cumulatedErrors
	 */
	public List<String> getCumulatedErrors() {
		return cumulatedErrors;
	}

	/**
	 * @param cumulatedErrors the cumulatedErrors to set
	 */
	public void setCumulatedErrors(List<String> cumulatedErrors) {
		this.cumulatedErrors = cumulatedErrors;
	}
}
