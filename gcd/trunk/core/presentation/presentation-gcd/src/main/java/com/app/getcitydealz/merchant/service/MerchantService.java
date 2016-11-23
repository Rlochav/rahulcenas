package com.app.getcitydealz.merchant.service;

import java.util.List;
import java.util.Map;

import com.app.commonexception.BaseException;
import com.app.deal.dto.DealzDTO;
import com.app.getcitydealz.dto.EmbedsDTO;
import com.app.getcitydealz.dto.HotDealBannerDTO;
import com.app.getcitydealz.dto.LocationDTO;
import com.app.getcitydealz.dto.MerchantCategoryDTO;
import com.app.getcitydealz.dto.MerchantDTO;
import com.app.getcitydealz.dto.SocialConnectionsDTO;
import com.app.getcitydealz.dto.SubCategoryDTO;
import com.app.login.dto.UserInfo;

public interface MerchantService {

	public MerchantDTO doRegisterMerchant(UserInfo userInfo, MerchantDTO merchantDTO, List<LocationDTO> locationDTOs) throws BaseException;

	public MerchantDTO updateMyProfile(UserInfo userInfo, MerchantDTO merchantDTO, List<LocationDTO> locations) throws BaseException;

	public MerchantDTO getMerchantDetailById(String mershantId, String merchantUrl) throws BaseException;

	public Map<String, String> getMasterCategory(UserInfo userInfo) throws BaseException;

	public Map<String, String> getCategory(UserInfo userInfo) throws BaseException;

	public LocationDTO saveEditLocation(Integer merchantId, LocationDTO locationDTO) throws BaseException;

	public LocationDTO getAdditionLocationByMerchant(UserInfo userInfo) throws BaseException;

	public MerchantDTO updateEmailPwd(UserInfo userInfo, MerchantDTO merchantDTO) throws BaseException;

	public String getLogoInfo(UserInfo userInfo) throws BaseException;

	public LocationDTO getLocationDetailsById(UserInfo userInfo, String locationId) throws BaseException;

	public SocialConnectionsDTO saveSocialConnection(UserInfo userInfo, SocialConnectionsDTO socialConnectionsDTO) throws BaseException;

	public SocialConnectionsDTO getMySocialConnections(String merchantId) throws BaseException;

	public LocationDTO deleteMerchantAdditionLocation(Integer merchantId, String locationId) throws BaseException;

	public List<String> getMediaFiles(UserInfo userInfo) throws BaseException;

	public Map<String, String> getSubCategoryMapByCategoryId(UserInfo userInfo, String categoryId) throws BaseException;

	public DealzDTO getMyAllHotDealz(UserInfo userInfo, String dealType) throws BaseException;

	public DealzDTO getDealzDetailById(UserInfo userInfo, String dealId, String dealType) throws BaseException;

	public List<String> getMySocialConnection(UserInfo userInfo) throws BaseException;

	public DealzDTO getMyLatestDeal(Integer userIndex) throws BaseException;

	public Map<String, String> getSubscriptionLevel(UserInfo userInfo) throws BaseException;

	public Map<String, String> getFeatureMap(UserInfo userInfo) throws BaseException;

	public Map<String, String> getNeighborhoodMap(UserInfo userInfo) throws BaseException;

	public Map<String, String> getSalesPersonMap(UserInfo userInfo) throws BaseException;

	public MerchantDTO getAllMerchantList(UserInfo userInfo, String start, String order) throws BaseException;

	public MerchantDTO getMerchantDetailsById(UserInfo userInfo, String merchantId) throws BaseException;

	public Map<String, String> getSubCategoryMap(String merchantId, String categoryId) throws BaseException;

	public List<MerchantCategoryDTO> getSelectedSubCategories(String mershantId, String categoryId,Integer type) throws BaseException;

	public List<SubCategoryDTO> getSubCategoryListByCategoryId(UserInfo userInfo, String categoryId) throws BaseException;

	public DealzDTO getHighestRatedDealz(UserInfo userInfo) throws BaseException;

	public String unSubscribedEmailById(String subscriptionId) throws BaseException;

	public String saveFBAccessToken(Integer userIndex, String accessToken, String params) throws BaseException;

	public String getMyAccessToken(UserInfo userInfo) throws BaseException;

	public Map<Integer, String> checkUserCanPost(UserInfo userInfo) throws Exception;

	public String getMyLevel(UserInfo userInfo) throws BaseException;

	public String updateMerchantLevel(UserInfo userInfo, String currentLevel, String changedLevel) throws BaseException;

	public HotDealBannerDTO getHotDealDetails(UserInfo userInfo) throws BaseException;

	public MerchantDTO getMerchantDetailByEmailId(String emailId) throws BaseException;

	public MerchantDTO getAdminDetailsByEmailId(String emailId) throws BaseException;

	public List<LocationDTO> saveMerchantLocations(String merchantId, List<LocationDTO> locationDTOs) throws BaseException;

	public EmbedsDTO saveMerchantEmbeds(UserInfo userInfo, EmbedsDTO embedsDTO) throws BaseException;

	public List<EmbedsDTO> getMerchantEmbeds(Integer merchantId) throws BaseException;

	public EmbedsDTO deleteEmbed(Integer embedId) throws BaseException;

	public EmbedsDTO updateEmbed(EmbedsDTO embedsDTO) throws BaseException;

	public String verifyRegisterForm(String userId, String emailId) throws BaseException;

	public void saveTwitterDetails(UserInfo userInfo, String userId, String screenName, String token, String tokenSecret) throws BaseException;

	public boolean updateDealz(UserInfo userInfo, String dealzId, String city) throws BaseException;

	public void saveAdminTwitterDetails(UserInfo userInfo, String userId, String screen, String token, String tokenSecret) throws BaseException;

	public void saveAdminFBAccessToken(Integer userIndex, String accessToken, String name) throws BaseException;
}
