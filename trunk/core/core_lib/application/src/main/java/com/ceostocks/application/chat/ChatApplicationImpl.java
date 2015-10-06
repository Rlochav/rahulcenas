package com.ceostocks.application.chat;

import static com.ceostocks.application.chat.UserChatDTOMapper.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceostocks.common.annotation.CeoStocksReadOnlyTxn;
import com.ceostocks.common.annotation.CeoStocksReqNewTxn;
import com.ceostocks.common.dto.UserChatDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.model.chat.CeoStocksChat;
import com.ceostocks.model.user.UserMaster;
import com.ceostocks.services.chat.ChatService;

public class ChatApplicationImpl implements ChatApplication {

	@Autowired
	private ChatService chatService;

	@CeoStocksReadOnlyTxn
	@Override
	public List<UserChatDTO> getUserLists() {
		List<UserMaster> userMasters = chatService.getUserLists();
		List<UserChatDTO> userChatDTOs = new ArrayList<UserChatDTO>();
		if (userMasters != null) {
			userMasters.forEach(userMaster -> userChatDTOs.add(mapper(userMaster)));
		}
		return userChatDTOs;
	}

	@CeoStocksReqNewTxn
	@Override
	public String sendUserChat(UserInfo userInfo, String tmpto, String tmpmsg) {
		chatService.sendUserChat(userInfo, tmpto, tmpmsg);
		return null;
	}

	@CeoStocksReqNewTxn
	@Override
	public List<UserChatDTO> getUserChat(UserInfo userInfo) {
		List<CeoStocksChat> ceoStocksChats = chatService.getUserChat(userInfo);
		List<UserChatDTO> userChatDTOs = new ArrayList<UserChatDTO>();
		if (ceoStocksChats != null) {
			ceoStocksChats.forEach(ceoStocksChat -> userChatDTOs.add(mapper(ceoStocksChat)));
		}
		return userChatDTOs;
	}

}
