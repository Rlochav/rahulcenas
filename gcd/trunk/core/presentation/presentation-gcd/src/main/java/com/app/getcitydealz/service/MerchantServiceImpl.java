package com.app.getcitydealz.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.commonexception.BaseException;
import com.app.deal.dto.DealzDTO;
import com.app.getcitydealz.dto.EmbedsDTO;
import com.app.getcitydealz.dto.HotDealBannerDTO;
import com.app.getcitydealz.dto.LocationDTO;
import com.app.getcitydealz.dto.MerchantCategoryDTO;
import com.app.getcitydealz.dto.MerchantDTO;
import com.app.getcitydealz.dto.SocialConnectionsDTO;
import com.app.getcitydealz.dto.SubCategoryDTO;
import com.app.getcitydealz.manager.MerchantManager;
import com.app.getcitydealz.merchant.service.MerchantService;
import com.app.login.dto.UserInfo;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	private MerchantManager merchantManager;

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Throwable.class)
	public MerchantDTO doRegisterMerchant(UserInfo userInfo, MerchantDTO merchantDTO, List<LocationDTO> locationDTOs) throws BaseException {
		MerchantDTO retDto = null;
		try {
			retDto = merchantManager.doRegisterMerchant(userInfo, merchantDTO);
			merchantManager.saveMerchantLocations(retDto.getMerchantId(), locationDTOs);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Throwable.class)
	public MerchantDTO updateMyProfile(UserInfo userInfo, MerchantDTO merchantDTO, List<LocationDTO> locationDTOs) throws BaseException {
		MerchantDTO retDto = null;
		try {
			retDto = merchantManager.updateMyProfile(userInfo, merchantDTO);
			merchantManager.saveMerchantLocations(retDto.getMerchantId(), locationDTOs);
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
	public MerchantDTO getMerchantDetailById(String merchantId, String merchantUrl) throws BaseException {
		MerchantDTO retDto = null;
		try {
			retDto = merchantManager.getMerchantDetailById(merchantId, merchantUrl);
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
	public Map<String, String> getMasterCategory(UserInfo userInfo) throws BaseException {
		Map<String, String> retMap = null;
		try {
			retMap = merchantManager.getMasterCategory(userInfo);
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
	public Map<String, String> getCategory(UserInfo userInfo) throws BaseException {
		Map<String, String> retMap = null;
		try {
			retMap = merchantManager.getCategory(userInfo);
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
	public LocationDTO saveEditLocation(Integer merchantId, LocationDTO locationDTO) throws BaseException {
		LocationDTO retDto = null;
		try {
			retDto = merchantManager.saveEditLocation(merchantId, locationDTO);
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
	public LocationDTO getAdditionLocationByMerchant(UserInfo userInfo) throws BaseException {
		LocationDTO retDto = null;
		try {
			retDto = merchantManager.getAdditionLocationByMerchant(userInfo);
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
	public MerchantDTO updateEmailPwd(UserInfo userInfo, MerchantDTO merchantDTO) throws BaseException {
		MerchantDTO retDto = null;
		try {
			retDto = merchantManager.updateEmailPwd(userInfo, merchantDTO);
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
	public String getLogoInfo(UserInfo userInfo) throws BaseException {
		String logiInfo = null;
		try {
			logiInfo = merchantManager.getLogoInfo(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return logiInfo;
	}

	@Transactional(propagation = Propagation.NEVER)
	public LocationDTO getLocationDetailsById(UserInfo userInfo, String locationId) throws BaseException {
		LocationDTO retDto = null;
		try {
			retDto = merchantManager.getLocationDetailsById(userInfo, locationId);
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
	public SocialConnectionsDTO saveSocialConnection(UserInfo userInfo, SocialConnectionsDTO socialConnectionsDTO) throws BaseException {
		SocialConnectionsDTO retDto = null;
		try {
			retDto = merchantManager.saveSocialConnection(userInfo, socialConnectionsDTO);
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
	public SocialConnectionsDTO getMySocialConnections(String merchantId) throws BaseException {
		SocialConnectionsDTO retDto = null;
		try {
			retDto = merchantManager.getMySocialConnections(merchantId);
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
	public LocationDTO deleteMerchantAdditionLocation(Integer merchantId, String locationId) throws BaseException {
		LocationDTO retDto = null;
		try {
			retDto = merchantManager.deleteMerchantAdditionLocation(merchantId, locationId);
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
	public List<String> getMediaFiles(UserInfo userInfo) throws BaseException {
		List<String> retList = null;
		try {
			retList = merchantManager.getMediaFiles(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retList;
	}

	@Transactional(propagation = Propagation.NEVER)
	public Map<String, String> getSubCategoryMapByCategoryId(UserInfo userInfo, String categoryId) throws BaseException {
		Map<String, String> retMap = null;
		try {
			retMap = merchantManager.getSubCategoryMapByCategoryId(userInfo, categoryId);
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
	public DealzDTO getMyAllHotDealz(UserInfo userInfo, String dealType) throws BaseException {
		DealzDTO retDto = null;
		try {
			retDto = merchantManager.getMyAllHotDealz(userInfo, dealType);
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
	public DealzDTO getDealzDetailById(UserInfo userInfo, String dealId, String dealType) throws BaseException {
		DealzDTO retDto = null;
		try {
			retDto = merchantManager.getDealzDetailById(userInfo, dealId, dealType);
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
	public List<String> getMySocialConnection(UserInfo userInfo) throws BaseException {
		List<String> retDto = null;
		try {
			retDto = merchantManager.getMySocialConnection(userInfo);
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
	public DealzDTO getMyLatestDeal(Integer userIndex) throws BaseException {
		DealzDTO retDto = null;
		try {
			retDto = merchantManager.getMyLatestDeal(userIndex);
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
	public Map<String, String> getSubscriptionLevel(UserInfo userInfo) throws BaseException {
		Map<String, String> retMap = null;
		try {
			retMap = merchantManager.getSubscriptionLevel(userInfo);
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
	public Map<String, String> getFeatureMap(UserInfo userInfo) throws BaseException {
		Map<String, String> retMap = null;
		try {
			retMap = merchantManager.getFeatureMap(userInfo);
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
	public Map<String, String> getNeighborhoodMap(UserInfo userInfo) throws BaseException {
		Map<String, String> retMap = null;
		try {
			retMap = merchantManager.getNeighborhoodMap(userInfo);
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
	public Map<String, String> getSalesPersonMap(UserInfo userInfo) throws BaseException {
		Map<String, String> retMap = null;
		try {
			retMap = merchantManager.getSalesPersonMap(userInfo);
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
	public MerchantDTO getAllMerchantList(UserInfo userInfo, String start, String order) throws BaseException {
		MerchantDTO retDto = null;
		try {
			retDto = merchantManager.getAllMerchantList(userInfo, start, order);
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
	public MerchantDTO getMerchantDetailsById(UserInfo userInfo, String merchantId) throws BaseException {
		MerchantDTO retDto = null;
		try {
			retDto = merchantManager.getMerchantDetailsById(userInfo, merchantId);
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
	public Map<String, String> getSubCategoryMap(String merchantId, String categoryId) throws BaseException {
		Map<String, String> retMap = null;
		try {
			retMap = merchantManager.getSubCategoryMap(merchantId, categoryId);
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
	public List<MerchantCategoryDTO> getSelectedSubCategories(String mershantId, String categoryId, Integer type) throws BaseException {
		List<MerchantCategoryDTO> retMap = null;
		try {
			retMap = merchantManager.getSelectedSubCategories(mershantId, categoryId, type);
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
	public List<SubCategoryDTO> getSubCategoryListByCategoryId(UserInfo userInfo, String categoryId) throws BaseException {
		List<SubCategoryDTO> retList = null;
		try {
			retList = merchantManager.getSubCategoryListByCategoryId(userInfo, categoryId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retList;
	}

	@Transactional(propagation = Propagation.NEVER)
	public DealzDTO getHighestRatedDealz(UserInfo userInfo) throws BaseException {
		DealzDTO retDto = null;
		try {
			retDto = merchantManager.getHighestRatedDealz(userInfo);
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
	public String unSubscribedEmailById(String subscriptionId) throws BaseException {
		String retMap = null;
		try {
			retMap = merchantManager.unSubscribedEmailById(subscriptionId);
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
	public String saveFBAccessToken(Integer userIndex, String accessToken, String params) throws BaseException {
		String retMap = null;
		try {
			retMap = merchantManager.saveFBAccessToken(userIndex, accessToken, params);
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
	public String getMyAccessToken(UserInfo userInfo) throws BaseException {
		String retMap = null;
		/*
		 * try { retMap = merchantManager.getMyAccessToken(userInfo); } catch
		 * (BaseException e) { e.printStackTrace(); throw e; } catch (Exception
		 * e) { e.printStackTrace(); throw e; }
		 */
		return retMap;
	}

	@Transactional(propagation = Propagation.NEVER)
	public Map<Integer, String> checkUserCanPost(UserInfo userInfo) throws Exception {
		Map<Integer, String> flag = null;
		try {
			flag = merchantManager.checkUserCanPost(userInfo);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return flag;
	}

	@Transactional(propagation = Propagation.NEVER)
	public String getMyLevel(UserInfo userInfo) throws BaseException {
		String levelId = null;
		try {
			levelId = merchantManager.getMyLevel(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return levelId;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String updateMerchantLevel(UserInfo userInfo, String currentLevel, String changedLevel) throws BaseException {
		String levelId = null;
		try {
			levelId = merchantManager.updateMerchantLevel(userInfo, currentLevel, changedLevel);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return levelId;
	}

	@Transactional(propagation = Propagation.NEVER)
	public HotDealBannerDTO getHotDealDetails(UserInfo userInfo) throws BaseException {
		HotDealBannerDTO bannerDTO = null;
		try {
			bannerDTO = merchantManager.getHotDealDetails(userInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bannerDTO;
	}

	@Transactional(propagation = Propagation.NEVER)
	public MerchantDTO getMerchantDetailByEmailId(String emailId) throws BaseException {
		MerchantDTO merchantDTO = null;
		try {
			merchantDTO = merchantManager.getMerchantDetailByEmailId(emailId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return merchantDTO;
	}

	@Transactional(propagation = Propagation.NEVER)
	public MerchantDTO getAdminDetailsByEmailId(String emailId) throws BaseException {
		MerchantDTO merchantDTO = null;
		try {
			merchantDTO = merchantManager.getAdminDetailsByEmailId(emailId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return merchantDTO;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Throwable.class)
	public List<LocationDTO> saveMerchantLocations(String merchantId, List<LocationDTO> locationDTOs) throws BaseException {
		List<LocationDTO> locs = null;
		try {
			locs = merchantManager.saveMerchantLocations(merchantId, locationDTOs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locs;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Throwable.class)
	public EmbedsDTO saveMerchantEmbeds(UserInfo userInfo, EmbedsDTO embedsDTO) throws BaseException {
		EmbedsDTO locs = null;
		try {
			locs = merchantManager.saveMerchantEmbeds(userInfo, embedsDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return locs;
	}

	@Transactional(propagation = Propagation.NEVER)
	public List<EmbedsDTO> getMerchantEmbeds(Integer merchantId) throws BaseException {
		List<EmbedsDTO> embedsDTOs = null;
		try {
			embedsDTOs = merchantManager.getMerchantEmbeds(merchantId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return embedsDTOs;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Throwable.class)
	public EmbedsDTO deleteEmbed(Integer embedId) throws BaseException {
		EmbedsDTO embedsDTO = null;
		try {
			embedsDTO = merchantManager.deleteEmbed(embedId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return embedsDTO;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Throwable.class)
	public EmbedsDTO updateEmbed(EmbedsDTO embedsDTO) throws BaseException {
		try {
			embedsDTO = merchantManager.updateEmbed(embedsDTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return embedsDTO;
	}

	@Override
	public String verifyRegisterForm(String userId, String emailId) throws BaseException {
		String message = null;
		try {
			message = merchantManager.verifyRegisterForm(userId, emailId);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return message;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void saveTwitterDetails(UserInfo userInfo, String userId, String screenName, String token, String tokenSecret) throws BaseException {
		try {
			merchantManager.saveTwitterDetails(userInfo, userId, screenName, token, tokenSecret);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Throwable.class)
	@Async
	public boolean updateDealz(UserInfo userInfo, String dealzId, String city) throws BaseException {
		boolean b = false;
		try {
			b = merchantManager.updateDealz(userInfo, dealzId, city);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return b;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Throwable.class)
	public void saveAdminTwitterDetails(UserInfo userInfo, String userId, String screenName, String token, String tokenSecret) throws BaseException {
		try {
			merchantManager.saveAdminTwitterDetails(userInfo, userId, screenName, token, tokenSecret);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Throwable.class)
	public void saveAdminFBAccessToken(Integer userIndex, String accessToken, String name) throws BaseException {
		String retMap = null;
		try {
			retMap = merchantManager.saveAdminFBAccessToken(userIndex, accessToken, name);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
