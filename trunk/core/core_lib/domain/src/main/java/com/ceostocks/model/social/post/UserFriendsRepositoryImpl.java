package com.ceostocks.model.social.post;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.base.BaseDaoJpa;

@Repository
public class UserFriendsRepositoryImpl extends BaseDaoJpa<UserFriends, UserFriendsPK> implements UserFriendsRepository {

	public UserFriendsRepositoryImpl() {
		super(UserFriends.class);
	}

	@Override
	public List<UserFriends> getUserFriends(BigDecimal userIndex, int start, int count) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<UserFriends> query = cb.createQuery(UserFriends.class);
		Root<UserFriends> root = query.from(UserFriends.class);
		query.select(root);

		List<Predicate> predicates = new ArrayList<Predicate>();
		ParameterExpression<BigDecimal> pe = cb.parameter(BigDecimal.class);
		predicates.add(cb.or(cb.equal(root.get("userFriendsPK").get("requesterId"), pe), cb.equal(root.get("userFriendsPK").get("accepterId"), pe)));
		ParameterExpression<Boolean> pe1 = cb.parameter(Boolean.class);
		predicates.add(cb.equal(root.get("isRequestAccepted"), pe1));
		query.where(predicates.toArray(new Predicate[predicates.size()]));

		TypedQuery<UserFriends> typedQuery = getEntityManager().createQuery(query);

		typedQuery.setParameter(pe, userIndex);
		typedQuery.setParameter(pe1, Boolean.TRUE);

		typedQuery.setFirstResult(start);
		typedQuery.setMaxResults(count);
		return typedQuery.getResultList();
	}

	@Override
	public List<UserFriends> searchByCriteria(UserFriendsFilter userFriendsFilter, int start, int count) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<UserFriends> query = cb.createQuery(UserFriends.class);
		Root<UserFriends> root = query.from(UserFriends.class);
		query.select(root);
		addCriteria(userFriendsFilter, cb, query, root);

		TypedQuery<UserFriends> typedQuery = getEntityManager().createQuery(query);
		addPositionalParameter(userFriendsFilter, typedQuery);

		if (start > 0 && count > 0) {
			typedQuery.setFirstResult(start);
			typedQuery.setMaxResults(count);
		}
		return typedQuery.getResultList();
	}

	private void addPositionalParameter(UserFriendsFilter userFriendsFilter, TypedQuery<?> typedQuery) {
		if (userFriendsFilter.getRequesterId() != null) {
			typedQuery.setParameter(UserFriendsFilter.REQUESTER_ID, userFriendsFilter.getRequesterId());
		}

		if (userFriendsFilter.getAccepterId() != null) {
			typedQuery.setParameter(UserFriendsFilter.ACCEPTER_ID, userFriendsFilter.getAccepterId());
		}

		if (userFriendsFilter.getIsRequestAccepted() != null) {
			typedQuery.setParameter(UserFriendsFilter.IS_REQUEST_ACCEPTED, userFriendsFilter.getIsRequestAccepted());
		}
	}

	private void addCriteria(UserFriendsFilter userFriendsFilter, CriteriaBuilder cb, CriteriaQuery<?> query, Root<?> root) {
		List<Predicate> predicates = new ArrayList<Predicate>();
		if (userFriendsFilter.getRequesterId() != null) {
			ParameterExpression<BigDecimal> p = cb.parameter(BigDecimal.class, UserFriendsFilter.REQUESTER_ID);
			predicates.add(cb.equal(root.get(UserFriendsFilter.USER_FRIENDS_PK).get(UserFriendsFilter.REQUESTER_ID), p));
		}

		if (userFriendsFilter.getAccepterId() != null) {
			ParameterExpression<BigDecimal> p = cb.parameter(BigDecimal.class, UserFriendsFilter.ACCEPTER_ID);
			predicates.add(cb.equal(root.get(UserFriendsFilter.USER_FRIENDS_PK).get(UserFriendsFilter.ACCEPTER_ID), p));
		}

		if (userFriendsFilter.getIsRequestAccepted() != null) {
			ParameterExpression<Boolean> p = cb.parameter(Boolean.class, UserFriendsFilter.IS_REQUEST_ACCEPTED);
			predicates.add(cb.equal(root.get(UserFriendsFilter.IS_REQUEST_ACCEPTED), p));
		}
		query.where(predicates.toArray(new Predicate[predicates.size()]));
	}

	@Override
	public Long count(UserFriendsFilter userFriendsFilter) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		Root<UserFriends> root = query.from(UserFriends.class);
		query.select(cb.count(root));
		addCriteria(userFriendsFilter, cb, query, root);
		TypedQuery<Long> typedQuery = getEntityManager().createQuery(query);
		addPositionalParameter(userFriendsFilter, typedQuery);
		return typedQuery.getSingleResult();
	}
}
