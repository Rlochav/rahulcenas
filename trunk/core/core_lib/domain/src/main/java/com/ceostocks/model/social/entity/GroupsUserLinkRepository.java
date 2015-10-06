package com.ceostocks.model.social.entity;

import java.math.BigDecimal;
import java.util.List;

import com.ceostocks.common.base.BaseDao;

public interface GroupsUserLinkRepository extends BaseDao<GroupsUserLink, GroupsUserLinkPK> {

	List<GroupsUserLink> getAllJoindGroups(BigDecimal userIndex);

}
