package com.ceostocks.services.social;

import java.util.List;

import com.ceostocks.common.dto.GroupDTO;
import com.ceostocks.common.dto.UserInfo;

public interface SocialService {

	GroupDTO manageGroup(UserInfo userInfo, GroupDTO groupDTO);

	GroupDTO joinGroup(UserInfo userInfo, GroupDTO groupDTO);

	GroupDTO leaveGroup(UserInfo userInfo, GroupDTO groupDTO);

	List<GroupDTO> getAllJoindGroups(UserInfo userInfo);
	
	GroupDTO getGroupDetailsById(UserInfo userInfo, GroupDTO groupDTO);
}
