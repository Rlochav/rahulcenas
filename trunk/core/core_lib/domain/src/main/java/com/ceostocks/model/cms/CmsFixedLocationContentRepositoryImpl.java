package com.ceostocks.model.cms;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.base.BaseDaoJpa;

@Repository
public class CmsFixedLocationContentRepositoryImpl extends BaseDaoJpa<CmsFixedLocationContent, Integer> implements CmsFixedLocationContentRepository {

	public CmsFixedLocationContentRepositoryImpl() {
		super(CmsFixedLocationContent.class);
		// TODO Auto-generated constructor stub
	}

}
