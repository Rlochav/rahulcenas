package com.ceostocks.mvc.chat;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceostocks.application.chat.ChatApplication;
import com.ceostocks.common.dto.UserChatDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
@RequestMapping("/component/")
public class ChatController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3892080662271397608L;
	@Autowired
	private ChatApplication chatApplication;

	@RequestMapping(value = CeoUrls.CEO_GET_ONLINE_USER_LIST)
	@ResponseBody
	public List<UserChatDTO> getUserLists() {
		try {
			return chatApplication.getUserLists();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = CeoUrls.CEO_SEND_USER_CHAT)
	@ResponseBody
	public String sendUserChat(@RequestParam String to, @RequestParam String msg) {
		UserInfo userInfo = (UserInfo) getSession().getAttribute(USER_INFO_SESSION);
		String tmpto = getRequestParam("to");
		String tmpmsg = getRequestParam("msg");
		try {

			chatApplication.sendUserChat(userInfo, to, msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = CeoUrls.CEO_GET_USER_CHAT)
	@ResponseBody
	public List<UserChatDTO> getUserChat() {
		UserInfo userInfo = (UserInfo) getSession().getAttribute(USER_INFO_SESSION);
		try {
			return chatApplication.getUserChat(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
