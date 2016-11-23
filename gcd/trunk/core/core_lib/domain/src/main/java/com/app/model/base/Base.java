package com.app.model.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

/**
 * This is the base class of all the models of It includes common attribute like
 * update, create date and owner.
 * 
 * @author Piyush Pratap Singh
 * @version 1.0
 * 
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Base<I extends Serializable> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 687134408473610826L;

	/**
	 * Property which represents id.
	 */
	public static String P_ID = "id";

	@Column(name = "CRTBy", nullable = false)
	private Integer createdBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CRTDate", nullable = false)
	private Date createdDate;

	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

}
