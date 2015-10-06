package com.ceostocks.model.user;

import java.math.BigDecimal;

import com.ceostocks.common.base.BaseDao;

public interface UserSessionRepository extends BaseDao<UserSession, Integer> {

	public UserSession getUserSessionByUserIndex(BigDecimal userIndex);
}
