package com.ceostocks.model.social.post;

import java.math.BigDecimal;
import java.util.List;

import com.ceostocks.common.base.BaseDao;

public interface UserFriendsRepository extends BaseDao<UserFriends, UserFriendsPK> {

	List<UserFriends> getUserFriends(BigDecimal userIndex, int start, int count);

	List<UserFriends> searchByCriteria(UserFriendsFilter userFriendsFeild, int start, int count);

	Long count(UserFriendsFilter userFriendsFeild);
}
