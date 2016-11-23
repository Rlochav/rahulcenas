package com.app.mvc.blog;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.post.dto.PostDTO;

public class PostMvcDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9217710671457981517L;
	private String postId;
	private String title;
	private String postTitle;
	private String postText;
	private String editor;
	private String post;
	private String postDate;
	private String jsonMessage;
	private MultipartFile attachedImage;
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
	 * @return the attachedImage
	 */
	public MultipartFile getAttachedImage() {
		return attachedImage;
	}

	/**
	 * @param attachedImage
	 *            the attachedImage to set
	 */
	public void setAttachedImage(MultipartFile attachedImage) {
		this.attachedImage = attachedImage;
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

}
