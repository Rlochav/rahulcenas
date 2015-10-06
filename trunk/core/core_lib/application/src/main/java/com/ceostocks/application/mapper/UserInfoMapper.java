package com.ceostocks.application.mapper;

import static org.springframework.util.CollectionUtils.isEmpty;

import java.util.ArrayList;
import java.util.List;

import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.util.DateUtil;
import com.ceostocks.model.document.UserProfilePic;
import com.ceostocks.model.user.RoleRightLink;
import com.ceostocks.model.user.UserMaster;
import com.ceostocks.model.user.UserRoles;

public class UserInfoMapper {

	public static UserInfo mapper(UserMaster userMaster) {
		UserInfo userInfo = buildUserInfo(userMaster);
		return userInfo;
	}

	public static List<UserInfo> mapper(List<UserMaster> userMasters) {
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		if (!isEmpty(userMasters)) {
			userMasters.forEach(uMaster -> {
				userInfos.add(buildUserInfo(uMaster));
			});
		}
		return userInfos;
	}

	private static UserInfo buildUserInfo(UserMaster userMaster) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserIndex(userMaster.getUserIndex());
		userInfo.setFirstName(userMaster.getFirstName());
		userInfo.setLastName(userMaster.getLastName());
		userInfo.setEmailId(userMaster.getEmailId());
		userInfo.setDob(DateUtil.parseDateToString(userMaster.getDob(), DateUtil.dateFormat));
		userInfo.setCountry(userMaster.getCountry().toString());
		userInfo.setTimelineId(userMaster.getTimeLineId());
		userInfo.setUserSessionId(userMaster.getUserSession() != null ? userMaster.getUserSession().getSessionId().toString() : null);
		for (UserRoles userRoles : userMaster.getUserRoles()) {
			List<RoleRightLink> roleRightLinks = userRoles.getRoleMaster().getRoleRightLinks();
			for (RoleRightLink roleRightLink : roleRightLinks) {
				userInfo.putPermissionMap(roleRightLink.getRightMaster().getProcessId() + "_" + roleRightLink.getRightMaster().getFunctionCode(), "true");
			}
		}
		for (UserProfilePic pic : userMaster.getUserProfilePics()) {
			if (pic.getStatus() != 666)
				userInfo.setProfilePic(pic.getSavedAs());
		}
		return userInfo;
	}
}
