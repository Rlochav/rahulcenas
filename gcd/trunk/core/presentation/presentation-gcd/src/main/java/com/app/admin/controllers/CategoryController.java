package com.app.admin.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.getcitydealz.dto.CategoryDTO;
import com.app.getcitydealz.dto.SubCategoryDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.utility.common.IntUtil;

@Controller
public class CategoryController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Autowired
	public GetCityDealz getCityDealz;
	@Autowired
	public MerchantService merchantService;

	@RequestMapping(value = "/component/categories")
	public ModelAndView display(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/category&subcategory");
		try {
			String start = getRequestParam("start");
			String page = null;
			if (start == null) {
				start = "0";
			}
			page = ((IntUtil.getInteger(start) / 2) + 1) + "";
			mav.addObject("page", page);
			mav.addObject("start", start);
			CategoryDTO categoryDTO = getCityDealz.getAllCategories(userInfo, start);
			if (categoryDTO != null) {
				modelMap.put("categories", categoryDTO.getCategoryDTOs());
				modelMap.put("count", categoryDTO.getCount());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/addSubCategory")
	public ModelAndView addNewSubCategoryDisplay(ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("admin/addNewSubCategories");
		String categoryId = getRequestParam("categoryId");
		modelMap.put("categoryId", categoryId);
		String categoryName = getRequestParam("categoryName");
		modelMap.put("categoryName", categoryName);
		try {
			SubCategoryDTO subCategoryDTO = getCityDealz.getSubCategoryByCategoryId(userInfo, categoryId);
			if (subCategoryDTO != null)
				modelMap.put("subCategories", subCategoryDTO.getSubCategoryDTOs());

		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/editSubCategory")
	public ModelAndView editSubCategoryDisplay() {
		String btnName = "Add New";
		ModelAndView mav = new ModelAndView("admin/editSubCategory");
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
		Map<String, String> categoryMap = null;
		try {
			categoryMap = merchantService.getCategory(null);
			mav.addObject("categoryId", getRequestParam("categoryId"));			
			mav.addObject("subCategoryId", getRequestParam("subCategoryId"));
			if (getRequestParam("subCategoryId") != null)
				btnName = "Update";
			mav.addObject("subCategoryName", getRequestParam("subCategoryName"));
			mav.addObject("categoryMap", categoryMap);
			mav.addObject("editSubCategoryForm", subCategoryDTO);
			mav.addObject("btnName", btnName);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (categoryMap == null)
				categoryMap = new HashMap<String, String>();
		}
		return mav;
	}

	@RequestMapping(value = "/component/saveNewSubCategory")
	@ResponseBody
	public SubCategoryDTO saveNewSubCategory() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
		try {
			if (getRequestParam("categoryId") != null && !getRequestParam("categoryId").trim().isEmpty())
				subCategoryDTO.setCategoryId(getRequestParam("categoryId"));

			if (getRequestParam("subCategoryName") != null && !getRequestParam("subCategoryName").trim().isEmpty())
				subCategoryDTO.setSubCategoryName(getRequestParam("subCategoryName"));

			if (getRequestParam("subCategoryId") != null && !getRequestParam("subCategoryId").trim().isEmpty())
				subCategoryDTO.setSubCategoryId(getRequestParam("subCategoryId"));

			subCategoryDTO = getCityDealz.saveSubCategory(userInfo, subCategoryDTO);
		} catch (Exception e) {
			subCategoryDTO = new SubCategoryDTO();
			e.printStackTrace();
			if (e instanceof BaseException) {
				BaseException bEx = (BaseException) e;
				subCategoryDTO.setJsonMessage(bEx.getMsgCode());
			} else if (e.getCause() instanceof BusinessException) {
				BusinessException bEx = (BusinessException) e.getCause();
				subCategoryDTO.setJsonMessage(bEx.getMsgCode());
			} else {
				subCategoryDTO
						.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return subCategoryDTO;
	}

	@RequestMapping(value = "/component/addCategory")
	public ModelAndView addNewCategoryDisplay() {
		ModelAndView mav = new ModelAndView("admin/addNewCategory");
		return mav;
	}

	@RequestMapping(value = "/component/saveCategoryDetails")
	public ModelAndView addNewCategory(@ModelAttribute("categoryForm") CategoryDTO categoryDTO, ModelMap modelMap) {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		ModelAndView mav = new ModelAndView("redirect:/component/addCategory");
		try {
			CategoryDTO dto = getCityDealz.saveCategories(userInfo, categoryDTO);
			if (dto != null && dto.getCategoryId() != null)
				modelMap.put("message", "Category saved successfully");
		} catch (Exception e) {
			modelMap.put("message", e.getMessage());
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/component/jsonSaveCategoryDetails")
	@ResponseBody
	public CategoryDTO jsonSaveNewCategory() {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		CategoryDTO categoryDTO = new CategoryDTO();
		try {
			if (getRequestParam("categoryId") != null && !getRequestParam("categoryId").trim().isEmpty())
				categoryDTO.setCategoryId(getRequestParam("categoryId"));

			if (getRequestParam("categoryName") != null && !getRequestParam("categoryName").trim().isEmpty())
				categoryDTO.setCategoryName(getRequestParam("categoryName"));

			categoryDTO = getCityDealz.saveCategories(userInfo, categoryDTO);
		} catch (Exception e) {
			categoryDTO = new CategoryDTO();
			e.printStackTrace();
			if (e instanceof BaseException) {
				BaseException bEx = (BaseException) e;
				categoryDTO.setJsonMessage(bEx.getMsgCode());
			} else if (e.getCause() instanceof BusinessException) {
				BusinessException bEx = (BusinessException) e.getCause();
				categoryDTO.setJsonMessage(bEx.getMsgCode());
			} else {
				categoryDTO
						.setJsonMessage("Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator");
			}
		}
		return categoryDTO;
	}
}
