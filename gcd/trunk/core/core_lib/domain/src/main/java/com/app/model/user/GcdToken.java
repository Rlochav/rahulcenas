package com.app.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "gcd_token")
public class GcdToken extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3820561848884024247L;

	@Id
	@Column(name = "TokenId")
	private Integer tokenId;
	@Column(name = "TokenType")
	private Integer tokenType;
	@Column(name = "TokenText")
	private String tokenText;

	/**
	 * @return the tokenId
	 */
	public Integer getTokenId() {
		return tokenId;
	}

	/**
	 * @param tokenId
	 *            the tokenId to set
	 */
	public void setTokenId(Integer tokenId) {
		this.tokenId = tokenId;
	}

	/**
	 * @return the tokenType
	 */
	public Integer getTokenType() {
		return tokenType;
	}

	/**
	 * @param tokenType
	 *            the tokenType to set
	 */
	public void setTokenType(Integer tokenType) {
		this.tokenType = tokenType;
	}

	/**
	 * @return the tokenText
	 */
	public String getTokenText() {
		return tokenText;
	}

	/**
	 * @param tokenText
	 *            the tokenText to set
	 */
	public void setTokenText(String tokenText) {
		this.tokenText = tokenText;
	}

}
