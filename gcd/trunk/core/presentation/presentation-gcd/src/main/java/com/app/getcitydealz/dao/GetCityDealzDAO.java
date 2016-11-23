package com.app.getcitydealz.dao;

import static com.app.utility.common.AppPropertyBuilder.getProperty;
import static org.springframework.util.CollectionUtils.isEmpty;
import static org.springframework.util.StringUtils.isEmpty;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import com.app.commonexception.BaseException;
import com.app.getcitydealz.dto.SubCategoryDTO;
import com.app.login.dto.UserInfo;
import com.app.model.base.Base;
import com.app.model.blog.GcdPost;
import com.app.model.category.Category;
import com.app.model.category.MasterCategory;
import com.app.model.category.SubCategory;
import com.app.model.citiesnstate.Cities;
import com.app.model.citiesnstate.States;
import com.app.model.getcitydealz.AccessibiltyIcons;
import com.app.model.getcitydealz.AdminSocialLink;
import com.app.model.getcitydealz.DealzRating;
import com.app.model.getcitydealz.DealzSubscriptionDetails;
import com.app.model.getcitydealz.MerchantDealz;
import com.app.model.getcitydealz.MerchantLocation;
import com.app.model.getcitydealz.MerchantMaster;
import com.app.model.getcitydealz.NeighborhoodMaster;
import com.app.model.levelmaster.LevelMaster;
import com.app.model.metadata.GcdPageManager;
import com.app.model.metadata.GcdRightHandRailsNav;
import com.app.model.metadata.GcdSocialNav;
import com.app.model.salesperson.SalesPerson;
import com.app.model.socialconnections.SocialAccounts;
import com.app.model.socialconnections.SocialConnections;
import com.app.model.user.UserMaster;
import com.app.persistence.JPADAO;
import com.app.persistence.exception.DAOException;
import com.app.social.dto.SocialProfileDTO;
import com.app.utility.common.IntUtil;

public class GetCityDealzDAO<T extends Base<I>, I extends Serializable> extends JPADAO<T, I> {

	@SuppressWarnings("unchecked")
	public boolean canPostDealzToday(UserInfo userInfo, Integer dealzId) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT CRTdate FROM merchantdealz WHERE status=1 AND DealType=1 AND MerchantId=? ");
		if (dealzId != null)
			queryString.append(" AND DealzId!=? ");
		queryString.append(" ORDER BY CRTDate DESC LIMIT 1 ");
		Query query = getEntityManager().createNativeQuery(queryString.toString());
		query.setParameter(1, userInfo.getUserIndex());
		if (dealzId != null)
			query.setParameter(2, dealzId);
		List<Object> mDealzs = query.getResultList();
		if (mDealzs != null && mDealzs.size() > 0) {
			Object latestDealz = mDealzs.get(0);
			if (latestDealz == null)
				return true;
			Date crtDate = (Date) latestDealz;
			long interval = ((new Date()).getTime() - crtDate.getTime()) / (60 * 60 * 1000);
			// if user have basic plan
			if (interval < 60)
				return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantLocation> getAdditionLocationByMerchant(UserInfo userInfo) throws DAOException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantlocation WHERE MerchantId=?", MerchantLocation.class);
		query.setParameter(1, userInfo.getUserIndex());
		List<MerchantLocation> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return rList;
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<Integer, Object> getAllDealz(UserInfo userInfo, String cityId, String upcoming, String start) throws DAOException {
		Map<Integer, Object> retMap = new HashMap<Integer, Object>();
		StringBuilder whereBuilder = new StringBuilder();
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT * FROM merchantdealz  WHERE status=1 AND DealType=1 AND EndDate>CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01")
				+ "',LocalTimeZoneUtc) AND ");

		if (upcoming.equals("1"))
			whereBuilder.append(" StartDate>CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01") + "',LocalTimeZoneUtc) ");
		if (upcoming.equals("0"))
			whereBuilder.append(" StartDate<=CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01") + "',LocalTimeZoneUtc) ");
		if (cityId != null)
			whereBuilder.append(" AND CityId=" + cityId);
		if (userInfo.getUserIndex() != null)
			whereBuilder.append(" AND MerchantId=? ");

		Query query = getEntityManager().createNativeQuery(
				queryString.toString() + whereBuilder.toString() + " ORDER BY StartDate DESC LIMIT " + start + ",10", MerchantDealz.class);
		if (userInfo != null && userInfo.getUserIndex() != null)
			query.setParameter(1, userInfo.getUserIndex());
		List<MerchantDealz> merchantDealzs = query.getResultList();
		retMap.put(1, merchantDealzs);
		Query countQuery = getEntityManager().createNativeQuery(
				"SELECT COUNT(*) FROM merchantdealz  WHERE status=1 AND DealType=1 AND EndDate>CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01")
						+ "',LocalTimeZoneUtc) AND " + whereBuilder.toString());
		List<BigInteger> count = countQuery.getResultList();
		if (count != null && count.size() > 0)
			retMap.put(2, count.get(0));

		return retMap;
	}

	@SuppressWarnings("unchecked")
	public Object getDocument(String dealzId) {
		Query query = getEntityManager().createNativeQuery(
				"SELECT FileSavedAs FROM documents d INNER JOIN documentlink dl ON d.DocId=dl.DocId WHERE dl.DealId=? AND dl.DocType=0");
		query.setParameter(1, IntUtil.getInteger(dealzId));
		List<Object> documents = query.getResultList();
		if (documents != null && documents.size() > 0)
			return documents.get(0);
		return null;

	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getCityMap(UserInfo userInfo) throws DAOException {
		Map<String, String> retMap = null;
		Query query = getEntityManager().createNativeQuery("SELECT CityId,CityName FROM gcdcities ");
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			retMap = new LinkedHashMap<String, String>();
			for (Object[] o : rList)
				retMap.put(IntUtil.getString((Integer) o[0]), o[1].toString());
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getDocumentDetailsByMerchantId(String merchantId) throws DAOException {
		Query query = getEntityManager()
				.createNativeQuery(
						"SELECT d.DocId,d.DocumentTitle,d.ShowOnPage,d.CRTDate,d.ContentType FROM documents d INNER JOIN documentlink dl ON d.DocId=dl.DocId WHERE MerchantId=? AND dl.DocType=1");
		query.setParameter(1, IntUtil.getInteger(merchantId));
		List<Object[]> documents = query.getResultList();
		if (documents != null && documents.size() > 0)
			return documents;
		return null;
	}

	@SuppressWarnings("unchecked")
	public boolean canUploadMediaFiles(Integer mId) {
		Query query = getEntityManager().createNativeQuery(
				"SELECT d.DocId FROM documents d INNER JOIN documentlink dl ON d.DocId=dl.DocId WHERE MerchantId=? AND dl.DocType=1");
		query.setParameter(1, mId);
		List<Object[]> documents = query.getResultList();
		if (documents != null && documents.size() < 3)
			return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public String getLogoInfo(Integer mId, Integer docType) throws DAOException {
		Query query = getEntityManager().createNativeQuery(
				"SELECT FileSavedAs FROM documents d INNER JOIN documentlink dl ON d.DocId=dl.DocId WHERE MerchantId=? AND dl.DocType=?");
		query.setParameter(1, mId);
		query.setParameter(2, docType);
		List<Object> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return (String) rList.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public String getFileName(Integer mId, Integer docType) throws DAOException {
		Query query = getEntityManager().createNativeQuery(
				"SELECT OrignalFileName FROM documents d INNER JOIN documentlink dl ON d.DocId=dl.DocId WHERE MerchantId=? AND dl.DocType=?");
		query.setParameter(1, mId);
		query.setParameter(2, docType);
		List<Object> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return (String) rList.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public Integer getCurrentRatingOfDealz(Integer iDealId) {
		Query query = getEntityManager().createNativeQuery("SELECT CurrentRating FROM dealzrating WHERE DealId=?");
		query.setParameter(1, iDealId);
		List<Object> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return (Integer) rList.get(0);
		return 0;
	}

	@SuppressWarnings("unchecked")
	public DealzRating getDealzRating(Integer iDealId) {
		Query query = getEntityManager().createNativeQuery("SELECT CurrentRating FROM dealzrating WHERE DealId=?", DealzRating.class);
		query.setParameter(1, iDealId);
		List<DealzRating> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return rList.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public UserMaster getUserMaster(UserInfo userInfo) throws DAOException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM usermaster WHERE EmailId = ? OR UserId=?", UserMaster.class);
		query.setParameter(1, userInfo.getUserId());
		query.setParameter(2, userInfo.getUserId());
		List<UserMaster> mMaster = query.getResultList();
		if (mMaster != null && mMaster.size() > 0)
			return mMaster.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<SubCategory> getSubcategoryByCategory(UserInfo userInfo, Integer categoryId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM subcategory WHERE CategoryId=? ORDER BY SubCategoryName ASC ", SubCategory.class);
		query.setParameter(1, categoryId);
		List<SubCategory> subCategories = query.getResultList();
		if (subCategories != null && subCategories.size() > 0)
			return subCategories;
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<Integer, Object> getAllCategory(UserInfo userInfo, String start) {

		Map<Integer, Object> retMap = new HashMap<Integer, Object>();
		Query query = getEntityManager().createNativeQuery("SELECT * FROM category ORDER BY CategoryName ASC LIMIT " + start + ",2", Category.class);
		List<Category> categories = query.getResultList();
		if (categories != null && categories.size() > 0)
			retMap.put(1, categories);

		Query countQuery = getEntityManager().createNativeQuery("SELECT COUNT(*) FROM category ");
		List<BigInteger> count = countQuery.getResultList();
		if (count != null && count.size() > 0)
			retMap.put(2, count.get(0));
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public List<NeighborhoodMaster> getNeighborhoodMasters(UserInfo userInfo) throws DAOException {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM neighborhoodmaster ");
		if (IntUtil.getInteger(userInfo.getCityId()) != null)
			sb.append("WHERE CityId=? ");
		sb.append(" ORDER BY NeighborhoodName ASC ");
		Query query = getEntityManager().createNativeQuery(sb.toString(), NeighborhoodMaster.class);
		if (IntUtil.getInteger(userInfo.getCityId()) != null)
			query.setParameter(1, IntUtil.getInteger(userInfo.getCityId()));
		List<NeighborhoodMaster> categories = query.getResultList();
		if (categories != null && categories.size() > 0)
			return categories;
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantMaster> getAllMerchantList(UserInfo userInfo) throws DAOException {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM merchantmaster ");
		if (userInfo.getCityText() != null)
			sb.append("WHERE City=? ");
		sb.append("ORDER BY MerchantName ASC ");
		Query query = getEntityManager().createNativeQuery(sb.toString(), MerchantMaster.class);
		if (userInfo.getCityText() != null)
			query.setParameter(1, userInfo.getCityText());
		List<MerchantMaster> categories = query.getResultList();
		if (categories != null && categories.size() > 0)
			return categories;
		return null;
	}

	@SuppressWarnings("unchecked")
	public boolean isCategoryExist(String categoryName, Integer categoryId) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT * FROM category WHERE CategoryName=?");
		if (categoryId != null)
			queryString.append(" AND CategoryId<>?");
		Query query = getEntityManager().createNativeQuery(queryString.toString(), Category.class);
		query.setParameter(1, categoryName);
		if (categoryId != null)
			query.setParameter(2, categoryId);
		List<Category> categories = query.getResultList();
		if (categories != null && categories.size() > 0)
			return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public boolean isSubCategoryExist(SubCategoryDTO subCategoryDTO, Integer subCategoryId) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT * FROM subcategory WHERE SubCategoryName=? AND CategoryId=?");
		if (subCategoryId != null)
			queryString.append(" AND SubCategoryId<>?");
		Query query = getEntityManager().createNativeQuery(queryString.toString(), SubCategory.class);
		query.setParameter(1, subCategoryDTO.getSubCategoryName());
		query.setParameter(2, IntUtil.getInteger(subCategoryDTO.getCategoryId()));
		if (subCategoryId != null)
			query.setParameter(3, subCategoryId);
		List<SubCategory> categories = query.getResultList();
		if (categories != null && categories.size() > 0)
			return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<SalesPerson> getAllSalesPerson(UserInfo userInfo) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM salesperson ORDER BY SalesPersonFirstName ASC ", SalesPerson.class);
		List<SalesPerson> salesPersons = query.getResultList();
		if (salesPersons != null && salesPersons.size() > 0)
			return salesPersons;
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Cities> getAllCityDetails() throws BaseException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM gcdcities ORDER BY CityName ASC ", Cities.class);
		List<Cities> cities = query.getResultList();
		if (cities != null && cities.size() > 0)
			return cities;
		return null;
	}

	@SuppressWarnings("unchecked")
	public States getStateDetailsByCity(Integer cityId) throws BaseException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM gcdstate WHERE CityId=?", States.class);
		query.setParameter(1, cityId);
		List<States> states = query.getResultList();
		if (states != null && states.size() > 0)
			return states.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<LevelMaster> getAllLevelDetails(UserInfo userInfo) throws DAOException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM levelmaster ORDER BY LevelType ASC ", LevelMaster.class);
		List<LevelMaster> levelMasters = query.getResultList();
		if (levelMasters != null && levelMasters.size() > 0)
			return levelMasters;
		return null;
	}

	@SuppressWarnings("unchecked")
	public AdminSocialLink getAdminSocialLink(UserInfo userInfo) throws DAOException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM adminsociallink WHERE UserIndex=?", AdminSocialLink.class);
		query.setParameter(1, userInfo.getUserIndex());
		List<AdminSocialLink> adminSocialLinks = query.getResultList();
		if (adminSocialLinks != null && adminSocialLinks.size() > 0)
			return adminSocialLinks.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<AccessibiltyIcons> getAllIconsDetails(UserInfo userInfo) throws DAOException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM accessibiltyicons ORDER BY IconName ASC ", AccessibiltyIcons.class);
		List<AccessibiltyIcons> icons = query.getResultList();
		if (icons != null && icons.size() > 0)
			return icons;
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<Integer, Object> getAllDealzs(UserInfo userInfo, String dealType, String start) {
		Map<Integer, Object> retMap = new HashMap<Integer, Object>();
		Query query = getEntityManager().createNativeQuery(
				"SELECT * FROM merchantdealz WHERE status=1 AND CityId=? AND DealType=? ORDER BY UPDdate DESC LIMIT " + start + ",20", MerchantDealz.class);
		query.setParameter(1, IntUtil.getInteger(userInfo.getCityId()));
		query.setParameter(2, IntUtil.getInteger(dealType));
		List<MerchantDealz> merchantDealzs = query.getResultList();
		if (merchantDealzs != null && merchantDealzs.size() > 0)
			retMap.put(1, merchantDealzs);

		Query countQuery = getEntityManager().createNativeQuery("SELECT COUNT(*) FROM merchantdealz WHERE status=1 AND CityId=? AND DealType=?");
		countQuery.setParameter(1, IntUtil.getInteger(userInfo.getCityId()));
		countQuery.setParameter(2, IntUtil.getInteger(dealType));
		List<BigInteger> count = countQuery.getResultList();
		if (count != null && count.size() > 0)
			retMap.put(2, count.get(0));
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public MerchantDealz getMerchantDealzById(UserInfo userInfo, Integer dealId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantdealz WHERE DealzId=?", MerchantDealz.class);
		query.setParameter(1, dealId);
		List<MerchantDealz> merchantDealzs = query.getResultList();
		if (merchantDealzs != null && merchantDealzs.size() > 0)
			return merchantDealzs.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getCategoryMapByMerchant(UserInfo userInfo, String merchantId) throws DAOException {
		Map<String, String> retMap = null;
		Query query = getEntityManager().createNativeQuery(
				"SELECT a.CategoryId,b.CategoryName FROM merchantcategory a INNER JOIN category b ON a.CategoryId=b.CategoryId WHERE a.MerchantId=?");
		query.setParameter(1, IntUtil.getInteger(merchantId));
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			retMap = new LinkedHashMap<String, String>();
			for (Object[] o : rList)
				retMap.put(IntUtil.getString((Integer) o[0]), o[1].toString());
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getSubCategoryMapByMerchant(UserInfo userInfo, String merchantId) throws DAOException {
		Map<String, String> retMap = null;
		Query query = getEntityManager()
				.createNativeQuery(
						"SELECT a.SubCategoryId,b.SubCategoryName FROM merchantsubcategory a INNER JOIN subcategory b ON a.SubCategoryId=b.SubCategoryId WHERE a.MerchantId=?");
		query.setParameter(1, IntUtil.getInteger(merchantId));
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			retMap = new LinkedHashMap<String, String>();
			for (Object[] o : rList)
				retMap.put(IntUtil.getString((Integer) o[0]), o[1].toString());
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getNeighborhoodsAndCountDealz(UserInfo userInfo) throws DAOException {
		StringBuilder queryString = new StringBuilder();
		queryString
				.append("SELECT a.NeighborhoodId,a.NeighborhoodName,(SELECT COUNT(*) FROM merchantdealz c WHERE status=1 AND DealType=1 AND c.StartDate<=CONVERT_TZ(NOW(),'"
						+ getProperty("server.utc.time", "01")
						+ "',LocalTimeZoneUtc) AND c.EndDate>CONVERT_TZ(NOW(),'"
						+ getProperty("server.utc.time", "01")
						+ "',LocalTimeZoneUtc) AND c.MerchantId IN(SELECT b.MerchantId FROM merchantmaster b WHERE b.NeighborhoodName=a.NeighborhoodId)");
		if (userInfo.getCityId() != null)
			queryString.append(" AND CityId=" + userInfo.getCityId() + "");
		queryString.append(" )AS COUNTS FROM neighborhoodmaster a GROUP BY a.NeighborhoodId ORDER BY a.NeighborhoodName");

		Query query = getEntityManager().createNativeQuery(queryString.toString());
		List<Object[]> objects = query.getResultList();
		if (objects != null && objects.size() > 0)
			return objects;
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantDealz> getAllDealzByNeighborhoodId(UserInfo userInfo, String neighborhoodId) throws DAOException {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT * FROM merchantdealz WHERE status=1 AND DealType=1 AND StartDate<=CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01")
				+ "',LocalTimeZoneUtc) AND EndDate>CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01")
				+ "',LocalTimeZoneUtc) AND merchantId IN(SELECT MerchantId FROM merchantmaster WHERE NeighborhoodName=?)");
		if (userInfo.getCityId() != null)
			queryString.append(" AND Cityid=" + userInfo.getCityId());
		queryString.append(" ORDER BY StartDate DESC");
		Query query = getEntityManager().createNativeQuery(queryString.toString(), MerchantDealz.class);
		query.setParameter(1, IntUtil.getInteger(neighborhoodId));
		List<MerchantDealz> objects = query.getResultList();
		if (objects != null && objects.size() > 0)
			return objects;
		return null;
	}

	@SuppressWarnings("unchecked")
	public NeighborhoodMaster getNeighborhoodsName(UserInfo userInfo, String neighborhoodId) throws BaseException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM neighborhoodmaster WHERE NeighborhoodId=?", NeighborhoodMaster.class);
		query.setParameter(1, IntUtil.getInteger(neighborhoodId));
		List<NeighborhoodMaster> neighborhoodMasters = query.getResultList();
		if (neighborhoodMasters != null && neighborhoodMasters.size() > 0)
			return neighborhoodMasters.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantDealz> getAllDealsByMasterCategory(UserInfo userInfo, String masterCategory) throws BaseException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM mastercategory WHERE CategoryName LIKE ?", MasterCategory.class);
		query.setParameter(1, "%" + masterCategory);
		List<MasterCategory> mCategory = query.getResultList();
		if (mCategory != null && mCategory.size() > 0) {
			Query query1 = getEntityManager().createNativeQuery("SELECT MerchantId FROM merchantmaster WHERE MasterCategory=?");
			query1.setParameter(1, mCategory.get(0).getCategoryId());
			List<Integer> merchantId = query1.getResultList();
			List<String> strIdx = new ArrayList<String>(merchantId.size());
			String idx = "";
			for (Integer myInt : merchantId) {
				strIdx.add(String.valueOf(myInt));
			}
			if (merchantId != null && merchantId.size() > 0) {
				//idx = org.apache.commons.lang.StringUtils.join(strIdx, ',');
			}

			if (idx.length() > 0) {
				StringBuilder sb = new StringBuilder();
				sb.append("SELECT * FROM merchantdealz WHERE status=1 AND DealType=1 AND StartDate<=CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01")
						+ "',LocalTimeZoneUtc) AND EndDate>CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01") + "',LocalTimeZoneUtc)");
				if (idx != null && !idx.trim().isEmpty())
					sb.append("AND MerchantId IN(" + idx + ")");
				sb.append("ORDER BY StartDate DESC ");
				Query query2 = getEntityManager().createNativeQuery(sb.toString(), MerchantDealz.class);
				List<MerchantDealz> merchantDealzs = query2.getResultList();
				if (merchantDealzs != null && merchantDealzs.size() > 0)
					return merchantDealzs;
			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getAllCategoryAndCountDealz(UserInfo userInfo) throws DAOException {
		StringBuilder queryString = new StringBuilder();
		queryString
				.append("SELECT a.CategoryId,a.CategoryName,(SELECT COUNT(*) FROM merchantdealz c INNER JOIN categorydealzlink d ON (c.DealzId=d.DealzId AND c.MerchantId=d.MerchantId) WHERE status=1 AND DealType=1 AND c.StartDate<=CONVERT_TZ(NOW(),'"
						+ getProperty("server.utc.time", "01")
						+ "',LocalTimeZoneUtc) AND c.EndDate>CONVERT_TZ(NOW(),'"
						+ getProperty("server.utc.time", "01")
						+ "',LocalTimeZoneUtc) AND d.CategoryId=a.CategoryId");
		if (userInfo.getCityId() != null)
			queryString.append(" AND CityId=" + userInfo.getCityId() + "");
		queryString.append(" )AS COUNTS FROM category a GROUP BY a.CategoryId ORDER BY a.CategoryName");
		Query query = getEntityManager().createNativeQuery(queryString.toString());
		List<Object[]> objects = query.getResultList();
		if (objects != null && objects.size() > 0)
			return objects;
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantDealz> getAllDelsByCategoryAndSubCategoryId(UserInfo userInfo, String categoryId, String subCategoryId) {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT * FROM merchantdealz a INNER JOIN subcategorydealzlink b ON a.DealzId=b.DealzId WHERE status=1 AND DealType=1 ");
		if (userInfo.getCityId() != null)
			queryString.append(" AND CityId=" + userInfo.getCityId());
		queryString.append("  AND a.StartDate<=CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01")
				+ "',LocalTimeZoneUtc) AND a.EndDate>CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01")
				+ "',LocalTimeZoneUtc) AND b.SubCategoryId=? ORDER BY a.StartDate DESC");
		Query query = getEntityManager().createNativeQuery(queryString.toString(), MerchantDealz.class);
		query.setParameter(1, IntUtil.getInteger(subCategoryId));
		List<MerchantDealz> merchantDealzs = query.getResultList();
		return merchantDealzs;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantDealz> getAllDealzByCategoryId(UserInfo userInfo, String categoryId) throws BaseException {
		StringBuilder queryString = new StringBuilder();
		queryString
				.append("SELECT * FROM merchantdealz a INNER JOIN categorydealzlink b ON a.DealzId=b.DealzId WHERE status=1 AND DealType=1 AND a.StartDate<=CONVERT_TZ(NOW(),'"
						+ getProperty("server.utc.time", "01")
						+ "',LocalTimeZoneUtc) AND a.EndDate>CONVERT_TZ(NOW(),'"
						+ getProperty("server.utc.time", "01")
						+ "',LocalTimeZoneUtc) AND b.CategoryId=? ");
		if (userInfo.getCityId() != null)
			queryString.append(" AND CityId=" + userInfo.getCityId());
		queryString.append("  ORDER BY a.StartDate DESC");
		Query query = getEntityManager().createNativeQuery(queryString.toString(), MerchantDealz.class);
		query.setParameter(1, IntUtil.getInteger(categoryId));
		List<MerchantDealz> merchantDealzs = query.getResultList();
		return merchantDealzs;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantMaster> getMerchantListInRange(UserInfo userInfo, String range, Integer flag) throws BaseException {
		String regex = "BETWEEN " + range;
		if (flag != null)
			regex = range;
		Query query = getEntityManager().createNativeQuery(
				"SELECT * FROM merchantmaster WHERE Status=1 AND MerchantName " + regex + " ORDER BY MerchantName ASC", MerchantMaster.class);
		List<MerchantMaster> merchantMasters = query.getResultList();
		if (merchantMasters != null && merchantMasters.size() > 0)
			return merchantMasters;
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantDealz> getDealzByMerchantId(UserInfo userInfo, String merchantId, Integer start, Integer count) throws BaseException {
		Query query = getEntityManager().createNativeQuery(
				"SELECT * FROM merchantdealz WHERE status=1 AND StartDate<=CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01")
						+ "',LocalTimeZoneUtc) AND DealType=1 AND MerchantId=? ORDER BY StartDate DESC ", MerchantDealz.class);
		query.setParameter(1, IntUtil.getInteger(merchantId));
		List<MerchantDealz> merchantDealzs = query.getResultList();
		return merchantDealzs;
	}

	@SuppressWarnings("unchecked")
	public MerchantDealz getMyLatestDeal(Integer userIndex) {
		Query query = getEntityManager().createNativeQuery(
				"SELECT * FROM merchantdealz WHERE status=1 AND DealType=1 AND MerchantId=? ORDER BY UPDDate DESC LIMIT 0,1", MerchantDealz.class);
		query.setParameter(1, userIndex);
		List<MerchantDealz> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			return rList.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Cities getCityDetails(String cityId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM gcdcities WHERE CityId=?", Cities.class);
		query.setParameter(1, IntUtil.getInteger(cityId));
		List<Cities> cities = query.getResultList();
		if (cities != null && cities.size() > 0) {
			return cities.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public boolean isAlreadySubscribed(String merchantId, String emailId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM dealzsubscriptiondetails WHERE EmailId=? AND MerchantId=?",
				DealzSubscriptionDetails.class);
		query.setParameter(1, emailId);
		query.setParameter(2, IntUtil.getInteger(merchantId));
		List<DealzSubscriptionDetails> cities = query.getResultList();
		if (cities != null && cities.size() > 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public SocialConnections getSocialConnectionsByMerchantId(Integer merchantId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM socialconnections WHERE MerchantId=?", SocialConnections.class);
		query.setParameter(1, merchantId);
		List<SocialConnections> connections = query.getResultList();
		if (connections != null && connections.size() > 0) {
			return connections.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getMediaByMerchantId(String merchantId) {
		Query query = getEntityManager().createNativeQuery(
				"SELECT a.DocID,a.DocumentTitle FROM documents a INNER JOIN documentlink b ON a.DocID=b.DocID WHERE b.MerchantID=? AND b.DocType=1");
		query.setParameter(1, IntUtil.getInteger(merchantId));
		List<Object[]> objects = query.getResultList();
		if (objects != null && objects.size() > 0) {
			return objects;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getStateMap(UserInfo userInfo, String cityId) throws DAOException {
		Map<String, String> retMap = null;
		Query query = getEntityManager().createNativeQuery("SELECT StateId,StateName FROM gcdstate WHERE CityId=?");
		query.setParameter(1, IntUtil.getInteger(cityId));
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			retMap = new LinkedHashMap<String, String>();
			for (Object[] o : rList)
				retMap.put(IntUtil.getString((Integer) o[0]), o[1].toString());
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public boolean isDealCodeUnique(String dealId, String dealCode) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT * FROM merchantdealz WHERE DealType=1 AND Code=?");
		if (!isEmpty(dealId))
			sb.append(" AND DealzId!=?");
		Query query = getEntityManager().createNativeQuery(sb.toString());
		query.setParameter(1, dealCode);
		if (!isEmpty(dealId))
			query.setParameter(2, IntUtil.getInteger(dealId));
		List<Object[]> objects = query.getResultList();
		if (objects != null && objects.size() > 0) {
			return false;
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	public List<GcdPost> getPostByMerchantId(String merchantId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM gcdpost WHERE MerchantId=? ORDER BY UPDDate DESC", GcdPost.class);
		query.setParameter(1, IntUtil.getInteger(merchantId));
		List<GcdPost> post = query.getResultList();
		if (post != null && post.size() > 0) {
			return post;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public GcdPost getPostContentById(String postId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM gcdpost WHERE PostId=?", GcdPost.class);
		query.setParameter(1, IntUtil.getInteger(postId));
		List<GcdPost> post = query.getResultList();
		if (post != null && post.size() > 0) {
			return post.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public MerchantDealz getDealzById(String dealzId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantdealz WHERE status=1 AND DealType=1 AND DealzId=?", MerchantDealz.class);
		query.setParameter(1, IntUtil.getInteger(dealzId));
		List<MerchantDealz> dealzs = query.getResultList();
		if (dealzs != null && dealzs.size() > 0) {
			return dealzs.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public MerchantDealz getLatestMerchantDealzById(UserInfo userInfo, Integer merchantId) {
		Query query = getEntityManager().createNativeQuery(
				"SELECT * FROM merchantdealz WHERE status=1 AND DealType=1 AND MerchantId=? AND EndDate>=CONVERT_TZ(NOW(),'"
						+ getProperty("server.utc.time", "01") + "',LocalTimeZoneUtc) ORDER BY UPDdate DESC LIMIT 0,1", MerchantDealz.class);
		query.setParameter(1, merchantId);
		List<MerchantDealz> dealzs = query.getResultList();
		if (dealzs != null && dealzs.size() > 0) {
			return dealzs.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Category> getAllCategories(UserInfo userInfo) throws DAOException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM category ", Category.class);
		List<Category> categories = query.getResultList();
		if (categories != null && categories.size() > 0) {
			return categories;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<SubCategory> getAllSubCategories(UserInfo userInfo) throws DAOException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM subcategory ", SubCategory.class);
		List<SubCategory> subCtg = query.getResultList();
		if (subCtg != null && subCtg.size() > 0) {
			return subCtg;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getMerchantCategoriesById(Integer merchantId) {
		Query query = getEntityManager().createNativeQuery("SELECT CategoryId FROM merchantcategory WHERE MerchantId=?");
		query.setParameter(1, merchantId);
		List<Object> categories = query.getResultList();
		if (categories != null && categories.size() > 0) {
			return categories;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Object> getMerchantSubCategoriesById(Integer merchantId) {
		Query query = getEntityManager().createNativeQuery("SELECT SubCategoryId FROM merchantsubcategory WHERE MerchantId=?");
		query.setParameter(1, merchantId);
		List<Object> subCategories = query.getResultList();
		if (subCategories != null && subCategories.size() > 0) {
			return subCategories;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public boolean isSubscriberEmailAvailable(String emailId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM subscribers WHERE EmailId=?");
		query.setParameter(1, emailId);
		List<Object> subscs = query.getResultList();
		if (subscs != null && subscs.size() > 0) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getCategoryNames(String categories) {
		Map<String, Object> retMap = null;
		Query query = getEntityManager().createNativeQuery("SELECT CategoryId,CategoryName FROM category WHERE CategoryId IN(" + categories + ")");
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			retMap = new LinkedHashMap<String, Object>();
			for (Object[] o : rList)
				retMap.put(IntUtil.getString((Integer) o[0]), o[1].toString());
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, Object> getNeighborhoodNames(String nId) {
		Map<String, Object> retMap = null;
		Query query = getEntityManager().createNativeQuery(
				"SELECT NeighborhoodId,NeighborhoodName FROM neighborhoodmaster WHERE NeighborhoodId IN(" + nId + ")");
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			retMap = new LinkedHashMap<String, Object>();
			for (Object[] o : rList)
				retMap.put(IntUtil.getString((Integer) o[0]), o[1].toString());
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public String getMerchantSubscriberEmails(Integer merchantId) {
		Query query = getEntityManager().createNativeQuery("SELECT EmailId FROM dealzsubscriptiondetails WHERE MerchantId=?");
		query.setParameter(1, merchantId);
		List<Object> emails = query.getResultList();
		String email = "";
		if (emails != null && emails.size() > 0) {
			for (Object o : emails) {
				email = email + (String) o + ",";
			}
		}

		if (email.length() > 0)
			email = email.substring(0, email.length() - 1);

		return email;
	}

	public Map<String, String> getSubscribedCtg(String[] categories) {
		Map<String, String> retMap = null;
		StringBuilder builder = new StringBuilder();
		for (String s : categories) {
			builder.append(s);
			builder.append(",");
		}
		String s = builder.substring(0, builder.length() - 1);
		Query query = getEntityManager().createNativeQuery("SELECT CategoryId,CategoryName FROM category WHERE CategoryId IN(" + s + ")");
		List<Object[]> ctgObjects = query.getResultList();
		if (ctgObjects != null && ctgObjects.size() > 0) {
			retMap = new HashMap<String, String>();
			for (Object[] o : ctgObjects) {
				retMap.put(((Integer) o[0]) + "", (String) o[1]);
			}
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getSubscribedNeighbour(String[] neighborhood) {
		Map<String, String> retMap = null;
		StringBuilder builder = new StringBuilder();
		for (String s : neighborhood) {
			builder.append(s);
			builder.append(",");
		}
		String s = builder.substring(0, builder.length() - 1);
		Query query = getEntityManager().createNativeQuery("SELECT NeighborhoodId,NeighborhoodName FROM neighborhoodmaster WHERE NeighborhoodId IN(" + s + ")");
		List<Object[]> nObjects = query.getResultList();
		if (nObjects != null && nObjects.size() > 0) {
			retMap = new HashMap<String, String>();
			for (Object[] o : nObjects) {
				retMap.put(((Integer) o[0]) + "", (String) o[1]);
			}
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getTimeZones() throws DAOException {
		Map<String, String> retMap = null;
		Query query = getEntityManager().createNativeQuery("SELECT Id, ZoneName,OffSet FROM gcd_times_zone");
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			retMap = new LinkedHashMap<String, String>();
			for (Object[] o : rList)
				retMap.put(IntUtil.getString((Integer) o[0]), o[1].toString() + " [" + o[2].toString() + "]");
		}
		return retMap;
	}

	public List<Object[]> getDealzByTileLike(String requestParam) throws DAOException {
		Query query = getEntityManager()
				.createNativeQuery(
						"SELECT Title,MerchantName,DealzId FROM merchantdealz a inner join merchantmaster b on(a.merchantId=b.merchantId) WHERE a.status=1 AND Title like ? LIMIT 0,15");
		query.setParameter(1, "%" + requestParam + "%");
		return query.getResultList();
	}

	public List<MerchantMaster> getDealzByMerchantNameLike(String requestParam) throws DAOException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantmaster WHERE MerchantName like ? LIMIT 0,15", MerchantMaster.class);
		query.setParameter(1, "%" + requestParam + "%");
		return query.getResultList();
	}

	public List<GcdSocialNav> getMetaById(Integer type) throws BaseException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM gcd_meta_nav WHERE Type=? ORDER BY Align ASC", GcdSocialNav.class);
		query.setParameter(1, type);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public String getLogoId(Integer merchantId) throws DAOException {
		Query query = getEntityManager().createNativeQuery(
				"SELECT d.DocId FROM documents d INNER JOIN documentlink dl ON d.DocId=dl.DocId WHERE MerchantId=? AND dl.DocType=12");
		query.setParameter(1, merchantId);
		List<Object> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return (Integer) rList.get(0) + "";
		return null;
	}

	public List<UserMaster> getUserMasters() {
		Query query = getEntityManager().createQuery("from UserMaster", UserMaster.class);
		return query.getResultList();
	}

	public boolean validateUserId(String userId, String userIndex) {
		String querys = "SELECT * FROM usermaster WHERE UserId=?";
		if (!isEmpty(userIndex))
			querys += " AND UserIndex!=?";
		Query query = getEntityManager().createNativeQuery(querys, UserMaster.class);
		query.setParameter(1, userId);
		if (!isEmpty(userIndex))
			query.setParameter(2, IntUtil.getInteger(userIndex));
		List<UserMaster> userMasters = query.getResultList();
		if (!isEmpty(userMasters)) {
			return true;
		}
		return false;
	}

	public boolean validateEmailId(String emailId, String userIndex) {
		String querys = "SELECT * FROM usermaster WHERE EmailId=?";
		if (!isEmpty(userIndex))
			querys += " AND UserIndex!=?";
		Query query = getEntityManager().createNativeQuery(querys, UserMaster.class);
		query.setParameter(1, emailId);
		if (!isEmpty(userIndex))
			query.setParameter(2, IntUtil.getInteger(userIndex));
		List<UserMaster> userMasters = query.getResultList();
		if (!isEmpty(userMasters)) {
			return true;
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getAllUserList() {
		Map<String, String> retMap = new LinkedHashMap<String, String>();
		Query query = getEntityManager().createQuery("from MerchantMaster m order by m.merchantName", MerchantMaster.class);
		List<MerchantMaster> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			for (MerchantMaster m : rList)
				retMap.put(IntUtil.getString(m.getMerchantId()), m.getMerchantName());
		}
		return retMap;
	}

	public SocialAccounts getSocialProfile(SocialProfileDTO dto) {
		SocialAccounts socialAccounts = null;
		Query query = getEntityManager().createNativeQuery("select * from gcd_social_account where EmailId=? and Account=?", SocialAccounts.class);
		query.setParameter(1, dto.getEmailId());
		query.setParameter(2, dto.getAccount());
		List<SocialAccounts> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			return rList.get(0);
		}
		return socialAccounts;
	}

	public String getNextOrderOfHotDeal() {
		Query query = getEntityManager().createNativeQuery("SELECT MAX(HotDealOrder) FROM merchantdealz m where dealType=2");
		Integer nextVal = (Integer) query.getResultList().get(0);
		return (nextVal + 1) + "";
	}

	public GcdPageManager getPageMetaByPageName(String pageName) {
		Query query = getEntityManager().createNativeQuery("select * from gcd_page_manager where PageUrl=?", GcdPageManager.class);
		query.setParameter(1, pageName);
		List<GcdPageManager> results = query.getResultList();
		if (!isEmpty(results)) {
			return results.get(0);
		}
		return null;
	}

	public List<GcdPageManager> getListOfPages() {
		Query query = getEntityManager().createNativeQuery("select * from gcd_page_manager", GcdPageManager.class);
		List<GcdPageManager> results = query.getResultList();
		return results;
	}

	public List<GcdRightHandRailsNav> getListOfRightHandRails() {
		Query query = getEntityManager().createNativeQuery("select * from gcd_content_manager Order By Align ASC", GcdRightHandRailsNav.class);
		List<GcdRightHandRailsNav> results = query.getResultList();
		return results;
	}

	@SuppressWarnings("unchecked")
	public String getDealImageId(Integer merchantId, int docType, Integer dealId) throws DAOException {
		Query query = getEntityManager().createNativeQuery(
				"SELECT d.DocId FROM documents d INNER JOIN documentlink dl ON d.DocId=dl.DocId WHERE MerchantId=? AND dl.DocType=? AND DealId=?");
		query.setParameter(1, merchantId);
		query.setParameter(2, docType);
		query.setParameter(3, dealId);
		List<Object> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return (Integer) rList.get(0) + "";
		return null;
	}
}
