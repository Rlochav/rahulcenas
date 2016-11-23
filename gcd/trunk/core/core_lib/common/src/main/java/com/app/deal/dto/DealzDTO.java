package com.app.deal.dto;

import java.util.List;

import com.app.base.dto.BaseDTO;
import com.app.getcitydealz.dto.LocationDTO;
import com.app.getcitydealz.dto.MerchantDTO;
import com.app.getcitydealz.dto.SocialConnectionsDTO;

public class DealzDTO extends BaseDTO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3004058636095339788L;
	private String dealId;
	private String category;
	private String subCategory;
	private String city;
	private String title;
	private String urlTitle;
	private String restriction;
	private String startDate;
	private String endDate;
	private String amountSaved;
	private String dealCode;
	private String description;
	private String merchantId;
	private String urlMerchantName;
	private String merchantName;
	private String imagePath;
	private String website;
	private String useLogo;
	private String dealType;
	private String currentRating;
	private List<DealzDTO> dealzDTOs;
	private String jsonMessage;
	private String latitude;
	private String longitude;
	private String counts;
	private SocialConnectionsDTO socialConnectionsDTO;
	private MerchantDTO merchantDTOs;
	private String emails;
	private String merchantAddress;
	private String accessTokenExpireDate;
	private List<LocationDTO> locationDTOs;
	private String googleAnalytics;
	private String localTimeZoneName;
	private String localTimeZoneUtc;
	private String timeZoneId;
	private String hotDealLink;
	private String orderNo;

	private String cityName;

	private String fbSortUrl;
	private String twitSortUrl;
	private String pinSortUrl;
	private String linkSortUrl;
	private String gPSortUrl;

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
	 * @return the useLogo
	 */
	public String getUseLogo() {
		return useLogo;
	}

	/**
	 * @param useLogo
	 *            the useLogo to set
	 */
	public void setUseLogo(String useLogo) {
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
	 * @return the dealzDTOs
	 */
	public List<DealzDTO> getDealzDTOs() {
		return dealzDTOs;
	}

	/**
	 * @param dealzDTOs
	 *            the dealzDTOs to set
	 */
	public void setDealzDTOs(List<DealzDTO> dealzDTOs) {
		this.dealzDTOs = dealzDTOs;
	}

	/**
	 * @return the currentRating
	 */
	public String getCurrentRating() {
		return currentRating;
	}

	/**
	 * @param currentRating
	 *            the currentRating to set
	 */
	public void setCurrentRating(String currentRating) {
		this.currentRating = currentRating;
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
	 * @return the merchantDTOs
	 */
	public MerchantDTO getMerchantDTOs() {
		return merchantDTOs;
	}

	/**
	 * @param merchantDTOs
	 *            the merchantDTOs to set
	 */
	public void setMerchantDTOs(MerchantDTO merchantDTOs) {
		this.merchantDTOs = merchantDTOs;
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
	 * @return the socialConnectionsDTO
	 */
	public SocialConnectionsDTO getSocialConnectionsDTO() {
		return socialConnectionsDTO;
	}

	/**
	 * @param socialConnectionsDTO
	 *            the socialConnectionsDTO to set
	 */
	public void setSocialConnectionsDTO(SocialConnectionsDTO socialConnectionsDTO) {
		this.socialConnectionsDTO = socialConnectionsDTO;
	}

	/**
	 * @return the urlTitle
	 */
	public String getUrlTitle() {
		return urlTitle;
	}

	/**
	 * @param urlTitle
	 *            the urlTitle to set
	 */
	public void setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}

	/**
	 * @return the urlMerchantName
	 */
	public String getUrlMerchantName() {
		return urlMerchantName;
	}

	/**
	 * @param urlMerchantName
	 *            the urlMerchantName to set
	 */
	public void setUrlMerchantName(String urlMerchantName) {
		this.urlMerchantName = urlMerchantName;
	}

	/**
	 * @return the emails
	 */
	public String getEmails() {
		return emails;
	}

	/**
	 * @param emails
	 *            the emails to set
	 */
	public void setEmails(String emails) {
		this.emails = emails;
	}

	/**
	 * @return the accessTokenExpireDate
	 */
	public String getAccessTokenExpireDate() {
		return accessTokenExpireDate;
	}

	/**
	 * @param accessTokenExpireDate
	 *            the accessTokenExpireDate to set
	 */
	public void setAccessTokenExpireDate(String accessTokenExpireDate) {
		this.accessTokenExpireDate = accessTokenExpireDate;
	}

	/**
	 * @return the merchantAddress
	 */
	public String getMerchantAddress() {
		return merchantAddress;
	}

	/**
	 * @param merchantAddress
	 *            the merchantAddress to set
	 */
	public void setMerchantAddress(String merchantAddress) {
		this.merchantAddress = merchantAddress;
	}

	/**
	 * @return the locationDTOs
	 */
	public List<LocationDTO> getLocationDTOs() {
		return locationDTOs;
	}

	/**
	 * @param locationDTOs
	 *            the locationDTOs to set
	 */
	public void setLocationDTOs(List<LocationDTO> locationDTOs) {
		this.locationDTOs = locationDTOs;
	}

	/**
	 * @return the googleAnalytics
	 */
	public String getGoogleAnalytics() {
		return googleAnalytics;
	}

	/**
	 * @param googleAnalytics
	 *            the googleAnalytics to set
	 */
	public void setGoogleAnalytics(String googleAnalytics) {
		this.googleAnalytics = googleAnalytics;
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
	 * @param timeZoneId
	 *            the timeZoneId to set
	 */
	public void setTimeZoneId(String timeZoneId) {
		this.timeZoneId = timeZoneId;
	}

	/**
	 * @return the fbSortUrl
	 */
	public String getFbSortUrl() {
		return fbSortUrl;
	}

	/**
	 * @param fbSortUrl
	 *            the fbSortUrl to set
	 */
	public void setFbSortUrl(String fbSortUrl) {
		this.fbSortUrl = fbSortUrl;
	}

	/**
	 * @return the twitSortUrl
	 */
	public String getTwitSortUrl() {
		return twitSortUrl;
	}

	/**
	 * @param twitSortUrl
	 *            the twitSortUrl to set
	 */
	public void setTwitSortUrl(String twitSortUrl) {
		this.twitSortUrl = twitSortUrl;
	}

	/**
	 * @return the pinSortUrl
	 */
	public String getPinSortUrl() {
		return pinSortUrl;
	}

	/**
	 * @param pinSortUrl
	 *            the pinSortUrl to set
	 */
	public void setPinSortUrl(String pinSortUrl) {
		this.pinSortUrl = pinSortUrl;
	}

	/**
	 * @return the linkSortUrl
	 */
	public String getLinkSortUrl() {
		return linkSortUrl;
	}

	/**
	 * @param linkSortUrl
	 *            the linkSortUrl to set
	 */
	public void setLinkSortUrl(String linkSortUrl) {
		this.linkSortUrl = linkSortUrl;
	}

	/**
	 * @return the gPSortUrl
	 */
	public String getgPSortUrl() {
		return gPSortUrl;
	}

	/**
	 * @param gPSortUrl
	 *            the gPSortUrl to set
	 */
	public void setgPSortUrl(String gPSortUrl) {
		this.gPSortUrl = gPSortUrl;
	}

	/**
	 * @return the hotDealLink
	 */
	public String getHotDealLink() {
		return hotDealLink;
	}

	/**
	 * @param hotDealLink
	 *            the hotDealLink to set
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
	 * @param orderNo
	 *            the orderNo to set
	 */
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	/**
	 * @return the cityName
	 */
	public String getCityName() {
		return cityName;
	}

	/**
	 * @param cityName the cityName to set
	 */
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}

}
