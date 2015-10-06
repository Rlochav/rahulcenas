package com.ceostocks.model.user;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.base.BaseDaoJpa;

@Repository
public class UserSessionRepositoryImpl extends BaseDaoJpa<UserSession, Integer> implements UserSessionRepository {

	public UserSessionRepositoryImpl() {
		super(UserSession.class);
	}

	@Override
	public UserSession getUserSessionByUserIndex(BigDecimal userIndex) {
		TypedQuery<UserSession> typedQuery = getEntityManager().createQuery("from UserSession u where u.userIndex=:userIndex", UserSession.class);
		typedQuery.setParameter("userIndex", userIndex);
		List<UserSession> userSessions = typedQuery.getResultList();
		if (userSessions.size() > 0)
			return userSessions.get(0);
		return null;
	}
}
