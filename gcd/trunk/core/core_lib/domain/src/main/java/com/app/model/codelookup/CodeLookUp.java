package com.app.model.codelookup;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

/**
 * The persistent class for the codelkup database table.
 * 
 */
@Entity
@Table(name = "codelkup")
public class CodeLookUp extends BaseNoUDF<Serializable> implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private CodeLookupPK codelkupPK;

	@Column(name = "Descr")
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

	@Column(name = "Status")
	private Integer status;

	public CodeLookUp() {
	}

	/**
	 * @return the codelkupPK
	 */
	public CodeLookupPK getCodelkupPK() {
		return codelkupPK;
	}

	/**
	 * @param codelkupPK
	 *            the codelkupPK to set
	 */
	public void setCodelkupPK(CodeLookupPK codelkupPK) {
		this.codelkupPK = codelkupPK;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}