package com.app.persistence.exception;

import java.io.Serializable;

import com.app.model.base.Base;

/**
 * 
 * @author Piyush Pratap Singh
 * 
 */
public class DAOStaleObjectException extends DAOUpdateException{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8119690191066895697L;
	private Base persistable;

    public DAOStaleObjectException(Throwable t) {
        super(t);
    }

    public DAOStaleObjectException(Base persistable, Throwable t) {
        super(t);
        this.setPersistable(persistable);
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
