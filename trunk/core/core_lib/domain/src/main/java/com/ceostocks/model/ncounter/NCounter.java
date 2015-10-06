package com.ceostocks.model.ncounter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;

@Entity
@Table(name = "NCOUNTER")
public class NCounter extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9160462984187127276L;

	@Id
	@Column(name = "KEY_NAME")
	private String keyName;
	@Column(name = "START_NO")
	private Integer startNo;
	@Column(name = "NEXT_NO")
	private Integer nextNo;

	/**
	 * @return the keyName
	 */
	public String getKeyName() {
		return keyName;
	}

	/**
	 * @param keyName
	 *            the keyName to set
	 */
	public void setKeyName(String keyName) {
		this.keyName = keyName;
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

}
