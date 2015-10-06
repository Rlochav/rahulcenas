package com.ceostocks.mvc.social;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceostocks.application.social.PostApplication;
import com.ceostocks.common.dto.PostDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
@RequestMapping("/component/")
public class PostController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8934020770145112076L;
	@Autowired
	private PostApplication postApplication;

	@RequestMapping(value = CeoUrls.CEO_SAVE_STATUS, method = RequestMethod.POST)
	@ResponseBody
	public PostDTO saveUserPost(@RequestBody PostDTO postDTO) {
		try {
			UserInfo userInfo = (UserInfo) getSession().getAttribute(USER_INFO_SESSION);
			postDTO.setPostedBy(userInfo.getUserIndex().toString());
			postDTO = postApplication.saveUserPost(postDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return postDTO;
	}

	@RequestMapping(value = CeoUrls.CEO_GET_TIMELINE_STATUS, method = RequestMethod.POST)
	@ResponseBody
	public List<PostDTO> getPostByTimelineId(@RequestBody PostDTO postDTO) {
		try {
			return postApplication.getPostByTimelineId(postDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
