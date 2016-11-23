package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class SubLevelMasterPK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8932511835157325020L;

	@Column(name = "LevelId")
	private Integer levelId;
	@Column(name = "SubLevelId")
	private Integer subLevelId;

	public SubLevelMasterPK() {

	}

	public SubLevelMasterPK(Integer levelId, Integer subLevelId) {
		this.levelId = levelId;
		this.subLevelId = subLevelId;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!(obj instanceof SubLevelMasterPK))
			return false;
		SubLevelMasterPK other = (SubLevelMasterPK) obj;
		return other.getLevelId() == this.getLevelId() && other.getSubLevelId() == this.getSubLevelId();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int hashResult = 1;
		hashResult = hashResult * prime + ((levelId == null ? 0 : levelId.hashCode()));
		hashResult = hashResult * prime + ((subLevelId == null ? 0 : subLevelId.hashCode()));
		return hashResult;
	}

	/**
	 * @return the levelId
	 */
	public Integer getLevelId() {
		return levelId;
	}

	/**
	 * @param levelId
	 *            the levelId to set
	 */
	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	/**
	 * @return the subLevelId
	 */
	public Integer getSubLevelId() {
		return subLevelId;
	}

	/**
	 * @param subLevelId
	 *            the subLevelId to set
	 */
	public void setSubLevelId(Integer subLevelId) {
		this.subLevelId = subLevelId;
	}

}
