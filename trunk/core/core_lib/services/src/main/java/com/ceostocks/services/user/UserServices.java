package com.ceostocks.services.user;

import java.math.BigDecimal;
import java.util.List;

import com.ceostocks.common.dto.DocumentDTO;
import com.ceostocks.common.dto.FriendDTO;
import com.ceostocks.common.dto.FriendRequestDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.model.social.post.UserFriends;
import com.ceostocks.model.user.UserMaster;

public interface UserServices {
	public UserMaster doLogin(String userId, String password, String ipAddress);

	public UserMaster doRegisterUser(UserMaster userMaster);

	public UserMaster getUserMasterByEmailId(String emailId);

	public UserMaster getUserMasterByActivationCode(String activationCode);

	public UserMaster saveUserProfilePic(UserMaster userMaster, DocumentDTO documentDTO);

	public UserMaster getUserMasterByIndex(BigDecimal userIndex);

	public List<UserMaster> searchFriends(FriendDTO friendDTO, UserInfo userInfo);

	public UserFriends sendFriendRequest(FriendRequestDTO friendRequestDTO);

	public UserFriends getUserFriend(BigDecimal requestUserIndex, BigDecimal friendUserIndex);

	public UserFriends confirmFriendRequest(FriendRequestDTO friendRequestDTO, UserInfo userInfo);

	public List<UserFriends> getUserFriends(UserInfo userInfo, FriendDTO friendDTO);

	public UserInfo getUserDetailsByTimelineId(String timelineId);
}
