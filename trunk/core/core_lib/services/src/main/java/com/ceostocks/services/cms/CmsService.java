package com.ceostocks.services.cms;

import java.util.List;

import com.ceostocks.common.dto.cms.CmsUrlCategoryDTO;
import com.ceostocks.common.dto.cms.CmsUrlDTO;
import com.ceostocks.model.cms.CmsUrl;
import com.ceostocks.model.cms.CmsUrlCategory;

public interface CmsService {

	List<CmsUrl> getCmsUrls(CmsUrlDTO cmsUrlDTO);

	List<CmsUrlCategory> getCmsCategoryUrls(String category);

	CmsUrlCategoryDTO saveCmsUrlCategory(CmsUrlCategoryDTO cmsUrlCategoryDTO);

}
