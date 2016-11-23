package com.app.getcitydealz.dto;

import java.io.Serializable;
import java.util.List;

public class HotDealBannerDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8398331984214822045L;

	private String dealId;
	private String imagePath;
	private String merchantName;
	private String merchantId;
	private String url;
	private String imageAlt;
	private List<HotDealBannerDTO> bannerDTOs;

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
	 * @return the bannerDTOs
	 */
	public List<HotDealBannerDTO> getBannerDTOs() {
		return bannerDTOs;
	}

	/**
	 * @param bannerDTOs
	 *            the bannerDTOs to set
	 */
	public void setBannerDTOs(List<HotDealBannerDTO> bannerDTOs) {
		this.bannerDTOs = bannerDTOs;
	}

	/**
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param url the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the imageAlt
	 */
	public String getImageAlt() {
		return imageAlt;
	}

	/**
	 * @param imageAlt the imageAlt to set
	 */
	public void setImageAlt(String imageAlt) {
		this.imageAlt = imageAlt;
	}

}
