package com.ceostocks.application.social;

import java.util.List;

import com.ceostocks.common.dto.GroupDTO;
import com.ceostocks.common.dto.UserInfo;

public interface SocialApplication {

	GroupDTO manageGroup(UserInfo userInfo, GroupDTO groupDTO);

	GroupDTO joinGroup(UserInfo userInfo, GroupDTO groupDTO);

	GroupDTO leaveGroup(UserInfo userInfo, GroupDTO groupDTO);
	
	List<GroupDTO> getGroupsByUser(UserInfo userInfo);
}
