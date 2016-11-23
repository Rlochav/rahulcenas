package com.app.persistence.exception;

/**
 * This exception is called when unexpected return value is received from a
 * method. Usually due to logical error in program implementation.
 * 
 * @author Piyush Pratap Singh
 */
public class AuditLoggingException extends RuntimeException {

    /**
     * Generated class UID
     */
    private static final long serialVersionUID = -5571782216124026964L;

    /**
     * Default constructor.
     */
    public AuditLoggingException() {
        super();
    }

    /**
     * Inherited constructor from RuntimeException.
     * 
     * @param message - error message
     * @param cause - root cause
     */
    public AuditLoggingException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Inherited constructor from RuntimeException.
     * 
     * @param message - error message
     */
    public AuditLoggingException(final String message) {
        super(message);
    }

    /**
     * Inherited constructor from RuntimeException.
     * 
     * @param cause - root cause
     */
    public AuditLoggingException(final Throwable cause) {
        super(cause);
    }

}
