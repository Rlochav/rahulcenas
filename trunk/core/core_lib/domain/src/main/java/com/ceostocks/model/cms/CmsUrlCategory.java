package com.ceostocks.model.cms;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;

@Entity
@Table(name = "CMS_URL_CATEGORY")
public class CmsUrlCategory extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -696875499010331622L;

	@Id
	@GeneratedValue(generator = "sq_cms_url_category_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_cms_url_category_id", sequenceName = "SQ_CMS_URL_CATEGORY_ID", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	@Column(name = "CATEGORY_TYPE")
	private Integer categoryType;
	@OneToMany(mappedBy = "cmsUrlCategory", fetch = FetchType.LAZY, orphanRemoval = true)
	private Set<CmsUrl> cmsUrls = new HashSet<>();

	public CmsUrlCategory() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param name
	 * @param isActive
	 */
	public CmsUrlCategory(String name, Boolean isActive, Integer categoryType) {
		this.name = name;
		this.isActive = isActive;
		this.categoryType = categoryType;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}

	/**
	 * @param isActive
	 *            the isActive to set
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the cmsUrls
	 */
	public Set<CmsUrl> getCmsUrls() {
		return cmsUrls;
	}

	/**
	 * @param cmsUrls
	 *            the cmsUrls to set
	 */
	public void addCmsUrl(CmsUrl cmsUrl) {
		this.cmsUrls.add(cmsUrl);
	}

	/**
	 * @return the categoryType
	 */
	public Integer getCategoryType() {
		return categoryType;
	}

	/**
	 * @param categoryType
	 *            the categoryType to set
	 */
	public void setCategoryType(Integer categoryType) {
		this.categoryType = categoryType;
	}

}
