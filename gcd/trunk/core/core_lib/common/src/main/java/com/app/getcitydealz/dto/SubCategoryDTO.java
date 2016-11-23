package com.app.getcitydealz.dto;

import java.io.Serializable;
import java.util.List;

public class SubCategoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8241175639707822443L;

	private String categoryId;
	private String subCategoryId;
	private String subCategoryName;
	private String counts;
	private List<SubCategoryDTO> subCategoryDTOs;
	private String jsonMessage;

	/**
	 * @return the subCategoryId
	 */
	public String getSubCategoryId() {
		return subCategoryId;
	}

	/**
	 * @param subCategoryId
	 *            the subCategoryId to set
	 */
	public void setSubCategoryId(String subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	/**
	 * @return the subCategoryName
	 */
	public String getSubCategoryName() {
		return subCategoryName;
	}

	/**
	 * @param subCategoryName
	 *            the subCategoryName to set
	 */
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	/**
	 * @return the subCategoryDTOs
	 */
	public List<SubCategoryDTO> getSubCategoryDTOs() {
		return subCategoryDTOs;
	}

	/**
	 * @param subCategoryDTOs
	 *            the subCategoryDTOs to set
	 */
	public void setSubCategoryDTOs(List<SubCategoryDTO> subCategoryDTOs) {
		this.subCategoryDTOs = subCategoryDTOs;
	}

	/**
	 * @return the jsonMessage
	 */
	public String getJsonMessage() {
		return jsonMessage;
	}

	/**
	 * @param jsonMessage
	 *            the jsonMessage to set
	 */
	public void setJsonMessage(String jsonMessage) {
		this.jsonMessage = jsonMessage;
	}

	/**
	 * @return the categoryId
	 */
	public String getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the counts
	 */
	public String getCounts() {
		return counts;
	}

	/**
	 * @param counts
	 *            the counts to set
	 */
	public void setCounts(String counts) {
		this.counts = counts;
	}

}
