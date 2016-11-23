package com.app.model.ncounter;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.app.model.base.BaseWithUDF;

/**
 * The persistent class for the ncounter database table.
 * 
 */
@Entity
@Table(name = "ncounter")
public class KeyManagerEntity<I extends Serializable> extends BaseWithUDF<I> {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private NcounterPK ncounterPK;

	@Column(name = "NextNo")
	private Integer nextNo;

	@Column(name = "StartNo")
	private Integer startNo;

	@Transient
	private KeyHelper keyHelper;

	public KeyManagerEntity() {
	}

	/**
	 * @return the ncounterPK
	 */
	public NcounterPK getNcounterPK() {
		return ncounterPK;
	}

	/**
	 * @param ncounterPK
	 *            the ncounterPK to set
	 */
	public void setNcounterPK(NcounterPK ncounterPK) {
		this.ncounterPK = ncounterPK;
	}

	/**
	 * @return the nextNo
	 */
	public Integer getNextNo() {
		return nextNo;
	}

	/**
	 * @param nextNo
	 *            the nextNo to set
	 */
	public void setNextNo(Integer nextNo) {
		this.nextNo = nextNo;
	}

	/**
	 * @return the startNo
	 */
	public Integer getStartNo() {
		return startNo;
	}

	/**
	 * @param startNo
	 *            the startNo to set
	 */
	public void setStartNo(Integer startNo) {
		this.startNo = startNo;
	}

	/**
	 * @return the keyHelper
	 */
	public KeyHelper getKeyHelper() {
		return keyHelper;
	}

	/**
	 * @param keyHelper
	 *            the keyHelper to set
	 */
	public void setKeyHelper(KeyHelper keyHelper) {
		this.keyHelper = keyHelper;
	}

}