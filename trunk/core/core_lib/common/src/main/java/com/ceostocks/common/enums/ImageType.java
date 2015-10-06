package com.ceostocks.common.enums;

public enum ImageType {

	PROFILE_PIC(1), POST_IMAGE(2);

	private Integer imageCode;

	ImageType(Integer imageCode) {
		this.imageCode = imageCode;
	}

	/**
	 * @return the imageCode
	 */
	public Integer getImageCode() {
		return imageCode;
	}
}
