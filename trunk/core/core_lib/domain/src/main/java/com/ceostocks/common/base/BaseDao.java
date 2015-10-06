package com.ceostocks.common.base;

import java.io.Serializable;

public interface BaseDao<T extends Serializable, ID> {

	void save(T t);

	void delete(T t);

	void update(T t);

	T getById(ID t) throws Exception;

	T findById(ID t);
}
