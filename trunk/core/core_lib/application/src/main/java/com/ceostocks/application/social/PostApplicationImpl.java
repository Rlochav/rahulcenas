package com.ceostocks.application.social;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceostocks.application.mapper.CommentDTOMapper;
import com.ceostocks.application.mapper.PostDTOMapper;
import com.ceostocks.common.annotation.CeoStocksReadOnlyTxn;
import com.ceostocks.common.annotation.CeoStocksReqNewTxn;
import com.ceostocks.common.dto.CommentDTO;
import com.ceostocks.common.dto.PostDTO;
import com.ceostocks.model.social.post.Comment;
import com.ceostocks.model.social.post.TimelinePost;
import com.ceostocks.services.social.PostService;
import com.ceostocks.services.user.UserServices;

public class PostApplicationImpl implements PostApplication {

	@Autowired
	private PostService postService;

	@Autowired
	private UserServices userServices;

	@CeoStocksReqNewTxn
	@Override
	public PostDTO saveUserPost(PostDTO postDTO) {
		TimelinePost timelinePost = postService.saveUserPost(postDTO);
		return PostDTOMapper.mapper(timelinePost, userServices);
	}

	@CeoStocksReadOnlyTxn
	@Override
	public List<PostDTO> getPostByTimelineId(PostDTO postDTO) {
		List<TimelinePost> timelinePosts = postService.getPostsByTimelineId(postDTO);
		return PostDTOMapper.mapper(timelinePosts, userServices);
	}

	@CeoStocksReqNewTxn
	@Override
	public CommentDTO saveComment(CommentDTO commentDTO) {
		Comment comment = postService.saveComment(commentDTO);
		return CommentDTOMapper.mapper(comment,userServices);
	}

}
