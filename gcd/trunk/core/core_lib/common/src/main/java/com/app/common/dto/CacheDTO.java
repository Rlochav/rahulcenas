/**
 * 
 */
package com.app.common.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class CacheDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5505290366971307760L;

	private Long cacheUpdatedAt;
	private Map<String, Map<String, String>> codeLkupKey1Map;
	private Map<String, Map<String, String>> codeLkupKey2Map;
	private Map<String, Map<String, String>> codeLkupKey3Map;
	private Map<String, String> appPropertyMap;
	private Map<String, String> roleMap;
	private Map<String, Object> auxMap = new HashMap<String, Object>();

	/**
	 * @return the cacheUpdatedAt
	 */
	public Long getCacheUpdatedAt() {
		return cacheUpdatedAt;
	}

	/**
	 * @param cacheUpdatedAt
	 *            the cacheUpdatedAt to set
	 */
	public void setCacheUpdatedAt(Long cacheUpdatedAt) {
		this.cacheUpdatedAt = cacheUpdatedAt;
	}

	/**
	 * @return the codeLkupKey1Map
	 */
	public Map<String, Map<String, String>> getCodeLkupKey1Map() {
		return codeLkupKey1Map;
	}

	/**
	 * @param codeLkupKey1Map
	 *            the codeLkupKey1Map to set
	 */
	public void setCodeLkupKey1Map(Map<String, Map<String, String>> codeLkupKey1Map) {
		this.codeLkupKey1Map = codeLkupKey1Map;
	}

	/**
	 * @return the codeLkupKey2Map
	 */
	public Map<String, Map<String, String>> getCodeLkupKey2Map() {
		return codeLkupKey2Map;
	}

	/**
	 * @param codeLkupKey2Map
	 *            the codeLkupKey2Map to set
	 */
	public void setCodeLkupKey2Map(Map<String, Map<String, String>> codeLkupKey2Map) {
		this.codeLkupKey2Map = codeLkupKey2Map;
	}

	/**
	 * @return the codeLkupKey3Map
	 */
	public Map<String, Map<String, String>> getCodeLkupKey3Map() {
		return codeLkupKey3Map;
	}

	/**
	 * @param codeLkupKey3Map
	 *            the codeLkupKey3Map to set
	 */
	public void setCodeLkupKey3Map(Map<String, Map<String, String>> codeLkupKey3Map) {
		this.codeLkupKey3Map = codeLkupKey3Map;
	}

	/**
	 * @return the appPropertyMap
	 */
	public Map<String, String> getAppPropertyMap() {
		return appPropertyMap;
	}

	/**
	 * @param appPropertyMap
	 *            the appPropertyMap to set
	 */
	public void setAppPropertyMap(Map<String, String> appPropertyMap) {
		this.appPropertyMap = appPropertyMap;
	}

	/**
	 * @return the roleMap
	 */
	public Map<String, String> getRoleMap() {
		return roleMap;
	}

	/**
	 * @param roleMap
	 *            the roleMap to set
	 */
	public void setRoleMap(Map<String, String> roleMap) {
		this.roleMap = roleMap;
	}

	/**
	 * @return the auxMap
	 */
	public Map<String, Object> getAuxMap() {
		return auxMap;
	}

	/**
	 * @param auxMap
	 *            the auxMap to set
	 */
	public void setAuxMap(Map<String, Object> auxMap) {
		this.auxMap = auxMap;
	}

}
