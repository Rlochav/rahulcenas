package com.ceostocks.common.base;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class Base implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5731070416436192167L;

	public static final Integer ACTIVE = 999;
	public static final Integer IN_ACTIVE = 666;

	@Column(name = "CREATED_BY")
	private BigDecimal createdBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CREATED_DATE", nullable = true)
	private Date createdDate;
	@Column(name = "UPDATED_BY")
	private BigDecimal updatedBy;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDATED_DATE", nullable = true)
	private Date updatedDate;

	/**
	 * @return the createdBy
	 */
	public BigDecimal getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(BigDecimal createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = (createdDate == null ? new Date() : createdDate);
	}

	/**
	 * @return the updatedBy
	 */
	public BigDecimal getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(BigDecimal updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 *            the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = (updatedDate == null ? new Date() : updatedDate);
	}

	@PrePersist
	public void prePersistCreationDate() {
		setCreatedDate(new Date());
		setUpdatedDate(new Date());
	}

	@PreUpdate
	public void preUpdateUpdatedDate() {
		setUpdatedDate(new Date());
	}
}
