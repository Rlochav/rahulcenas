package com.app.base.dto;

import java.io.Serializable;
import java.util.Date;

public class BaseDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 952393441683991949L;
	private String createdBy;
	private String createdByText;
	private String modifiedBy;
	private String modifiedByText;
	private Date createDate;
	private String createDateText;
	private Date modifiedDate;
	private String modifiedDateText;
	private String status;
	private String statusText;
	private String readOnlyFlag = "false";
	private boolean errorFlag = false;

	private String operationFlag;
	private Integer count;
	private Integer fromRecords;
	private Integer toRecords;
	private String sortType;
	private String sortColumnName;
	private String rowVersion;

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
	 * @return the modifiedBy
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}

	/**
	 * @param modifiedBy
	 *            the modifiedBy to set
	 */
	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 *            the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * @return the modifiedDate
	 */
	public Date getModifiedDate() {
		return modifiedDate;
	}

	/**
	 * @param modifiedDate
	 *            the modifiedDate to set
	 */
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the errorFlag
	 */
	public boolean isErrorFlag() {
		return errorFlag;
	}

	/**
	 * @param errorFlag
	 *            the errorFlag to set
	 */
	public void setErrorFlag(boolean errorFlag) {
		this.errorFlag = errorFlag;
	}

	/**
	 * @return the operationFlag
	 */
	public String getOperationFlag() {
		return operationFlag;
	}

	/**
	 * @param operationFlag
	 *            the operationFlag to set
	 */
	public void setOperationFlag(String operationFlag) {
		this.operationFlag = operationFlag;
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
	 * @return the fromRecords
	 */
	public Integer getFromRecords() {
		return fromRecords;
	}

	/**
	 * @param fromRecords
	 *            the fromRecords to set
	 */
	public void setFromRecords(Integer fromRecords) {
		this.fromRecords = fromRecords;
	}

	/**
	 * @return the toRecords
	 */
	public Integer getToRecords() {
		return toRecords;
	}

	/**
	 * @param toRecords
	 *            the toRecords to set
	 */
	public void setToRecords(Integer toRecords) {
		this.toRecords = toRecords;
	}

	/**
	 * @return the sortType
	 */
	public String getSortType() {
		return sortType;
	}

	/**
	 * @param sortType
	 *            the sortType to set
	 */
	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	/**
	 * @return the sortColumnName
	 */
	public String getSortColumnName() {
		return sortColumnName;
	}

	/**
	 * @param sortColumnName
	 *            the sortColumnName to set
	 */
	public void setSortColumnName(String sortColumnName) {
		this.sortColumnName = sortColumnName;
	}

	/**
	 * @return the rowVersion
	 */
	public String getRowVersion() {
		return rowVersion;
	}

	/**
	 * @param rowVersion
	 *            the rowVersion to set
	 */
	public void setRowVersion(String rowVersion) {
		this.rowVersion = rowVersion;
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
	 * @return the modifiedByText
	 */
	public String getModifiedByText() {
		return modifiedByText;
	}

	/**
	 * @param modifiedByText
	 *            the modifiedByText to set
	 */
	public void setModifiedByText(String modifiedByText) {
		this.modifiedByText = modifiedByText;
	}

	/**
	 * @return the createDateText
	 */
	public String getCreateDateText() {
		return createDateText;
	}

	/**
	 * @param createDateText
	 *            the createDateText to set
	 */
	public void setCreateDateText(String createDateText) {
		this.createDateText = createDateText;
	}

	/**
	 * @return the modifiedDateText
	 */
	public String getModifiedDateText() {
		return modifiedDateText;
	}

	/**
	 * @param modifiedDateText
	 *            the modifiedDateText to set
	 */
	public void setModifiedDateText(String modifiedDateText) {
		this.modifiedDateText = modifiedDateText;
	}

	/**
	 * @return the statusText
	 */
	public String getStatusText() {
		return statusText;
	}

	/**
	 * @param statusText
	 *            the statusText to set
	 */
	public void setStatusText(String statusText) {
		this.statusText = statusText;
	}

	/**
	 * @return the readOnlyFlag
	 */
	public String getReadOnlyFlag() {
		return readOnlyFlag;
	}

	/**
	 * @param readOnlyFlag
	 *            the readOnlyFlag to set
	 */
	public void setReadOnlyFlag(String readOnlyFlag) {
		this.readOnlyFlag = readOnlyFlag;
	}
}
