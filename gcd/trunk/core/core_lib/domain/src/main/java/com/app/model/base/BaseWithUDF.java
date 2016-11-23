package com.app.model.base;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class BaseWithUDF<I extends Serializable> extends Base<Serializable> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4480433098799838276L;

	@Column(name = "SDF1")
	private String sdf1;

	@Column(name = "SDF2")
	private String sdf2;

	@Column(name = "SDF3")
	private String sdf3;

	@Column(name = "SDF4")
	private String sdf4;

	@Column(name = "SDF5")
	private String sdf5;

	@Column(name = "UDF1")
	private String udf1;

	@Column(name = "UDF2")
	private String udf2;

	@Column(name = "UDF3")
	private String udf3;

	@Column(name = "UDF4")
	private String udf4;

	@Column(name = "UDF5")
	private String udf5;

	@Column(name = "UPDBy", nullable = false)
	private Integer updatedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "UPDdate", nullable = false)
	private Date updatedDate;

	@Version
	@Column(name = "RowVersion", nullable = false)
	private Integer rowVersion;

	/**
	 * @return the sdf1
	 */
	public String getSdf1() {
		return sdf1;
	}

	/**
	 * @param sdf1
	 *            the sdf1 to set
	 */
	public void setSdf1(String sdf1) {
		this.sdf1 = sdf1;
	}

	/**
	 * @return the sdf2
	 */
	public String getSdf2() {
		return sdf2;
	}

	/**
	 * @param sdf2
	 *            the sdf2 to set
	 */
	public void setSdf2(String sdf2) {
		this.sdf2 = sdf2;
	}

	/**
	 * @return the sdf3
	 */
	public String getSdf3() {
		return sdf3;
	}

	/**
	 * @param sdf3
	 *            the sdf3 to set
	 */
	public void setSdf3(String sdf3) {
		this.sdf3 = sdf3;
	}

	/**
	 * @return the sdf4
	 */
	public String getSdf4() {
		return sdf4;
	}

	/**
	 * @param sdf4
	 *            the sdf4 to set
	 */
	public void setSdf4(String sdf4) {
		this.sdf4 = sdf4;
	}

	/**
	 * @return the sdf5
	 */
	public String getSdf5() {
		return sdf5;
	}

	/**
	 * @param sdf5
	 *            the sdf5 to set
	 */
	public void setSdf5(String sdf5) {
		this.sdf5 = sdf5;
	}

	/**
	 * @return the udf1
	 */
	public String getUdf1() {
		return udf1;
	}

	/**
	 * @param udf1
	 *            the udf1 to set
	 */
	public void setUdf1(String udf1) {
		this.udf1 = udf1;
	}

	/**
	 * @return the udf2
	 */
	public String getUdf2() {
		return udf2;
	}

	/**
	 * @param udf2
	 *            the udf2 to set
	 */
	public void setUdf2(String udf2) {
		this.udf2 = udf2;
	}

	/**
	 * @return the udf3
	 */
	public String getUdf3() {
		return udf3;
	}

	/**
	 * @param udf3
	 *            the udf3 to set
	 */
	public void setUdf3(String udf3) {
		this.udf3 = udf3;
	}

	/**
	 * @return the udf4
	 */
	public String getUdf4() {
		return udf4;
	}

	/**
	 * @param udf4
	 *            the udf4 to set
	 */
	public void setUdf4(String udf4) {
		this.udf4 = udf4;
	}

	/**
	 * @return the udf5
	 */
	public String getUdf5() {
		return udf5;
	}

	/**
	 * @param udf5
	 *            the udf5 to set
	 */
	public void setUdf5(String udf5) {
		this.udf5 = udf5;
	}

	/**
	 * @return the updatedBy
	 */
	public Integer getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy
	 *            the updatedBy to set
	 */
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the updatedDate
	 */
	public Date getUpdatedDate() {
		return updatedDate;
	}

	/**
	 * @param updatedDate
	 *            the updatedDate to set
	 */
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	/**
	 * @return the rowVersion
	 */
	public Integer getRowVersion() {
		return rowVersion;
	}

	/**
	 * @param rowVersion
	 *            the rowVersion to set
	 */
	public void setRowVersion(Integer rowVersion) {
		this.rowVersion = rowVersion;
	}

}
