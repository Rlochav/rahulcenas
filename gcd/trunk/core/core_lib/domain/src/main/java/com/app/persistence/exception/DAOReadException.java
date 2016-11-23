package com.app.persistence.exception;

import com.app.model.base.Base;

/**
 * @author Piyush Pratap Singh
 * @version 1.0
 * @see
 */
public class DAOReadException extends DAOException {

    /**
	 * 
	 */
	private static final long serialVersionUID = -8648901426356541941L;
	private Base persistable;
    private String query;

    public DAOReadException(Base persistable, Throwable t) {
        super(t);
        this.setPersistable(persistable);
    }

    public DAOReadException(String query, Throwable t) {
        super(t);
        this.setQuery(query);
    }

    public DAOReadException(Throwable t) {
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
	public Base getPersistable() {
		return persistable;
	}

	/**
	 * @param query the query to set
	 */
	public void setQuery(String query) {
		this.query = query;
	}

	/**
	 * @return the query
	 */
	public String getQuery() {
		return query;
	}
}
