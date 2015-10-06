package com.ceostocks.application.chat;

import java.util.List;

import com.ceostocks.common.dto.UserChatDTO;
import com.ceostocks.common.dto.UserInfo;

public interface ChatApplication {

	public List<UserChatDTO> getUserLists();

	public String sendUserChat(UserInfo userInfo, String tmpto, String tmpmsg);

	public List<UserChatDTO> getUserChat(UserInfo userInfo);
}
