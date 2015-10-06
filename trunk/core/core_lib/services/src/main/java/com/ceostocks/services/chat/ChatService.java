package com.ceostocks.services.chat;

import java.util.List;

import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.model.chat.CeoStocksChat;
import com.ceostocks.model.user.UserMaster;

public interface ChatService {

	public List<UserMaster> getUserLists();

	public String sendUserChat(UserInfo userInfo, String tmpto, String tmpmsg);

	public List<CeoStocksChat> getUserChat(UserInfo userInfo);
}
