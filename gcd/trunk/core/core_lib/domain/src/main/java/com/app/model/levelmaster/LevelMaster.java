package com.app.model.levelmaster;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "levelmaster")
public class LevelMaster extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6977432867913020352L;

	@Id
	@Column(name = "LevelId")
	private Integer levelId;
	@Column(name = "LevelType")
	private String levelType;
	@Column(name = "LevelFullYearPrice")
	private String levelFullYearPrice;
	@Column(name = "QuarterPaymentPrice")
	private String quarterPaymentPrice;

	/**
	 * @return the levelId
	 */
	public Integer getLevelId() {
		return levelId;
	}

	/**
	 * @param levelId
	 *            the levelId to set
	 */
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	/**
	 * @return the levelType
	 */
	public String getLevelType() {
		return levelType;
	}

	/**
	 * @param levelType
	 *            the levelType to set
	 */
	public void setLevelType(String levelType) {
		this.levelType = levelType;
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

}
