package com.ceostocks.mvc.cms;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ceostocks.application.cms.CmsApplication;
import com.ceostocks.common.dto.UserInfo;
import com.ceostocks.common.dto.cms.CmsUrlCategoryDTO;
import com.ceostocks.common.dto.cms.CmsUrlDTO;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
@RequestMapping("/component/")
public class CmsController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1711330012421000038L;

	@Autowired
	private CmsApplication cmsApplication;
	@Autowired
	private UserInfo userInfo;

	@RequestMapping(value = CeoUrls.CEO_CMS_PAGE_LIST)
	public String displayCmsPageList() {
		return "cms/cmsPageList";
	}

	@RequestMapping(value = CeoUrls.CEO_CMS_PAGE_CONTENT_EDITOR)
	public String displayCmsPageContentEditor() {
		return "cms/cmsPageContentEditor";
	}

	@RequestMapping(value = CeoUrls.CEO_CMS_URL_LIST)
	public String displayCmsUrlList() {
		return "cms/cmsUrlList";
	}

	@RequestMapping(value = CeoUrls.CEO_CMS_URL_MASTER)
	public String displayCmsUrlMaster() {
		return "cms/cmsUrlMaster";
	}

	@RequestMapping(value = CeoUrls.CEO_CMS_MENU_LIST)
	public String displayCmsMenuList() {
		return "cms/cmsMenuList";
	}

	@RequestMapping(value = CeoUrls.CEO_CMS_MENU_MASTER)
	public String displayCmsMenuMaster() {
		return "cms/cmsMenuMaster";
	}

	@RequestMapping(value = CeoUrls.CEO_CMS_CONTENT_LIST)
	public String displayCmsContentList() {
		return "cms/cmsContentList";
	}
	
	@RequestMapping(value = CeoUrls.CEO_CMS_URL_CATEGORY_MASTER)
	public String displayCmsUrlCategoryMaster() {
		return "cms/cmsUrlCategoryMaster";
	}

	@RequestMapping(value = CeoUrls.CEO_CMS_GET_CMS_URLS)
	@ResponseBody
	public List<CmsUrlDTO> getCmsUrls(@RequestBody CmsUrlDTO cmsUrlDTO) {
		try {
			return cmsApplication.getCmsUrls(cmsUrlDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@RequestMapping(value = CeoUrls.CEO_CMS_GET_CMS_URLS_CATEGORY)
	@ResponseBody
	public List<CmsUrlCategoryDTO> getCmsCategoryUrls(@RequestBody String category) {
		try {
			return cmsApplication.getCmsCategoryUrls(category);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@RequestMapping(value = CeoUrls.CEO_CMS_SAVE_CMS_URL_CATEGORY)
	@ResponseBody
	public CmsUrlCategoryDTO saveCmsUrlCategory(@RequestBody CmsUrlCategoryDTO cmsUrlCategoryDTO) {
		try {
			System.out.println(userInfo.getUserIndex());
			return cmsApplication.saveCmsUrlCategory(cmsUrlCategoryDTO);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
