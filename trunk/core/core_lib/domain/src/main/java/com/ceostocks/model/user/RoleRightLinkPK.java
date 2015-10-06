package com.ceostocks.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RoleRightLinkPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1933860113541114324L;

	@Column(name = "ROLE_ID")
	private Integer roleId;
	@Column(name = "RIGHT_ID")
	private Integer rightId;

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

	/**
	 * @return the rightId
	 */
	public Integer getRightId() {
		return rightId;
	}

	/**
	 * @param rightId
	 *            the rightId to set
	 */
	public void setRightId(Integer rightId) {
		this.rightId = rightId;
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
		result = prime * result + ((rightId == null) ? 0 : rightId.hashCode());
		result = prime * result + ((roleId == null) ? 0 : roleId.hashCode());
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
		RoleRightLinkPK other = (RoleRightLinkPK) obj;
		if (rightId == null) {
			if (other.rightId != null)
				return false;
		} else if (!rightId.equals(other.rightId))
			return false;
		if (roleId == null) {
			if (other.roleId != null)
				return false;
		} else if (!roleId.equals(other.roleId))
			return false;
		return true;
	}

}
