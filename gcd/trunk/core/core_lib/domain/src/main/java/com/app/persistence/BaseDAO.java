package com.app.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import com.app.model.base.Base;

public interface BaseDAO<T extends Base<I>, I extends Serializable> {

	public Collection<? extends Base<I>> read(Class<? extends Base<I>> persistable) throws Exception;

	public Base<Serializable> readByID(Class<T> clazz, Serializable id) throws Exception;

	//public Collection<?> read(GenericQuery query) throws Exception;

	T load(I id) throws Exception;

	T get(I id);

	List<T> get(I... ids);

	List<T> getAll();

	List<T> findByExample(T example);

	void update(T object);

	void update(T... objects);

	void save(T object);

	void save(T... objects);

	void delete(I id) throws UnsupportedOperationException;

	void delete(I... ids) throws Exception;

	void delete(T object) throws Exception;

	void delete(T... objects) throws Exception;

	void deleteAll();

	void refresh(T entity);

	void flushAndClear();
}
