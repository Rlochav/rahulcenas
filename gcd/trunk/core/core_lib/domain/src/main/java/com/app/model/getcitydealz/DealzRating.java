package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "dealzrating")
public class DealzRating implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7824203763076530664L;

	@Id
	@Column(name = "DealId")
	private Integer dealId;
	@Column(name = "Start1")
	private Integer start1;
	@Column(name = "RatedBy1")
	private String ratedBy1;
	@Column(name = "Start2")
	private Integer start2;
	@Column(name = "RatedBy2")
	private String ratedBy2;
	@Column(name = "Start3")
	private Integer start3;
	@Column(name = "RatedBy3")
	private String ratedBy3;
	@Column(name = "Start4")
	private Integer start4;
	@Column(name = "RatedBy4")
	private String ratedBy4;
	@Column(name = "Start5")
	private Integer start5;
	@Column(name = "RatedBy5")
	private String ratedBy5;
	@Column(name = "CurrentRating")
	private Integer currentRating;

	/**
	 * @return the dealId
	 */
	public Integer getDealId() {
		return dealId;
	}

	/**
	 * @param dealId
	 *            the dealId to set
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	/**
	 * @return the start1
	 */
	public Integer getStart1() {
		return start1;
	}

	/**
	 * @param start1
	 *            the start1 to set
	 */
	public void setStart1(Integer start1) {
		this.start1 = start1;
	}

	/**
	 * @return the ratedBy1
	 */
	public String getRatedBy1() {
		return ratedBy1;
	}

	/**
	 * @param ratedBy1
	 *            the ratedBy1 to set
	 */
	public void setRatedBy1(String ratedBy1) {
		this.ratedBy1 = ratedBy1;
	}

	/**
	 * @return the start2
	 */
	public Integer getStart2() {
		return start2;
	}

	/**
	 * @param start2
	 *            the start2 to set
	 */
	public void setStart2(Integer start2) {
		this.start2 = start2;
	}

	/**
	 * @return the ratedBy2
	 */
	public String getRatedBy2() {
		return ratedBy2;
	}

	/**
	 * @param ratedBy2
	 *            the ratedBy2 to set
	 */
	public void setRatedBy2(String ratedBy2) {
		this.ratedBy2 = ratedBy2;
	}

	/**
	 * @return the start3
	 */
	public Integer getStart3() {
		return start3;
	}

	/**
	 * @param start3
	 *            the start3 to set
	 */
	public void setStart3(Integer start3) {
		this.start3 = start3;
	}

	/**
	 * @return the ratedBy3
	 */
	public String getRatedBy3() {
		return ratedBy3;
	}

	/**
	 * @param ratedBy3
	 *            the ratedBy3 to set
	 */
	public void setRatedBy3(String ratedBy3) {
		this.ratedBy3 = ratedBy3;
	}

	/**
	 * @return the start4
	 */
	public Integer getStart4() {
		return start4;
	}

	/**
	 * @param start4
	 *            the start4 to set
	 */
	public void setStart4(Integer start4) {
		this.start4 = start4;
	}

	/**
	 * @return the ratedBy4
	 */
	public String getRatedBy4() {
		return ratedBy4;
	}

	/**
	 * @param ratedBy4
	 *            the ratedBy4 to set
	 */
	public void setRatedBy4(String ratedBy4) {
		this.ratedBy4 = ratedBy4;
	}

	/**
	 * @return the start5
	 */
	public Integer getStart5() {
		return start5;
	}

	/**
	 * @param start5
	 *            the start5 to set
	 */
	public void setStart5(Integer start5) {
		this.start5 = start5;
	}

	/**
	 * @return the ratedBy5
	 */
	public String getRatedBy5() {
		return ratedBy5;
	}

	/**
	 * @param ratedBy5
	 *            the ratedBy5 to set
	 */
	public void setRatedBy5(String ratedBy5) {
		this.ratedBy5 = ratedBy5;
	}

	/**
	 * @return the currentRating
	 */
	public Integer getCurrentRating() {
		return currentRating;
	}

	/**
	 * @param currentRating
	 *            the currentRating to set
	 */
	public void setCurrentRating(Integer currentRating) {
		this.currentRating = currentRating;
	}

}
