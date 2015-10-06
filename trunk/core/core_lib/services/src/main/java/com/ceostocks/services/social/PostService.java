package com.ceostocks.services.social;

import java.util.List;

import com.ceostocks.common.dto.CommentDTO;
import com.ceostocks.common.dto.PostDTO;
import com.ceostocks.model.social.post.Comment;
import com.ceostocks.model.social.post.TimelinePost;

public interface PostService {

	public TimelinePost saveUserPost(PostDTO postDTO);

	public List<TimelinePost> getPostsByTimelineId(PostDTO postDTO);

	public Comment saveComment(CommentDTO commentDTO);
}
