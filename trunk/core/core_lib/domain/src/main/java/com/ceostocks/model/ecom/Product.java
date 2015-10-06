package com.ceostocks.model.ecom;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;

@Entity
@Table(name = "PRODUCT")
public class Product extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1990848767218551295L;
	@Id
	@GeneratedValue(generator = "seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq", sequenceName = "SQ_PRODUCT_ID", allocationSize = 1)
	@Column(name = "ID")
	private BigDecimal id;
	@Column(name = "PRODUCT_NAME")
	private String productName;
	@Column(name = "PRODUCT_CODE")
	private String productCode;
	@Column(name = "PRODUCT_PRICE")
	private String productPrice;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PRODUCT_CATEGORY", joinColumns = { @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID") }, inverseJoinColumns = { @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID") })
	private Set<Category> categories= new HashSet<Category>();

	/**
	 * @return the id
	 */
	public BigDecimal getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(BigDecimal id) {
		this.id = id;
	}

	/**
	 * @return the productName
	 */
	public String getProductName() {
		return productName;
	}

	/**
	 * @param productName
	 *            the productName to set
	 */
	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 * @return the productCode
	 */
	public String getProductCode() {
		return productCode;
	}

	/**
	 * @param productCode
	 *            the productCode to set
	 */
	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	/**
	 * @return the productPrice
	 */
	public String getProductPrice() {
		return productPrice;
	}

	/**
	 * @param productPrice
	 *            the productPrice to set
	 */
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
	
}
