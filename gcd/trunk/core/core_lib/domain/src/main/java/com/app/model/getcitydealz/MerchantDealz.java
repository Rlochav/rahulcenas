package com.app.model.getcitydealz;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "merchantdealz")
public class MerchantDealz extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 216444614000341410L;

	@EmbeddedId
	private MerchantDealzPK merchantDealzPK;
	@Column(name = "StartDate")
	private Date startDate;
	@Column(name = "EndDate")
	private Date endDate;
	@Column(name = "Code")
	private String code;
	@Column(name = "Title")
	private String title;
	@Column(name = "Description")
	private String description;
	@Column(name = "AmountSaving")
	private String amountSaving;
	@Column(name = "Restrictions")
	private String restrictions;
	@Column(name = "ImageUrl")
	private String imageUrl;
	@Column(name = "UseLogo")
	private Integer useLogo;
	@Column(name = "DealType")
	private Integer dealType;
	@Column(name = "Latitude")
	private String latitude;
	@Column(name = "Longitude")
	private String longitude;
	@Column(name = "Processed")
	private Integer processed;
	@Column(name = "Payed")
	private Integer payed;
	@Column(name = "LocalTimeZoneName")
	private String localTimeZoneName;
	@Column(name = "LocalTimeZoneUtc")
	private String localTimeZoneUtc;

	@Column(name = "FBSortUrl")
	private String fbSortUrl;
	@Column(name = "TwitSortUrl")
	private String twitSortUrl;
	@Column(name = "PinSortUrl")
	private String pinSortUrl;
	@Column(name = "LinkSortUrl")
	private String linkSortUrl;
	@Column(name = "GpSortUrl")
	private String gPSortUrl;
	@Column(name = "Status")
	private Integer status;
	@Column(name = "HotDealLink")
	private String hotDealLink;
	@Column(name = "HotDealOrder")
	private Integer hotDealOrder;

	@Column(name = "AdminSocialPostedStatus")
	private Integer adminSocialPostedStatus;

	/**
	 * @return the merchantDealzPK
	 */
	public MerchantDealzPK getMerchantDealzPK() {
		return merchantDealzPK;
	}

	/**
	 * @param merchantDealzPK
	 *            the merchantDealzPK to set
	 */
	public void setMerchantDealzPK(MerchantDealzPK merchantDealzPK) {
		this.merchantDealzPK = merchantDealzPK;
	}

	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate
	 *            the startDate to set
	 */
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate
	 *            the endDate to set
	 */
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
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
	 * @return the amountSaving
	 */
	public String getAmountSaving() {
		return amountSaving;
	}

	/**
	 * @param amountSaving
	 *            the amountSaving to set
	 */
	public void setAmountSaving(String amountSaving) {
		this.amountSaving = amountSaving;
	}

	/**
	 * @return the restrictions
	 */
	public String getRestrictions() {
		return restrictions;
	}

	/**
	 * @param restrictions
	 *            the restrictions to set
	 */
	public void setRestrictions(String restrictions) {
		this.restrictions = restrictions;
	}

	/**
	 * @return the imageUrl
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param imageUrl
	 *            the imageUrl to set
	 */
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	/**
	 * @return the useLogo
	 */
	public Integer getUseLogo() {
		return useLogo;
	}

	/**
	 * @param useLogo
	 *            the useLogo to set
	 */
	public void setUseLogo(Integer useLogo) {
		this.useLogo = useLogo;
	}

	/**
	 * @return the dealType
	 */
	public Integer getDealType() {
		return dealType;
	}

	/**
	 * @param dealType
	 *            the dealType to set
	 */
	public void setDealType(Integer dealType) {
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
	 * @return the processed
	 */
	public Integer getProcessed() {
		return processed;
	}

	/**
	 * @param processed
	 *            the processed to set
	 */
	public void setProcessed(Integer processed) {
		this.processed = processed;
	}

	/**
	 * @return the payed
	 */
	public Integer getPayed() {
		return payed;
	}

	/**
	 * @param payed
	 *            the payed to set
	 */
	public void setPayed(Integer payed) {
		this.payed = payed;
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
	 * @return the hotDealOrder
	 */
	public Integer getHotDealOrder() {
		return hotDealOrder;
	}

	/**
	 * @param hotDealOrder
	 *            the hotDealOrder to set
	 */
	public void setHotDealOrder(Integer hotDealOrder) {
		this.hotDealOrder = hotDealOrder;
	}

	/**
	 * @return the adminSocialPostedStatus
	 */
	public Integer getAdminSocialPostedStatus() {
		return adminSocialPostedStatus;
	}

	/**
	 * @param adminSocialPostedStatus
	 *            the adminSocialPostedStatus to set
	 */
	public void setAdminSocialPostedStatus(Integer adminSocialPostedStatus) {
		this.adminSocialPostedStatus = adminSocialPostedStatus;
	}

}
