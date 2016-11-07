package com.ceostocks.model.cms;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CMS_FIXED_LOCATION_CONTENT")
public class CmsFixedLocationContent extends CmsContent {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7105613613133217911L;

	@Id
	@GeneratedValue(generator = "sq_flc_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "sq_flc_id", sequenceName = "SQ_FLC_ID", allocationSize = 1)
	@Column(name = "ID")
	private Integer id;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

	/**
	 * @return the id
	 */
	public Integer getId() {
		return id;
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

}
