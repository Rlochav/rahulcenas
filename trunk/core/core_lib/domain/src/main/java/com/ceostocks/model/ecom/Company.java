package com.ceostocks.model.ecom;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;
import com.ceostocks.model.user.UserMaster;

@Entity
@Table(name = "COMPANY")
public class Company extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3520660688343832035L;
	@Id
	@GeneratedValue(generator = "sq_company_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_company_id", sequenceName = "SQ_COMPANY_ID", allocationSize = 1)
	@Column(name = "COMPANY_ID")
	private BigDecimal companyId;
	@Column(name = "COMPANY_CODE")
	private String companyCode;
	@Column(name = "TIN_NUMBER")
	private String tinNumber;
	@Column(name = "COMPANY_NAME")
	private String companyName;
	@Column(name = "EMAIL_ADDRESS")
	private String emailAddress;
	@Column(name = "COMPANY_ADDRESS_LINE1")
	private String companyAddressLine1;
	@Column(name = "COMPANY_ADDRESS_LINE2")
	private String companyAddressLine2;
	@Column(name = "COMPANY_ADDRESS_LINE3")
	private String companyAddressLine3;
	@Column(name = "CONTACT_PERSON_NAME")
	private String contactPersonName;
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	@Column(name = "MOBILE_NO")
	private String mobileNo;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "OWNER")
	private UserMaster userMaster;

	/**
	 * @return the companyId
	 */
	public BigDecimal getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId
	 *            the companyId to set
	 */
	public void setCompanyId(BigDecimal companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the companyCode
	 */
	public String getCompanyCode() {
		return companyCode;
	}

	/**
	 * @param companyCode
	 *            the companyCode to set
	 */
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}

	/**
	 * @return the tinNumber
	 */
	public String getTinNumber() {
		return tinNumber;
	}

	/**
	 * @param tinNumber
	 *            the tinNumber to set
	 */
	public void setTinNumber(String tinNumber) {
		this.tinNumber = tinNumber;
	}

	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName
	 *            the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @param emailAddress
	 *            the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	/**
	 * @return the companyAddressLine1
	 */
	public String getCompanyAddressLine1() {
		return companyAddressLine1;
	}

	/**
	 * @param companyAddressLine1
	 *            the companyAddressLine1 to set
	 */
	public void setCompanyAddressLine1(String companyAddressLine1) {
		this.companyAddressLine1 = companyAddressLine1;
	}

	/**
	 * @return the companyAddressLine2
	 */
	public String getCompanyAddressLine2() {
		return companyAddressLine2;
	}

	/**
	 * @param companyAddressLine2
	 *            the companyAddressLine2 to set
	 */
	public void setCompanyAddressLine2(String companyAddressLine2) {
		this.companyAddressLine2 = companyAddressLine2;
	}

	/**
	 * @return the companyAddressLine3
	 */
	public String getCompanyAddressLine3() {
		return companyAddressLine3;
	}

	/**
	 * @param companyAddressLine3
	 *            the companyAddressLine3 to set
	 */
	public void setCompanyAddressLine3(String companyAddressLine3) {
		this.companyAddressLine3 = companyAddressLine3;
	}

	/**
	 * @return the contactPersonName
	 */
	public String getContactPersonName() {
		return contactPersonName;
	}

	/**
	 * @param contactPersonName
	 *            the contactPersonName to set
	 */
	public void setContactPersonName(String contactPersonName) {
		this.contactPersonName = contactPersonName;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the mobileNo
	 */
	public String getMobileNo() {
		return mobileNo;
	}

	/**
	 * @param mobileNo
	 *            the mobileNo to set
	 */
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the userMaster
	 */
	public UserMaster getUserMaster() {
		return userMaster;
	}

	/**
	 * @param userMaster
	 *            the userMaster to set
	 */
	public void setUserMaster(UserMaster userMaster) {
		this.userMaster = userMaster;
	}

}
