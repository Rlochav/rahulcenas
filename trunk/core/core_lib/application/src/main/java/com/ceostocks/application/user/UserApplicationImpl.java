package com.ceostocks.application.user;

import static com.ceostocks.application.mapper.UserInfoMapper.mapper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import com.ceostocks.application.mapper.FriendDTOMapper;
import com.ceostocks.application.mapper.FriendRequestDTOMapper;
import com.ceostocks.common.annotation.CeoStocksDefaultTxn;
import com.ceostocks.common.annotation.CeoStocksReadOnlyTxn;
import com.ceostocks.common.annotation.CeoStocksReqNewTxn;
import com.ceostocks.common.dto.DocumentDTO;
import com.ceostocks.common.dto.FriendDTO;
import com.ceostocks.common.dto.FriendRequestDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.model.social.post.UserFriends;
import com.ceostocks.model.user.UserMaster;
import com.ceostocks.services.user.UserServices;

public class UserApplicationImpl implements UserApplication {

	@Autowired
	private UserServices userServices;

	@Autowired
	private MessageSource msgSource;

	@CeoStocksReqNewTxn
	@Override
	public UserMaster doRegisterUser(UserMaster userMaster) {
		return userServices.doRegisterUser(userMaster);
	}

	@CeoStocksDefaultTxn
	@Override
	public UserInfo doLogin(String userId, String password, String ipAddress) {
		UserInfo userInfo = mapper(userServices.doLogin(userId, password, ipAddress));
		return userInfo;
	}

	@CeoStocksReadOnlyTxn
	@Override
	public UserMaster getUserMasterByEmailId(String emailId) {
		return userServices.getUserMasterByEmailId(emailId);
	}

	@CeoStocksReqNewTxn
	@Override
	public UserInfo getUserMasterByActivationCode(String activationCode) {
		UserMaster userMaster = userServices.getUserMasterByActivationCode(activationCode);
		UserInfo userInfo = null;
		if (userMaster != null) {
			userInfo = mapper(userMaster);
			userMaster.setIsActive(true);
			doRegisterUser(userMaster);
		}
		return userInfo;
	}

	@CeoStocksReqNewTxn
	@Override
	public UserInfo updateUserMaster(UserInfo userInfo, DocumentDTO documentDTO) {
		UserMaster userMaster = userServices.getUserMasterByEmailId(userInfo.getEmailId());
		userMaster = userServices.doRegisterUser(userMaster);
		userInfo = mapper(userMaster);
		return userInfo;
	}

	@CeoStocksReqNewTxn
	@Override
	public UserInfo saveUserProfilePic(UserInfo userInfo, DocumentDTO documentDTO) {
		UserMaster userMaster = userServices.getUserMasterByEmailId(userInfo.getEmailId());
		userServices.saveUserProfilePic(userMaster, documentDTO);
		userInfo = mapper(userMaster);
		return userInfo;
	}

	@CeoStocksReadOnlyTxn
	@Override
	public List<FriendDTO> searchFriends(FriendDTO friendDTO, UserInfo userInfo) {
		List<UserMaster> userMasters = userServices.searchFriends(friendDTO, userInfo);
		return FriendDTOMapper.mapper(userMasters, userInfo.getUserIndex(), userServices);
	}

	@CeoStocksReqNewTxn
	@Override
	public FriendRequestDTO sendFriendRequest(FriendRequestDTO friendRequestDTO) {
		UserFriends userFriends = userServices.sendFriendRequest(friendRequestDTO);
		return FriendRequestDTOMapper.mapper(userFriends);
	}

	@CeoStocksReqNewTxn
	@Override
	public FriendRequestDTO confirmFriendRequest(FriendRequestDTO friendRequestDTO, UserInfo userInfo) {
		UserFriends userFriends = userServices.confirmFriendRequest(friendRequestDTO, userInfo);
		return FriendRequestDTOMapper.mapper(userFriends);
	}

	@CeoStocksReadOnlyTxn
	@Override
	public List<FriendDTO> getUserFriends(UserInfo userInfo, FriendDTO friendDTO) {
		List<UserFriends> userFriends = userServices.getUserFriends(userInfo, friendDTO);
		return FriendDTOMapper.mapperForFriends(userFriends, userServices, userInfo);
	}

	@CeoStocksReadOnlyTxn
	@Override
	public UserInfo getUserDetailsByTimelineId(String timelineId) {
		UserInfo userInfo = userServices.getUserDetailsByTimelineId(timelineId);
		return userInfo;
	}
}
