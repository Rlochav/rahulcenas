package com.ceostocks.model.social.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.TypedQuery;

import com.ceostocks.common.base.BaseDaoJpa;

public class GroupsUserLinkRepositoryImpl extends BaseDaoJpa<GroupsUserLink, GroupsUserLinkPK> implements GroupsUserLinkRepository {

	public GroupsUserLinkRepositoryImpl() {
		super(GroupsUserLink.class);
	}

	@Override
	public List<GroupsUserLink> getAllJoindGroups(BigDecimal userIndex) {
		TypedQuery<GroupsUserLink> typedQuery = getEntityManager().createNamedQuery("GroupsUserLink.findAllJoindGroups()", GroupsUserLink.class);
		typedQuery.setParameter("userIndex", userIndex);
		return typedQuery.getResultList();
	}
}
