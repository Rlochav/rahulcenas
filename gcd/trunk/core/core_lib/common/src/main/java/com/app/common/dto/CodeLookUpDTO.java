package com.app.common.dto;

import java.util.List;

import com.app.base.dto.BaseDTO;

public class CodeLookUpDTO extends BaseDTO {

	private static final long serialVersionUID = 1L;

	private String lkupCode;
	private String keyCode;
	private String key1;
	private String key2;
	private String key3;
	private String key4;
	private String key5;
	private String key3Text;

	/**
	 * @return the key3Text
	 */
	public String getKey3Text() {
		return key3Text;
	}

	/**
	 * @param key3Text
	 *            the key3Text to set
	 */
	public void setKey3Text(String key3Text) {
		this.key3Text = key3Text;
	}

	private List<CodeLookUpDTO> codeLookUpDTOList;

	/**
	 * @return the codeLookUpDTOList
	 */
	public List<CodeLookUpDTO> getCodeLookUpDTOList() {
		return codeLookUpDTOList;
	}

	/**
	 * @param codeLookUpDTOList
	 *            the codeLookUpDTOList to set
	 */
	public void setCodeLookUpDTOList(List<CodeLookUpDTO> codeLookUpDTOList) {
		this.codeLookUpDTOList = codeLookUpDTOList;
	}

	/**
	 * @return the lkupCode
	 */
	public String getLkupCode() {
		return lkupCode;
	}

	/**
	 * @param lkupCode
	 *            the lkupCode to set
	 */
	public void setLkupCode(String lkupCode) {
		this.lkupCode = lkupCode;
	}

	/**
	 * @return the keyCode
	 */
	public String getKeyCode() {
		return keyCode;
	}

	/**
	 * @param keyCode
	 *            the keyCode to set
	 */
	public void setKeyCode(String keyCode) {
		this.keyCode = keyCode;
	}

	/**
	 * @return the key1
	 */
	public String getKey1() {
		return key1;
	}

	/**
	 * @param key1
	 *            the key1 to set
	 */
	public void setKey1(String key1) {
		this.key1 = key1;
	}

	/**
	 * @return the key2
	 */
	public String getKey2() {
		return key2;
	}

	/**
	 * @param key2
	 *            the key2 to set
	 */
	public void setKey2(String key2) {
		this.key2 = key2;
	}

	/**
	 * @return the key3
	 */
	public String getKey3() {
		return key3;
	}

	/**
	 * @param key3
	 *            the key3 to set
	 */
	public void setKey3(String key3) {
		this.key3 = key3;
	}

	/**
	 * @return the key4
	 */
	public String getKey4() {
		return key4;
	}

	/**
	 * @param key4
	 *            the key4 to set
	 */
	public void setKey4(String key4) {
		this.key4 = key4;
	}

	/**
	 * @return the key5
	 */
	public String getKey5() {
		return key5;
	}

	/**
	 * @param key5
	 *            the key5 to set
	 */
	public void setKey5(String key5) {
		this.key5 = key5;
	}

}
