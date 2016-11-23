package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "gcd_times_zone")
public class GcdTimeZone implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7149873744769565014L;

	@Id
	@Column(name = "Id")
	private Integer id;
	@Column(name = "ZoneName")
	private String zoneName;
	@Column(name = "OffSet")
	private String offSet;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the zoneName
	 */
	public String getZoneName() {
		return zoneName;
	}

	/**
	 * @param zoneName
	 *            the zoneName to set
	 */
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	/**
	 * @return the offSet
	 */
	public String getOffSet() {
		return offSet;
	}

	/**
	 * @param offSet
	 *            the offSet to set
	 */
	public void setOffSet(String offSet) {
		this.offSet = offSet;
	}

}
