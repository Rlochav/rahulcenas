package com.app.model.blog;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "gcdpost")
public class GcdPost extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1620917494966469745L;

	@Id
	@Column(name = "PostId")
	private Integer postId;
	@Column(name = "Title")
	private String title;
	@Column(name = "Post")
	private String post;
	@Column(name = "MerchantId")
	private String merchantId;

	/**
	 * @return the postId
	 */
	public Integer getPostId() {
		return postId;
	}

	/**
	 * @param postId
	 *            the postId to set
	 */
	public void setPostId(Integer postId) {
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
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId
	 *            the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

}
