package com.ceostocks.application.social;

import java.util.List;

import com.ceostocks.common.dto.CommentDTO;
import com.ceostocks.common.dto.PostDTO;

public interface PostApplication {

	public PostDTO saveUserPost(PostDTO postDTO);

	public List<PostDTO> getPostByTimelineId(PostDTO postDTO);

	public CommentDTO saveComment(CommentDTO commentDTO);
}
