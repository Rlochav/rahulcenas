package com.ceostocks.application.mapper;

import static org.springframework.util.CollectionUtils.isEmpty;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.ceostocks.common.dto.FriendDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.enums.FriendRequestStatus;
import com.ceostocks.common.util.DateUtil;
import com.ceostocks.model.document.UserProfilePic;
import com.ceostocks.model.social.post.UserFriends;
import com.ceostocks.model.user.UserMaster;
import com.ceostocks.services.user.UserServices;

public class FriendDTOMapper {

	public static List<FriendDTO> mapper(List<UserMaster> userMasters, BigDecimal createdBy, UserServices userServices) {
		List<FriendDTO> friendDTOs = new ArrayList<FriendDTO>();
		if (!isEmpty(userMasters)) {
			userMasters.forEach(uMaster -> {
				friendDTOs.add(buildfriendDTO(uMaster, createdBy, userServices));
			});
		}
		return friendDTOs;
	}

	private static FriendDTO buildfriendDTO(UserMaster userMaster, BigDecimal createdBy, UserServices userServices) {
		FriendDTO friendDTO = new FriendDTO();
		friendDTO.setUserIndex(userMaster.getUserIndex().toString());
		friendDTO.setFirstName(userMaster.getFirstName());
		friendDTO.setLastName(userMaster.getLastName());
		friendDTO.setEmailId(userMaster.getEmailId());
		friendDTO.setDob(DateUtil.parseDateToString(userMaster.getDob(), DateUtil.dateFormat));
		friendDTO.setCountry(userMaster.getCountry().toString());
		friendDTO.setTimelineId(userMaster.getTimeLineId());
		friendDTO.setUserSessionId(userMaster.getUserSession() != null ? userMaster.getUserSession().getSessionId().toString() : null);
		UserFriends userFriends = userServices.getUserFriend(createdBy, userMaster.getUserIndex());
		if (userFriends != null && !userFriends.getIsRequestAccepted()) {
			friendDTO.setUserFriendStatus(FriendRequestStatus.FRIEND_REQUEST_SENT.getStatus());
		}
		if (userFriends == null) {
			userFriends = userServices.getUserFriend(userMaster.getUserIndex(), createdBy);
			if (userFriends != null && !userFriends.getIsRequestAccepted())
				friendDTO.setUserFriendStatus(FriendRequestStatus.CONFIRM_FRIEND_REQUEST.getStatus());
		}
		if (userFriends != null && userFriends.getIsRequestAccepted()) {
			friendDTO.setUserFriendStatus(FriendRequestStatus.FRIENDS.getStatus());
		}

		if (userFriends == null) {
			friendDTO.setUserFriendStatus(FriendRequestStatus.ADD_AS_FRIEND.getStatus());
		}

		for (UserProfilePic pic : userMaster.getUserProfilePics()) {
			if (pic.getStatus() != 666)
				friendDTO.setProfilePic(pic.getSavedAs());
		}
		return friendDTO;
	}

	public static List<FriendDTO> mapperForFriends(List<UserFriends> userFriends, UserServices userServices, UserInfo userInfo) {
		List<FriendDTO> friendDTOs = new ArrayList<FriendDTO>();
		userFriends.forEach(friend -> {
			if (!userInfo.getUserIndex().equals(friend.getUserFriendsPK().getAccepterId()))
				friendDTOs.add(buildfriendDTO(userServices.getUserMasterByIndex(friend.getUserFriendsPK().getAccepterId()), userInfo.getUserIndex(),
						userServices));
			else
				friendDTOs.add(buildfriendDTO(userServices.getUserMasterByIndex(friend.getUserFriendsPK().getRequesterId()), userInfo.getUserIndex(),
						userServices));
		});
		return friendDTOs;
	}
}
