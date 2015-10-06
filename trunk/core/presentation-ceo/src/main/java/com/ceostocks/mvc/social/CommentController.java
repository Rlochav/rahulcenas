package com.ceostocks.mvc.social;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceostocks.application.social.PostApplication;
import com.ceostocks.common.dto.CommentDTO;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
@RequestMapping("/component/")
public class CommentController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8287724398972485017L;

	@Autowired
	private PostApplication postApplication;

	@RequestMapping(value = CeoUrls.CEO_SAVE_POST_COMMENT, method = RequestMethod.POST)
	@ResponseBody
	public CommentDTO saveComment(@RequestBody CommentDTO commentDTO) {
		try {
			UserInfo userInfo = (UserInfo) getSession().getAttribute(USER_INFO_SESSION);
			commentDTO.setCreatedBy(userInfo.getUserIndex().toString());
			commentDTO = postApplication.saveComment(commentDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return commentDTO;
	}
}
