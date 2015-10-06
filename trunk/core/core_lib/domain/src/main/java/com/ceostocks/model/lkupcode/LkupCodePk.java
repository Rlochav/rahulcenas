package com.ceostocks.model.lkupcode;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class LkupCodePk implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4051611255124706601L;

	@Column(name = "LKUP_CODE")
	private String lkupCode;
	@Column(name = "KEY_CODE")
	private String keyCode;

	/**
	 * @return the lkupCode
	 */
	public String getLkupCode() {
		return lkupCode;
	}

	/**
	 * @param lkupCode
	 *            the lkupCode to set
	 */
	public void setLkupCode(String lkupCode) {
		this.lkupCode = lkupCode;
	}

	/**
	 * @return the keyCode
	 */
	public String getKeyCode() {
		return keyCode;
	}

	/**
	 * @param keyCode
	 *            the keyCode to set
	 */
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
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
		result = prime * result + ((keyCode == null) ? 0 : keyCode.hashCode());
		result = prime * result + ((lkupCode == null) ? 0 : lkupCode.hashCode());
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
		LkupCodePk other = (LkupCodePk) obj;
		if (keyCode == null) {
			if (other.keyCode != null)
				return false;
		} else if (!keyCode.equals(other.keyCode))
			return false;
		if (lkupCode == null) {
			if (other.lkupCode != null)
				return false;
		} else if (!lkupCode.equals(other.lkupCode))
			return false;
		return true;
	}

}
