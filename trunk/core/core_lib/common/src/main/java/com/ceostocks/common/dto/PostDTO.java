package com.ceostocks.common.dto;

import java.util.ArrayList;
import java.util.List;

import com.ceostocks.common.enums.Privacy;

public class PostDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -485553944332658436L;

	private String postId;
	private String postText;
	private String[] postImageNames;
	private String postedBy;
	private String postedByUserPic;
	private String visibility;
	private String status;
	private String timelineId;
	private String postCreationDate;
	private String postUpdatedDate;
	private String isPostedByOnWall;
	private List<CommentDTO> commentDTOs = new ArrayList<CommentDTO>();

	public PostDTO() {

	}

	/**
	 * @param postId
	 * @param postText
	 * @param postImageId
	 * @param postedBy
	 * @param postCreationDate
	 * @param postUpdatedDate
	 * @param visibility
	 * @param status
	 * @param timelineId
	 */
	public PostDTO(String postId, String postText, String[] postImageNames, String postedBy, String postCreationDate, String postUpdatedDate,
			String visibility, String status, String timelineId, String isPostedByOnWall) {
		super();
		this.postId = postId;
		this.postText = postText;
		this.postImageNames = postImageNames;
		this.postedBy = postedBy;
		this.postCreationDate = postCreationDate;
		this.postUpdatedDate = postUpdatedDate;
		this.visibility = visibility;
		this.status = status;
		this.timelineId = timelineId;
		this.isPostedByOnWall = isPostedByOnWall;
	}

	/**
	 * @return the postId
	 */
	public String getPostId() {
		return postId;
	}

	/**
	 * @param postId
	 *            the postId to set
	 */
	public void setPostId(String postId) {
		this.postId = postId;
	}

	/**
	 * @return the postText
	 */
	public String getPostText() {
		return postText;
	}

	/**
	 * @param postText
	 *            the postText to set
	 */
	public void setPostText(String postText) {
		this.postText = postText;
	}

	/**
	 * @return the postImageNames
	 */
	public String[] getPostImageNames() {
		return postImageNames;
	}

	/**
	 * @param postImageNames
	 *            the postImageNames to set
	 */
	public void setPostImageNames(String[] postImageNames) {
		this.postImageNames = postImageNames;
	}

	/**
	 * @return the postedBy
	 */
	public String getPostedBy() {
		return postedBy;
	}

	/**
	 * @param postedBy
	 *            the postedBy to set
	 */
	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	/**
	 * @return the postCreationDate
	 */
	public String getPostCreationDate() {
		return postCreationDate;
	}

	/**
	 * @param postCreationDate
	 *            the postCreationDate to set
	 */
	public void setPostCreationDate(String postCreationDate) {
		this.postCreationDate = postCreationDate;
	}

	/**
	 * @return the postUpdatedDate
	 */
	public String getPostUpdatedDate() {
		return postUpdatedDate;
	}

	/**
	 * @param postUpdatedDate
	 *            the postUpdatedDate to set
	 */
	public void setPostUpdatedDate(String postUpdatedDate) {
		this.postUpdatedDate = postUpdatedDate;
	}

	/**
	 * @return the visibility
	 */
	public String getVisibility() {
		return visibility;
	}

	/**
	 * @param visibility
	 *            the visibility to set
	 */
	public void setVisibility(String visibility) {
		this.visibility = visibility;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the timelineId
	 */
	public String getTimelineId() {
		return timelineId;
	}

	/**
	 * @param timelineId
	 *            the timelineId to set
	 */
	public void setTimelineId(String timelineId) {
		this.timelineId = timelineId;
	}

	/**
	 * @return the commentDTOs
	 */
	public List<CommentDTO> getCommentDTOs() {
		return commentDTOs;
	}

	public boolean addCommentDTO(CommentDTO commentDTO) {
		return commentDTOs.add(commentDTO);
	}

	/**
	 * @param commentDTOs
	 *            the commentDTOs to set
	 */
	public void setCommentDTOs(List<CommentDTO> commentDTOs) {
		this.commentDTOs = commentDTOs;
	}

	/**
	 * @return the isPostedByOnWall
	 */
	public String getIsPostedByOnWall() {
		return isPostedByOnWall;
	}

	/**
	 * @param isPostedByOnWall
	 *            the isPostedByOnWall to set
	 */
	public void setIsPostedByOnWall(String isPostedByOnWall) {
		this.isPostedByOnWall = isPostedByOnWall;
	}

	/**
	 * @return the postedByUserPic
	 */
	public String getPostedByUserPic() {
		return postedByUserPic;
	}

	/**
	 * @param postedByUserPic the postedByUserPic to set
	 */
	public void setPostedByUserPic(String postedByUserPic) {
		this.postedByUserPic = postedByUserPic;
	}

}
