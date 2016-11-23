package com.app.persistence.factory;

import com.app.persistence.BaseDAO;
import com.app.persistence.exception.DAOException;

public abstract class DAOFactory<T extends BaseDAO> {

	public static int DEFAULT = 1;

	public abstract T getDAO(Class<?> clazz);

	public static DAOFactory<? extends BaseDAO> getDAOFactory(final int type) throws DAOException {
		if (type == DEFAULT)
			return new JPADAOFactory();
		else
			return null;
	}
}
