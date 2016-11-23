package com.app.getcitydealz.dto;

import java.io.Serializable;
import java.util.List;

public class CategoryDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5912469185467098264L;
	private String categoryId;
	private String categoryName;
	private String counts;
	private List<SubCategoryDTO> subCategoryDTOs;
	private List<CategoryDTO> categoryDTOs;
	private List<NeighborhoodDTO> neighborhoodDTOs;
	private String jsonMessage;
	private String count;

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
	public void setCategoryDTOs(List<CategoryDTO> categoryDTOs) {
		this.categoryDTOs = categoryDTOs;
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

	/**
	 * @return the count
	 */
	public String getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(String count) {
		this.count = count;
	}

	/**
	 * @return the neighborhoodDTOs
	 */
	public List<NeighborhoodDTO> getNeighborhoodDTOs() {
		return neighborhoodDTOs;
	}

	/**
	 * @param neighborhoodDTOs
	 *            the neighborhoodDTOs to set
	 */
	public void setNeighborhoodDTOs(List<NeighborhoodDTO> neighborhoodDTOs) {
		this.neighborhoodDTOs = neighborhoodDTOs;
	}

}
