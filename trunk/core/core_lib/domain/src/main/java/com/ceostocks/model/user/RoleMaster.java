package com.ceostocks.model.user;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;

@Entity
@Table(name = "ROLE_MASTER")
public class RoleMaster extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3546084661491915774L;

	@Id
	@GeneratedValue(generator = "seq_role_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_role_id", sequenceName = "SQ_ROLE_ID", allocationSize = 1)
	@Column(name = "ROLE_ID", precision = 19)
	private BigDecimal roleId;
	@Column(name = "ROLE_NAME")
	private String roleName;
	@Column(name = "IS_ACTIVE")
	private String isActive;

	@OneToMany(mappedBy = "roleMaster", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<RoleRightLink> roleRightLinks = new ArrayList<RoleRightLink>();

	@OneToMany(mappedBy = "roleMaster", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<UserRoles> userRoles = new ArrayList<UserRoles>();

	/**
	 * @return the roleId
	 */
	public BigDecimal getRoleId() {
		return roleId;
	}

	/**
	 * @return the roleName
	 */
	public String getRoleName() {
		return roleName;
	}

	/**
	 * @param roleName
	 *            the roleName to set
	 */
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * @return the isActive
	 */
	public String getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the roleRightLinks
	 */
	public List<RoleRightLink> getRoleRightLinks() {
		return roleRightLinks;
	}

	/**
	 * @param roleRightLinks
	 *            the roleRightLinks to set
	 */
	public void setRoleRightLinks(List<RoleRightLink> roleRightLinks) {
		this.roleRightLinks = roleRightLinks;
	}

	/**
	 * @return the userRoles
	 */
	public List<UserRoles> getUserRoles() {
		return userRoles;
	}

	/**
	 * @param userRoles
	 *            the userRoles to set
	 */
	public void setUserRoles(List<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

}
