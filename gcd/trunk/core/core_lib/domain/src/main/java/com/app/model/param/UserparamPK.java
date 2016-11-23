package com.app.model.param;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the userparams database table.
 * 
 */
@Embeddable
public class UserparamPK implements Serializable {
	// default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name = "ParamCode", unique = true, nullable = false)
	private String paramCode;

	@Column(name = "KeyCode", unique = true, nullable = false)
	private String keyCode;

	public UserparamPK() {
	}

	public UserparamPK(String paramCode, String keyCode) {
		this.paramCode = paramCode;
		this.keyCode = keyCode;
	}

	public String getParamCode() {
		return this.paramCode;
	}

	public void setParamCode(String paramCode) {
		this.paramCode = paramCode;
	}

	public String getKeyCode() {
		return this.keyCode;
	}

	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((keyCode == null) ? 0 : keyCode.hashCode());
		result = prime * result
				+ ((paramCode == null) ? 0 : paramCode.hashCode());
		return result;
	}

	/* (non-Javadoc)
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
		UserparamPK other = (UserparamPK) obj;
		if (keyCode == null) {
			if (other.keyCode != null)
				return false;
		} else if (!keyCode.equals(other.keyCode))
			return false;
		if (paramCode == null) {
			if (other.paramCode != null)
				return false;
		} else if (!paramCode.equals(other.paramCode))
			return false;
		return true;
	}
}