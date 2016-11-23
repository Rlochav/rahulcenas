package com.app.admin.controllers;

import static org.springframework.util.CollectionUtils.isEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.common.dto.GcdMetaDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.mvc.common.AppWebHandler;

@Controller
public class GcdMetaPageController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4623662541245853191L;

	@Autowired
	private GetCityDealz getCityDealz;

	@RequestMapping(value = "/component/pageList")
	public ModelAndView displayPageList() {
		ModelAndView mav = new ModelAndView("admin/gcdMetaPageList");
		try {
			GcdMetaDTO dto = getCityDealz.getListOfPages();
			if (dto != null && !isEmpty(dto.getGcdMetaDTOs())) {
				mav.addObject("dto", dto.getGcdMetaDTOs());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/pageEditor")
	public ModelAndView displayPageMatster(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("admin/gcdMetaPageMaster");
		try {
			String id = getRequestParam("id");
			GcdMetaDTO dto = getCityDealz.getPageDetailsById(id);
			if (dto == null) {
				dto = new GcdMetaDTO();
			}
			modelMap.put("metaDTO", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/savePageMaster")
	public String savePageMaster(@ModelAttribute GcdMetaDTO dto) {
		try {
			String msg = getCityDealz.savePageMaster(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/component/pageList";
	}

	@RequestMapping(value = "/component/righHandRails")
	public String displayRighHandRails(ModelMap mav) {
		try {
			GcdMetaDTO dto = getCityDealz.getListOfRightHandRails();
			if (dto != null && !isEmpty(dto.getGcdMetaDTOs())) {
				mav.addAttribute("dto", dto.getGcdMetaDTOs());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "admin/gcdMetaRightHandRailsList";
	}

	@RequestMapping(value = "/rightHandRailEditor")
	public ModelAndView displayRighHandRailsMaster(ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("admin/gcdMetaRightHandRailsMaster");
		try {
			String id = getRequestParam("id");
			GcdMetaDTO dto = getCityDealz.getRighHandRailDetailsById(id);
			if (dto == null) {
				dto = new GcdMetaDTO();
			}
			modelMap.put("metaDTO", dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/saveRightHandRails")
	public String saveRightHandRails(@ModelAttribute GcdMetaDTO dto, RedirectAttributes redirectAttributes) {
		try {
			dto.setShowOnPage(dto.getShowOnPage() == null ? "0" : "1");
			String msg = getCityDealz.saveRightHandRails(dto);
			redirectAttributes.addFlashAttribute("message", "Deails saved successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/component/righHandRails";
	}
}
