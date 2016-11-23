package com.app.mvc.homePage;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.common.interceptor.SupportClass;
import com.app.deal.dto.DealzDTO;
import com.app.getcitydealz.dto.CategoryDTO;
import com.app.getcitydealz.dto.NeighborhoodDTO;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.mvc.common.AppWebHandler;

@Controller
public class SearchAutoCompleteController extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4849728059088876598L;

	@Autowired
	private GetCityDealz getCityDealz;

	@RequestMapping("/searchQuery")
	public String searchQuery(ModelMap modelMap) {
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		Map<String, String> queryResultMap = new LinkedHashMap<String, String>();
		try {
			modelMap.put("cityDTO", getCityDealz.getCityDetails(cityId));
			if (!StringUtils.isEmpty(getRequestParam("query")))
				queryResultMap = getCityDealz.getAutoQuery(getRequestParam("query"));

			modelMap.put("query", getRequestParam("query"));

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				modelMap.put("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				modelMap.put("categoryDTO", categoryDTO.getCategoryDTOs());

			DealzDTO dealzDTO = getCityDealz.getAllDealsByMasterCategory(userInfo, "NightLife");
			if (dealzDTO != null && dealzDTO.getDealzDTOs() != null)
				modelMap.put("deals", dealzDTO.getDealzDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		modelMap.addAttribute("queryResultMap", queryResultMap);
		return "homePage/searchResult";
	}
}
