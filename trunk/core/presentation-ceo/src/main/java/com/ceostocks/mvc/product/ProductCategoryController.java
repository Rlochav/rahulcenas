package com.ceostocks.mvc.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ceostocks.application.ecom.CategoriesApplication;
import com.ceostocks.application.mapper.CategoryDTOMapper;
import com.ceostocks.common.dto.CategoryDTO;
import com.ceostocks.common.handler.CeoStocksWebHandler;
import com.ceostocks.common.util.IntUtil;
import com.ceostocks.mvc.urls.CeoUrls;

@Controller
@RequestMapping("/component/")
public class ProductCategoryController extends CeoStocksWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 732438622940221351L;

	@Autowired
	private CategoriesApplication categoriesApplication;

	@RequestMapping(value = CeoUrls.CEO_OPEN_CATEGORY_MASTER)
	public ModelAndView displayCategoryMaster() {

		return new ModelAndView("product/categoryMaster");
	}

	@RequestMapping(value = CeoUrls.CEO_SAVE_CATEGORY, method = RequestMethod.POST)
	@ResponseBody
	public CategoryDTO saveCategory() {
		CategoryDTO cDto = null;
		try {
			String categoryCode = getRequestParam("categoryCode");
			String categoryName = getRequestParam("categoryName");
			cDto = new CategoryDTO(categoryCode, categoryName);
			cDto = categoriesApplication.saveCategory(CategoryDTOMapper.categoryDtoToEntityMapper(cDto));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cDto == null)
				cDto = new CategoryDTO();
		}
		return cDto;
	}

	@RequestMapping(value = CeoUrls.CEO_SEARCH_CATEGORY)
	@ResponseBody
	public CategoryDTO searchCategory() {
		CategoryDTO categoryDTO = null;
		try {
			Integer start = IntUtil.getInteger(getRequestParam("start"));
			Integer count = IntUtil.getInteger(getRequestParam("count"));
			categoryDTO = categoriesApplication.searchCategory(start, count);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return categoryDTO;
	}
}
