package com.ceostocks.application.mapper;

import java.util.ArrayList;
import java.util.List;

import com.ceostocks.common.dto.cms.CmsUrlCategoryDTO;
import com.ceostocks.model.cms.CmsUrlCategory;

public class CmsUrlCategoryDTOMapper {

	public static List<CmsUrlCategoryDTO> mapper(List<CmsUrlCategory> cmsUrlCategories) {
		List<CmsUrlCategoryDTO> urlCategoryDTOs = new ArrayList<>();
		if (cmsUrlCategories != null) {
			cmsUrlCategories.forEach(urlCtgs -> {
				urlCategoryDTOs.add(new CmsUrlCategoryDTO(urlCtgs.getId().toString(), urlCtgs.getName(), urlCtgs.getIsActive().toString(),
						urlCtgs.getCategoryType().toString(), CmsUrlDTOMapper.mapper(new ArrayList<>(urlCtgs.getCmsUrls()))));
			});
		}
		return urlCategoryDTOs;
	}
}
