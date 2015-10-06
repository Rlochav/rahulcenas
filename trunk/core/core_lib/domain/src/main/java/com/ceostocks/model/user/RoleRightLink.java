package com.ceostocks.model.user;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;

@Entity
@Table(name = "ROLE_RIGHT_LINK")
public class RoleRightLink extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7357819255128819630L;

	@EmbeddedId
	private RoleRightLinkPK roleRightLinkPK;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "ROLE_ID", insertable = false, updatable = false)
	private RoleMaster roleMaster;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "RIGHT_ID", insertable = false, updatable = false)
	private RightMaster rightMaster;

	public RoleRightLinkPK getRoleRightLinkPK() {
		return roleRightLinkPK;
	}

	public void setRoleRightLinkPK(RoleRightLinkPK roleRightLinkPK) {
		this.roleRightLinkPK = roleRightLinkPK;
	}

	public RoleMaster getRoleMaster() {
		return roleMaster;
	}

	public void setRoleMaster(RoleMaster roleMaster) {
		this.roleMaster = roleMaster;
	}

	public RightMaster getRightMaster() {
		return rightMaster;
	}

	public void setRightMaster(RightMaster rightMaster) {
		this.rightMaster = rightMaster;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
