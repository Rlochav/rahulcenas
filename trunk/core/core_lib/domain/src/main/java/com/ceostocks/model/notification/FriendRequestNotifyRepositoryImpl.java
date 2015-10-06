package com.ceostocks.model.notification;

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
import com.ceostocks.model.social.post.UserFriendsFilter;

@Repository
public class FriendRequestNotifyRepositoryImpl extends BaseDaoJpa<FriendRequestNotify, BigDecimal> implements FriendRequestNotifyRepository {

	public FriendRequestNotifyRepositoryImpl() {
		super(FriendRequestNotify.class);
	}

	@Override
	public List<FriendRequestNotify> searchByCriteria(UserFriendsFilter userFriendsFilter, int start, int count) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<FriendRequestNotify> query = cb.createQuery(FriendRequestNotify.class);
		Root<FriendRequestNotify> root = query.from(FriendRequestNotify.class);
		query.select(root);
		addCriteria(userFriendsFilter, cb, query, root);

		TypedQuery<FriendRequestNotify> typedQuery = getEntityManager().createQuery(query);
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

		if (userFriendsFilter.getIsSeen() != null) {
			typedQuery.setParameter(UserFriendsFilter.IS_SEEN, userFriendsFilter.getIsSeen());
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

		if (userFriendsFilter.getIsSeen() != null) {
			ParameterExpression<Boolean> p = cb.parameter(Boolean.class, UserFriendsFilter.IS_SEEN);
			predicates.add(cb.equal(root.get(UserFriendsFilter.IS_SEEN), p));
		}
		query.where(predicates.toArray(new Predicate[predicates.size()]));
	}

	@Override
	public Long count(UserFriendsFilter userFriendsFilter) {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> query = cb.createQuery(Long.class);
		Root<FriendRequestNotify> root = query.from(FriendRequestNotify.class);
		query.select(cb.count(root));
		addCriteria(userFriendsFilter, cb, query, root);
		TypedQuery<Long> typedQuery = getEntityManager().createQuery(query);
		addPositionalParameter(userFriendsFilter, typedQuery);
		return typedQuery.getSingleResult();
	}
}
