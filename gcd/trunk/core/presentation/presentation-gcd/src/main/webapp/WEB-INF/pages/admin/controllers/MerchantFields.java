package com.app.admin.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.getcitydealz.dto.MerchantCategoryDTO;

public class MerchantFields implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String merchantId;
	private String merchantName;
	private String userId;
	private String contactFirstName;
	private String contactLastName;
	private String contactPhone;
	private String contactAlternatePhone;
	private String address1;
	private String address2;
	private String address3;
	private String businessPhone;
	private String city;
	private String cityId;
	private String state;
	private String zipCode;
	private String emailId;
	private String salesPerson;
	private String dailyDealenName;
	private String testDrive;
	private String googleAnalyticsId;
	private String blogTemplateId;
	private String merchantLevel;
	private String password;
	private String masterCategory;
	private String masterCategoryText;
	private String category1;
	private String category1Text;
	private String category2;
	private String category2Text;
	private String subCategory1;
	private String subCategory1Text;
	private String subCategory2;
	private String subCategory2Text;
	private String merchantFeature;
	private String websiteUrl;
	private boolean isDifferentBillingAddress;
	private List<String> mFeatureList;
	private String neighborhoodName;
	private String logoId;
	private String subscriptionLevel;
	private String getCityDealzName;
	private MultipartFile logo;
	private List<MerchantCategoryDTO> merchantCategories;
	private String jsonMessage;

	private String bAddress1;
	private String bAddress2;
	private String bAddress3;
	private String bCity;
	private String bState;

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
	 * @return the merchantName
	 */
	public String getMerchantName() {
		return merchantName;
	}

	/**
	 * @param merchantName
	 *            the merchantName to set
	 */
	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	/**
	 * @return the contactFirstName
	 */
	public String getContactFirstName() {
		return contactFirstName;
	}

	/**
	 * @param contactFirstName
	 *            the contactFirstName to set
	 */
	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	/**
	 * @return the contactLastName
	 */
	public String getContactLastName() {
		return contactLastName;
	}

	/**
	 * @param contactLastName
	 *            the contactLastName to set
	 */
	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	/**
	 * @return the contactPhone
	 */
	public String getContactPhone() {
		return contactPhone;
	}

	/**
	 * @param contactPhone
	 *            the contactPhone to set
	 */
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	/**
	 * @return the contactAlternatePhone
	 */
	public String getContactAlternatePhone() {
		return contactAlternatePhone;
	}

	/**
	 * @param contactAlternatePhone
	 *            the contactAlternatePhone to set
	 */
	public void setContactAlternatePhone(String contactAlternatePhone) {
		this.contactAlternatePhone = contactAlternatePhone;
	}

	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1
	 *            the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2
	 *            the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * @return the address3
	 */
	public String getAddress3() {
		return address3;
	}

	/**
	 * @param address3
	 *            the address3 to set
	 */
	public void setAddress3(String address3) {
		this.address3 = address3;
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
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}

	/**
	 * @param zipCode
	 *            the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the salesPerson
	 */
	public String getSalesPerson() {
		return salesPerson;
	}

	/**
	 * @param salesPerson
	 *            the salesPerson to set
	 */
	public void setSalesPerson(String salesPerson) {
		this.salesPerson = salesPerson;
	}

	/**
	 * @return the dailyDealenName
	 */
	public String getDailyDealenName() {
		return dailyDealenName;
	}

	/**
	 * @param dailyDealenName
	 *            the dailyDealenName to set
	 */
	public void setDailyDealenName(String dailyDealenName) {
		this.dailyDealenName = dailyDealenName;
	}

	/**
	 * @return the testDrive
	 */
	public String getTestDrive() {
		return testDrive;
	}

	/**
	 * @param testDrive
	 *            the testDrive to set
	 */
	public void setTestDrive(String testDrive) {
		this.testDrive = testDrive;
	}

	/**
	 * @return the googleAnalyticsId
	 */
	public String getGoogleAnalyticsId() {
		return googleAnalyticsId;
	}

	/**
	 * @param googleAnalyticsId
	 *            the googleAnalyticsId to set
	 */
	public void setGoogleAnalyticsId(String googleAnalyticsId) {
		this.googleAnalyticsId = googleAnalyticsId;
	}

	/**
	 * @return the blogTemplateId
	 */
	public String getBlogTemplateId() {
		return blogTemplateId;
	}

	/**
	 * @param blogTemplateId
	 *            the blogTemplateId to set
	 */
	public void setBlogTemplateId(String blogTemplateId) {
		this.blogTemplateId = blogTemplateId;
	}

	/**
	 * @return the merchantLevel
	 */
	public String getMerchantLevel() {
		return merchantLevel;
	}

	/**
	 * @param merchantLevel
	 *            the merchantLevel to set
	 */
	public void setMerchantLevel(String merchantLevel) {
		this.merchantLevel = merchantLevel;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the category1
	 */
	public String getCategory1() {
		return category1;
	}

	/**
	 * @param category1
	 *            the category1 to set
	 */
	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	/**
	 * @return the category2
	 */
	public String getCategory2() {
		return category2;
	}

	/**
	 * @param category2
	 *            the category2 to set
	 */
	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	/**
	 * @return the subCategory1
	 */
	public String getSubCategory1() {
		return subCategory1;
	}

	/**
	 * @param subCategory1
	 *            the subCategory1 to set
	 */
	public void setSubCategory1(String subCategory1) {
		this.subCategory1 = subCategory1;
	}

	/**
	 * @return the subCategory2
	 */
	public String getSubCategory2() {
		return subCategory2;
	}

	/**
	 * @param subCategory2
	 *            the subCategory2 to set
	 */
	public void setSubCategory2(String subCategory2) {
		this.subCategory2 = subCategory2;
	}

	/**
	 * @return the merchantFeature
	 */
	public String getMerchantFeature() {
		return merchantFeature;
	}

	/**
	 * @param merchantFeature
	 *            the merchantFeature to set
	 */
	public void setMerchantFeature(String merchantFeature) {
		this.merchantFeature = merchantFeature;
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
	 * @return the masterCategory
	 */
	public String getMasterCategory() {
		return masterCategory;
	}

	/**
	 * @param masterCategory
	 *            the masterCategory to set
	 */
	public void setMasterCategory(String masterCategory) {
		this.masterCategory = masterCategory;
	}

	/**
	 * @return the merchantCategories
	 */
	public List<MerchantCategoryDTO> getMerchantCategories() {
		return merchantCategories;
	}

	/**
	 * @param merchantCategories
	 *            the merchantCategories to set
	 */
	public void setMerchantCategories(
			List<MerchantCategoryDTO> merchantCategories) {
		this.merchantCategories = merchantCategories;
	}

	/**
	 * @return the mFeatureList
	 */
	public List<String> getmFeatureList() {
		return mFeatureList;
	}

	/**
	 * @param mFeatureList
	 *            the mFeatureList to set
	 */
	public void setmFeatureList(List<String> mFeatureList) {
		this.mFeatureList = mFeatureList;
	}

	/**
	 * @return the neighborhoodName
	 */
	public String getNeighborhoodName() {
		return neighborhoodName;
	}

	/**
	 * @param neighborhoodName
	 *            the neighborhoodName to set
	 */
	public void setNeighborhoodName(String neighborhoodName) {
		this.neighborhoodName = neighborhoodName;
	}

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the subCategory1Text
	 */
	public String getSubCategory1Text() {
		return subCategory1Text;
	}

	/**
	 * @param subCategory1Text
	 *            the subCategory1Text to set
	 */
	public void setSubCategory1Text(String subCategory1Text) {
		this.subCategory1Text = subCategory1Text;
	}

	/**
	 * @return the subCategory2Text
	 */
	public String getSubCategory2Text() {
		return subCategory2Text;
	}

	/**
	 * @param subCategory2Text
	 *            the subCategory2Text to set
	 */
	public void setSubCategory2Text(String subCategory2Text) {
		this.subCategory2Text = subCategory2Text;
	}

	/**
	 * @return the masterCategoryText
	 */
	public String getMasterCategoryText() {
		return masterCategoryText;
	}

	/**
	 * @param masterCategoryText
	 *            the masterCategoryText to set
	 */
	public void setMasterCategoryText(String masterCategoryText) {
		this.masterCategoryText = masterCategoryText;
	}

	/**
	 * @return the category1Text
	 */
	public String getCategory1Text() {
		return category1Text;
	}

	/**
	 * @param category1Text
	 *            the category1Text to set
	 */
	public void setCategory1Text(String category1Text) {
		this.category1Text = category1Text;
	}

	/**
	 * @return the category2Text
	 */
	public String getCategory2Text() {
		return category2Text;
	}

	/**
	 * @param category2Text
	 *            the category2Text to set
	 */
	public void setCategory2Text(String category2Text) {
		this.category2Text = category2Text;
	}

	/**
	 * @return the logoId
	 */
	public String getLogoId() {
		return logoId;
	}

	/**
	 * @param logoId
	 *            the logoId to set
	 */
	public void setLogoId(String logoId) {
		this.logoId = logoId;
	}

	/**
	 * @return the businessPhone
	 */
	public String getBusinessPhone() {
		return businessPhone;
	}

	/**
	 * @param businessPhone
	 *            the businessPhone to set
	 */
	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}

	/**
	 * @return the websiteUrl
	 */
	public String getWebsiteUrl() {
		return websiteUrl;
	}

	/**
	 * @param websiteUrl
	 *            the websiteUrl to set
	 */
	public void setWebsiteUrl(String websiteUrl) {
		this.websiteUrl = websiteUrl;
	}

	/**
	 * @return the isDifferentBillingAddress
	 */
	public boolean isDifferentBillingAddress() {
		return isDifferentBillingAddress;
	}

	/**
	 * @param isDifferentBillingAddress
	 *            the isDifferentBillingAddress to set
	 */
	public void setDifferentBillingAddress(boolean isDifferentBillingAddress) {
		this.isDifferentBillingAddress = isDifferentBillingAddress;
	}

	/**
	 * @return the logo
	 */
	public MultipartFile getLogo() {
		return logo;
	}

	/**
	 * @param logo
	 *            the logo to set
	 */
	public void setLogo(MultipartFile logo) {
		this.logo = logo;
	}

	/**
	 * @return the subscriptionLevel
	 */
	public String getSubscriptionLevel() {
		return subscriptionLevel;
	}

	/**
	 * @param subscriptionLevel
	 *            the subscriptionLevel to set
	 */
	public void setSubscriptionLevel(String subscriptionLevel) {
		this.subscriptionLevel = subscriptionLevel;
	}

	/**
	 * @return the getCityDealzName
	 */
	public String getGetCityDealzName() {
		return getCityDealzName;
	}

	/**
	 * @param getCityDealzName
	 *            the getCityDealzName to set
	 */
	public void setGetCityDealzName(String getCityDealzName) {
		this.getCityDealzName = getCityDealzName;
	}

	/**
	 * @return the bAddress1
	 */
	public String getbAddress1() {
		return bAddress1;
	}

	/**
	 * @param bAddress1
	 *            the bAddress1 to set
	 */
	public void setbAddress1(String bAddress1) {
		this.bAddress1 = bAddress1;
	}

	/**
	 * @return the bAddress2
	 */
	public String getbAddress2() {
		return bAddress2;
	}

	/**
	 * @param bAddress2
	 *            the bAddress2 to set
	 */
	public void setbAddress2(String bAddress2) {
		this.bAddress2 = bAddress2;
	}

	/**
	 * @return the bAddress3
	 */
	public String getbAddress3() {
		return bAddress3;
	}

	/**
	 * @param bAddress3
	 *            the bAddress3 to set
	 */
	public void setbAddress3(String bAddress3) {
		this.bAddress3 = bAddress3;
	}

	/**
	 * @return the bCity
	 */
	public String getbCity() {
		return bCity;
	}

	/**
	 * @param bCity
	 *            the bCity to set
	 */
	public void setbCity(String bCity) {
		this.bCity = bCity;
	}

	/**
	 * @return the bState
	 */
	public String getbState() {
		return bState;
	}

	/**
	 * @param bState
	 *            the bState to set
	 */
	public void setbState(String bState) {
		this.bState = bState;
	}

	/**
	 * @return the cityId
	 */
	public String getCityId() {
		return cityId;
	}

	/**
	 * @param cityId the cityId to set
	 */
	public void setCityId(String cityId) {
		this.cityId = cityId;
	}

}
