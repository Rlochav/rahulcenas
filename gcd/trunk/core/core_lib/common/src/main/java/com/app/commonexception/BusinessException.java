/**
 * 
 */
package com.app.commonexception;

import java.util.List;

/**
 * @author Piyush Pratap Singh
 *
 */
public class BusinessException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 356240320372860905L;
	
	public BusinessException(String msgCode, String type) {
		super(msgCode, type);
		// TODO Auto-generated constructor stub
	}
	
	public BusinessException(String message, Throwable cause) {
		super(message,cause);
		// TODO Auto-generated constructor stub
	}
	public BusinessException(List<String> message, String type) {
		super(message,type);
		// TODO Auto-generated constructor stub
	}

}
