package com.ceostocks.model.notification;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("1")
public class FriendRequestNotify extends Notification {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1066162612959079204L;

	@Column(name = "REQUESTER_ID")
	private BigDecimal requesterId;
	@Column(name = "ACCEPTER_ID")
	private BigDecimal accepterId;
	@Column(name = "IS_REQUEST_ACCEPTED", nullable = false)
	private Boolean isRequestAccepted;

	/**
	 * 
	 */
	public FriendRequestNotify() {
		super();
	}

	/**
	 * 
	 * @param fromUser
	 * @param toUser
	 * @param friendRequestStatus
	 * @param notificationId
	 * @param isSeen
	 */
	public FriendRequestNotify(BigDecimal requesterId, BigDecimal accepterId, Boolean isRequestAccepted, Boolean isSeen) {
		super(isSeen);
		this.requesterId = requesterId;
		this.accepterId = accepterId;
		this.isRequestAccepted = isRequestAccepted;
	}

	/**
	 * @return the requesterId
	 */
	public BigDecimal getRequesterId() {
		return requesterId;
	}

	/**
	 * @param requesterId
	 *            the requesterId to set
	 */
	public void setRequesterId(BigDecimal requesterId) {
		this.requesterId = requesterId;
	}

	/**
	 * @return the accepterId
	 */
	public BigDecimal getAccepterId() {
		return accepterId;
	}

	/**
	 * @param accepterId
	 *            the accepterId to set
	 */
	public void setAccepterId(BigDecimal accepterId) {
		this.accepterId = accepterId;
	}

	/**
	 * @return the isRequestAccepted
	 */
	public Boolean getIsRequestAccepted() {
		return isRequestAccepted;
	}

	/**
	 * @param isRequestAccepted
	 *            the isRequestAccepted to set
	 */
	public void setIsRequestAccepted(Boolean isRequestAccepted) {
		this.isRequestAccepted = isRequestAccepted;
	}
}
