package com.app.persistence;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import com.app.model.base.Base;

public class JPADAO<T extends Base<I>, I extends Serializable> implements BaseDAO<T, I> {
	private EntityManager entityManager;

	@Override
	public Collection<? extends Base<I>> read(Class<? extends Base<I>> persistable) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Base<Serializable> readByID(Class<T> clazz, Serializable id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T load(I id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T get(I id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> get(I... ids) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<T> findByExample(T example) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(T object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(T... objects) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(T object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(T... objects) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(I id) throws UnsupportedOperationException {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(I... ids) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(T object) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(T... objects) throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public void refresh(T entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void flushAndClear() {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

	/**
	 * @param entityManager
	 *            the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

}
