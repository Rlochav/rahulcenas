package com.ceostocks.model.cms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CMS_PAGE_CONTENT")
public class CmsPageContent extends CmsContent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1088629838378977866L;

	@Id
	@Column(name = "ID")
	private Integer id;
	@OneToOne
	@PrimaryKeyJoinColumn(name = "ID")
	private CmsPage cmsPage;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @return the cmsPage
	 */
	public CmsPage getCmsPage() {
		return cmsPage;
	}

	/**
	 * @param cmsPage
	 *            the cmsPage to set
	 */
	public void setCmsPage(CmsPage cmsPage) {
		this.cmsPage = cmsPage;
	}

}
