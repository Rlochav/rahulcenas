package com.ceostocks.model.lkupcode;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;

@Entity
@Table(name = "LKUPCODE")
public class LkupCode extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2409248832245240700L;

	@EmbeddedId
	private LkupCodePk lkupCodePk;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "KEY1")
	private String key1;
	@Column(name = "KEY2")
	private String key2;
	@Column(name = "KEY3")
	private String key3;
	@Column(name = "KEY4")
	private String key4;
	@Column(name = "KEY5")
	private String key5;

	/**
	 * @return the lkupCodePk
	 */
	public LkupCodePk getLkupCodePk() {
		return lkupCodePk;
	}

	/**
	 * @param lkupCodePk
	 *            the lkupCodePk to set
	 */
	public void setLkupCodePk(LkupCodePk lkupCodePk) {
		this.lkupCodePk = lkupCodePk;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
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

}
