package com.ceostocks.services.chat;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.model.chat.CeoStocksChat;
import com.ceostocks.model.chat.CeoStocksChatRepository;
import com.ceostocks.model.user.UserMaster;
import com.ceostocks.model.user.UserMasterRepository;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private UserMasterRepository userMasterRepository;

	@Autowired
	private CeoStocksChatRepository ceoStocksChatRepository;

	@Override
	public List<UserMaster> getUserLists() {
		return userMasterRepository.findAll();
	}

	@Override
	public String sendUserChat(UserInfo userInfo, String tmpto, String tmpmsg) {
		CeoStocksChat ceoStocksChat = new CeoStocksChat(userInfo.getFirstName(), tmpto, tmpmsg, "sent", new Date());
		ceoStocksChatRepository.save(ceoStocksChat);
		return null;
	}

	@Override
	public List<CeoStocksChat> getUserChat(UserInfo userInfo) {
		List<CeoStocksChat> ceoStocksChats = ceoStocksChatRepository.getUserChat(userInfo.getFirstName());
		if (ceoStocksChats != null) {
			ceoStocksChats.forEach(ceoStocksChat -> {
				ceoStocksChat.setMessageState("delivered");
				ceoStocksChatRepository.update(ceoStocksChat);
			});
		}
		return ceoStocksChats;
	}

}
