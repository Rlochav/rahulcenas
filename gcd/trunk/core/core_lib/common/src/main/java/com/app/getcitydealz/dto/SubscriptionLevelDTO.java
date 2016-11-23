package com.app.getcitydealz.dto;

import java.io.Serializable;
import java.util.List;

public class SubscriptionLevelDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5332219140422209423L;

	private String levelId;
	private String levelName;
	private String levelFullYearPrice;
	private String quarterPaymentPrice;
	private String jsonMessage;
	private List<SubscriptionLevelDTO> subscriptionLevelDTOs;

	/**
	 * @return the levelId
	 */
	public String getLevelId() {
		return levelId;
	}

	/**
	 * @param levelId
	 *            the levelId to set
	 */
	public void setLevelId(String levelId) {
		this.levelId = levelId;
	}

	/**
	 * @return the levelName
	 */
	public String getLevelName() {
		return levelName;
	}

	/**
	 * @param levelName
	 *            the levelName to set
	 */
	public void setLevelName(String levelName) {
		this.levelName = levelName;
	}

	/**
	 * @return the levelFullYearPrice
	 */
	public String getLevelFullYearPrice() {
		return levelFullYearPrice;
	}

	/**
	 * @param levelFullYearPrice
	 *            the levelFullYearPrice to set
	 */
	public void setLevelFullYearPrice(String levelFullYearPrice) {
		this.levelFullYearPrice = levelFullYearPrice;
	}

	/**
	 * @return the quarterPaymentPrice
	 */
	public String getQuarterPaymentPrice() {
		return quarterPaymentPrice;
	}

	/**
	 * @param quarterPaymentPrice
	 *            the quarterPaymentPrice to set
	 */
	public void setQuarterPaymentPrice(String quarterPaymentPrice) {
		this.quarterPaymentPrice = quarterPaymentPrice;
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
	 * @return the subscriptionLevelDTOs
	 */
	public List<SubscriptionLevelDTO> getSubscriptionLevelDTOs() {
		return subscriptionLevelDTOs;
	}

	/**
	 * @param subscriptionLevelDTOs the subscriptionLevelDTOs to set
	 */
	public void setSubscriptionLevelDTOs(List<SubscriptionLevelDTO> subscriptionLevelDTOs) {
		this.subscriptionLevelDTOs = subscriptionLevelDTOs;
	}

}
