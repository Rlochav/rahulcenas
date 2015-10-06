package com.ceostocks.application.mapper;

import com.ceostocks.common.dto.CommentDTO;
import com.ceostocks.model.social.post.Comment;
import com.ceostocks.model.user.UserMaster;
import com.ceostocks.services.user.UserServices;

public class CommentDTOMapper {

	public static CommentDTO mapper(Comment comment, UserServices userServices) {
		CommentDTO commentDTO = new CommentDTO(comment.getCommentId().toString(), comment.getCommentText());
		UserMaster userMaster = userServices.getUserMasterByIndex(comment.getCreatedBy());
		commentDTO.setCreatedByText(userMaster.getFirstName() + " " + userMaster.getLastName());
		return commentDTO;
	}

}
