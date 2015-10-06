package com.ceostocks.application.social;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceostocks.common.annotation.CeoStocksReadOnlyTxn;
import com.ceostocks.common.annotation.CeoStocksReqNewTxn;
import com.ceostocks.common.dto.GroupDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.services.social.SocialService;

public class SocialApplicationImpl implements SocialApplication {

	@Autowired
	private SocialService socialService;

	/**
	 * Create/Update/Delete groups
	 */
	@CeoStocksReqNewTxn
	@Override
	public GroupDTO manageGroup(UserInfo userInfo, GroupDTO groupDTO) {
		return socialService.manageGroup(userInfo, groupDTO);
	}

	@CeoStocksReqNewTxn
	@Override
	public GroupDTO joinGroup(UserInfo userInfo, GroupDTO groupDTO) {
		return socialService.joinGroup(userInfo, groupDTO);
	}

	@CeoStocksReqNewTxn
	@Override
	public GroupDTO leaveGroup(UserInfo userInfo, GroupDTO groupDTO) {
		return socialService.leaveGroup(userInfo, groupDTO);
	}

	@CeoStocksReadOnlyTxn
	@Override
	public List<GroupDTO> getGroupsByUser(UserInfo userInfo) {
		return socialService.getAllJoindGroups(userInfo);
	}
}
