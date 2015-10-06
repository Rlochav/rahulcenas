package com.ceostocks.common.dto;

import java.util.ArrayList;
import java.util.List;

public class CategoryDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6662072742401791195L;
	private String categoryId;
	private String categoryCode;
	private String categoryName;
	private List<CategoryDTO> categoryDTOs;

	public CategoryDTO() {

	}

	public CategoryDTO(String categoryCode, String categoryName) {
		super();
		this.categoryCode = categoryCode;
		this.categoryName = categoryName;
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
	 * @return the categoryCode
	 */
	public String getCategoryCode() {
		return categoryCode;
	}

	/**
	 * @param categoryCode
	 *            the categoryCode to set
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName
	 *            the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the categoryDTOs
	 */
	public List<CategoryDTO> getCategoryDTOs() {
		return categoryDTOs;
	}

	/**
	 * @param categoryDTOs
	 *            the categoryDTOs to set
	 */
	public void addCategoryDTO(CategoryDTO categoryDTO) {
		if (this.categoryDTOs == null)
			this.categoryDTOs = new ArrayList<CategoryDTO>();
		this.categoryDTOs.add(categoryDTO);
	}

}
