package com.ceostocks.application.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ceostocks.common.dto.cms.CmsUrlDTO;
import com.ceostocks.model.cms.CmsUrl;

public class CmsUrlDTOMapper {

	public static List<CmsUrlDTO> mapper(List<CmsUrl> cmsUrls) {
		List<CmsUrlDTO> cmsUrlDTOs = new ArrayList<>();
		if (cmsUrls != null) {
			cmsUrls.forEach(cmsUrl -> {
				cmsUrlDTOs.add(new CmsUrlDTO(cmsUrl.getId().toString(), cmsUrl.getName(), cmsUrl.getIsActive().toString()));
			});
		}
		return cmsUrlDTOs;
	}
}
