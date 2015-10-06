package com.ceostocks.application.chat;

import com.ceostocks.common.dto.UserChatDTO;
import com.ceostocks.common.util.DateUtil;
import com.ceostocks.model.chat.CeoStocksChat;
import com.ceostocks.model.user.UserMaster;

public class UserChatDTOMapper {

	public static UserChatDTO mapper(UserMaster userMaster) {
		UserChatDTO dto = new UserChatDTO();
		dto.setNickName(userMaster.getFirstName());
		return dto;
	}

	public static UserChatDTO mapper(CeoStocksChat ceoStocksChat) {
		UserChatDTO dto = new UserChatDTO();
		dto.setMsg(ceoStocksChat.getMessage());
		dto.setMsgtime(DateUtil.parseDateToString(ceoStocksChat.getMessageTime(), DateUtil.dateTimeFormat));
		dto.setMsgId(ceoStocksChat.getId().toString());
		dto.setUserFrom(ceoStocksChat.getUserFrom());
		dto.setUserTo(ceoStocksChat.getUserTo());
		return dto;
	}
}
