package com.app.login.dto;

import java.io.Serializable;

public class UserInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3004058636095339788L;
	private String userId;
	private String userName;
	private String emailId;
	private String password;
	private Integer userIndex;
	private String status;
	private String userType;
	private String lastVisitedDateTime;
	private String dateFormat = "MM/dd/yyyy";
	private String dateTimeFormat = "MM/dd/yyyy hh:mm a";
	private String userLevel;
	private String address1;
	private String address2;
	private String address3;
	private String cityId;
	private String city;
	private String cityCode;
	private String cityText;
	private String state;
	private String zipCode;
	private String contactFirstName;
	private String contactLastName;
	private String contactPhone;
	private String businessHours;
	private String salesPerson;
	private String dailyDealenName;
	private String testDrive;
	private String googleAnalyticsId;
	private String blogTemplateId;
	private String merchantLevel;
	private String contactAlternatePhone;
	private String logoImage;
	private String jsonMessage;
	private String logoId;
	private String ipAddress;
	private String sessionId;
	private String cityToDisplay;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the userIndex
	 */
	public Integer getUserIndex() {
		return userIndex;
	}

	/**
	 * @param userIndex
	 *            the userIndex to set
	 */
	public void setUserIndex(Integer userIndex) {
		this.userIndex = userIndex;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getLastVisitedDateTime() {
		return lastVisitedDateTime;
	}

	public void setLastVisitedDateTime(String lastVisitedDateTime) {
		this.lastVisitedDateTime = lastVisitedDateTime;
	}

	/**
	 * @return the dateFormat
	 */
	public String getDateFormat() {
		return dateFormat;
	}

	/**
	 * @param dateFormat
	 *            the dateFormat to set
	 */
	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	/**
	 * @return the dateTimeFormat
	 */
	public String getDateTimeFormat() {
		return dateTimeFormat;
	}

	/**
	 * @param dateTimeFormat
	 *            the dateTimeFormat to set
	 */
	public void setDateTimeFormat(String dateTimeFormat) {
		this.dateTimeFormat = dateTimeFormat;
	}

	/**
	 * @return the userLevel
	 */
	public String getUserLevel() {
		return userLevel;
	}

	/**
	 * @param userLevel
	 *            the userLevel to set
	 */
	public void setUserLevel(String userLevel) {
		this.userLevel = userLevel;
	}

	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName
	 *            the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
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
	 * @return the logoImage
	 */
	public String getLogoImage() {
		return logoImage;
	}

	/**
	 * @param logoImage
	 *            the logoImage to set
	 */
	public void setLogoImage(String logoImage) {
		this.logoImage = logoImage;
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
	 * @return the ipAddress
	 */
	public String getIpAddress() {
		return ipAddress;
	}

	/**
	 * @param ipAddress
	 *            the ipAddress to set
	 */
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	/**
	 * @return the sessionId
	 */
	public String getSessionId() {
		return sessionId;
	}

	/**
	 * @param sessionId
	 *            the sessionId to set
	 */
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}

	/**
	 * @return the cityText
	 */
	public String getCityText() {
		return cityText;
	}

	/**
	 * @param cityText
	 *            the cityText to set
	 */
	public void setCityText(String cityText) {
		this.cityText = cityText;
	}

	/**
	 * @return the cityCode
	 */
	public String getCityCode() {
		return cityCode;
	}

	/**
	 * @param cityCode the cityCode to set
	 */
	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
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

	/**
	 * @return the businessHours
	 */
	public String getBusinessHours() {
		return businessHours;
	}

	/**
	 * @param businessHours the businessHours to set
	 */
	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}

	/**
	 * @return the cityToDisplay
	 */
	public String getCityToDisplay() {
		return cityToDisplay;
	}

	/**
	 * @param cityToDisplay the cityToDisplay to set
	 */
	public void setCityToDisplay(String cityToDisplay) {
		this.cityToDisplay = cityToDisplay;
	}

}
