package com.ceostocks.model.notification;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class MessageNotify extends Notification {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7318217242371358776L;

	@Column(name = "NOTIFY_MESSAGE")
	private String notifyMessage;

	/**
	 * @return the notifyMessage
	 */
	public String getNotifyMessage() {
		return notifyMessage;
	}

	/**
	 * @param notifyMessage
	 *            the notifyMessage to set
	 */
	public void setNotifyMessage(String notifyMessage) {
		this.notifyMessage = notifyMessage;
	}
}
