package com.ceostocks.common.dto;

import java.util.ArrayList;
import java.util.List;

public class SubCategoryDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7754437936938874209L;
	private String categoryId;
	private String subCategoryId;
	private String categoryCode;
	private String subCategoryCode;
	private String subCategoryName;
	private List<SubCategoryDTO> categoryDTOs;

	public SubCategoryDTO() {

	}

	/**
	 * @param categoryId
	 * @param subCategoryId
	 * @param subCategoryCode
	 * @param subCategoryName
	 */
	public SubCategoryDTO(String categoryId, String subCategoryCode, String subCategoryName) {
		super();
		this.categoryId = categoryId;
		this.subCategoryCode = subCategoryCode;
		this.subCategoryName = subCategoryName;
	}

	/**
	 * @param categoryId
	 * @param subCategoryId
	 * @param categoryCode
	 * @param subCategoryCode
	 * @param subCategoryName
	 */
	public SubCategoryDTO(String categoryId, String subCategoryId, String categoryCode, String subCategoryCode, String subCategoryName) {
		super();
		this.categoryId = categoryId;
		this.subCategoryId = subCategoryId;
		this.categoryCode = categoryCode;
		this.subCategoryCode = subCategoryCode;
		this.subCategoryName = subCategoryName;
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
	 * @return the subCategoryCode
	 */
	public String getSubCategoryCode() {
		return subCategoryCode;
	}

	/**
	 * @param subCategoryCode
	 *            the subCategoryCode to set
	 */
	public void setSubCategoryCode(String subCategoryCode) {
		this.subCategoryCode = subCategoryCode;
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
	 * @return the categoryDTOs
	 */
	public List<SubCategoryDTO> getCategoryDTOs() {
		return categoryDTOs;
	}

	/**
	 * @return the categoryCode
	 */
	public String getCategoryCode() {
		return categoryCode;
	}

	/**
	 * @param categoryDTOs
	 *            the categoryDTOs to set
	 */
	public void addCategoryDTO(SubCategoryDTO subCategoryDTO) {
		if (this.categoryDTOs == null)
			this.categoryDTOs = new ArrayList<SubCategoryDTO>();
		this.categoryDTOs.add(subCategoryDTO);
	}

}
