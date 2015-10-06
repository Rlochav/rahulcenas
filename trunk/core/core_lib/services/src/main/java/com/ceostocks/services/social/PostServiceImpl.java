package com.ceostocks.services.social;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceostocks.common.base.Base;
import com.ceostocks.common.dto.CommentDTO;
import com.ceostocks.common.dto.PostDTO;
import com.ceostocks.common.enums.Privacy;
import com.ceostocks.common.util.IntUtil;
import com.ceostocks.model.document.Document;
import com.ceostocks.model.document.DocumentRepository;
import com.ceostocks.model.social.post.Comment;
import com.ceostocks.model.social.post.CommentRepository;
import com.ceostocks.model.social.post.TimelinePost;
import com.ceostocks.model.social.post.TimelinePostRepository;

@Service
public class PostServiceImpl implements PostService {

	@Autowired
	private TimelinePostRepository timelinePostRepository;

	@Autowired
	private CommentRepository commentRepository;

	@Autowired
	private DocumentRepository documentRepository;

	@Override
	public TimelinePost saveUserPost(PostDTO postDTO) {
		TimelinePost timelinePost = new TimelinePost(postDTO.getPostText(), Privacy.getCodeByName(postDTO.getVisibility()), Base.ACTIVE,
				postDTO.getTimelineId());
		timelinePost.setCreatedBy(new BigDecimal(postDTO.getPostedBy()));
		timelinePost.setUpdatedBy(new BigDecimal(postDTO.getPostedBy()));
		addTimeLineImages(postDTO, timelinePost);
		timelinePostRepository.save(timelinePost);
		return timelinePost;
	}

	private void addTimeLineImages(PostDTO postDTO, TimelinePost timelinePost) {
		if (postDTO.getPostImageNames() != null) {
			for (String imageName : postDTO.getPostImageNames()) {
				Document document = documentRepository.getByFileSavedAs(imageName.replace("|", "."));
				document.setTimelinePost(timelinePost);
				timelinePost.addDocument(document);
			}
		}
	}

	@Override
	public List<TimelinePost> getPostsByTimelineId(PostDTO postDTO) {
		List<TimelinePost> timelinePosts = timelinePostRepository.getPostsByTimelineId(postDTO.getTimelineId(), postDTO.getStart(), postDTO.getTotal());
		return timelinePosts;
	}

	@Override
	public Comment saveComment(CommentDTO commentDTO) {
		Comment comment = new Comment(commentDTO.getCommentText(), timelinePostRepository.findById(new BigDecimal(commentDTO.getPostId())));
		comment.setCreatedBy(new BigDecimal(commentDTO.getCreatedBy()));
		comment.setUpdatedBy(new BigDecimal(commentDTO.getCreatedBy()));
		commentRepository.save(comment);
		return comment;
	}
}
