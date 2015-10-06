package com.ceostocks.model.social.post;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class UserFriendsPK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9013719375223552595L;

	@Column(name = "REQUESTER_ID")
	private BigDecimal requesterId;
	@Column(name = "ACCEPTER_ID")
	private BigDecimal accepterId;

	public UserFriendsPK() {

	}

	/**
	 * @param requesterId
	 * @param accepterId
	 */
	public UserFriendsPK(BigDecimal requesterId, BigDecimal accepterId) {
		this.requesterId = requesterId;
		this.accepterId = accepterId;
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accepterId == null) ? 0 : accepterId.hashCode());
		result = prime * result + ((requesterId == null) ? 0 : requesterId.hashCode());
		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserFriendsPK other = (UserFriendsPK) obj;
		if (accepterId == null) {
			if (other.accepterId != null)
				return false;
		} else if (!accepterId.equals(other.accepterId))
			return false;
		if (requesterId == null) {
			if (other.requesterId != null)
				return false;
		} else if (!requesterId.equals(other.requesterId))
			return false;
		return true;
	}

}