package com.app.admin.controllers;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.getcitydealz.dto.IconsDTO;

public class IconFeilds implements Serializable {
	private String iconId;
	private String iconName;
	private String iconUrl;
	private MultipartFile iconImage;
	private String jsonMessage;
	public List<IconsDTO> iconsDTOs;

	/**
	 * @return the iconId
	 */
	public String getIconId() {
		return iconId;
	}

	/**
	 * @param iconId
	 *            the iconId to set
	 */
	public void setIconId(String iconId) {
		this.iconId = iconId;
	}

	/**
	 * @return the iconName
	 */
	public String getIconName() {
		return iconName;
	}

	/**
	 * @param iconName
	 *            the iconName to set
	 */
	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	/**
	 * @return the iconUrl
	 */
	public String getIconUrl() {
		return iconUrl;
	}

	/**
	 * @param iconUrl
	 *            the iconUrl to set
	 */
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	/**
	 * @return the iconImage
	 */
	public MultipartFile getIconImage() {
		return iconImage;
	}

	/**
	 * @param iconImage
	 *            the iconImage to set
	 */
	public void setIconImage(MultipartFile iconImage) {
		this.iconImage = iconImage;
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
	 * @return the iconsDTOs
	 */
	public List<IconsDTO> getIconsDTOs() {
		return iconsDTOs;
	}

	/**
	 * @param iconsDTOs
	 *            the iconsDTOs to set
	 */
	public void setIconsDTOs(List<IconsDTO> iconsDTOs) {
		this.iconsDTOs = iconsDTOs;
	}

}
