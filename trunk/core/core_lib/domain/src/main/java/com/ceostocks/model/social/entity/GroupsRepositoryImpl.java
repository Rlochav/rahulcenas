package com.ceostocks.model.social.entity;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.ceostocks.common.base.BaseDaoJpa;

@Repository
public class GroupsRepositoryImpl extends BaseDaoJpa<Groups, BigDecimal> implements GroupsRepository {

	public GroupsRepositoryImpl() {
		super(Groups.class);
	}
}
