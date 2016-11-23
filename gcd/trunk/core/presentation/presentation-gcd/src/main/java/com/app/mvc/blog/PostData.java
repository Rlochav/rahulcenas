package com.app.mvc.blog;

import org.springframework.web.multipart.MultipartFile;

import com.app.post.dto.PostDTO;

public class PostData extends PostDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5489309992995934226L;

	private MultipartFile attachedImage;

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
}
