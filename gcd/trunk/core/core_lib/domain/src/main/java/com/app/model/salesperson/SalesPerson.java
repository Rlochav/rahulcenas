package com.app.model.salesperson;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "salesperson")
public class SalesPerson extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9015849171103649242L;

	@Id
	@Column(name = "SalesPersonId")
	private Integer salesPersonId;
	@Column(name = "SalesPersonFirstName")
	private String salesPersonFirstName;
	@Column(name = "SalesPersonLastName")
	private String salesPersonLastName;
	@Column(name = "Status")
	private Integer status;

	/**
	 * @return the salesPersonId
	 */
	public Integer getSalesPersonId() {
		return salesPersonId;
	}

	/**
	 * @param salesPersonId
	 *            the salesPersonId to set
	 */
	public void setSalesPersonId(Integer salesPersonId) {
		this.salesPersonId = salesPersonId;
	}

	/**
	 * @return the salesPersonFirstName
	 */
	public String getSalesPersonFirstName() {
		return salesPersonFirstName;
	}

	/**
	 * @param salesPersonFirstName
	 *            the salesPersonFirstName to set
	 */
	public void setSalesPersonFirstName(String salesPersonFirstName) {
		this.salesPersonFirstName = salesPersonFirstName;
	}

	/**
	 * @return the salesPersonLastName
	 */
	public String getSalesPersonLastName() {
		return salesPersonLastName;
	}

	/**
	 * @param salesPersonLastName
	 *            the salesPersonLastName to set
	 */
	public void setSalesPersonLastName(String salesPersonLastName) {
		this.salesPersonLastName = salesPersonLastName;
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

}
