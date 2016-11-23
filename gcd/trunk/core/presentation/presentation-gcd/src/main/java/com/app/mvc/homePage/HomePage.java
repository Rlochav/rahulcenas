package com.app.mvc.homePage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.common.dto.CommonFormDTO;
import com.app.common.dto.GcdMetaDTO;
import com.app.common.interceptor.SupportClass;
import com.app.commonexception.BaseException;
import com.app.deal.dto.DealzDTO;
import com.app.getcitydealz.dto.CategoryDTO;
import com.app.getcitydealz.dto.CityDTO;
import com.app.getcitydealz.dto.DocumentDTO;
import com.app.getcitydealz.dto.EmbedsDTO;
import com.app.getcitydealz.dto.IconsDTO;
import com.app.getcitydealz.dto.LocationDTO;
import com.app.getcitydealz.dto.MerchantDTO;
import com.app.getcitydealz.dto.NeighborhoodDTO;
import com.app.getcitydealz.dto.SocialConnectionsDTO;
import com.app.getcitydealz.dto.SubCategoryDTO;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.getcitydealz.service.GetCityDealz;
import com.app.login.dto.UserInfo;
import com.app.model.getcitydealz.MerchantMaster;
import com.app.mvc.common.AppWebConstant;
import com.app.mvc.common.AppWebHandler;
import com.app.post.dto.PostDTO;
import com.app.social.connect.GCDFacebookUtil;
import com.app.social.connect.GCDTwitterUtil;
import com.app.social.connect.InstagramUtil;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.IntUtil;
import com.app.utility.common.StringUtil;

@Controller
public class HomePage extends AppWebHandler {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7167846822602659278L;

	@Autowired
	private GetCityDealz getCityDealz;
	@Autowired
	private MerchantService merchantService;

	@RequestMapping(value = "/checkpoint")
	public ModelAndView commonLoginDisplay() {
		ModelAndView mav = new ModelAndView("homePage/login");
		return mav;
	}

	// Start Changes
	// 6/22/2014............................................................................................................

	@RequestMapping(value = "/index")
	public ModelAndView displayIndex(ModelMap modelMap) {
		UserInfo userInfo = new UserInfo();
		ModelAndView mav = new ModelAndView("homePage/homePage");
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);

		try {
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());
			String upcoming = "0";
			String start = getRequestParam("start");
			String page = null;
			if (start == null) {
				start = "0";
			}
			page = ((IntUtil.getInteger(start) / 10) + 1) + "";
			mav.addObject("page", page);
			mav.addObject("start", start);

			if (cityId != null) {
				mav.addObject("cityName", "Local Daily Deals For " + getCityDealz.getCityText(cityId));
			}

			List<DealzDTO> dealzDTOs = getCityDealz.getAllDealz(userInfo, cityId, upcoming, start);
			if (dealzDTOs != null) {
				mav.addObject("dealzs", dealzDTOs);
				modelMap.put("count", (dealzDTOs.get(0)).getCounts());
				modelMap.put("totalPage", Math.ceil((double) IntUtil.getInteger((dealzDTOs.get(0)).getCounts()) / 10));
			}
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/getdeals-city")
	public ModelAndView gcdCitys(ModelMap modelMap, HttpServletRequest request) throws BaseException {
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(request.toString());
		userInfo.setCityId(cityId);
		CommonFormDTO formDTO = new CommonFormDTO();
		ModelAndView mav = new ModelAndView("homePage/getdeals-city");
		String queryParam = getRequestParam("q");
		NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
		if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
			mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		mav.addObject("q", queryParam);
		String requestedPath = request.getHeader("Referer");
		CityDTO cityDTO = getCityDealz.getAllCityDetails(userInfo);
		boolean CAN_BE_REDIRECT = false;
		System.out.println("URL: " + requestedPath);
		if (cityDTO != null && cityDTO.getCityDTOs() != null && cityDTO.getCityDTOs().size() > 0) {
			for (CityDTO dto : cityDTO.getCityDTOs()) {
				if (requestedPath != null && requestedPath.indexOf(dto.getCityCode()) > 0) {
					System.out.println(requestedPath.indexOf(dto.getCityCode()) + "    " + dto.getCityCode());
					CAN_BE_REDIRECT = true;
					break;
				}
			}
		}
		if (CAN_BE_REDIRECT) {
			String qParam = getRequestParam("q");
			switch (qParam) {
			case "email": {
				mav = new ModelAndView("redirect:/subscribe");
				break;
			}
			case "map": {
				mav = new ModelAndView("redirect:/dealzByMap/DealsOnMap");
				break;
			}
			case "mList": {
				mav = new ModelAndView("redirect:/new-orleans-merchant-listing");
				break;
			}
			}
		}

		Map<String, String> cityMap = null;
		try {
			cityMap = getCityDealz.getCityMap(userInfo);
			mav.addObject("cityMap", cityMap);
			mav.addObject("chooseCityForm", formDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cityMap == null)
				cityMap = new HashMap<String, String>();
		}
		return mav;
	}

	@RequestMapping(value = "/redirectToGcdCity")
	public String redirectToGcdCity(ModelMap modelMap) {
		return "homePage/redirect";
	}

	// End
	// Changes............................................................................................................

	/*
	 * @RequestMapping(value = "/dev") public ModelAndView display(ModelMap
	 * modelMap) { UserInfo userInfo = new UserInfo(); ModelAndView mav = new
	 * ModelAndView("homePage/homePage"); String cityId = new
	 * SupportClass().getCityId(getRequest().getRequestURL().toString());
	 * userInfo.setCityId(cityId);
	 * 
	 * try { CategoryDTO categoryDTO =
	 * getCityDealz.getAllCategoriesOnly(userInfo);
	 * mav.addObject("subdomainUrl",
	 * AppPropertyBuilder.getProperty("sub.domain.url", "01")); if (categoryDTO
	 * != null && categoryDTO.getCategoryDTOs() != null)
	 * mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs()); String
	 * upcoming = "0"; String start = getRequestParam("start"); String page =
	 * null; if (start == null) { start = "0"; } page =
	 * ((IntUtil.getInteger(start) / 10) + 1) + ""; mav.addObject("page", page);
	 * mav.addObject("start", start);
	 * 
	 * if (cityId != null) { mav.addObject("cityName", "Local Daily Deals For "
	 * + getCityDealz.getCityText(cityId)); }
	 * 
	 * List<DealzDTO> dealzDTOs = getCityDealz.getAllDealz(userInfo, cityId,
	 * upcoming, start); if (dealzDTOs != null) { mav.addObject("dealzs",
	 * dealzDTOs); modelMap.put("count", (dealzDTOs.get(0)).getCounts());
	 * modelMap.put("totalPage", Math.ceil((double)
	 * IntUtil.getInteger((dealzDTOs.get(0)).getCounts()) / 10)); }
	 * NeighborhoodDTO neighborhoodDTO =
	 * getCityDealz.getNeighborhoodsAndCountDealz(userInfo); if (neighborhoodDTO
	 * != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
	 * mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs()); } catch
	 * (Exception e) { e.printStackTrace(); } return mav; }
	 */

	@RequestMapping(value = "/merchant-login-city")
	public ModelAndView citieslistDisplay() throws BaseException {
		UserInfo userInfo = getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO) != null ? (UserInfo) getSessionAttribute(AppWebConstant.SESSION_ATTR_USER_INFO)
				: null;
		if (userInfo == null)
			userInfo = new UserInfo();
		CommonFormDTO formDTO = new CommonFormDTO();
		ModelAndView mav = new ModelAndView("homePage/merchant-login-city");
		String requestedPath = getRequest().getHeader("Referer");

		if (requestedPath == null)
			return new ModelAndView("redirect:/index");

		NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
		if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
			mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());

		CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
		mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
		if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
			mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

		CityDTO cityDTO = getCityDealz.getAllCityDetails(userInfo);
		boolean CAN_BE_REDIRECT = false;
		System.out.println("URL: " + requestedPath);
		if (cityDTO != null && cityDTO.getCityDTOs() != null && cityDTO.getCityDTOs().size() > 0) {
			for (CityDTO dto : cityDTO.getCityDTOs()) {
				System.out.println(requestedPath.indexOf(dto.getCityCode()) + "    " + dto.getCityCode());
				if (requestedPath.indexOf(dto.getCityCode()) > 0) {
					CAN_BE_REDIRECT = true;
					break;
				}
			}
		}
		if (CAN_BE_REDIRECT)
			mav = new ModelAndView("redirect:/merchant-signin");
		System.out.println(CAN_BE_REDIRECT);
		Map<String, String> cityMap = null;
		try {
			cityMap = getCityDealz.getCityMap(userInfo);
			mav.addObject("cityMap", cityMap);
			mav.addObject("chooseCityForm", formDTO);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cityMap == null)
				cityMap = new HashMap<String, String>();
		}
		return mav;
	}

	@RequestMapping(value = "/redirectToCityLink")
	public String redirectToCityLink() {
		return "homePage/redirect";
	}

	@RequestMapping(value = "/merchant-signin")
	public ModelAndView merchantLoginDisplay(ModelMap modelMap) {
		UserInfo userInfo = new UserInfo();
		ModelAndView mav = new ModelAndView("homePage/cityHomePage");
		MerchantMaster merchantMaster = new MerchantMaster();
		modelMap.put("merchantMaster", merchantMaster);
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
		try {
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/dealsbymaincategory/dining")
	public ModelAndView diningDisplay() {
		UserInfo userInfo = new UserInfo();
		ModelAndView mav = new ModelAndView("category/dining");
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);

		mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
		try {
			mav.addObject("cityDTO", getCityDealz.getCityDetails(cityId));
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			DealzDTO dealzDTO = getCityDealz.getAllDealsByMasterCategory(userInfo, "Dining");
			if (dealzDTO != null && dealzDTO.getDealzDTOs() != null)
				mav.addObject("deals", dealzDTO.getDealzDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/dealsbymaincategory/attractions")
	public ModelAndView attractionsDisplay() {
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		ModelAndView mav = new ModelAndView("category/attractions");

		mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
		try {
			mav.addObject("cityDTO", getCityDealz.getCityDetails(cityId));
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			DealzDTO dealzDTO = getCityDealz.getAllDealsByMasterCategory(userInfo, "Attractions");
			if (dealzDTO != null && dealzDTO.getDealzDTOs() != null)
				mav.addObject("deals", dealzDTO.getDealzDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/dealsbymaincategory/night-life")
	public ModelAndView nightLifeDisplay() {
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		ModelAndView mav = new ModelAndView("category/nightLife");

		mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
		try {
			mav.addObject("cityDTO", getCityDealz.getCityDetails(cityId));
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			DealzDTO dealzDTO = getCityDealz.getAllDealsByMasterCategory(userInfo, "NightLife");
			if (dealzDTO != null && dealzDTO.getDealzDTOs() != null)
				mav.addObject("deals", dealzDTO.getDealzDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/dealsbymaincategory/recreation")
	public ModelAndView recreationDisplay() {
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		ModelAndView mav = new ModelAndView("category/recreation");

		mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
		try {
			mav.addObject("cityDTO", getCityDealz.getCityDetails(cityId));
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			DealzDTO dealzDTO = getCityDealz.getAllDealsByMasterCategory(userInfo, "Recreation");
			if (dealzDTO != null && dealzDTO.getDealzDTOs() != null)
				mav.addObject("deals", dealzDTO.getDealzDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/dealsbymaincategory/services")
	public ModelAndView servicesDisplay() {
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		ModelAndView mav = new ModelAndView("category/services");
		mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
		try {
			mav.addObject("cityDTO", getCityDealz.getCityDetails(cityId));
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			DealzDTO dealzDTO = getCityDealz.getAllDealsByMasterCategory(userInfo, "Services");
			if (dealzDTO != null && dealzDTO.getDealzDTOs() != null)
				mav.addObject("deals", dealzDTO.getDealzDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/dealsbymaincategory/shopping")
	public ModelAndView shoppingDisplay() {
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		ModelAndView mav = new ModelAndView("category/shopping");
		mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
		try {
			mav.addObject("cityDTO", getCityDealz.getCityDetails(cityId));
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			DealzDTO dealzDTO = getCityDealz.getAllDealsByMasterCategory(userInfo, "Shopping");
			if (dealzDTO != null && dealzDTO.getDealzDTOs() != null)
				mav.addObject("deals", dealzDTO.getDealzDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/dealsbyarea/{neighborhoodName}-{neighborhoodId}")
	public ModelAndView dealsbyareaDisplay(@PathVariable String neighborhoodId) {
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		ModelAndView mav = new ModelAndView("dealzByNeighborhood/dealzByNeighborhood");
		mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
		try {
			mav.addObject("cityDTO", getCityDealz.getCityDetails(cityId));
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			NeighborhoodDTO nDto = getCityDealz.getNeighborhoodsName(userInfo, neighborhoodId);
			List<DealzDTO> dealzDTOs = getCityDealz.getAllDealzByNeighborhoodId(userInfo, neighborhoodId);

			if (cityId != null) {
				mav.addObject("cityName", "in " + getCityDealz.getCityText(cityId));
			}

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			if (nDto != null)
				mav.addObject("nDto", nDto);
			if (dealzDTOs != null)
				mav.addObject("dealzs", dealzDTOs);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/dealsbycategory/{categoryName}-{categoryId}")
	public ModelAndView dealsbycategoryDisplay(@PathVariable String categoryId) {
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		ModelAndView mav = new ModelAndView("dealsbycategory/dealsbycategory");

		mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
		try {
			mav.addObject("cityDTO", getCityDealz.getCityDetails(cityId));
			String categoryName = getCityDealz.getCategoryName(categoryId);
			mav.addObject("categoryNames", categoryName);
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());
			List<DealzDTO> dealzDTOs = getCityDealz.getAllDealzByCategoryId(userInfo, categoryId);
			if (dealzDTOs != null)
				mav.addObject("dealzs", dealzDTOs);
			List<SubCategoryDTO> subCategoryDTO = merchantService.getSubCategoryListByCategoryId(userInfo, categoryId);
			Map<String, List<SubCategoryDTO>> subCtgByCtgId = new HashMap<String, List<SubCategoryDTO>>();
			subCtgByCtgId.put(categoryId, subCategoryDTO);
			mav.addObject("subCtgByCtgId", subCtgByCtgId);
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/dealsbysubcategory/{categoryName}-{categoryId}/{subcategoryName}-{subcategoryId}")
	public ModelAndView dealsbysubcategoryDisplay(@PathVariable("categoryId") String categoryId, @PathVariable("subcategoryId") String subcategoryId) {
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		ModelAndView mav = new ModelAndView("dealsbycategory/ealsbysubcategory");
		mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
		try {
			String subCategoryName = getCityDealz.getSubCategoryName(categoryId, subcategoryId);
			mav.addObject("subCategoryName", subCategoryName);

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			List<DealzDTO> dealzDTOs = getCityDealz.getAllDelsByCategoryAndSubCategoryId(userInfo, categoryId, subcategoryId);
			if (dealzDTOs != null)
				mav.addObject("dealzs", dealzDTOs);

			Map<String, List<SubCategoryDTO>> subCtgByCtgId = new HashMap<String, List<SubCategoryDTO>>();
			List<SubCategoryDTO> subCategoryDTO = merchantService.getSubCategoryListByCategoryId(userInfo, categoryId);

			subCtgByCtgId.put(categoryId, subCategoryDTO);
			mav.addObject("subCtgByCtgId", subCtgByCtgId);
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/new-orleans-merchant-listing")
	public ModelAndView cityWiseMerchantListDisplay() {
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		ModelAndView mav = new ModelAndView("homePage/cityWiseMerchantList");
		try {
			MerchantDTO mDtoAH = getCityDealz.getMerchantListInRange(userInfo, "REGEXP '^[^i-z 0-9]'", 1);
			mav.addObject("mDtoAH", mDtoAH.getMerchantDTOs());
			MerchantDTO mDtoIP = getCityDealz.getMerchantListInRange(userInfo, "'I%' AND 'Q%'", null);
			if (mDtoIP != null)
				mav.addObject("mDtoIP", mDtoIP.getMerchantDTOs());
			MerchantDTO mDtoQZ = getCityDealz.getMerchantListInRange(userInfo, "REGEXP '^[^a-q 0-9]'", 1);
			if (mDtoQZ != null)
				mav.addObject("mDtoQZ", mDtoQZ.getMerchantDTOs());
			MerchantDTO mDtoSpecial = getCityDealz.getMerchantListInRange(userInfo, "REGEXP '^[^a-z]'", 1);
			if (mDtoSpecial != null)
				mav.addObject("mDtoSpecial", mDtoSpecial.getMerchantDTOs());

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/merchant/{merchantName}")
	public ModelAndView merchantDetailsWithLatestDeals(@PathVariable String merchantName) {
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		ModelAndView mav = new ModelAndView("homePage/merchantDetailsWithLatestDeals");
		mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
		try {
			mav.addObject("cityDTO", getCityDealz.getCityDetails(cityId));
			MerchantDTO merchantDTO = null;
			try {
				merchantDTO = merchantService.getMerchantDetailById(null, merchantName);
			} catch (Exception e) {
				// TODO: handle exception
			}

			if (merchantDTO == null) {
				mav = new ModelAndView("redirect:/pageNotFound?pnf=merchant/" + merchantName);

				CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
				if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
					mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

				NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
				if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
					mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
				return mav;
			}

			PostDTO postDTO = getCityDealz.getPostByMerchantId(merchantDTO.getMerchantId());
			if (postDTO != null)
				mav.addObject("posts", postDTO.getPostDTOs());

			DocumentDTO documentDTO = getCityDealz.getMediaByMerchantId(merchantDTO.getMerchantId());
			if (documentDTO != null)
				mav.addObject("documentDTO", documentDTO.getDocumentDTOs());

			List<EmbedsDTO> embedsDTOs = merchantService.getMerchantEmbeds(IntUtil.getInteger(merchantDTO.getMerchantId()));
			mav.addObject("embedsDTOs", embedsDTOs);

			IconsDTO icnDTO = new IconsDTO();
			if (merchantDTO != null && merchantDTO.getMerchantFeature() != null && merchantDTO.getMerchantFeature().length() > 0) {
				IconsDTO iconsDTO = getCityDealz.getAllIconsDetails(userInfo);
				String[] incons = merchantDTO.getMerchantFeature().split(",");
				for (String icns : incons) {
					for (IconsDTO iDto : iconsDTO.getIconsDTOs()) {
						if (icns.equals(iDto.getIconId())) {
							if (icnDTO.getIconsDTOs() == null)
								icnDTO.setIconsDTOs(new ArrayList<IconsDTO>());
							icnDTO.getIconsDTOs().add(iDto);
						}
					}
				}
			}

			mav.addObject("icons", icnDTO.getIconsDTOs());
			merchantDTO.setBusinessHours(merchantDTO.getBusinessHours() != null ? merchantDTO.getBusinessHours().replaceAll(",", "<br/>") : "");
			mav.addObject("merchantDTO", merchantDTO);
			if (merchantDTO.getLocationDTOs() != null) {
				if (merchantDTO.getLocationDTOs().size() > 0) {
					mav.addObject("locationDTO1", merchantDTO.getLocationDTOs().get(0));
				} else {
					mav.addObject("locationDTO1", new LocationDTO());
				}
				if (merchantDTO.getLocationDTOs().size() > 1) {
					mav.addObject("locationDTO2", merchantDTO.getLocationDTOs().get(1));
				} else {
					mav.addObject("locationDTO2", new LocationDTO());
				}
				if (merchantDTO.getLocationDTOs().size() > 2) {
					mav.addObject("locationDTO3", merchantDTO.getLocationDTOs().get(2));
				} else {
					mav.addObject("locationDTO3", new LocationDTO());
				}
				mav.addObject("NoOtherLocation", "false");
			} else {
				mav.addObject("NoOtherLocation", "true");
			}
			SocialConnectionsDTO connectionsDTO = merchantService.getMySocialConnections(merchantDTO.getMerchantId());
			if (connectionsDTO != null) {
				mav.addObject("connectionDTO", connectionsDTO);
				// Twitter API
				if ("1".equals(connectionsDTO.getTwitterAccountchk()))
					mav.addObject("tweets", GCDTwitterUtil.getLatestTweets(StringUtil.getLastByFSlas(connectionsDTO.getTwitterAccount()), 5));
				// Facebook API
				if ("1".equals(connectionsDTO.getFacebookFanPagechk()))
					mav.addObject("facebooks", GCDFacebookUtil.getLatestFbFeeds(StringUtil.getLastByFSlas(connectionsDTO.getFacebookFanPage()), 5));

				if ("1".equals(connectionsDTO.getInstagramAccountchk()))
					mav.addObject("instagram", InstagramUtil.getFeeds(connectionsDTO.getInstagramAccount()));
			}
			List<DealzDTO> dealzDTOs = getCityDealz.getDealzByMerchantId(userInfo, merchantDTO.getMerchantId(), 0, 15);
			if (dealzDTOs != null) {
				mav.addObject("dealzs", dealzDTOs);
			}

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/dealzByMap/DealsOnMap")
	public ModelAndView dealsByMapDisplay() {
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		ModelAndView mav = new ModelAndView("dealsByMap/dealsByMap");
		try {
			mav.addObject("cityDTO", getCityDealz.getCityDetails(cityId));
			List<DealzDTO> dealzDTOs = getCityDealz.getAllDealzWithMerchantInfo(userInfo);
			if (dealzDTOs != null)
				mav.addObject("dealzs", dealzDTOs);

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/blog/{postId}/{merchantId}")
	public ModelAndView displayPostByMerchant(@PathVariable String postId, @PathVariable String merchantId) {
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		ModelAndView mav = new ModelAndView("blog/blogcontent");
		try {
			PostDTO postDTO = getCityDealz.getPostContentById(postId);
			mav.addObject("postDTO", postDTO);
			DocumentDTO documentDTO = getCityDealz.getMediaByMerchantId(merchantId);
			if (documentDTO != null)
				mav.addObject("documentDTO", documentDTO.getDocumentDTOs());

			MerchantDTO merchantDTO = merchantService.getMerchantDetailById(merchantId, null);
			mav.addObject("merchantDTO", merchantDTO);

			IconsDTO icnDTO = new IconsDTO();
			if (merchantDTO != null && merchantDTO.getMerchantFeature() != null && merchantDTO.getMerchantFeature().length() > 0) {
				IconsDTO iconsDTO = getCityDealz.getAllIconsDetails(userInfo);
				String[] incons = merchantDTO.getMerchantFeature().split(",");
				for (String icns : incons) {
					for (IconsDTO iDto : iconsDTO.getIconsDTOs()) {
						if (icns.equals(iDto.getIconId())) {
							if (icnDTO.getIconsDTOs() == null)
								icnDTO.setIconsDTOs(new ArrayList<IconsDTO>());
							icnDTO.getIconsDTOs().add(iDto);
						}
					}
				}
			}

			mav.addObject("icons", icnDTO.getIconsDTOs());
			merchantDTO.setBusinessHours(merchantDTO.getBusinessHours() != null ? merchantDTO.getBusinessHours().replaceAll(",", "<br/>") : "");
			SocialConnectionsDTO connectionsDTO = merchantService.getMySocialConnections(merchantDTO.getMerchantId());
			if (connectionsDTO != null) {
				mav.addObject("connectionDTO", connectionsDTO);
			}
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/{merchantName}/deal/{dealTitle}--{dealzId}")
	public ModelAndView dealzByIdDispaly(@PathVariable String dealzId) {
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		ModelAndView mav = null;
		try {
			DealzDTO dealzDTO = getCityDealz.getDealzById(userInfo, dealzId);
			if (dealzDTO == null) {
				mav = new ModelAndView("redirect:/pageNotFound?pnf=" + dealzId);

				CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
				if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
					mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

				NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
				if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
					mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
				return mav;
			}
			mav = new ModelAndView("merchant/dealzById");
			mav.addObject("dealzDTO", dealzDTO);
			mav.addObject("connectionDTO", dealzDTO.getSocialConnectionsDTO());

			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/sitemap")
	public ModelAndView displaySiteMap() {
		ModelAndView mav = new ModelAndView("sitemap/siteMap");
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		try {
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/about-get-city-dealz")
	public ModelAndView displayAboutGcd() {
		ModelAndView mav = new ModelAndView("homePage/about-get-city-dealz");
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		try {
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/become-a-merchant/subscription-plan-pricing")
	public ModelAndView displayPricing() {
		ModelAndView mav = new ModelAndView("homePage/subscription-plan-pricing");
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		try {
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/become-a-merchant/refund-policy")
	public ModelAndView displayRefundPolicy() {
		ModelAndView mav = new ModelAndView("homePage/refund-policy");
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		try {
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/employment")
	public ModelAndView displayEmployment() {
		ModelAndView mav = new ModelAndView("homePage/employment");
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		try {
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/blogs")
	public ModelAndView displayBlogs() {
		ModelAndView mav = new ModelAndView("homePage/blogs");
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		try {
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/jefferson-chamber")
	public ModelAndView displayJeffersonChamber() {
		ModelAndView mav = new ModelAndView("homePage/jefferson-chamber");
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		try {
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/privacy-policy")
	public ModelAndView privicyDisplay() {
		ModelAndView mav = new ModelAndView("homePage/privicy");
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		try {
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/contactus")
	public ModelAndView contactsDisplay() {
		ModelAndView mav = new ModelAndView("homePage/contactUs");
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		try {
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping(value = "/common/{pageName}")
	public ModelAndView customFooterPageDisplay(@PathVariable String pageName, ModelMap modelMap) {
		ModelAndView mav = new ModelAndView("homePage/customFooterPages");
		UserInfo userInfo = new UserInfo();
		String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
		userInfo.setCityId(cityId);
		try {
			GcdMetaDTO dto = getCityDealz.getPageMetaByPageName(pageName);
			modelMap.put("dto", dto);
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			mav.addObject("subdomainUrl", AppPropertyBuilder.getProperty("sub.domain.url", "01"));
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());
			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	@RequestMapping("/pageNotFound")
	public ModelAndView defaultErrorPage() {
		ModelAndView mav = new ModelAndView("merchant/noDealFound");
		try {
			UserInfo userInfo = new UserInfo();
			String cityId = new SupportClass().getCityId(getRequest().getRequestURL().toString());
			userInfo.setCityId(cityId);
			CategoryDTO categoryDTO = getCityDealz.getAllCategoriesOnly(userInfo);
			if (categoryDTO != null && categoryDTO.getCategoryDTOs() != null)
				mav.addObject("categoryDTO", categoryDTO.getCategoryDTOs());

			NeighborhoodDTO neighborhoodDTO = getCityDealz.getNeighborhoodsAndCountDealz(userInfo);
			if (neighborhoodDTO != null && neighborhoodDTO.getNeighborhoodDTOs() != null)
				mav.addObject("nDtoLis", neighborhoodDTO.getNeighborhoodDTOs());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mav;
	}

	/*@RequestMapping("/error")
	public String handleResourceNotFoundException() {
		Throwable throwable = (Throwable) getRequest().getAttribute("javax.servlet.error.exception");
		Integer statusCode = (Integer) getRequest().getAttribute("javax.servlet.error.status_code");
		String servletName = (String) getRequest().getAttribute("javax.servlet.error.servlet_name");
		if (servletName == null) {
			servletName = "Unknown";
		}
		String requestUri = (String) getRequest().getAttribute("javax.servlet.error.request_uri");
		if (requestUri == null) {
			requestUri = "Unknown";
		}
		return "redirect:/pageNotFound?pnf=" + requestUri;
	}*/

}
