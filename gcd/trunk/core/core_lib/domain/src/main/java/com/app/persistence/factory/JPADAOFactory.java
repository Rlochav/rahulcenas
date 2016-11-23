package com.app.persistence.factory;

import com.app.persistence.BaseDAO;

public class JPADAOFactory extends DAOFactory<BaseDAO> {

	@Override
	public BaseDAO getDAO(Class clazz) {
		try {
			return (BaseDAO) clazz.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		}catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

}
