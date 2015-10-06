package com.ceostocks.mvc.social;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceostocks.application.social.SocialApplication;
import com.ceostocks.common.base.Base;
import com.ceostocks.common.dto.GroupDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
@RequestMapping("/component/group/")
public class GroupController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2279924656162341952L;

	@Autowired
	private SocialApplication socialApplication;

	@RequestMapping(value = CeoUrls.CEO_ROOT)
	public String display(ModelMap modelMap) {
		modelMap.addAttribute(USER_INFO, getSession().getAttribute(USER_INFO_SESSION));
		return "user/group/userGroup";
	}

	@RequestMapping(value = CeoUrls.CEO_SAVE_GROUP, method = RequestMethod.POST)
	@ResponseBody
	public GroupDTO createGroup(@RequestBody GroupDTO groupDTO) {
		UserInfo userInfo = (UserInfo) getSession().getAttribute(USER_INFO_SESSION);
		try {
			groupDTO.setStatus(Base.ACTIVE);
			groupDTO = socialApplication.manageGroup(userInfo, groupDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return groupDTO;
	}

	@RequestMapping(value = CeoUrls.CEO_DELETE_GROUP, method = RequestMethod.POST)
	@ResponseBody
	public GroupDTO deleteGroup(@RequestBody GroupDTO groupDTO) {
		UserInfo userInfo = (UserInfo) getSession().getAttribute(USER_INFO_SESSION);
		try {
			groupDTO.setStatus(Base.IN_ACTIVE);
			groupDTO = socialApplication.manageGroup(userInfo, groupDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return groupDTO;
	}

	@RequestMapping(value = CeoUrls.CEO_JOIN_GROUP, method = RequestMethod.POST)
	@ResponseBody
	public GroupDTO joinGroup(@RequestBody GroupDTO groupDTO) {
		UserInfo userInfo = (UserInfo) getSession().getAttribute(USER_INFO_SESSION);
		try {
			groupDTO = socialApplication.joinGroup(userInfo, groupDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return groupDTO;
	}

	@RequestMapping(value = CeoUrls.CEO_LEAVE_GROUP, method = RequestMethod.DELETE)
	@ResponseBody
	public GroupDTO leaveGroup(@RequestBody GroupDTO groupDTO) {
		UserInfo userInfo = (UserInfo) getSession().getAttribute(USER_INFO_SESSION);
		try {
			groupDTO = socialApplication.leaveGroup(userInfo, groupDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return groupDTO;
	}

	@RequestMapping(value = CeoUrls.CEO_GET_ALL_JOINED_GROUP, method = RequestMethod.GET)
	@ResponseBody
	public List<GroupDTO> getAllJoinedGroup() {
		UserInfo userInfo = (UserInfo) getSession().getAttribute(USER_INFO_SESSION);
		try {
			return socialApplication.getGroupsByUser(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
