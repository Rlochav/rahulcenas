package com.app.getcitydealz.service;

import java.util.List;
import java.util.Map;

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
import com.app.login.dto.UserInfo;
import com.app.post.dto.PostDTO;
import com.app.social.dto.SocialProfileDTO;

public interface GetCityDealz {

	public DealzDTO saveMerchantDealz(UserInfo userInfo, DealzDTO dealzDTO) throws BaseException;

	public List<DealzDTO> getAllDealz(UserInfo userInfo, String cityId, String upcoming, String start) throws BaseException;

	public DocumentDTO saveDocumentDetails(UserInfo userInfo, DocumentDTO documentDTO) throws BaseException;

	public Map<String, String> getCityMap(UserInfo userInfo) throws BaseException;

	public DocumentDTO getDocumentDetailsByMerchantId(String string) throws BaseException;

	public DocumentDTO deleteMediaFile(String merchantId, String docId) throws BaseException;

	public DealzRateDTO rateDealz(UserInfo userInfo, DealzRateDTO dealzRateDTO) throws BaseException;

	public DocumentDTO updateDocumentDetails(UserInfo userInfo, DocumentDTO documentDTO) throws BaseException;

	public CategoryDTO saveCategories(UserInfo userInfo, CategoryDTO categoryDTO) throws BaseException;

	public UserInfo adminDoLogin(UserInfo userInfo) throws BaseException;

	public CategoryDTO getAllCategories(UserInfo userInfo, String start) throws BaseException;

	public SubCategoryDTO getSubCategoryByCategoryId(UserInfo userInfo, String categoryId) throws BaseException;

	public SubCategoryDTO saveSubCategory(UserInfo userInfo, SubCategoryDTO subCategoryDTO) throws BaseException;

	public NeighborhoodDTO saveNeighborhood(UserInfo userInfo, NeighborhoodDTO neighborhoodDTO) throws BaseException;

	public NeighborhoodDTO getAllNeighborhoods(UserInfo userInfo) throws BaseException;

	public String getCityText(String cityId) throws BaseException;

	public MerchantDTO getAllMerchantList(UserInfo userInfo) throws BaseException;

	public SalesPersonDTO saveSalesPerson(UserInfo userInfo, SalesPersonDTO salesPersonDTO) throws BaseException;

	public SalesPersonDTO getAllSalesPerson(UserInfo userInfo) throws BaseException;

	public SalesPersonDTO getSalesPersonById(UserInfo userInfo, String spId) throws BaseException;

	public CityDTO saveCityDetails(UserInfo userInfo, CityDTO cityDTO) throws BaseException;

	public CityDTO getAllCityDetails(UserInfo userInfo) throws BaseException;

	public CityDTO getCityDetailsById(String cityId, String stateId) throws BaseException;

	public SubscriptionLevelDTO saveSubscriptionLevelDetails(UserInfo userInfo, SubscriptionLevelDTO levelDTO) throws BaseException;

	public SubscriptionLevelDTO getAllLevelDetails(UserInfo userInfo) throws BaseException;

	public SubscriptionLevelDTO getLevelDetailsById(UserInfo userInfo, String levelId) throws BaseException;

	public SocialConnectionsDTO saveSConnDetails(UserInfo userInfo, SocialConnectionsDTO connectionsDTO, String flag) throws BaseException;

	public SocialConnectionsDTO getAdminSConnDetails(UserInfo userInfo) throws BaseException;

	public IconsDTO saveIconsDetails(UserInfo userInfo, IconsDTO iconsDTO) throws BaseException;

	public IconsDTO getAllIconsDetails(UserInfo userInfo) throws BaseException;

	public IconsDTO getIconsDetailsById(UserInfo userInfo, String iconId) throws BaseException;

	public DealzDTO getAllDealzs(UserInfo userInfo, String dealType, String start) throws BaseException;

	public DealzDTO deleteDealById(UserInfo userInfo, DealzDTO dealzDTO) throws BaseException;

	public Map<String, String> getCategoryMapByMerchant(UserInfo userInfo, String merchantId) throws BaseException;

	public Map<String, String> getSubCategoryMapByMerchant(UserInfo userInfo, String requestParam) throws BaseException;

	public Map<String, String> getCityMapByMerchant(UserInfo userInfo, String requestParam) throws BaseException;

	public NeighborhoodDTO getNeighborhoodsAndCountDealz(UserInfo userInfo) throws BaseException;

	public List<DealzDTO> getAllDealzByNeighborhoodId(UserInfo userInfo, String neighborhoodId) throws BaseException;

	public NeighborhoodDTO getNeighborhoodsName(UserInfo userInfo, String neighborhoodId) throws BaseException;

	public DealzDTO getAllDealsByMasterCategory(UserInfo userInfo, String masterCategory) throws BaseException;

	public MerchantDTO deactivateMerchant(UserInfo userInfo, String merchantId) throws BaseException;

	public CategoryDTO getAllCategoriesOnly(UserInfo userInfo) throws BaseException;

	public List<DealzDTO> getAllDelsByCategoryAndSubCategoryId(UserInfo userInfo, String categoryId, String subcategoryId) throws BaseException;

	public List<DealzDTO> getAllDealzByCategoryId(UserInfo userInfo, String categoryId) throws BaseException;

	public MerchantDTO getMerchantListInRange(UserInfo userInfo, String range, Integer flag) throws BaseException;

	public List<DealzDTO> getDealzByMerchantId(UserInfo userInfo, String merchantId, Integer start, Integer count) throws BaseException;

	public List<DealzDTO> getAllDealzWithMerchantInfo(UserInfo userInfo) throws BaseException;

	public CityDTO getCityDetails(String cityId) throws BaseException;

	public SubscriptionDTO subscribeDealz(SubscriptionDTO subscriptionDTO) throws BaseException;

	public DocumentDTO getMediaByMerchantId(String merchantId) throws BaseException;

	public List<DocumentDTO> getDocumentData(UserInfo userInfo, Integer docId, String mId) throws BaseException;

	public Map<String, String> getStateMap(UserInfo userInfo, String cityId) throws BaseException;

	public PostDTO getPostByMerchantId(String merchantId) throws BaseException;

	public PostDTO getPostContentById(String postId) throws BaseException;

	public DealzDTO getDealzById(UserInfo userInfo, String dealzId) throws BaseException;

	public String getCategoryName(String categoryId) throws BaseException;

	public String getSubCategoryName(String categoryId, String subcategoryId) throws BaseException;

	public List<CategoryDTO> getListOfCategoryNneighborhoods(UserInfo userInfo) throws BaseException;

	public String subscribeDealz(UserInfo userInfo, SubscriptionDTO subscriptionDTO, String[] categories, String[] neighborhood) throws BaseException;

	public String isDealCodeUniqe(UserInfo userInfo, String dealId, String dealCode) throws BaseException;

	public Map<String, String> getTimeZones() throws BaseException;

	public Map<String, String> getAutoQuery(String requestParam) throws BaseException;

	public com.app.common.dto.GcdMetaDTO saveMetaNav(UserInfo userInfo, com.app.common.dto.GcdMetaDTO gmDto) throws BaseException;

	public com.app.common.dto.GcdMetaDTO getMetaByType(Integer metaId) throws BaseException;

	public GcdMetaDTO getMetaById(Integer metaId) throws BaseException;

	public List<UserInfo> getUserMasters(UserInfo userInfo) throws BaseException;

	public UserInfo getAdminDetailsById(String requestParam) throws BaseException;

	public UserInfo saveAdminDetails(UserInfo usermaster) throws BaseException;

	public String validateAdminUserIdEmailId(String userId, String emailId, String userIdenx) throws BaseException;

	public Map<String, String> getAllUserList() throws BaseException;

	public SocialProfileDTO saveSocialDetails(SocialProfileDTO dto) throws BaseException;

	public String getNextOrderOfHotDeal() throws BaseException;

	public GcdMetaDTO getPageMetaByPageName(String pageName) throws BaseException;

	public GcdMetaDTO getListOfPages() throws BaseException;

	public GcdMetaDTO getListOfRightHandRails() throws BaseException;

	public String saveRightHandRails(GcdMetaDTO dto) throws BaseException;

	public String savePageMaster(GcdMetaDTO dto) throws BaseException;

	public GcdMetaDTO getRighHandRailDetailsById(String id) throws BaseException;

	public GcdMetaDTO getPageDetailsById(String id) throws BaseException;
}
