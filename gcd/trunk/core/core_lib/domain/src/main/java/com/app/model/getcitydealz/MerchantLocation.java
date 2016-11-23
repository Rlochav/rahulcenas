package com.app.model.getcitydealz;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "merchantlocation")
public class MerchantLocation extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2876686828567951392L;

	@EmbeddedId
	private MerchantLocationPK merchantLocationPK;

	@Column(name = "LocationName")
	private String locationName;
	@Column(name = "ContactFirstName")
	private String contactFirstName;
	@Column(name = "ContactLastName")
	private String contactLastName;
	@Column(name = "LocationPhone")
	private String locationPhone;
	@Column(name = "Address1")
	private String address1;
	@Column(name = "Address2")
	private String address2;
	@Column(name = "Address3")
	private String address3;
	@Column(name = "City")
	private String city;
	@Column(name = "State")
	private String state;
	@Column(name = "ZipCode")
	private String zipCode;
	@Column(name = "Email")
	private String email;
	@Column(name = "LocationDesc")
	private String locationDesc;
	@Column(name = "LocationHours")
	private String locationHours;
	@Column(name = "NeighborhoodId")
	private Integer neighborhoodid;

	public MerchantLocationPK getMerchantLocationPK() {
		return merchantLocationPK;
	}

	public void setMerchantLocationPK(MerchantLocationPK merchantLocationPK) {
		this.merchantLocationPK = merchantLocationPK;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getContactFirstName() {
		return contactFirstName;
	}

	public void setContactFirstName(String contactFirstName) {
		this.contactFirstName = contactFirstName;
	}

	public String getContactLastName() {
		return contactLastName;
	}

	public void setContactLastName(String contactLastName) {
		this.contactLastName = contactLastName;
	}

	public String getLocationPhone() {
		return locationPhone;
	}

	public void setLocationPhone(String locationPhone) {
		this.locationPhone = locationPhone;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLocationDesc() {
		return locationDesc;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDesc = locationDesc;
	}

	public String getLocationHours() {
		return locationHours;
	}

	public void setLocationHours(String locationHours) {
		this.locationHours = locationHours;
	}

	public Integer getNeighborhoodid() {
		return neighborhoodid;
	}

	public void setNeighborhoodid(Integer neighborhoodid) {
		this.neighborhoodid = neighborhoodid;
	}

}
