package com.ceostocks.model.user;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.base.BaseDaoJpa;

@Repository
public class UserMasteRepositoryImpl extends BaseDaoJpa<UserMaster, BigDecimal> implements UserMasterRepository {

	public UserMasteRepositoryImpl() {
		super(UserMaster.class);
	}

	@Override
	public UserMaster getByEmailOrUserId(String userId) {
		UserMaster userMaster = null;
		TypedQuery<UserMaster> typedQuery = getEntityManager().createQuery("from UserMaster u where u.emailId=?", UserMaster.class);
		userMaster = getSingleResult(userMaster, typedQuery, userId);

		if (userMaster == null) {
			typedQuery = getEntityManager().createQuery("from UserMaster u where u.userId=?", UserMaster.class);
			userMaster = getSingleResult(userMaster, typedQuery, userId);
		}

		return userMaster;
	}

	@Override
	public boolean isEmailUnique(String emailId) {
		TypedQuery<UserMaster> typedQuery = getEntityManager().createQuery("from UserMaster u where u.emailId=?", UserMaster.class);
		typedQuery.setParameter(1, emailId);
		try {
			typedQuery.getSingleResult();
		} catch (NoResultException e) {
			return false;
		}
		return true;
	}

	private UserMaster getSingleResult(UserMaster userMaster, TypedQuery<UserMaster> typedQuery, String userId) {
		typedQuery.setParameter(1, userId);
		try {
			userMaster = typedQuery.getSingleResult();
		} catch (NoResultException e) {
			// ignore
		}
		return userMaster;
	}

	@Override
	public List<UserMaster> findAll() {
		TypedQuery<UserMaster> query = getEntityManager().createQuery("from UserMaster", UserMaster.class);
		return query.getResultList();
	}

	@Override
	public List<UserMaster> searchByCriteria(UserMasterFilter userMasterFilter, int start, int count) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<UserMaster> query = cb.createQuery(UserMaster.class);
		Root<UserMaster> root = query.from(UserMaster.class);
		query.select(root);
		addCriteria(userMasterFilter, cb, query, root);

		TypedQuery<UserMaster> typedQuery = getEntityManager().createQuery(query);
		addPositionalParameter(userMasterFilter, typedQuery);

		if (start > 0 && count > 0) {
			typedQuery.setFirstResult(start);
			typedQuery.setMaxResults(count);
		}
		return typedQuery.getResultList();
	}

	private void addPositionalParameter(UserMasterFilter userMasterFilter, TypedQuery<?> typedQuery) {
		if (userMasterFilter != null) {
			if (userMasterFilter.getOfFlag()) {
				typedQuery.setParameter(UserMasterFilter.FIRST_NAME, userMasterFilter.getFirstName());
				typedQuery.setParameter(UserMasterFilter.LAST_NAME, userMasterFilter.getLastName());
				typedQuery.setParameter(UserMasterFilter.EMAIL_ID, userMasterFilter.getEmailId());
			}

			if (userMasterFilter.getFirstName() != null && !userMasterFilter.getOfFlag()) {
				typedQuery.setParameter(UserMasterFilter.FIRST_NAME, userMasterFilter.getFirstName());
			}

			if (userMasterFilter.getLastName() != null && !userMasterFilter.getOfFlag()) {
				typedQuery.setParameter(UserMasterFilter.LAST_NAME, userMasterFilter.getLastName());
			}

			if (userMasterFilter.getEmailId() != null && !userMasterFilter.getOfFlag()) {
				typedQuery.setParameter(UserMasterFilter.EMAIL_ID, userMasterFilter.getEmailId());
			}

			if (userMasterFilter.getActivateCode() != null) {
				typedQuery.setParameter(UserMasterFilter.ACTIVATE_CODE, userMasterFilter.getActivateCode());
			}

			if (userMasterFilter.getTimeLineId() != null) {
				typedQuery.setParameter(UserMasterFilter.TIMELINE_ID, userMasterFilter.getTimeLineId());
			}
		}
	}

	private void addCriteria(UserMasterFilter userMasterFilter, CriteriaBuilder cb, CriteriaQuery<?> query, Root<?> root) {
		if (userMasterFilter != null) {
			List<Predicate> predicates = new ArrayList<Predicate>();
			if (userMasterFilter.getOfFlag()) {
				predicates.add(addOrStatementCriteria(userMasterFilter, cb, root));
			}

			if (userMasterFilter.getFirstName() != null && !userMasterFilter.getOfFlag()) {
				ParameterExpression<String> p = cb.parameter(String.class, UserMasterFilter.FIRST_NAME);
				predicates.add(cb.like(cb.lower(root.get(UserMasterFilter.FIRST_NAME)), p));
			}

			if (userMasterFilter.getLastName() != null && !userMasterFilter.getOfFlag()) {
				ParameterExpression<String> p = cb.parameter(String.class, UserMasterFilter.LAST_NAME);
				predicates.add(cb.like(cb.lower(root.get(UserMasterFilter.LAST_NAME)), p));
			}

			if (userMasterFilter.getEmailId() != null && !userMasterFilter.getOfFlag()) {
				ParameterExpression<String> p = cb.parameter(String.class, UserMasterFilter.EMAIL_ID);
				predicates.add(cb.equal(root.get(UserMasterFilter.EMAIL_ID), p));
			}

			if (userMasterFilter.getActivateCode() != null) {
				ParameterExpression<String> p = cb.parameter(String.class, UserMasterFilter.ACTIVATE_CODE);
				predicates.add(cb.equal(root.get(UserMasterFilter.ACTIVATE_CODE), p));
			}

			if (userMasterFilter.getTimeLineId() != null) {
				ParameterExpression<String> p = cb.parameter(String.class, UserMasterFilter.TIMELINE_ID);
				predicates.add(cb.equal(root.get(UserMasterFilter.TIMELINE_ID), p));
			}
			query.where(predicates.toArray(new Predicate[predicates.size()]));
		}
	}

	private Predicate addOrStatementCriteria(UserMasterFilter userMasterFilter, CriteriaBuilder cb, Root<?> root) {
		List<Predicate> orPredicates = new ArrayList<Predicate>();
		ParameterExpression<String> firstNameExpression = cb.parameter(String.class, UserMasterFilter.FIRST_NAME);
		orPredicates.add(cb.like(cb.lower(root.get(UserMasterFilter.FIRST_NAME)), firstNameExpression));

		ParameterExpression<String> lastNameExpression = cb.parameter(String.class, UserMasterFilter.LAST_NAME);
		orPredicates.add(cb.like(cb.lower(root.get(UserMasterFilter.LAST_NAME)), lastNameExpression));

		ParameterExpression<String> emailIdNameExpression = cb.parameter(String.class, UserMasterFilter.EMAIL_ID);
		orPredicates.add(cb.like(cb.lower(root.get(UserMasterFilter.EMAIL_ID)), emailIdNameExpression));
		return cb.or(orPredicates.toArray(new Predicate[orPredicates.size()]));
	}
}
