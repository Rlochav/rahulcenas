package com.ceostocks.application.user;

import java.util.List;

import com.ceostocks.common.dto.DocumentDTO;
import com.ceostocks.common.dto.FriendDTO;
import com.ceostocks.common.dto.FriendRequestDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.model.user.UserMaster;

public interface UserApplication {

	public UserInfo doLogin(String userId, String password, String ipAddress);

	public UserMaster doRegisterUser(UserMaster userMaster);

	public UserMaster getUserMasterByEmailId(String emailId);

	public UserInfo getUserMasterByActivationCode(String activationCode);

	public UserInfo updateUserMaster(UserInfo userInfo, DocumentDTO documentDTO);

	public UserInfo saveUserProfilePic(UserInfo userInfo, DocumentDTO documentDTO);

	public List<FriendDTO> searchFriends(FriendDTO friendDTO, UserInfo userInfo);

	public FriendRequestDTO sendFriendRequest(FriendRequestDTO friendRequestDTO);

	public FriendRequestDTO confirmFriendRequest(FriendRequestDTO friendRequestDTO, UserInfo userInfo);

	public List<FriendDTO> getUserFriends(UserInfo userInfo, FriendDTO friendDTO);

	public UserInfo getUserDetailsByTimelineId(String timelineId);
}
