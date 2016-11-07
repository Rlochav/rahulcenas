package com.ceostocks.application.cms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceostocks.application.mapper.CmsUrlCategoryDTOMapper;
import com.ceostocks.application.mapper.CmsUrlDTOMapper;
import com.ceostocks.common.annotation.CeoStocksReqNewTxn;
import com.ceostocks.common.dto.cms.CmsUrlCategoryDTO;
import com.ceostocks.common.dto.cms.CmsUrlDTO;
import com.ceostocks.model.cms.CmsUrl;
import com.ceostocks.model.cms.CmsUrlCategory;
import com.ceostocks.services.cms.CmsService;

public class CmsApplicationImpl implements CmsApplication {

	@Autowired
	private CmsService cmsService;

	@Override
	public List<CmsUrlDTO> getCmsUrls(CmsUrlDTO cmsUrlDTO) {
		List<CmsUrl> cmsUrls = cmsService.getCmsUrls(cmsUrlDTO);
		List<CmsUrlDTO> cmsUrlDTOs = CmsUrlDTOMapper.mapper(cmsUrls);
		return cmsUrlDTOs;
	}

	@Override
	public List<CmsUrlCategoryDTO> getCmsCategoryUrls(String category) {
		List<CmsUrlCategory> cmsUrlCategories = cmsService.getCmsCategoryUrls(category);

		return CmsUrlCategoryDTOMapper.mapper(cmsUrlCategories);
	}

	@CeoStocksReqNewTxn
	public CmsUrlCategoryDTO saveCmsUrlCategory(CmsUrlCategoryDTO cmsUrlCategoryDTO) {
		return cmsService.saveCmsUrlCategory(cmsUrlCategoryDTO);
	}
}
