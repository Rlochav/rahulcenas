package com.app.model.subscriber;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "subscribers")
public class Subscribers extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3514585532802309378L;

	@Id
	@Column(name = "SubscriberId")
	private Integer subscriberId;
	@Column(name = "FirstName")
	private String firstName;
	@Column(name = "LastName")
	private String lastName;
	@Column(name = "EmailId")
	private String emailId;
	@Column(name = "SubscriptionType")
	private Integer subscriptionType;
	@Column(name = "IsActive")
	private Integer isActive;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "SubscriberId", referencedColumnName = "SubscriberId")
	private List<SubscriberNeighborhoodsLink> neighborhoodsLinks;
	@OneToMany(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
	@JoinColumn(name = "SubscriberId", referencedColumnName = "SubscriberId")
	private List<SubscriberCategoryLink> subscriberCategoryLinks;

	/**
	 * @return the subscriberId
	 */
	public Integer getSubscriberId() {
		return subscriberId;
	}

	/**
	 * @param subscriberId
	 *            the subscriberId to set
	 */
	public void setSubscriberId(Integer subscriberId) {
		this.subscriberId = subscriberId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @param emailId
	 *            the emailId to set
	 */
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @return the subscriptionType
	 */
	public Integer getSubscriptionType() {
		return subscriptionType;
	}

	/**
	 * @param subscriptionType
	 *            the subscriptionType to set
	 */
	public void setSubscriptionType(Integer subscriptionType) {
		this.subscriptionType = subscriptionType;
	}

	/**
	 * @return the isActive
	 */
	public Integer getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(Integer isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the neighborhoodsLinks
	 */
	public List<SubscriberNeighborhoodsLink> getNeighborhoodsLinks() {
		return neighborhoodsLinks;
	}

	/**
	 * @param neighborhoodsLinks
	 *            the neighborhoodsLinks to set
	 */
	public void setNeighborhoodsLinks(List<SubscriberNeighborhoodsLink> neighborhoodsLinks) {
		this.neighborhoodsLinks = neighborhoodsLinks;
	}

	/**
	 * @return the subscriberCategoryLinks
	 */
	public List<SubscriberCategoryLink> getSubscriberCategoryLinks() {
		return subscriberCategoryLinks;
	}

	/**
	 * @param subscriberCategoryLinks
	 *            the subscriberCategoryLinks to set
	 */
	public void setSubscriberCategoryLinks(List<SubscriberCategoryLink> subscriberCategoryLinks) {
		this.subscriberCategoryLinks = subscriberCategoryLinks;
	}

}
