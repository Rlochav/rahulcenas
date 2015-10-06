package com.ceostocks.model.social.page;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.base.BaseDaoJpa;

@Repository
public class UserPageRepositoryImpl extends BaseDaoJpa<UserPage, BigDecimal> implements UserPageRepository {

	public UserPageRepositoryImpl() {
		super(UserPage.class);
	}
}
