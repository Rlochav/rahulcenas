package com.app.persistence.exception;

import java.util.LinkedList;
import java.util.List;

import com.app.commonexception.BaseException;

/**
 * 
 * @author Piyush Pratap Singh
 * @version 1.0
 * @see
 */
public class DAOException extends BaseException {
    /**
	 *
	 */
	private static final long serialVersionUID = 8121909527897221099L;
	private List<String> cumulatedErrors;
	
    public DAOException(Throwable t) {
        super(BUSSINESS_TYP, t);
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
}
