package com.ceostocks.model.cms;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.base.BaseDaoJpa;

@Repository
public class CmsUrlRepositoryImpl extends BaseDaoJpa<CmsUrl, Integer> implements CmsUrlRepository {

	public CmsUrlRepositoryImpl() {
		super(CmsUrl.class);
		// TODO Auto-generated constructor stub
	}

}
