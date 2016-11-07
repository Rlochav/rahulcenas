package com.ceostocks.application.cms;

import java.util.List;

import com.ceostocks.common.dto.cms.CmsUrlCategoryDTO;
import com.ceostocks.common.dto.cms.CmsUrlDTO;

public interface CmsApplication {

	List<CmsUrlDTO> getCmsUrls(CmsUrlDTO cmsUrlDTO);

	List<CmsUrlCategoryDTO> getCmsCategoryUrls(String category);

	CmsUrlCategoryDTO saveCmsUrlCategory(CmsUrlCategoryDTO cmsUrlCategoryDTO);

}
