package com.ceostocks.model.social.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.Where;

import com.ceostocks.common.base.Base;

@Entity
@Table(name = "GROUPS")
@Where(clause = "status<>666")
@DynamicUpdate
public class Groups extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1758583287344997200L;

	@Id
	@GeneratedValue(generator = "sq_group_Id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_group_Id", sequenceName = "SQ_GROUP_ID", allocationSize = 1)
	@Column(name = "GROUP_ID")
	private BigDecimal groupId;
	@Column(name = "GROUP_NAME")
	private String groupName;
	@Column(name = "IS_FAVORITES")
	private Boolean isFavorites;
	@Column(name = "PRIVICY_TYPE")
	private Integer privicyType;
	@Column(name = "STATUS")
	private Integer status;

	public Groups() {
		// orm use
	}

	/**
	 * @param groupName
	 * @param isFavorites
	 * @param privicyType
	 */
	public Groups(String groupName, Boolean isFavorites, Integer privicyType) {

		this.groupName = groupName;
		this.isFavorites = isFavorites;
		this.privicyType = privicyType;
	}

	/**
	 * @return the groupId
	 */
	public BigDecimal getGroupId() {
		return groupId;
	}

	/**
	 * @return the groupName
	 */
	public String getGroupName() {
		return groupName;
	}

	/**
	 * @return the isFavorites
	 */
	public Boolean getIsFavorites() {
		return isFavorites;
	}

	/**
	 * @return the privicyType
	 */
	public Integer getPrivicyType() {
		return privicyType;
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

	public void modify(String groupName, Boolean isFavorites, Integer privicyType, Integer status) {
		this.groupName = groupName;
		this.isFavorites = isFavorites;
		this.privicyType = privicyType;
		this.status = status;
	}
}
