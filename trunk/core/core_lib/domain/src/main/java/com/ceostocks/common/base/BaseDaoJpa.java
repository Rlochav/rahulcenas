package com.ceostocks.common.base;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.exception.NotFoundException;

@Repository
public abstract class BaseDaoJpa<T extends Serializable, ID> implements BaseDao<T, ID> {

	@PersistenceContext(unitName = "domain")
	private EntityManager entityManager;

	private Class<T> clazz;

	/*
	 * public BaseDaoJpa() {
	 * 
	 * }
	 */

	public BaseDaoJpa(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public void save(T t) {
		entityManager.persist(t);
	}

	@Override
	public void delete(T t) {
		entityManager.remove(t);
	}

	@Override
	public void update(T t) {
		entityManager.merge(t);
	}

	@Override
	public T getById(ID id) {
		T t = findById(id);
		if (t == null)
			throw new NotFoundException("entity not found for given id=" + id);
		return null;
	}

	@Override
	public T findById(ID id) {
		if (id != null)
			return entityManager.find(clazz, id);
		return null;
	}

	/**
	 * @return the entityManager
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
