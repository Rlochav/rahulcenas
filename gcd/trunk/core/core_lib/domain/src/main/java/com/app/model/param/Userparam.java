package com.app.model.param;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseWithUDF;

/**
 * The persistent class for the userparams database table.
 * 
 */
@Entity
@Table(name = "userparams")
public class Userparam extends BaseWithUDF<Serializable> {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private UserparamPK userparamPK;

	@Column(name = "Descr", nullable = false)
	private String descr;

	@Column(name = "Key1")
	private String key1;

	@Column(name = "Key2")
	private String key2;

	@Column(name = "Key3")
	private String key3;

	@Column(name = "Key4")
	private String key4;

	@Column(name = "Key5")
	private String key5;

	@Column(name = "isActive")
	private Boolean isActive;

	public Userparam() {
	}

	/**
	 * @return the userparamPK
	 */
	public UserparamPK getUserparamPK() {
		return userparamPK;
	}

	/**
	 * @param userparamPK
	 *            the userparamPK to set
	 */
	public void setUserparamPK(UserparamPK userparamPK) {
		this.userparamPK = userparamPK;
	}

	/**
	 * @return the descr
	 */
	public String getDescr() {
		return descr;
	}

	/**
	 * @param descr
	 *            the descr to set
	 */
	public void setDescr(String descr) {
		this.descr = descr;
	}

	/**
	 * @return the key1
	 */
	public String getKey1() {
		return key1;
	}

	/**
	 * @param key1
	 *            the key1 to set
	 */
	public void setKey1(String key1) {
		this.key1 = key1;
	}

	/**
	 * @return the key2
	 */
	public String getKey2() {
		return key2;
	}

	/**
	 * @param key2
	 *            the key2 to set
	 */
	public void setKey2(String key2) {
		this.key2 = key2;
	}

	/**
	 * @return the key3
	 */
	public String getKey3() {
		return key3;
	}

	/**
	 * @param key3
	 *            the key3 to set
	 */
	public void setKey3(String key3) {
		this.key3 = key3;
	}

	/**
	 * @return the key4
	 */
	public String getKey4() {
		return key4;
	}

	/**
	 * @param key4
	 *            the key4 to set
	 */
	public void setKey4(String key4) {
		this.key4 = key4;
	}

	/**
	 * @return the key5
	 */
	public String getKey5() {
		return key5;
	}

	/**
	 * @param key5
	 *            the key5 to set
	 */
	public void setKey5(String key5) {
		this.key5 = key5;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

}