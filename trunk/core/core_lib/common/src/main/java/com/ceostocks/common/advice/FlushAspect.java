package com.ceostocks.common.advice;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;

public class FlushAspect {

	@PersistenceContext(unitName = "domain")
	private EntityManager entityManager;

	private HibernateJpaDialect jpaDialect = new HibernateJpaDialect();

	public Object flushBeforeCommit(ProceedingJoinPoint jp) throws Throwable {
		Object o = null;
		o = jp.proceed();
		try {
			entityManager.flush();
		} catch (RuntimeException orignal) {
			DataAccessException converted = jpaDialect.translateExceptionIfPossible(orignal);
			throw converted != null ? converted : orignal;
		}
		return o;
	}
}
