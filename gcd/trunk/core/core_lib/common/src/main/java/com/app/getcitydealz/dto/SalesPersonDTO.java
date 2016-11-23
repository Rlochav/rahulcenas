package com.app.getcitydealz.dto;

import java.io.Serializable;
import java.util.List;

public class SalesPersonDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5406506352371584806L;

	private String salesPersonId;
	private String salesPersonFirstName;
	private String salesPersonLastName;
	private String Status;
	private String jsonMessage;
	private List<SalesPersonDTO> salesPersonDTOs;

	/**
	 * @return the salesPersonId
	 */
	public String getSalesPersonId() {
		return salesPersonId;
	}

	/**
	 * @param salesPersonId
	 *            the salesPersonId to set
	 */
	public void setSalesPersonId(String salesPersonId) {
		this.salesPersonId = salesPersonId;
	}

	/**
	 * @return the salesPersonFirstName
	 */
	public String getSalesPersonFirstName() {
		return salesPersonFirstName;
	}

	/**
	 * @param salesPersonFirstName
	 *            the salesPersonFirstName to set
	 */
	public void setSalesPersonFirstName(String salesPersonFirstName) {
		this.salesPersonFirstName = salesPersonFirstName;
	}

	/**
	 * @return the salesPersonLastName
	 */
	public String getSalesPersonLastName() {
		return salesPersonLastName;
	}

	/**
	 * @param salesPersonLastName
	 *            the salesPersonLastName to set
	 */
	public void setSalesPersonLastName(String salesPersonLastName) {
		this.salesPersonLastName = salesPersonLastName;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return Status;
	}

	/**
	 * @param status
	 *            the status to set
	 */
	public void setStatus(String status) {
		Status = status;
	}

	/**
	 * @return the jsonMessage
	 */
	public String getJsonMessage() {
		return jsonMessage;
	}

	/**
	 * @param jsonMessage
	 *            the jsonMessage to set
	 */
	public void setJsonMessage(String jsonMessage) {
		this.jsonMessage = jsonMessage;
	}

	/**
	 * @return the salesPersonDTOs
	 */
	public List<SalesPersonDTO> getSalesPersonDTOs() {
		return salesPersonDTOs;
	}

	/**
	 * @param salesPersonDTOs the salesPersonDTOs to set
	 */
	public void setSalesPersonDTOs(List<SalesPersonDTO> salesPersonDTOs) {
		this.salesPersonDTOs = salesPersonDTOs;
	}

}
