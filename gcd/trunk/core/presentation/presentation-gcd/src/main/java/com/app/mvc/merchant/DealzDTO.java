package com.app.mvc.merchant;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class DealzDTO {

	private String dealId;
	private String category;
	private String subCategory;
	private String city;
	private String title;
	private String restriction;
	private String startDate;
	private String endDate;
	private String amountSaved;
	private String dealCode;
	private String description;
	private String merchantId;
	private String imagePath;
	private String website;
	private List<MultipartFile> files;
	private String docType;
	private boolean useLogo;
	private String dealType;
	private String latitude;
	private String longitude;
	private String jsonMessage;
	private String localTimeZoneName;
	private String localTimeZoneUtc;
	private String timeZoneId;
	private String hotDealLink;
	private String orderNo;

	/**
	 * @return the dealId
	 */
	public String getDealId() {
		return dealId;
	}

	/**
	 * @param dealId
	 *            the dealId to set
	 */
	public void setDealId(String dealId) {
		this.dealId = dealId;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category
	 *            the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the subCategory
	 */
	public String getSubCategory() {
		return subCategory;
	}

	/**
	 * @param subCategory
	 *            the subCategory to set
	 */
	public void setSubCategory(String subCategory) {
		this.subCategory = subCategory;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the restriction
	 */
	public String getRestriction() {
		return restriction;
	}

	/**
	 * @param restriction
	 *            the restriction to set
	 */
	public void setRestriction(String restriction) {
		this.restriction = restriction;
	}

	/**
	 * @return the startDate
	 */
	public String getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the amountSaved
	 */
	public String getAmountSaved() {
		return amountSaved;
	}

	/**
	 * @param amountSaved
	 *            the amountSaved to set
	 */
	public void setAmountSaved(String amountSaved) {
		this.amountSaved = amountSaved;
	}

	/**
	 * @return the dealCode
	 */
	public String getDealCode() {
		return dealCode;
	}

	/**
	 * @param dealCode
	 *            the dealCode to set
	 */
	public void setDealCode(String dealCode) {
		this.dealCode = dealCode;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the merchantId
	 */
	public String getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId
	 *            the merchantId to set
	 */
	public void setMerchantId(String merchantId) {
		this.merchantId = merchantId;
	}

	/**
	 * @return the imagePath
	 */
	public String getImagePath() {
		return imagePath;
	}

	/**
	 * @param imagePath
	 *            the imagePath to set
	 */
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
	 * @return the website
	 */
	public String getWebsite() {
		return website;
	}

	/**
	 * @param website
	 *            the website to set
	 */
	public void setWebsite(String website) {
		this.website = website;
	}

	/**
	 * @return the files
	 */
	public List<MultipartFile> getFiles() {
		return files;
	}

	/**
	 * @param files
	 *            the files to set
	 */
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	/**
	 * @return the docType
	 */
	public String getDocType() {
		return docType;
	}

	/**
	 * @param docType
	 *            the docType to set
	 */
	public void setDocType(String docType) {
		this.docType = docType;
	}

	/**
	 * @return the useLogo
	 */
	public boolean isUseLogo() {
		return useLogo;
	}

	/**
	 * @param useLogo
	 *            the useLogo to set
	 */
	public void setUseLogo(boolean useLogo) {
		this.useLogo = useLogo;
	}

	/**
	 * @return the dealType
	 */
	public String getDealType() {
		return dealType;
	}

	/**
	 * @param dealType
	 *            the dealType to set
	 */
	public void setDealType(String dealType) {
		this.dealType = dealType;
	}

	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude
	 *            the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude
	 *            the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the localTimeZoneName
	 */
	public String getLocalTimeZoneName() {
		return localTimeZoneName;
	}

	/**
	 * @param localTimeZoneName
	 *            the localTimeZoneName to set
	 */
	public void setLocalTimeZoneName(String localTimeZoneName) {
		this.localTimeZoneName = localTimeZoneName;
	}

	/**
	 * @return the localTimeZoneUtc
	 */
	public String getLocalTimeZoneUtc() {
		return localTimeZoneUtc;
	}

	/**
	 * @param localTimeZoneUtc
	 *            the localTimeZoneUtc to set
	 */
	public void setLocalTimeZoneUtc(String localTimeZoneUtc) {
		this.localTimeZoneUtc = localTimeZoneUtc;
	}

	/**
	 * @return the timeZoneId
	 */
	public String getTimeZoneId() {
		return timeZoneId;
	}

	/**
	 * @param timeZoneId the timeZoneId to set
	 */
	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	/**
	 * @return the hotDealLink
	 */
	public String getHotDealLink() {
		return hotDealLink;
	}

	/**
	 * @param hotDealLink the hotDealLink to set
	 */
	public void setHotDealLink(String hotDealLink) {
		this.hotDealLink = hotDealLink;
	}

	/**
	 * @return the orderNo
	 */
	public String getOrderNo() {
		return orderNo;
	}

	/**
	 * @param orderNo the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

}
