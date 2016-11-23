package com.app.model.codelookup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * The primary key class for the codelkup database table.
 * 
 */
@Embeddable
public class CodeLookupPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "LkupCode", unique = true, nullable = false)
	private String lkupCode;

	@Column(name = "KeyCode", unique = true, nullable = false)
	private String keyCode;

	public CodeLookupPK() {
	}

	public CodeLookupPK(String lkupCode, String keyCode) {
		super();
		this.lkupCode = lkupCode;
		this.keyCode = keyCode;
	}

	public String getLkupCode() {
		return this.lkupCode;
	}

	public void setLkupCode(String lkupCode) {
		this.lkupCode = lkupCode;
	}

	public String getKeyCode() {
		return this.keyCode;
	}

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
		CodeLookupPK other = (CodeLookupPK) obj;
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