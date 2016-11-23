package com.app.persistence.exception;

import java.io.Serializable;

import com.app.model.base.Base;

/**
 * @author Piyush Pratap Singh
 * @version 1.0
 * @see
 */
public class DAOUpdateException extends DAOException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1537336880678577118L;
	private Base persistable;

    public DAOUpdateException(Base persistable, Throwable t) {
        super(t);
        this.setPersistable(persistable);
    }

    public DAOUpdateException(Throwable t) {
        super(t);
    }

	/**
	 * @param persistable the persistable to set
	 */
	public void setPersistable(Base persistable) {
		this.persistable = persistable;
	}

	/**
	 * @return the persistable
	 */
	public Base<Serializable> getPersistable() {
		return persistable;
	}
}
