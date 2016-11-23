package com.app.model.socialconnections;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "fbaccesstokemerchantlink")
public class FBAccessTokeMerchantLink extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1835250953082129176L;
	@Id
	@Column(name = "ConnectionId")
	private Integer connectionId;
	@Column(name = "AccessToken")
	private String accessToken;
	@Column(name = "Name")
	private String name;

	/**
	 * @return the connectionId
	 */
	public Integer getConnectionId() {
		return connectionId;
	}

	/**
	 * @param connectionId
	 *            the connectionId to set
	 */
	public void setConnectionId(Integer connectionId) {
		this.connectionId = connectionId;
	}

	/**
	 * @return the accessToken
	 */
	public String getAccessToken() {
		return accessToken;
	}

	/**
	 * @param accessToken
	 *            the accessToken to set
	 */
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
