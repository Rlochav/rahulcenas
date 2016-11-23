package com.app.model.citiesnstate;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.app.model.base.BaseNoUDF;

@Entity
@Table(name = "gcdstate")
public class States extends BaseNoUDF<Serializable> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4348133218158289325L;
	@EmbeddedId
	private StatesPK statesPK;
	@Column(name = "StateName")
	private String stateName;

	/**
	 * @return the statesPK
	 */
	public StatesPK getStatesPK() {
		return statesPK;
	}

	/**
	 * @param statesPK
	 *            the statesPK to set
	 */
	public void setStatesPK(StatesPK statesPK) {
		this.statesPK = statesPK;
	}

	/**
	 * @return the stateName
	 */
	public String getStateName() {
		return stateName;
	}

	/**
	 * @param stateName
	 *            the stateName to set
	 */
	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
