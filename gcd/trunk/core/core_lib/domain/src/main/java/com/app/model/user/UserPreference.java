package com.app.model.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "userpreference")
public class UserPreference extends BaseNoUDF<Serializable> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5273989843031109295L;
	@Id
	@Column(name = "UserIndex", nullable = false)
	private Integer userIndex;
	@Column(name = "Type")
	private Integer type;
	@Column(name = "KeyPreference")
	private Integer keyPreference;
	@Column(name = "Value")
	private String value;

	/**
	 * @return the userIndex
	 */
	public Integer getUserIndex() {
		return userIndex;
	}

	/**
	 * @param userIndex
	 *            the userIndex to set
	 */
	public void setUserIndex(Integer userIndex) {
		this.userIndex = userIndex;
	}

	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * @return the keyPreference
	 */
	public Integer getKeyPreference() {
		return keyPreference;
	}

	/**
	 * @param keyPreference
	 *            the keyPreference to set
	 */
	public void setKeyPreference(Integer keyPreference) {
		this.keyPreference = keyPreference;
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}

}
