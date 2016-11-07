package com.ceostocks.model.cms;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;

@Entity
@Table(name = "CMS_PAGE")
public class CmsPage extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8421696763158109165L;
	@Id
	@GeneratedValue(generator = "sq_cms_page_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_cms_page_id", sequenceName = "SQ_CMS_PAGE_ID", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "DESCIPTION")
	private String desciption;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;
	@OneToOne(mappedBy = "cmsPage", cascade = CascadeType.ALL, orphanRemoval = true)
	private CmsPageContent cmsPageContent;

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
	 * @return the desciption
	 */
	public String getDesciption() {
		return desciption;
	}

	/**
	 * @param desciption
	 *            the desciption to set
	 */
	public void setDesciption(String desciption) {
		this.desciption = desciption;
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
	 * @return the cmsPageContent
	 */
	public CmsPageContent getCmsPageContent() {
		return cmsPageContent;
	}

	/**
	 * @param cmsPageContent
	 *            the cmsPageContent to set
	 */
	public void setCmsPageContent(CmsPageContent cmsPageContent) {
		this.cmsPageContent = cmsPageContent;
	}

}
