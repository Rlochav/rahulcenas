package com.ceostocks.common.dto;

import java.io.Serializable;

public class BaseDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4122523433335393854L;

	private String createdBy;
	private String createdByText;
	private String createdDate;
	private String updatedBy;
	private String updatedByText;
	private String updatedDate;

	private Integer start;
	private Integer count;
	private Integer total;

	public BaseDTO() {

	}

	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy
	 *            the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the createdByText
	 */
	public String getCreatedByText() {
		return createdByText;
	}

	/**
	 * @param createdByText
	 *            the createdByText to set
	 */
	public void setCreatedByText(String createdByText) {
		this.createdByText = createdByText;
	}

	/**
	 * @return the createdDate
	 */
	public String getCreatedDate() {
		return createdDate;
	}

	/**
	 * @param createdDate
	 *            the createdDate to set
	 */
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	/**
	 * @return the updatedBy
	 */
	public String getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedByText
	 */
	public String getUpdatedByText() {
		return updatedByText;
	}

	/**
	 * @param updatedByText
	 *            the updatedByText to set
	 */
	public void setUpdatedByText(String updatedByText) {
		this.updatedByText = updatedByText;
	}

	/**
	 * @return the updatedDate
	 */
	public String getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 *            the updatedDate to set
	 */
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the start
	 */
	public Integer getStart() {
		return start;
	}

	/**
	 * @param start
	 *            the start to set
	 */
	public void setStart(Integer start) {
		this.start = start;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the total
	 */
	public Integer getTotal() {
		return total;
	}

	/**
	 * @param total
	 *            the total to set
	 */
	public void setTotal(Integer total) {
		this.total = total;
	}

}
