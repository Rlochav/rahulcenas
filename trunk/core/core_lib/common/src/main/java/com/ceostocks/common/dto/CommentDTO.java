package com.ceostocks.common.dto;

public class CommentDTO extends BaseDTO {

	private String postId;
	private String commentId;
	private String commentText;
	private String commentedByUserPic;

	public CommentDTO() {

	}

	/**
	 * @param commentId
	 * @param commentText
	 */
	public CommentDTO(String commentId, String commentText) {
		super();
		this.commentId = commentId;
		this.commentText = commentText;
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
	 * @return the commentId
	 */
	public String getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId
	 *            the commentId to set
	 */
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}

	/**
	 * @return the commentText
	 */
	public String getCommentText() {
		return commentText;
	}

	/**
	 * @param commentText
	 *            the commentText to set
	 */
	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	/**
	 * @return the commentedByUserPic
	 */
	public String getCommentedByUserPic() {
		return commentedByUserPic;
	}

	/**
	 * @param commentedByUserPic the commentedByUserPic to set
	 */
	public void setCommentedByUserPic(String commentedByUserPic) {
		this.commentedByUserPic = commentedByUserPic;
	}

}
