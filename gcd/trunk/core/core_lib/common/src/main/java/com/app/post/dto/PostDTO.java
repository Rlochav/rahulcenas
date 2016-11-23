package com.app.post.dto;

import java.io.Serializable;
import java.util.List;

public class PostDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6665287864253572379L;

	private String postId;
	private String title;
	private String postTitle;
	private String postText;
	private String editor;
	private String post;
	private String postDate;
	private String attachedFileName;
	private String jsonMessage;
	private List<PostDTO> postDTOs;

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
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the postTitle
	 */
	public String getPostTitle() {
		return postTitle;
	}

	/**
	 * @param postTitle
	 *            the postTitle to set
	 */
	public void setPostTitle(String postTitle) {
		this.postTitle = postTitle;
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
	 * @return the post
	 */
	public String getPost() {
		return post;
	}

	/**
	 * @param post
	 *            the post to set
	 */
	public void setPost(String post) {
		this.post = post;
	}

	/**
	 * @return the postDate
	 */
	public String getPostDate() {
		return postDate;
	}

	/**
	 * @param postDate
	 *            the postDate to set
	 */
	public void setPostDate(String postDate) {
		this.postDate = postDate;
	}

	/**
	 * @return the jsonMessage
	 */
	public String getJsonMessage() {
		return jsonMessage;
	}

	/**
	 * @param jsonMessage
	 *            the jsonMessage to set
	 */
	public void setJsonMessage(String jsonMessage) {
		this.jsonMessage = jsonMessage;
	}

	/**
	 * @return the postDTOs
	 */
	public List<PostDTO> getPostDTOs() {
		return postDTOs;
	}

	/**
	 * @param postDTOs
	 *            the postDTOs to set
	 */
	public void setPostDTOs(List<PostDTO> postDTOs) {
		this.postDTOs = postDTOs;
	}

	/**
	 * @return the editor
	 */
	public String getEditor() {
		return editor;
	}

	/**
	 * @param editor
	 *            the editor to set
	 */
	public void setEditor(String editor) {
		this.editor = editor;
	}

	/**
	 * @return the attachedFileName
	 */
	public String getAttachedFileName() {
		return attachedFileName;
	}

	/**
	 * @param attachedFileName the attachedFileName to set
	 */
	public void setAttachedFileName(String attachedFileName) {
		this.attachedFileName = attachedFileName;
	}

}
