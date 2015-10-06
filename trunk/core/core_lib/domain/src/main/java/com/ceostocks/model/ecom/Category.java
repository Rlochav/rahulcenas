package com.ceostocks.model.ecom;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;

@Entity
@Table(name = "CATEGORY")
public class Category extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1518863792475038500L;

	@Id
	@GeneratedValue(generator = "sq_category_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_category_id", sequenceName = "SQ_CATEGORY_ID", allocationSize = 1)
	@Column(name = "CATEGORY_ID")
	private Integer categoryId;
	@Column(name = "CATEGORY_NAME")
	private String categoryName;
	@Column(name = "CATEGORY_CODE")
	private String categoryCode;
	@OneToMany(mappedBy = "category", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<Category> categories = new HashSet<Category>();
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PARENT_CATEGORY")
	private Category category;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "PRODUCT_CATEGORY", joinColumns = { @JoinColumn(name = "CATEGORY_ID", referencedColumnName = "CATEGORY_ID") }, inverseJoinColumns = { @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID") })
	private Set<Product> products = new HashSet<Product>();

	/**
	 * @return the categoryId
	 */
	public Integer getCategoryId() {
		return categoryId;
	}

	/**
	 * @param categoryId
	 *            the categoryId to set
	 */
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	/**
	 * @return the categoryName
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param categoryName
	 *            the categoryName to set
	 */
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	/**
	 * @return the categoryCode
	 */
	public String getCategoryCode() {
		return categoryCode;
	}

	/**
	 * @param categoryCode
	 *            the categoryCode to set
	 */
	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}

	/**
	 * @return the productCategories
	 */
	public Set<Category> getCategories() {
		return categories;
	}

	/**
	 * @param productCategories
	 *            the productCategories to set
	 */
	public void addCategory(Category category) {
		this.categories.add(category);
	}

	/**
	 * @return the productCategory
	 */
	public Category geCategory() {
		return category;
	}

	/**
	 * @param productCategory
	 *            the productCategory to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

}
