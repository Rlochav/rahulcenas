package com.app.model.getcitydealz;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

@Entity
@Table(name = "featuremaster")
public class FeatureMaster implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3981745634518168345L;

	@Id
	@Column(name = "FeatureId")
	private Integer featureId;
	@Column(name = "FeatureName")
	private String featureName;

	/**
	 * @return the featureId
	 */
	public Integer getFeatureId() {
		return featureId;
	}

	/**
	 * @param featureId
	 *            the featureId to set
	 */
	public void setFeatureId(Integer featureId) {
		this.featureId = featureId;
	}

	/**
	 * @return the featureName
	 */
	public String getFeatureName() {
		return featureName;
	}

	/**
	 * @param featureName
	 *            the featureName to set
	 */
	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

}
