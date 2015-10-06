package com.ceostocks.model.lkupcode;

import java.util.List;

import com.ceostocks.common.base.BaseDao;

public interface LkupCodeRepository extends BaseDao<LkupCode, LkupCodePk>{

	public List<LkupCode> getAll();
}
