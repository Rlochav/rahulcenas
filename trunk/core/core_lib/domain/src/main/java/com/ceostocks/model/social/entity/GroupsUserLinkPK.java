package com.ceostocks.model.social.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class GroupsUserLinkPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1148272572731350192L;

	@Column(name = "GROUP_ID")
	private BigDecimal groupId;
	@Column(name = "USER_INDEX")
	private BigDecimal userIndex;

	public GroupsUserLinkPK() {

	}

	/**
	 * @param groupId
	 * @param userIndex
	 */
	public GroupsUserLinkPK(BigDecimal groupId, BigDecimal userIndex) {
		super();
		this.groupId = groupId;
		this.userIndex = userIndex;
	}

	/**
	 * @return the groupId
	 */
	public BigDecimal getGroupId() {
		return groupId;
	}

	/**
	 * @param groupId
	 *            the groupId to set
	 */
	public void setGroupId(BigDecimal groupId) {
		this.groupId = groupId;
	}

	/**
	 * @return the userIndex
	 */
	public BigDecimal getUserIndex() {
		return userIndex;
	}

	/**
	 * @param userIndex
	 *            the userIndex to set
	 */
	public void setUserIndex(BigDecimal userIndex) {
		this.userIndex = userIndex;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((groupId == null) ? 0 : groupId.hashCode());
		result = prime * result + ((userIndex == null) ? 0 : userIndex.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GroupsUserLinkPK other = (GroupsUserLinkPK) obj;
		if (groupId == null) {
			if (other.groupId != null)
				return false;
		} else if (!groupId.equals(other.groupId))
			return false;
		if (userIndex == null) {
			if (other.userIndex != null)
				return false;
		} else if (!userIndex.equals(other.userIndex))
			return false;
		return true;
	}

}
