package com.ceostocks.mvc.product;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ceostocks.application.ecom.CategoriesApplication;
import com.ceostocks.common.dto.SubCategoryDTO;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.common.util.IntUtil;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
@RequestMapping("/component/")
public class ProductSubCategoryController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7093370780747685895L;

	@Autowired
	private CategoriesApplication categoriesApplication;

	@RequestMapping(value = CeoUrls.CEO_OPEN_SUB_CATEGORY_MASTER)
	public ModelAndView displaySubCategoryMaster() {
		ModelAndView mav = new ModelAndView("product/subCategoryMaster");
		Map<String, String> categoryMap = null;
		try {
			categoryMap = categoriesApplication.getCategoryMap();
			mav.addObject("categoryMap", mapper.writeValueAsString(categoryMap));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (categoryMap == null)
				categoryMap = new HashMap<String, String>();
		}

		return mav;
	}

	@RequestMapping(value = CeoUrls.CEO_SAVE_SUB_CATEGORY, method = RequestMethod.POST)
	@ResponseBody
	public SubCategoryDTO saveSubCategory() {
		SubCategoryDTO sbCDto = null;
		try {
			String categoryId = getRequestParam("categoryId");
			String subCategoryCode = getRequestParam("sCategoryCode");
			String subCategoryName = getRequestParam("sCategoryName");
			sbCDto = new SubCategoryDTO(categoryId, subCategoryCode, subCategoryName);
			sbCDto = categoriesApplication.saveSubCategory(sbCDto);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (sbCDto == null)
				sbCDto = new SubCategoryDTO();
		}
		return sbCDto;
	}

	@RequestMapping(value = CeoUrls.CEO_SEARCH_SUB_CATEGORY)
	@ResponseBody
	public SubCategoryDTO searchSubCategory() {
		SubCategoryDTO subCategoryDTO = null;
		try {
			Integer start = IntUtil.getInteger(getRequestParam("start"));
			Integer count = IntUtil.getInteger(getRequestParam("count"));
			subCategoryDTO = categoriesApplication.searchSubCategory(start, count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return subCategoryDTO;
	}
}
