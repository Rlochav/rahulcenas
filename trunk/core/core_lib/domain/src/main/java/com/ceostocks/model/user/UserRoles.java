package com.ceostocks.model.user;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;

@Entity
@Table(name = "USER_ROLES")
public class UserRoles extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7214084156444723019L;

	@EmbeddedId
	private UserRolesPK userRolesPK;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	@ManyToOne()
	@JoinColumn(name = "USER_INDEX", insertable = false, updatable = false)
	private UserMaster userMaster;

	@ManyToOne()
	@JoinColumn(name = "ROLE_ID", insertable = false, updatable = false)
	private RoleMaster roleMaster;

	/**
	 * @return the userRolesPK
	 */
	public UserRolesPK getUserRolesPK() {
		return userRolesPK;
	}

	/**
	 * @param userRolesPK
	 *            the userRolesPK to set
	 */
	public void setUserRolesPK(UserRolesPK userRolesPK) {
		this.userRolesPK = userRolesPK;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the userMaster
	 */
	public UserMaster getUserMaster() {
		return userMaster;
	}

	/**
	 * @param userMaster
	 *            the userMaster to set
	 */
	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

	/**
	 * @return the roleMaster
	 */
	public RoleMaster getRoleMaster() {
		return roleMaster;
	}

	/**
	 * @param roleMaster
	 *            the roleMaster to set
	 */
	public void setRoleMaster(RoleMaster roleMaster) {
		this.roleMaster = roleMaster;
	}

}
