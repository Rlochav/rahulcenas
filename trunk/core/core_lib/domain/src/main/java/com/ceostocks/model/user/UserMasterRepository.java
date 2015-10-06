package com.ceostocks.model.user;

import java.math.BigDecimal;
import java.util.List;

import com.ceostocks.common.base.BaseDao;

public interface UserMasterRepository extends BaseDao<UserMaster, BigDecimal> {

	public UserMaster getByEmailOrUserId(String userId);

	public boolean isEmailUnique(String emailId);

	public List<UserMaster> findAll();

	List<UserMaster> searchByCriteria(UserMasterFilter userMasterFilter, int start, int count);
}
