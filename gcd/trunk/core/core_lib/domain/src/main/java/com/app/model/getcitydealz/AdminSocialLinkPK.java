package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import com.app.model.documentsmanagemant.DocumentLinkPK;

@Embeddable
public class AdminSocialLinkPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2919277056039712633L;

	@Column(name = "UserIndex")
	private Integer userIndex;
	@Column(name = "LinkId")
	private Integer linkId;

	public AdminSocialLinkPK(Integer userIndex, Integer linkId) {
		this.linkId = linkId;
		this.userIndex = userIndex;
	}

	public AdminSocialLinkPK() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashValue = 1;
		hashValue = hashValue * prime + ((userIndex == null) ? 0 : userIndex.hashCode());
		hashValue = hashValue * prime + ((linkId == null) ? 0 : linkId.hashCode());
		return hashValue;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof DocumentLinkPK))
			return false;
		AdminSocialLinkPK other = (AdminSocialLinkPK) obj;
		return other.getUserIndex() == this.getUserIndex() && other.getLinkId() == this.getLinkId();
	}

	/**
	 * @return the userIndex
	 */
	public Integer getUserIndex() {
		return userIndex;
	}

	/**
	 * @param userIndex
	 *            the userIndex to set
	 */
	public void setUserIndex(Integer userIndex) {
		this.userIndex = userIndex;
	}

	/**
	 * @return the linkId
	 */
	public Integer getLinkId() {
		return linkId;
	}

	/**
	 * @param linkId
	 *            the linkId to set
	 */
	public void setLinkId(Integer linkId) {
		this.linkId = linkId;
	}

}
