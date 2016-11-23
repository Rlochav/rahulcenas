package com.app.model.getcitydealz;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.constraints.NotEmpty;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "merchantmaster")
public class MerchantMaster extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 20438062043201566L;

	@Id
	@Column(name = "MerchantId")
	private Integer merchantId;
	@NotEmpty(message = "User Id is mandatory.")
	@Column(name = "UserId")
	private String userId;
	@Column(name = "MerchantName")
	private String merchantName;
	@Column(name = "ContactFirstName")
	private String contactFirstName;
	@Column(name = "ContactLastName")
	private String contactLastName;
	@Column(name = "ContactPhone")
	private String contactPhone;
	@Column(name = "ContactAltPhone")
	private String contactAltPhone;
	@Column(name = "Address1")
	private String address1;
	@Column(name = "Address2")
	private String address2;
	@Column(name = "Address3")
	private String address3;
	@Column(name = "City")
	private Integer city;
	@Column(name = "CityToDispaly")
	private String cityToDispaly;
	@Column(name = "State")
	private String state;
	@Column(name = "Zip")
	private String zip;
	@Column(name = "EmailId")
	private String emailId;
	@Column(name = "SalesPerson")
	private String salesPerson;
	@Column(name = "DailyDealenName")
	private String dailyDealenName;
	@Column(name = "TestDrive")
	private String testDrive;
	@Column(name = "GoogleAnalyticId")
	private String googleAnalyticId;
	@Column(name = "BlogTemplateId")
	private String blogTemplateId;
	@NotEmpty(message = "Password Id is mandatory.")
	@Column(name = "Password")
	private String password;
	@Column(name = "MasterCategory")
	private Integer masterCategory;
	@Column(name = "NeighborhoodName")
	private Integer neighborhoodName;
	@Column(name = "WebsiteUrl")
	private String websiteUrl;

	@Column(name = "BillingAddress1")
	private String billingAddress1;
	@Column(name = "BillingAddress2")
	private String billingAddress2;
	@Column(name = "BillingAddress3")
	private String billingAddress3;
	@Column(name = "BillingCity")
	private String billingCity;
	@Column(name = "BillingState")
	private String billingState;

	@Column(name = "Status")
	private Integer status;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "DeactivateDate")
	private Date deactivateDate;

	@Column(name = "NeighborhoodAddress")
	private String neighborhoodAddress;
	@Column(name = "NeighborhoodCity")
	private String neighborhoodCity;
	@Column(name = "NeighborhoodState")
	private String neighborhoodState;
	@Column(name = "NeighborhoodZip")
	private String neighborhoodZip;

	@Column(name = "BusinessHours")
	private String businessHours;

	@Column(name = "MerchantUrl")
	private String merchantUrl;

	/**
	 * @return the merchantId
	 */
	public Integer getMerchantId() {
		return merchantId;
	}

	/**
	 * @param merchantId
	 *            the merchantId to set
	 */
	public void setMerchantId(Integer merchantId) {
		this.merchantId = merchantId;
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
	 * @return the contactAltPhone
	 */
	public String getContactAltPhone() {
		return contactAltPhone;
	}

	/**
	 * @param contactAltPhone
	 *            the contactAltPhone to set
	 */
	public void setContactAltPhone(String contactAltPhone) {
		this.contactAltPhone = contactAltPhone;
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
	public Integer getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(Integer city) {
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
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
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
	 * @return the googleAnalyticId
	 */
	public String getGoogleAnalyticId() {
		return googleAnalyticId;
	}

	/**
	 * @param googleAnalyticId
	 *            the googleAnalyticId to set
	 */
	public void setGoogleAnalyticId(String googleAnalyticId) {
		this.googleAnalyticId = googleAnalyticId;
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
	 * @return the masterCategory
	 */
	public Integer getMasterCategory() {
		return masterCategory;
	}

	/**
	 * @param masterCategory
	 *            the masterCategory to set
	 */
	public void setMasterCategory(Integer masterCategory) {
		this.masterCategory = masterCategory;
	}

	/**
	 * @return the neighborhoodName
	 */
	public Integer getNeighborhoodName() {
		return neighborhoodName;
	}

	/**
	 * @param neighborhoodName
	 *            the neighborhoodName to set
	 */
	public void setNeighborhoodName(Integer neighborhoodName) {
		this.neighborhoodName = neighborhoodName;
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
	 * @return the billingAddress1
	 */
	public String getBillingAddress1() {
		return billingAddress1;
	}

	/**
	 * @param billingAddress1
	 *            the billingAddress1 to set
	 */
	public void setBillingAddress1(String billingAddress1) {
		this.billingAddress1 = billingAddress1;
	}

	/**
	 * @return the billingAddress2
	 */
	public String getBillingAddress2() {
		return billingAddress2;
	}

	/**
	 * @param billingAddress2
	 *            the billingAddress2 to set
	 */
	public void setBillingAddress2(String billingAddress2) {
		this.billingAddress2 = billingAddress2;
	}

	/**
	 * @return the billingAddress3
	 */
	public String getBillingAddress3() {
		return billingAddress3;
	}

	/**
	 * @param billingAddress3
	 *            the billingAddress3 to set
	 */
	public void setBillingAddress3(String billingAddress3) {
		this.billingAddress3 = billingAddress3;
	}

	/**
	 * @return the billingCity
	 */
	public String getBillingCity() {
		return billingCity;
	}

	/**
	 * @param billingCity
	 *            the billingCity to set
	 */
	public void setBillingCity(String billingCity) {
		this.billingCity = billingCity;
	}

	/**
	 * @return the billingState
	 */
	public String getBillingState() {
		return billingState;
	}

	/**
	 * @param billingState
	 *            the billingState to set
	 */
	public void setBillingState(String billingState) {
		this.billingState = billingState;
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

	/**
	 * @return the deactivateDate
	 */
	public Date getDeactivateDate() {
		return deactivateDate;
	}

	/**
	 * @param deactivateDate
	 *            the deactivateDate to set
	 */
	public void setDeactivateDate(Date deactivateDate) {
		this.deactivateDate = deactivateDate;
	}

	public String getNeighborhoodAddress() {
		return neighborhoodAddress;
	}

	public void setNeighborhoodAddress(String neighborhoodAddress) {
		this.neighborhoodAddress = neighborhoodAddress;
	}

	public String getNeighborhoodCity() {
		return neighborhoodCity;
	}

	public void setNeighborhoodCity(String neighborhoodCity) {
		this.neighborhoodCity = neighborhoodCity;
	}

	public String getNeighborhoodState() {
		return neighborhoodState;
	}

	public void setNeighborhoodState(String neighborhoodState) {
		this.neighborhoodState = neighborhoodState;
	}

	public String getNeighborhoodZip() {
		return neighborhoodZip;
	}

	public void setNeighborhoodZip(String neighborhoodZip) {
		this.neighborhoodZip = neighborhoodZip;
	}

	public String getBusinessHours() {
		return businessHours;
	}

	public void setBusinessHours(String businessHours) {
		this.businessHours = businessHours;
	}

	/**
	 * @return the cityToDispaly
	 */
	public String getCityToDispaly() {
		return cityToDispaly;
	}

	/**
	 * @param cityToDispaly
	 *            the cityToDispaly to set
	 */
	public void setCityToDispaly(String cityToDispaly) {
		this.cityToDispaly = cityToDispaly;
	}

	/**
	 * @return the merchantUrl
	 */
	public String getMerchantUrl() {
		return merchantUrl;
	}

	/**
	 * @param merchantUrl
	 *            the merchantUrl to set
	 */
	public void setMerchantUrl(String merchantUrl) {
		this.merchantUrl = merchantUrl;
	}

}
