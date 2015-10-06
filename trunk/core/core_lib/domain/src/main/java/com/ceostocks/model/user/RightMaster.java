package com.ceostocks.model.user;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.ceostocks.common.base.Base;

@Entity
@Table(name = "RIGHT_MASTER")
public class RightMaster extends Base {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5364329818219304731L;

	@Id
	@GeneratedValue(generator = "seq_right_id", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "seq_right_id", sequenceName = "SQ_RIGHT_ID", allocationSize = 1)
	@Column(name = "RIGHT_ID")
	private BigDecimal rightId;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "PROCESS_ID")
	private String processId;
	@Column(name = "FUNCTION_CODE")
	private String functionCode;
	@Column(name = "FUNCTION_DESRC")
	private String functionDescr;
	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

	@OneToMany(mappedBy = "rightMaster", cascade = CascadeType.ALL)
	private List<RoleRightLink> roleRightLinks;

	/**
	 * @return the rightId
	 */
	public BigDecimal getRightId() {
		return rightId;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the processId
	 */
	public String getProcessId() {
		return processId;
	}

	/**
	 * @param processId
	 *            the processId to set
	 */
	public void setProcessId(String processId) {
		this.processId = processId;
	}

	/**
	 * @return the functionCode
	 */
	public String getFunctionCode() {
		return functionCode;
	}

	/**
	 * @param functionCode
	 *            the functionCode to set
	 */
	public void setFunctionCode(String functionCode) {
		this.functionCode = functionCode;
	}

	/**
	 * @return the functionDescr
	 */
	public String getFunctionDescr() {
		return functionDescr;
	}

	/**
	 * @param functionDescr
	 *            the functionDescr to set
	 */
	public void setFunctionDescr(String functionDescr) {
		this.functionDescr = functionDescr;
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
	 * @return the roleRightLinks
	 */
	public List<RoleRightLink> getRoleRightLinks() {
		return roleRightLinks;
	}

	/**
	 * @param roleRightLinks
	 *            the roleRightLinks to set
	 */
	public void setRoleRightLinks(List<RoleRightLink> roleRightLinks) {
		this.roleRightLinks = roleRightLinks;
	}

}
