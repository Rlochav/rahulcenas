package com.ceostocks.model.cms;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.base.BaseDaoJpa;

@Repository
public class CmsPageRepositoryImpl extends BaseDaoJpa<CmsPage, Integer> implements CmsPageRepository {

	public CmsPageRepositoryImpl() {
		super(CmsPage.class);
		// TODO Auto-generated constructor stub
	}

}
