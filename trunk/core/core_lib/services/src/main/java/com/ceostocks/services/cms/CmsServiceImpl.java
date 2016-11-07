package com.ceostocks.services.cms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.dto.cms.CmsUrlCategoryDTO;
import com.ceostocks.common.dto.cms.CmsUrlDTO;
import com.ceostocks.common.util.IntUtil;
import com.ceostocks.model.cms.CmsFixedLocationContentRepository;
import com.ceostocks.model.cms.CmsPageRepository;
import com.ceostocks.model.cms.CmsUrl;
import com.ceostocks.model.cms.CmsUrlCategory;
import com.ceostocks.model.cms.CmsUrlCategoryRepository;
import com.ceostocks.model.cms.CmsUrlRepository;

@Service
public class CmsServiceImpl implements CmsService {

	@Autowired
	private CmsFixedLocationContentRepository cmsFixedLocationContentRepository;
	@Autowired
	private CmsPageRepository cmsPageRepository;
	@Autowired
	private CmsUrlRepository cmsUrlRepository;
	@Autowired
	private CmsUrlCategoryRepository cmsUrlCategoryRepository;
	@Autowired
	private UserInfo userInfo;

	@Override
	public List<CmsUrl> getCmsUrls(CmsUrlDTO cmsUrlDTO) {

		return null;
	}

	@Override
	public List<CmsUrlCategory> getCmsCategoryUrls(String categoryType) {

		return cmsUrlCategoryRepository.getCmsUrlsCategoryByType(IntUtil.getInteger(categoryType));
	}

	@Override
	public CmsUrlCategoryDTO saveCmsUrlCategory(CmsUrlCategoryDTO cmsUrlCtgDTO) {
		/*CmsUrlCategory cmsUrlCategory = new CmsUrlCategory(cmsUrlCtgDTO.getName(), new Boolean(cmsUrlCtgDTO.getIsActive()),
				IntUtil.getInteger(cmsUrlCtgDTO.getCategoryType()));
		cmsUrlCategoryRepository.save(cmsUrlCategory);*/
		System.out.println(userInfo.getUserIndex());
		return cmsUrlCtgDTO;
	}
}
