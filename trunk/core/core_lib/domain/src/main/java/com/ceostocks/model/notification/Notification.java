package com.ceostocks.model.notification;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;

@Entity
@Table(name = "NOTIFICATION")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "NOTIFICATION_TYPE", discriminatorType = DiscriminatorType.INTEGER)
public abstract class Notification extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6933678972249491926L;
	@Id
	@GeneratedValue(generator = "sq_notification_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_notification_id", sequenceName = "SQ_NOTIFICATION_ID", allocationSize = 1)
	@Column(name = "NOTIFICATION_ID")
	private BigDecimal notificationId;
	@Column(name = "IS_SEEN")
	private Boolean isSeen;

	public Notification() {

	}

	/**
	 * @param notificationId
	 * @param isSeen
	 */
	public Notification(Boolean isSeen) {
		super();
		this.isSeen = isSeen;
	}

	/**
	 * @return the notificationId
	 */
	public BigDecimal getNotificationId() {
		return notificationId;
	}

	/**
	 * @return the isSeen
	 */
	public Boolean getIsSeen() {
		return isSeen;
	}

	/**
	 * @param isSeen
	 *            the isSeen to set
	 */
	public void setIsSeen(Boolean isSeen) {
		this.isSeen = isSeen;
	}

}
