package com.app.getcitydealz.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.common.dto.GcdMetaDTO;
import com.app.commonexception.BaseException;
import com.app.deal.dto.DealzDTO;
import com.app.getcitydealz.dto.CategoryDTO;
import com.app.getcitydealz.dto.CityDTO;
import com.app.getcitydealz.dto.DealzRateDTO;
import com.app.getcitydealz.dto.DocumentDTO;
import com.app.getcitydealz.dto.IconsDTO;
import com.app.getcitydealz.dto.MerchantDTO;
import com.app.getcitydealz.dto.NeighborhoodDTO;
import com.app.getcitydealz.dto.SalesPersonDTO;
import com.app.getcitydealz.dto.SocialConnectionsDTO;
import com.app.getcitydealz.dto.SubCategoryDTO;
import com.app.getcitydealz.dto.SubscriptionDTO;
import com.app.getcitydealz.dto.SubscriptionLevelDTO;
import com.app.getcitydealz.manager.GetCityDealzManager;
import com.app.login.dto.UserInfo;
import com.app.post.dto.PostDTO;
import com.app.social.dto.SocialProfileDTO;

@Service
public class GetCityDealzService implements GetCityDealz {

	@Autowired
	private GetCityDealzManager getCityDealzManager;

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public DealzDTO saveMerchantDealz(UserInfo userInfo, DealzDTO dealzDTO) throws BaseException {
		DealzDTO retDTO = null;
		try {
			retDTO = getCityDealzManager.saveMerchantDealz(userInfo, dealzDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDTO;
	}

	@Transactional(propagation = Propagation.NEVER)
	public List<DealzDTO> getAllDealz(UserInfo userInfo, String cityId, String upcoming, String start) throws BaseException {
		List<DealzDTO> retDtoList = null;
		try {
			retDtoList = getCityDealzManager.getAllDealz(userInfo, cityId, upcoming, start);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDtoList;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public DocumentDTO saveDocumentDetails(UserInfo userInfo, DocumentDTO documentDTO) throws BaseException {
		DocumentDTO retDto = null;
		try {
			retDto = getCityDealzManager.saveDocumentDetails(userInfo, documentDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public Map<String, String> getCityMap(UserInfo userInfo) throws BaseException {
		Map<String, String> retMap = null;
		try {
			retMap = getCityDealzManager.getCityMap(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	@Transactional(propagation = Propagation.NEVER)
	public Map<String, String> getStateMap(UserInfo userInfo, String cityId) throws BaseException {
		Map<String, String> retMap = null;
		try {
			retMap = getCityDealzManager.getStateMap(userInfo, cityId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	@Transactional(propagation = Propagation.NEVER)
	public DocumentDTO getDocumentDetailsByMerchantId(String merchantId) throws BaseException {
		DocumentDTO retDto = null;
		try {
			retDto = getCityDealzManager.getDocumentDetailsByMerchantId(merchantId);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public DocumentDTO deleteMediaFile(String merchantId, String docId) throws BaseException {
		DocumentDTO retDto = null;
		try {
			retDto = getCityDealzManager.deleteMediaFile(merchantId, docId);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public DealzRateDTO rateDealz(UserInfo userInfo, DealzRateDTO dealzRateDTO) throws BaseException {
		DealzRateDTO retDTO = null;
		try {
			retDTO = getCityDealzManager.rateDealz(userInfo, dealzRateDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDTO;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public DocumentDTO updateDocumentDetails(UserInfo userInfo, DocumentDTO documentDTO) throws BaseException {
		DocumentDTO retDto = null;
		try {
			retDto = getCityDealzManager.updateDocumentDetails(userInfo, documentDTO);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public CategoryDTO saveCategories(UserInfo userInfo, CategoryDTO categoryDTO) throws BaseException {
		CategoryDTO retDto = null;
		try {
			retDto = getCityDealzManager.saveCategories(userInfo, categoryDTO);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public UserInfo adminDoLogin(UserInfo userInfo) throws BaseException {
		UserInfo retDto = null;
		try {
			retDto = getCityDealzManager.adminDoLogin(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public CategoryDTO getAllCategories(UserInfo userInfo, String start) throws BaseException {
		CategoryDTO retDto = null;
		try {
			retDto = getCityDealzManager.getAllCategories(userInfo, start);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public SubCategoryDTO getSubCategoryByCategoryId(UserInfo userInfo, String categoryId) throws BaseException {
		SubCategoryDTO retDto = null;
		try {
			retDto = getCityDealzManager.getSubCategoryByCategoryId(userInfo, categoryId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public SubCategoryDTO saveSubCategory(UserInfo userInfo, SubCategoryDTO subCategoryDTO) throws BaseException {
		SubCategoryDTO retDto = null;
		try {
			retDto = getCityDealzManager.saveSubCategory(userInfo, subCategoryDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public NeighborhoodDTO saveNeighborhood(UserInfo userInfo, NeighborhoodDTO neighborhoodDTO) throws BaseException {
		NeighborhoodDTO retDto = null;
		try {
			retDto = getCityDealzManager.saveNeighborhood(userInfo, neighborhoodDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public NeighborhoodDTO getAllNeighborhoods(UserInfo userInfo) throws BaseException {
		NeighborhoodDTO retDto = null;
		try {
			retDto = getCityDealzManager.getAllNeighborhoods(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public String getCityText(String cityId) throws BaseException {
		String cityName = null;
		try {
			cityName = getCityDealzManager.getCityText(cityId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return cityName;
	}

	@Transactional(propagation = Propagation.NEVER)
	public MerchantDTO getAllMerchantList(UserInfo userInfo) throws BaseException {
		MerchantDTO retDto = null;
		try {
			retDto = getCityDealzManager.getAllMerchantList(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public SalesPersonDTO saveSalesPerson(UserInfo userInfo, SalesPersonDTO salesPersonDTO) throws BaseException {
		SalesPersonDTO retDto = null;
		try {
			retDto = getCityDealzManager.saveSalesPerson(userInfo, salesPersonDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public SalesPersonDTO getAllSalesPerson(UserInfo userInfo) throws BaseException {
		SalesPersonDTO retDto = null;
		try {
			retDto = getCityDealzManager.getAllSalesPerson(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public SalesPersonDTO getSalesPersonById(UserInfo userInfo, String spId) throws BaseException {
		SalesPersonDTO retDto = null;
		try {
			retDto = getCityDealzManager.getSalesPersonById(userInfo, spId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public CityDTO saveCityDetails(UserInfo userInfo, CityDTO cityDTO) throws BaseException {
		CityDTO retDto = null;
		try {
			retDto = getCityDealzManager.saveCityDetails(userInfo, cityDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public CityDTO getAllCityDetails(UserInfo userInfo) throws BaseException {
		CityDTO retDto = null;
		try {
			retDto = getCityDealzManager.getAllCityDetails(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public CityDTO getCityDetailsById(String cityId, String stateId) throws BaseException {
		CityDTO retDto = null;
		try {
			retDto = getCityDealzManager.getCityDetailsById(cityId, stateId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public SubscriptionLevelDTO saveSubscriptionLevelDetails(UserInfo userInfo, SubscriptionLevelDTO levelDTO) throws BaseException {
		SubscriptionLevelDTO retDto = null;
		try {
			retDto = getCityDealzManager.saveSubscriptionLevelDetails(userInfo, levelDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public SubscriptionLevelDTO getAllLevelDetails(UserInfo userInfo) throws BaseException {
		SubscriptionLevelDTO retDto = null;
		try {
			retDto = getCityDealzManager.getAllLevelDetails(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public SubscriptionLevelDTO getLevelDetailsById(UserInfo userInfo, String levelId) throws BaseException {
		SubscriptionLevelDTO retDto = null;
		try {
			retDto = getCityDealzManager.getLevelDetailsById(userInfo, levelId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public SocialConnectionsDTO saveSConnDetails(UserInfo userInfo, SocialConnectionsDTO connectionsDTO, String flag) throws BaseException {
		SocialConnectionsDTO retDto = null;
		try {
			retDto = getCityDealzManager.saveSConnDetails(userInfo, connectionsDTO, flag);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public SocialConnectionsDTO getAdminSConnDetails(UserInfo userInfo) throws BaseException {
		SocialConnectionsDTO retDto = null;
		try {
			retDto = getCityDealzManager.getAdminSConnDetails(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public IconsDTO saveIconsDetails(UserInfo userInfo, IconsDTO iconsDTO) throws BaseException {
		IconsDTO retDto = null;
		try {
			retDto = getCityDealzManager.saveIconsDetails(userInfo, iconsDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public IconsDTO getAllIconsDetails(UserInfo userInfo) throws BaseException {
		IconsDTO retDto = null;
		try {
			retDto = getCityDealzManager.getAllIconsDetails(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public IconsDTO getIconsDetailsById(UserInfo userInfo, String iconId) throws BaseException {
		IconsDTO retDto = null;
		try {
			retDto = getCityDealzManager.getIconsDetailsById(userInfo, iconId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public DealzDTO getAllDealzs(UserInfo userInfo, String dealType, String start) throws BaseException {
		DealzDTO retDtoList = null;
		try {
			retDtoList = getCityDealzManager.getAllDealzs(userInfo, dealType, start);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retDtoList;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public DealzDTO deleteDealById(UserInfo userInfo, DealzDTO dealzDTO) throws BaseException {
		DealzDTO retDto = null;
		try {
			retDto = getCityDealzManager.deleteDealById(userInfo, dealzDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public Map<String, String> getCategoryMapByMerchant(UserInfo userInfo, String merchantId) throws BaseException {
		Map<String, String> retMap = null;
		try {
			retMap = getCityDealzManager.getCategoryMapByMerchant(userInfo, merchantId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	@Transactional(propagation = Propagation.NEVER)
	public Map<String, String> getSubCategoryMapByMerchant(UserInfo userInfo, String merchantId) throws BaseException {
		Map<String, String> retMap = null;
		try {
			retMap = getCityDealzManager.getSubCategoryMapByMerchant(userInfo, merchantId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	@Transactional(propagation = Propagation.NEVER)
	public Map<String, String> getCityMapByMerchant(UserInfo userInfo, String merchantId) throws BaseException {
		Map<String, String> retMap = null;
		try {
			// retMap = getCityDealzManager.getCityMapByMerchant(userInfo,
			// merchantId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	@Transactional(propagation = Propagation.NEVER)
	public NeighborhoodDTO getNeighborhoodsAndCountDealz(UserInfo userInfo) throws BaseException {
		NeighborhoodDTO retDto = null;
		try {
			retDto = getCityDealzManager.getNeighborhoodsAndCountDealz(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public List<DealzDTO> getAllDealzByNeighborhoodId(UserInfo userInfo, String neighborhoodId) throws BaseException {
		List<DealzDTO> retDtoList = null;
		try {
			retDtoList = getCityDealzManager.getAllDealzByNeighborhoodId(userInfo, neighborhoodId);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retDtoList;
	}

	@Transactional(propagation = Propagation.NEVER)
	public NeighborhoodDTO getNeighborhoodsName(UserInfo userInfo, String neighborhoodId) throws BaseException {
		NeighborhoodDTO nDto = null;
		try {
			nDto = getCityDealzManager.getNeighborhoodsName(userInfo, neighborhoodId);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public DealzDTO getAllDealsByMasterCategory(UserInfo userInfo, String masterCategory) throws BaseException {
		DealzDTO nDto = null;
		try {
			nDto = getCityDealzManager.getAllDealsByMasterCategory(userInfo, masterCategory);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public MerchantDTO deactivateMerchant(UserInfo userInfo, String merchantId) throws BaseException {
		MerchantDTO nDto = null;
		try {
			nDto = getCityDealzManager.deactivateMerchant(userInfo, merchantId);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public CategoryDTO getAllCategoriesOnly(UserInfo userInfo) throws BaseException {
		CategoryDTO nDto = null;
		try {
			nDto = getCityDealzManager.getAllCategoriesOnly(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public List<DealzDTO> getAllDelsByCategoryAndSubCategoryId(UserInfo userInfo, String categoryId, String subcategoryId) throws BaseException {
		List<DealzDTO> retList = null;
		try {
			retList = getCityDealzManager.getAllDelsByCategoryAndSubCategoryId(userInfo, categoryId, subcategoryId);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retList;
	}

	@Transactional(propagation = Propagation.NEVER)
	public List<DealzDTO> getAllDealzByCategoryId(UserInfo userInfo, String categoryId) throws BaseException {
		List<DealzDTO> retList = null;
		try {
			retList = getCityDealzManager.getAllDealzByCategoryId(userInfo, categoryId);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retList;
	}

	@Transactional(propagation = Propagation.NEVER)
	public MerchantDTO getMerchantListInRange(UserInfo userInfo, String range, Integer flag) throws BaseException {
		MerchantDTO nDto = null;
		try {
			nDto = getCityDealzManager.getMerchantListInRange(userInfo, range, flag);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public List<DealzDTO> getDealzByMerchantId(UserInfo userInfo, String merchantId, Integer start, Integer count) throws BaseException {
		List<DealzDTO> retList = null;
		try {
			retList = getCityDealzManager.getDealzByMerchantId(userInfo, merchantId, start, count);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retList;
	}

	@Transactional(propagation = Propagation.NEVER)
	public List<DealzDTO> getAllDealzWithMerchantInfo(UserInfo userInfo) throws BaseException {
		List<DealzDTO> retList = null;
		try {
			retList = getCityDealzManager.getAllDealzWithMerchantInfo(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retList;
	}

	@Transactional(propagation = Propagation.NEVER)
	public CityDTO getCityDetails(String cityId) throws BaseException {
		CityDTO cityDto = null;
		try {
			cityDto = getCityDealzManager.getCityDetails(cityId);
		} catch (BaseException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cityDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public SubscriptionDTO subscribeDealz(SubscriptionDTO subscriptionDTO) throws BaseException {
		SubscriptionDTO sDto = null;
		try {
			sDto = getCityDealzManager.subscribeDealz(subscriptionDTO);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public DocumentDTO getMediaByMerchantId(String merchantId) throws BaseException {
		DocumentDTO sDto = null;
		try {
			sDto = getCityDealzManager.getMediaByMerchantId(merchantId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public List<DocumentDTO> getDocumentData(UserInfo userInfo, Integer docId, String mId) throws BaseException {
		List<DocumentDTO> sDto = null;
		try {
			sDto = getCityDealzManager.getDocumentData(userInfo, docId, mId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return sDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public PostDTO getPostByMerchantId(String merchantId) throws BaseException {
		PostDTO postDto = null;
		try {
			postDto = getCityDealzManager.getPostByMerchantId(merchantId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return postDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public PostDTO getPostContentById(String postId) throws BaseException {
		PostDTO postDto = null;
		try {
			postDto = getCityDealzManager.getPostContentById(postId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return postDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public DealzDTO getDealzById(UserInfo userInfo, String dealzId) throws BaseException {
		DealzDTO retDto = null;
		try {
			retDto = getCityDealzManager.getDealzById(dealzId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public String getCategoryName(String categoryId) throws BaseException {
		String categoryName = null;
		try {
			categoryName = getCityDealzManager.getCategoryName(categoryId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return categoryName;
	}

	@Transactional(propagation = Propagation.NEVER)
	public String getSubCategoryName(String categoryId, String subcategoryId) throws BaseException {
		String subCtgName = null;
		try {
			subCtgName = getCityDealzManager.getSubCategoryName(categoryId, subcategoryId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return subCtgName;
	}

	@Transactional(propagation = Propagation.NEVER)
	public List<CategoryDTO> getListOfCategoryNneighborhoods(UserInfo userInfo) throws BaseException {
		List<CategoryDTO> retDto = null;
		try {
			retDto = getCityDealzManager.getListOfCategoryNneighborhoods(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String subscribeDealz(UserInfo userInfo, SubscriptionDTO subscriptionDTO, String[] categories, String[] neighborhood) throws BaseException {
		String retStr = null;
		try {
			retStr = getCityDealzManager.subscribeDealz(userInfo, subscriptionDTO, categories, neighborhood);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retStr;
	}

	@Transactional(propagation = Propagation.NEVER)
	public String isDealCodeUniqe(UserInfo userInfo, String dealId, String dealCode) throws BaseException {
		String retStr = null;
		try {
			retStr = getCityDealzManager.isDealCodeUniqe(userInfo, dealId, dealCode);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retStr;
	}

	@Transactional(propagation = Propagation.NEVER)
	public Map<String, String> getTimeZones() throws BaseException {
		Map<String, String> retMap = null;
		try {
			retMap = getCityDealzManager.getTimeZones();
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	@Transactional(propagation = Propagation.NEVER)
	public Map<String, String> getAutoQuery(String requestParam) throws BaseException {
		Map<String, String> retMap = null;
		try {
			retMap = getCityDealzManager.getAutoQuery(requestParam);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public GcdMetaDTO saveMetaNav(UserInfo userInfo, GcdMetaDTO gmDto) throws BaseException {
		try {
			gmDto = getCityDealzManager.saveMetaNav(userInfo, gmDto);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return gmDto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public GcdMetaDTO getMetaByType(Integer metaId) {
		GcdMetaDTO gcdMetaDTO = null;
		try {
			gcdMetaDTO = getCityDealzManager.getMetaByType(metaId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gcdMetaDTO;
	}

	@Transactional(propagation = Propagation.NEVER)
	public GcdMetaDTO getMetaById(Integer metaId) throws BaseException {
		GcdMetaDTO gcdMetaDTO = null;
		try {
			gcdMetaDTO = getCityDealzManager.getMetaById(metaId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gcdMetaDTO;
	}

	@Transactional(propagation = Propagation.NEVER)
	public List<UserInfo> getUserMasters(UserInfo userInfo) throws BaseException {
		List<UserInfo> usermasters = null;
		try {
			usermasters = getCityDealzManager.getUserMasters(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usermasters;
	}

	@Transactional(propagation = Propagation.NEVER)
	public UserInfo getAdminDetailsById(String userId) throws BaseException {
		UserInfo usermaster = null;
		try {
			usermaster = getCityDealzManager.getAdminDetailsById(userId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usermaster;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	public UserInfo saveAdminDetails(UserInfo usermaster) throws BaseException {
		try {
			usermaster = getCityDealzManager.saveAdminDetails(usermaster);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usermaster;
	}

	@Transactional(propagation = Propagation.NEVER)
	public String validateAdminUserIdEmailId(String userId, String emailId, String userIndex) throws BaseException {
		String mesg = null;
		try {
			mesg = getCityDealzManager.validateAdminUserIdEmailId(userId, emailId, userIndex);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return mesg;
	}

	@Transactional(propagation = Propagation.NEVER)
	public Map<String, String> getAllUserList() throws BaseException {
		Map<String, String> userMaps = null;
		try {
			userMaps = getCityDealzManager.getAllUserList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userMaps;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW, noRollbackFor = Exception.class)
	public SocialProfileDTO saveSocialDetails(SocialProfileDTO dto) throws BaseException {
		try {
			dto = getCityDealzManager.saveSocialDetails(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public String getNextOrderOfHotDeal() throws BaseException {
		String val = null;
		try {
			val = getCityDealzManager.getNextOrderOfHotDeal();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return val;
	}

	@Transactional(propagation = Propagation.NEVER)
	public GcdMetaDTO getPageMetaByPageName(String pageName) throws BaseException {
		GcdMetaDTO dto = null;
		try {
			dto = getCityDealzManager.getPageMetaByPageName(pageName);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Transactional(propagation = Propagation.NEVER)
	public GcdMetaDTO getListOfPages() throws BaseException {
		GcdMetaDTO gcdMetaDTO = null;
		try {
			gcdMetaDTO = getCityDealzManager.getListOfPages();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gcdMetaDTO;
	}

	@Transactional(propagation = Propagation.NEVER)
	public GcdMetaDTO getListOfRightHandRails() throws BaseException {
		GcdMetaDTO gcdMetaDTO = null;
		try {
			gcdMetaDTO = getCityDealzManager.getListOfRightHandRails();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gcdMetaDTO;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String saveRightHandRails(GcdMetaDTO dto) throws BaseException {
		String msg = null;
		try {
			msg = getCityDealzManager.saveRightHandRails(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String savePageMaster(GcdMetaDTO dto) throws BaseException {
		String msg = null;
		try {
			msg = getCityDealzManager.savePageMaster(dto);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return msg;
	}

	@Transactional(propagation = Propagation.NEVER)
	public GcdMetaDTO getRighHandRailDetailsById(String id) throws BaseException {
		GcdMetaDTO gcdMetaDTO = null;
		try {
			gcdMetaDTO = getCityDealzManager.getRighHandRailDetailsById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gcdMetaDTO;
	}

	@Transactional(propagation = Propagation.NEVER)
	public GcdMetaDTO getPageDetailsById(String id) throws BaseException {
		GcdMetaDTO gcdMetaDTO = null;
		try {
			gcdMetaDTO = getCityDealzManager.getPageDetailsById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gcdMetaDTO;
	}
}
