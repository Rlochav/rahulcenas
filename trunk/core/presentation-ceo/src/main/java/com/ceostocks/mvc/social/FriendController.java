package com.ceostocks.mvc.social;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceostocks.application.user.UserApplication;
import com.ceostocks.common.dto.FriendDTO;
import com.ceostocks.common.dto.FriendRequestDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
@RequestMapping("/component/friends/")
public class FriendController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6382852433980017257L;

	@Autowired
	private UserApplication userApplication;

	@RequestMapping(value = CeoUrls.CEO_ROOT)
	public String display(ModelMap modelMap) {
		modelMap.addAttribute(USER_INFO, getSession().getAttribute(USER_INFO_SESSION));
		return "user/friends/userFriends";
	}

	@RequestMapping(value = CeoUrls.CEO_SEARCH_FRIEND)
	public String displaySearchFriend(ModelMap modelMap) {
		modelMap.addAttribute(USER_INFO, getSession().getAttribute(USER_INFO_SESSION));
		return "user/friends/searchFriends";
	}

	@RequestMapping(value = CeoUrls.CEO_JSON_SEARCH_FRIEND, method = RequestMethod.POST)
	@ResponseBody
	public List<FriendDTO> searchFriends(@RequestBody FriendDTO friendDTO) {
		UserInfo userInfo = (UserInfo) getSession().getAttribute(USER_INFO_SESSION);
		try {
			List<FriendDTO> userInfos = userApplication.searchFriends(friendDTO, userInfo);
			return userInfos;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = CeoUrls.CEO_JSON_SEND_FRIEND_REQUEST, method = RequestMethod.POST)
	@ResponseBody
	public FriendRequestDTO sendFriendRequest(@RequestBody FriendRequestDTO friendRequestDTO) {
		UserInfo userInfo = (UserInfo) getSession().getAttribute(USER_INFO_SESSION);
		try {
			friendRequestDTO.setFriendRequestFrom(userInfo.getUserIndex().toString());
			friendRequestDTO = userApplication.sendFriendRequest(friendRequestDTO);
			return friendRequestDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = CeoUrls.CEO_JSON_CONFIRM_FRIEND_REQUEST, method = RequestMethod.POST)
	@ResponseBody
	public FriendRequestDTO confirmFriendRequest(@RequestBody FriendRequestDTO friendRequestDTO) {
		UserInfo userInfo = (UserInfo) getSession().getAttribute(USER_INFO_SESSION);
		try {
			friendRequestDTO = userApplication.confirmFriendRequest(friendRequestDTO, userInfo);
			return friendRequestDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping(value = CeoUrls.CEO_JSON_GET_USER_FRIENDS, method = RequestMethod.POST)
	@ResponseBody
	public List<FriendDTO> getUserFriends(@RequestBody FriendDTO friendDTO) {
		UserInfo userInfo = (UserInfo) getSession().getAttribute(USER_INFO_SESSION);
		try {
			List<FriendDTO> friendDTOs = userApplication.getUserFriends(userInfo, friendDTO);
			return friendDTOs;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
