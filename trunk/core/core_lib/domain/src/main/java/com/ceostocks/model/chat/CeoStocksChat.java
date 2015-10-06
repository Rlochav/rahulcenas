package com.ceostocks.model.chat;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "ceo_stocks_chat")
public class CeoStocksChat implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3987030479659283614L;

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;

	@Column(name = "USERFROM")
	private String userFrom;

	@Column(name = "USERTO")
	private String userTo;

	@Column(name = "MESSAGE")
	private String message;

	@Column(name = "MESSAGE_STATE")
	private String messageState;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "msgtime")
	private Date messageTime;

	public CeoStocksChat() {

	}

	public CeoStocksChat(String userFrom, String userTo, String message, String messageState, Date messageTime) {
		super();
		this.userFrom = userFrom;
		this.userTo = userTo;
		this.message = message;
		this.messageState = messageState;
		this.messageTime = messageTime;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the userFrom
	 */
	public String getUserFrom() {
		return userFrom;
	}

	/**
	 * @return the userTo
	 */
	public String getUserTo() {
		return userTo;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param messageState
	 *            the messageState to set
	 */
	public void setMessageState(String messageState) {
		this.messageState = messageState;
	}

	/**
	 * @return the messageState
	 */
	public String getMessageState() {
		return messageState;
	}

	/**
	 * @return the messageTime
	 */
	public Date getMessageTime() {
		return messageTime;
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		result = prime * result + ((messageState == null) ? 0 : messageState.hashCode());
		result = prime * result + ((messageTime == null) ? 0 : messageTime.hashCode());
		result = prime * result + ((userFrom == null) ? 0 : userFrom.hashCode());
		result = prime * result + ((userTo == null) ? 0 : userTo.hashCode());
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
		CeoStocksChat other = (CeoStocksChat) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		if (messageState == null) {
			if (other.messageState != null)
				return false;
		} else if (!messageState.equals(other.messageState))
			return false;
		if (messageTime == null) {
			if (other.messageTime != null)
				return false;
		} else if (!messageTime.equals(other.messageTime))
			return false;
		if (userFrom == null) {
			if (other.userFrom != null)
				return false;
		} else if (!userFrom.equals(other.userFrom))
			return false;
		if (userTo == null) {
			if (other.userTo != null)
				return false;
		} else if (!userTo.equals(other.userTo))
			return false;
		return true;
	}
}
