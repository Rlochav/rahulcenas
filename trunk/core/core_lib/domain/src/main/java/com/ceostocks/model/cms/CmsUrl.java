package com.ceostocks.model.cms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;

@Entity
@Table(name = "CMS_URL")
public class CmsUrl extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1671898666455016072L;
	@Id
	@GeneratedValue(generator = "sq_cms_url_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_cms_url_id", sequenceName = "SQ_CMS_URL_ID", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	@ManyToOne
	private CmsUrlCategory cmsUrlCategory;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
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
	 * @return the cmsUrlCategory
	 */
	public CmsUrlCategory getCmsUrlCategory() {
		return cmsUrlCategory;
	}

	/**
	 * @param cmsUrlCategory
	 *            the cmsUrlCategory to set
	 */
	public void setCmsUrlCategory(CmsUrlCategory cmsUrlCategory) {
		this.cmsUrlCategory = cmsUrlCategory;
	}

}
