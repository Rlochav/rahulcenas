package com.app.model.user;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "gcd_transaction")
public class GCDtransaction implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6738539628486101743L;

	@EmbeddedId
	private GCDtransactionPK dtransactionPK;

	@Column(name = "dealStartTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dealStartTime;
	@Column(name = "EmailTriggerTime")
	@Temporal(TemporalType.TIMESTAMP)
	private Date emailTriggerTime;
	@Column(name = "DeliveryStatus")
	private Integer deliveryStatus;

	public GCDtransaction() {

	}

	public GCDtransaction(Integer dealId, Date dealStartDate, Integer subscriberId) {
		this.setDtransactionPK(new GCDtransactionPK(dealId, subscriberId));
		this.setDealStartTime(dealStartDate);
		this.setEmailTriggerTime(new Date());
	}

	/**
	 * @return the dtransactionPK
	 */
	public GCDtransactionPK getDtransactionPK() {
		return dtransactionPK;
	}

	/**
	 * @param dtransactionPK
	 *            the dtransactionPK to set
	 */
	public void setDtransactionPK(GCDtransactionPK dtransactionPK) {
		this.dtransactionPK = dtransactionPK;
	}

	/**
	 * @return the dealStartTime
	 */
	public Date getDealStartTime() {
		return dealStartTime;
	}

	/**
	 * @param dealStartTime
	 *            the dealStartTime to set
	 */
	public void setDealStartTime(Date dealStartTime) {
		this.dealStartTime = dealStartTime;
	}

	/**
	 * @return the emailTriggerTime
	 */
	public Date getEmailTriggerTime() {
		return emailTriggerTime;
	}

	/**
	 * @param emailTriggerTime
	 *            the emailTriggerTime to set
	 */
	public void setEmailTriggerTime(Date emailTriggerTime) {
		this.emailTriggerTime = emailTriggerTime;
	}

	/**
	 * @return the deliveryStatus
	 */
	public Integer getDeliveryStatus() {
		return deliveryStatus;
	}

	/**
	 * @param deliveryStatus
	 *            the deliveryStatus to set
	 */
	public void setDeliveryStatus(Integer deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}
}
