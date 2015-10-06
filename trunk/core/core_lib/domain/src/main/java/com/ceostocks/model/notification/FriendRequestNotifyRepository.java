package com.ceostocks.model.notification;

import java.math.BigDecimal;
import java.util.List;

import com.ceostocks.common.base.BaseDao;
import com.ceostocks.model.social.post.UserFriendsFilter;

public interface FriendRequestNotifyRepository extends BaseDao<FriendRequestNotify, BigDecimal> {

	List<FriendRequestNotify> searchByCriteria(UserFriendsFilter userFriendsFeild, int start, int count);

	Long count(UserFriendsFilter userFriendsFilter);

}
