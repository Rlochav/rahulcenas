package com.ceostocks.model.user;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.base.BaseDaoJpa;

@Repository
public class UserSessionLogRepositoryImpl extends BaseDaoJpa<UserSessionLog, Integer> implements UserSessionLogRepository {

	public UserSessionLogRepositoryImpl() {
		super(UserSessionLog.class);
	}
}
