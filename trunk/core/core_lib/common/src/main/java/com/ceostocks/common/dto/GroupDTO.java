package com.ceostocks.common.dto;

import java.math.BigDecimal;
import java.util.Set;

public class GroupDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2685389009908169931L;
	private BigDecimal groupId;
	private String groupName;
	private Boolean isFavorites;
	private String privicyType;
	private Integer status;
	private BigDecimal groupOwner;
	private String groupOwnerText;
	private Set<UserInfo> groupAdmins;
	private Set<UserInfo> groupMembers;

	public GroupDTO() {

	}

	/**
	 * @param groupId
	 * @param groupName
	 * @param isFavorites
	 * @param privicyType
	 * @param groupOwner
	 */
	public GroupDTO(BigDecimal groupId, String groupName, Boolean isFavorites, String privicyType, String groupOwnerText) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.isFavorites = isFavorites;
		this.privicyType = privicyType;
		this.groupOwnerText = groupOwnerText;
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
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @param groupName
	 *            the groupName to set
	 */
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	/**
	 * @return the isFavorites
	 */
	public Boolean getIsFavorites() {
		return isFavorites;
	}

	/**
	 * @param isFavorites
	 *            the isFavorites to set
	 */
	public void setIsFavorites(Boolean isFavorites) {
		this.isFavorites = isFavorites;
	}

	/**
	 * @return the privicyType
	 */
	public String getPrivicyType() {
		return privicyType;
	}

	/**
	 * @param privicyType
	 *            the privicyType to set
	 */
	public void setPrivicyType(String privicyType) {
		this.privicyType = privicyType;
	}

	/**
	 * @return the groupOwner
	 */
	public BigDecimal getGroupOwner() {
		return groupOwner;
	}

	/**
	 * @param groupOwner
	 *            the groupOwner to set
	 */
	public void setGroupOwner(BigDecimal groupOwner) {
		this.groupOwner = groupOwner;
	}

	/**
	 * @return the groupAdmins
	 */
	public Set<UserInfo> getGroupAdmins() {
		return groupAdmins;
	}

	/**
	 * @param groupAdmins
	 *            the groupAdmins to set
	 */
	public void setGroupAdmins(Set<UserInfo> groupAdmins) {
		this.groupAdmins = groupAdmins;
	}

	/**
	 * @return the groupMembers
	 */
	public Set<UserInfo> getGroupMembers() {
		return groupMembers;
	}

	/**
	 * @param groupMembers
	 *            the groupMembers to set
	 */
	public void setGroupMembers(Set<UserInfo> groupMembers) {
		this.groupMembers = groupMembers;
	}

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the groupOwnerText
	 */
	public String getGroupOwnerText() {
		return groupOwnerText;
	}

	/**
	 * @param groupOwnerText the groupOwnerText to set
	 */
	public void setGroupOwnerText(String groupOwnerText) {
		this.groupOwnerText = groupOwnerText;
	}

}
