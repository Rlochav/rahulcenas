package com.ceostocks.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserRolesPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3571273642468751602L;

	@Column(name = "USER_INDEX")
	private Integer userIndex;
	@Column(name = "ROLE_ID")
	private Integer roleId;

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
	 * @return the roleId
	 */
	public Integer getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId
	 *            the roleId to set
	 */
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
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
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
		result = prime * result
				+ ((userIndex == null) ? 0 : userIndex.hashCode());
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
		UserRolesPK other = (UserRolesPK) obj;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		if (userIndex == null) {
			if (other.userIndex != null)
				return false;
		} else if (!userIndex.equals(other.userIndex))
			return false;
		return true;
	}

}
