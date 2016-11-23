package com.app.getcitydealz.dao;

import static com.app.utility.common.AppPropertyBuilder.getProperty;

import java.io.Serializable;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.persistence.Query;

import com.app.commonexception.BaseException;
import com.app.getcitydealz.dto.MerchantCategoryDTO;
import com.app.login.dto.UserInfo;
import com.app.model.base.Base;
import com.app.model.getcitydealz.AdminSocialLink;
import com.app.model.getcitydealz.MerchantCategory;
import com.app.model.getcitydealz.MerchantDealz;
import com.app.model.getcitydealz.MerchantEmbeds;
import com.app.model.getcitydealz.MerchantFeatureLink;
import com.app.model.getcitydealz.MerchantLocation;
import com.app.model.getcitydealz.MerchantMaster;
import com.app.model.getcitydealz.MerchantSubCategory;
import com.app.model.merchantlevel.MerchantLevel;
import com.app.model.socialconnections.AdminFBAccessToken;
import com.app.model.socialconnections.AdminTwitterOAuth;
import com.app.model.socialconnections.SocialConnections;
import com.app.model.socialconnections.TwitterOAuthdetails;
import com.app.model.subscriber.Subscribers;
import com.app.model.user.UserMaster;
import com.app.persistence.JPADAO;
import com.app.persistence.exception.DAOException;
import com.app.utility.common.DateUtil;
import com.app.utility.common.IntUtil;

public class MerchantDAO<T extends Base<I>, I extends Serializable> extends JPADAO<T, I> {

	@SuppressWarnings("unchecked")
	public boolean canProstDealz(UserInfo userInfo) {
		Query query = getEntityManager().createNativeQuery(
				"SELECT CRTdate FROM merchantdealz WHERE status=1 AND DealType=1 AND MerchantId=? ORDER BY CRTDate DESC LIMIT 1");
		query.setParameter(1, userInfo.getUserIndex());
		List<Object> mDealzs = query.getResultList();
		if (mDealzs != null && mDealzs.size() > 0) {
			Object latestDealz = mDealzs.get(0);
			if (latestDealz == null)
				return true;
			Date crtDate = (Date) latestDealz;
			long interval = ((new Date()).getTime() - crtDate.getTime()) / (60 * 1000);
			// if user have basic plan
			if (interval < 60)
				return false;
		}
		return true;
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
	public List<MerchantDealz> getAllDealz(UserInfo userInfo, Integer dealType) throws DAOException {
		StringBuilder queryString = new StringBuilder();
		queryString.append("SELECT * FROM merchantdealz WHERE MerchantId=? AND DealType=? ORDER BY UPDdate DESC");

		Query query = getEntityManager().createNativeQuery(queryString.toString(), MerchantDealz.class);
		query.setParameter(1, userInfo.getUserIndex());
		query.setParameter(2, dealType);
		List<MerchantDealz> merchantDealzs = query.getResultList();
		return merchantDealzs;
	}

	@SuppressWarnings("unchecked")
	public boolean isEmailIsRegistered(String emailId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantmaster WHERE EmailId=?");
		query.setParameter(1, emailId);
		List<Object> mDealzs = query.getResultList();
		if (mDealzs != null && mDealzs.size() > 0)
			return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getMasterCategory(UserInfo userInfo) throws DAOException {
		Map<String, String> retMap = null;
		Query query = getEntityManager().createNativeQuery("SELECT CategoryId,CategoryName FROM mastercategory ORDER BY CategoryName ASC ");
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			retMap = new LinkedHashMap<String, String>();
			for (Object[] o : rList)
				retMap.put(IntUtil.getString((Integer) o[0]), o[1].toString());
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getCategory(UserInfo userInfo) throws DAOException {
		Map<String, String> retMap = null;
		Query query = getEntityManager().createNativeQuery("SELECT CategoryId,CategoryName FROM category ORDER BY CategoryName ASC ");
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			retMap = new LinkedHashMap<String, String>();
			for (Object[] o : rList)
				retMap.put(IntUtil.getString((Integer) o[0]), o[1].toString());
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantCategory> getMerchantCategory(Integer merchantId) throws BaseException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantcategory WHERE MerchantId=?", MerchantCategory.class);
		query.setParameter(1, merchantId);
		List<MerchantCategory> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return rList;
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantFeatureLink> getMerchentFeatuer(Integer merchantId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantfeature WHERE MerchantId=?", MerchantFeatureLink.class);
		query.setParameter(1, merchantId);
		List<MerchantFeatureLink> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return rList;
		return null;
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
	public String getLogoInfo(Integer merchantId) throws DAOException {
		Query query = getEntityManager().createNativeQuery(
				"SELECT FileSavedAs FROM documents d INNER JOIN documentlink dl ON d.DocId=dl.DocId WHERE MerchantId=? AND dl.DocType=2");
		query.setParameter(1, merchantId);
		List<Object> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return (String) rList.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public String getLogoId(Integer merchantId) throws DAOException {
		Query query = getEntityManager().createNativeQuery(
				"SELECT d.DocId FROM documents d INNER JOIN documentlink dl ON d.DocId=dl.DocId WHERE MerchantId=? AND dl.DocType=2");
		query.setParameter(1, merchantId);
		List<Object> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return (Integer) rList.get(0) + "";
		return null;
	}

	@SuppressWarnings("unchecked")
	public SocialConnections getMySocialConnections(Integer userIndex) throws BaseException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM socialconnections WHERE MerchantId=?", SocialConnections.class);
		query.setParameter(1, userIndex);
		List<SocialConnections> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return rList.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public TwitterOAuthdetails getMyTwitterOAuthdetails(Integer merchantId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM twitteroauthdetails WHERE MerchantId=?", TwitterOAuthdetails.class);
		query.setParameter(1, merchantId);
		List<TwitterOAuthdetails> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return rList.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<String> getMediaFiles(UserInfo userInfo) throws DAOException {
		Query query = getEntityManager().createNativeQuery(
				"SELECT OrignalFileName FROM documents d INNER JOIN documentlink dl ON d.DocId=dl.DocId WHERE MerchantId=? AND dl.DocType=1");
		query.setParameter(1, userInfo.getUserIndex());
		List<String> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return rList;
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getSubCategoryMapByCategoryId(UserInfo userInfo, String categoryId) throws DAOException {
		Map<String, String> retMap = null;
		Query query = getEntityManager().createNativeQuery(
				"SELECT SubCategoryId,SubCategoryName FROM subcategory WHERE CategoryId=? ORDER BY SubCategoryName ASC");
		query.setParameter(1, IntUtil.getInteger(categoryId));
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			retMap = new LinkedHashMap<String, String>();
			for (Object[] o : rList)
				retMap.put(IntUtil.getString((Integer) o[0]), o[1].toString());
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public String getSubCategoryNameById(String merchantId, Integer categoryId) {
		Query query = getEntityManager()
				.createNativeQuery(
						"SELECT group_concat(a.SubCategoryName,'') FROM subcategory a inner join merchantsubcategory b on a.SubCategoryId=b.SubCategoryId Where b.MerchantId=? AND a.CategoryId=?");
		query.setParameter(1, IntUtil.getInteger(merchantId));
		query.setParameter(2, categoryId);
		List<String> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			return (String) rList.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String getMasterCategoryNameById(Integer categoryId) {
		Query query = getEntityManager().createNativeQuery("SELECT CategoryName FROM mastercategory WHERE CategoryId=?");
		query.setParameter(1, categoryId);
		List<String> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			return (String) rList.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String getCategoryNameById(Integer categoryId) {
		Query query = getEntityManager().createNativeQuery("SELECT CategoryName FROM category WHERE CategoryId=?");
		query.setParameter(1, categoryId);
		List<String> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			return (String) rList.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantDealz> getDealzDetailById(UserInfo userInfo, String dealId, String dealType) throws DAOException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantdealz WHERE DealType=" + dealType + " AND DealzId=?", MerchantDealz.class);
		query.setParameter(1, dealId);
		List<MerchantDealz> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			return rList;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public SocialConnections getMySocialConnection(Integer merchantId) throws BaseException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM socialconnections WHERE MerchantId=?", SocialConnections.class);
		query.setParameter(1, merchantId);
		List<SocialConnections> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			return rList.get(0);
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantDealz> getMyLatestDeal(Integer userIndex) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantdealz WHERE DealType=1 AND MerchantId=? ORDER BY UPDDate DESC LIMIT 0,5",
				MerchantDealz.class);
		query.setParameter(1, userIndex);
		List<MerchantDealz> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			return rList;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getSubscriptionLevel(UserInfo userInfo) throws DAOException {
		Map<String, String> retMap = null;
		Query query = getEntityManager().createNativeQuery("SELECT LevelId,LevelType FROM levelmaster ORDER BY LevelType ASC ");
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			retMap = new LinkedHashMap<String, String>();
			for (Object[] o : rList)
				retMap.put(IntUtil.getString((Integer) o[0]), o[1].toString());
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getFeatureMap(UserInfo userInfo) throws DAOException {
		Map<String, String> retMap = null;
		Query query = getEntityManager().createNativeQuery("SELECT IconId,IconName FROM accessibiltyicons ORDER BY IconName ASC ");
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			retMap = new LinkedHashMap<String, String>();
			for (Object[] o : rList)
				retMap.put(IntUtil.getString((Integer) o[0]), o[1].toString());
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getNeighborhoodMap(UserInfo userInfo) throws DAOException {
		Map<String, String> retMap = null;
		Query query = getEntityManager().createNativeQuery("SELECT NeighborhoodId,NeighborhoodName FROM neighborhoodmaster ORDER BY NeighborhoodName ASC ");
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			retMap = new LinkedHashMap<String, String>();
			for (Object[] o : rList)
				retMap.put(IntUtil.getString((Integer) o[0]), o[1].toString());
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public boolean isUserIdExist(String userId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantmaster WHERE UserId=?");
		query.setParameter(1, userId);
		List<Object> mMaster = query.getResultList();
		if (mMaster != null && mMaster.size() > 0)
			return true;
		return false;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantSubCategory> getMerchantSubCategory(Integer merchantId) throws BaseException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantsubcategory WHERE MerchantId=?", MerchantSubCategory.class);
		query.setParameter(1, merchantId);
		List<MerchantSubCategory> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return rList;
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getSalesPersonMap(UserInfo userInfo) throws DAOException {
		Map<String, String> retMap = null;
		Query query = getEntityManager().createNativeQuery(
				"SELECT SalesPersonId,SalesPersonFirstName FROM salesperson WHERE Status=1 ORDER BY SalesPersonFirstName ASC ");
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			retMap = new LinkedHashMap<String, String>();
			for (Object[] o : rList)
				retMap.put(IntUtil.getString((Integer) o[0]), o[1].toString());
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public Map<Integer, Object> getAllMerchantList(UserInfo userInfo, String start, String order) throws DAOException {
		Map<Integer, Object> retMap = new LinkedHashMap<Integer, Object>();
		String sortBy = "MerchantName";

		if ("desc".equals(order))
			sortBy = "CRTDate";

		Query query = getEntityManager().createNativeQuery(
				"SELECT * FROM merchantmaster WHERE City=? ORDER BY " + sortBy + " " + order + " LIMIT " + start + ",20", MerchantMaster.class);
		query.setParameter(1, userInfo.getCityId());
		List<MerchantMaster> categories = query.getResultList();
		if (categories != null && categories.size() > 0)
			retMap.put(1, categories);

		Query countQuery = getEntityManager().createNativeQuery("SELECT COUNT(*) FROM merchantmaster WHERE City=?");
		countQuery.setParameter(1, userInfo.getCityId());
		List<BigInteger> count = countQuery.getResultList();
		if (count != null && count.size() > 0)
			retMap.put(2, count.get(0));
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public MerchantLevel getMerchantLevelByMerchant(Integer mId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantlevel WHERE MerchantId=?", MerchantLevel.class);
		query.setParameter(1, mId);
		List<MerchantLevel> merchantLevels = query.getResultList();
		if (merchantLevels != null && merchantLevels.size() > 0)
			return merchantLevels.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantCategory> getMerchantCtgByMerchant(Integer mId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantcategory WHERE MerchantId=?", MerchantCategory.class);
		query.setParameter(1, mId);
		List<MerchantCategory> merchantCategories = query.getResultList();
		if (merchantCategories != null && merchantCategories.size() > 0)
			return merchantCategories;
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getSubCategoryMap(String merchantId, String categoryId) throws BaseException {
		Map<String, String> retMap = null;
		Query query = getEntityManager().createNativeQuery(
				"SELECT a.SubCategoryId,a.SubCategoryName FROM subcategory a Where  a.CategoryId=? ORDER BY a.SubCategoryName ASC");
		query.setParameter(1, IntUtil.getInteger(categoryId));
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			retMap = new LinkedHashMap<String, String>();
			for (Object[] o : rList)
				retMap.put(IntUtil.getString((Integer) o[0]), o[1].toString());
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantCategoryDTO> getSelectedSubCategories(String mershantId, String categoryId, Integer type) throws DAOException {
		List<MerchantCategoryDTO> list = new ArrayList<MerchantCategoryDTO>();
		Query query = getEntityManager()
				.createNativeQuery(
						"SELECT a.SubCategoryId,b.CategoryType,b.CategoryId FROM subcategory a inner join merchantsubcategory b on a.SubCategoryId=b.SubCategoryId Where b.MerchantId=?");
		query.setParameter(1, IntUtil.getInteger(mershantId));
		List<Object[]> rList = query.getResultList();
		if (rList != null && rList.size() > 0) {
			for (Object[] o : rList) {
				MerchantCategoryDTO categoryDTO = new MerchantCategoryDTO();
				categoryDTO.setCategoryId(IntUtil.getString((Integer) o[2]));
				categoryDTO.setCategoryType(IntUtil.getString((Integer) o[1]));
				categoryDTO.setSubCatgoryId(IntUtil.getString((Integer) o[0]));
				list.add(categoryDTO);
			}
			return list;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getSubCategoryListByCategoryId(UserInfo userInfo, String categoryId) throws DAOException {
		StringBuilder queryString = new StringBuilder();
		queryString
				.append("SELECT a.SubCategoryId,a.SubCategoryName,(SELECT COUNT(*) FROM merchantdealz c INNER JOIN subcategorydealzlink d ON (c.DealzId=d.DealzId AND c.MerchantId=d.MerchantId) WHERE status=1 AND DealType=1");
		if (userInfo.getCityId() != null)
			queryString.append(" AND CityId=" + userInfo.getCityId() + "");
		queryString.append(" AND c.StartDate<=CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01")
				+ "',LocalTimeZoneUtc) AND c.EndDate>CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01")
				+ "',LocalTimeZoneUtc) AND d.SubCategoryId=a.SubCategoryId) AS COUNTS FROM subcategory a WHERE a.CategoryId=" + categoryId
				+ " GROUP BY a.SubCategoryId");
		Query query = getEntityManager().createNativeQuery(queryString.toString());
		List<Object[]> subCategories = query.getResultList();
		if (subCategories != null && subCategories.size() > 0)
			return subCategories;
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getHighestRatedDealz(UserInfo userInfo) {
		Query query = getEntityManager()
				.createNativeQuery(
						"select a.dealzId,a.title from merchantdealz a inner join dealzrating b on a.dealzId=b.dealId where status=1 AND DealType=1 AND a.MerchantId=? AND b.CurrentRating=(select MAX(k.CurrentRating) from merchantdealz l inner join dealzrating k on l.dealzId=k.dealId where status=1 AND DealType=1 AND l.MerchantId=?) ORDER BY CurrentRating DESC LIMIT 0,5");
		query.setParameter(1, userInfo.getUserIndex());
		query.setParameter(2, userInfo.getUserIndex());
		List<Object[]> dealz = query.getResultList();
		if (dealz != null && dealz.size() > 0)
			return dealz;
		return null;
	}

	@SuppressWarnings("unchecked")
	public Map<Integer, String> checkUserCanPost(UserInfo userInfo) {
		Map<Integer, String> retMap = null;
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantlevel Where MerchantId=?", MerchantLevel.class);
		query.setParameter(1, userInfo.getUserIndex());
		List<MerchantLevel> levelMasters = query.getResultList();

		if (levelMasters != null && levelMasters.size() > 0) {
			MerchantLevel levelMaster = levelMasters.get(0);
			Query query1 = getEntityManager()
					.createNativeQuery(
							"SELECT a.CRTdate FROM merchantdealz a INNER JOIN merchantlevel b ON (a.MerchantId=b.MerchantId) WHERE status=1 AND DealType=1 AND a.MerchantId=? AND b.LevelId=? ORDER BY a.CRTDate DESC LIMIT 1");
			query1.setParameter(1, userInfo.getUserIndex());
			query1.setParameter(2, levelMaster.getMerchantLevelPK().getLevelId());
			List<Object> mDealzs = query1.getResultList();
			if (mDealzs != null && mDealzs.size() > 0) {
				Object latestDealz = mDealzs.get(0);
				if (latestDealz == null)
					return null;
				Date crtDate = (Date) latestDealz;
				DateFormat dateFormat = new SimpleDateFormat(userInfo.getDateTimeFormat());
				Date curr = DateUtil.stringDateToDate(dateFormat.format(new Date()), userInfo.getDateTimeFormat());

				long interval = TimeUnit.MILLISECONDS.toMinutes(((curr).getTime() - crtDate.getTime()));

				if (interval < 60 && levelMaster.getMerchantLevelPK().getLevelId().equals(1)) {// BASIC{
					retMap = new HashMap<Integer, String>();
					retMap.put(1,
							"As a Basic Member You Can Only Post 1 Deal in a 24 Hour Period.  Please Consider Upgrading If You'd Like To Post Another Deal Before Tomorrow.");
					return retMap;
				}

			}
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public String getMyLevel(UserInfo userInfo) throws BaseException {
		String levelId = null;
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantlevel WHERE MerchantId=?", MerchantLevel.class);
		query.setParameter(1, userInfo.getUserIndex());
		List<MerchantLevel> levels = query.getResultList();
		if (levels != null && levels.size() > 0) {
			levelId = levels.get(0).getMerchantLevelPK().getLevelId() + "";
		}
		return levelId;
	}

	public List<MerchantLocation> getMerchantAllLoction(Integer merchantId) {
		Query query = getEntityManager().createQuery("from MerchantLocation l WHERE l.merchantLocationPK.merchantId=?", MerchantLocation.class);
		query.setParameter(1, merchantId);
		List<MerchantLocation> locs = query.getResultList();
		return locs;
	}

	public List<MerchantDealz> getAllHotDeals(UserInfo userInfo) {
		Query query = getEntityManager().createQuery("from MerchantDealz l WHERE l.dealType=2 AND l.payed=1 ORDER BY HotDealOrder DESC", MerchantDealz.class);
		List<MerchantDealz> dealzs = query.getResultList();
		return dealzs;
	}

	public MerchantMaster getMerchantDetailByEmailId(String emailId) {
		MerchantMaster mMaster = null;
		Query query = getEntityManager().createQuery("from MerchantMaster m WHERE m.emailId=?", MerchantMaster.class);
		query.setParameter(1, emailId);
		List<MerchantMaster> mMasters = query.getResultList();
		if (mMasters != null && mMasters.size() > 0) {
			return mMasters.get(0);
		}
		return mMaster;
	}

	public UserMaster getAdminDetailsByEmailId(String emailId) {
		UserMaster mMaster = null;
		Query query = getEntityManager().createQuery("from UserMaster m WHERE m.emailId=?", UserMaster.class);
		query.setParameter(1, emailId);
		List<UserMaster> mMasters = query.getResultList();
		if (mMasters != null && mMasters.size() > 0) {
			return mMasters.get(0);
		}
		return mMaster;
	}

	public List<MerchantEmbeds> getMerchantEmbeds(Integer merchantId) {
		Query query = getEntityManager().createQuery("from MerchantEmbeds m WHERE m.merchantId=?", MerchantEmbeds.class);
		query.setParameter(1, merchantId);
		return query.getResultList();
	}

	public Date getDate(String offSet) {
		Query query = getEntityManager().createNativeQuery("SELECT CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01") + "','" + offSet + "')");
		return (Date) query.getSingleResult();
	}

	public MerchantMaster getMerchantMatsterByUrl(String merchantUrl) {
		Query query = getEntityManager().createQuery("from MerchantMaster m WHERE m.merchantUrl=?", MerchantMaster.class);
		query.setParameter(1, merchantUrl);
		return (MerchantMaster) query.getSingleResult();
	}

	public AdminSocialLink getAdminSocialConnection(Integer userIndex) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM adminsociallink WHERE UserIndex=?", AdminSocialLink.class);
		query.setParameter(1, userIndex);
		List<AdminSocialLink> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return rList.get(0);
		return null;
	}

	public Subscribers getSubscriberByEmailId(String subscriptionId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM subscribers WHERE EmailId=?", Subscribers.class);
		query.setParameter(1, subscriptionId);
		List<Subscribers> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return rList.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Subscribers> getSubscriberWithCategories(Integer subscriberType) {
		Query q = getEntityManager().createNativeQuery(" SELECT * FROM subscribers WHERE SubscriptionType=? AND IsActive!=1", Subscribers.class);
		q.setParameter(1, subscriberType);
		List<Subscribers> subscribers = q.getResultList();
		return subscribers;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getDealzListByCategoryToSend(Integer categoryId) {
		Query q = getEntityManager()
				.createNativeQuery(
						"SELECT DISTINCT c.MerchantName,a.Title,a.StartDate,a.EndDate,a.AmountSaving,a.Code,a.Description,c.MerchantId,a.DealzId,a.UseLogo,a.Restrictions,c.MerchantUrl FROM merchantdealz a INNER JOIN merchantmaster c On c.MerchantId=a.MerchantId INNER JOIN categorydealzlink b ON b.dealzId=a.DealzId WHERE a.DealType=1 AND a.status=1 AND StartDate<=CONVERT_TZ(NOW(),'"
								+ getProperty("server.utc.time", "01")
								+ "',LocalTimeZoneUtc) AND EndDate>CONVERT_TZ(NOW(),'"
								+ getProperty("server.utc.time", "01") + "',LocalTimeZoneUtc) AND b.CategoryId=? AND b.Processed!=1");
		q.setParameter(1, categoryId);
		List<Object[]> dealzList = q.getResultList();
		return dealzList;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getDealzListByNhoodToSend(Integer neighborhoodId) {
		Query q = getEntityManager()
				.createNativeQuery(
						"SELECT DISTINCT c.MerchantName,a.Title,a.StartDate,a.EndDate,a.AmountSaving,a.Code,a.Description,c.MerchantId,a.DealzId,a.UseLogo,a.Restrictions,c.MerchantUrl FROM merchantdealz a INNER JOIN merchantmaster c On c.MerchantId=a.MerchantId INNER JOIN neighborhooddealzlink b ON b.DealzId=a.DealzId WHERE a.DealType=1 AND a.status=1 AND StartDate<=CONVERT_TZ(NOW(),'"
								+ getProperty("server.utc.time", "01")
								+ "',LocalTimeZoneUtc) AND EndDate>CONVERT_TZ(NOW(),'"
								+ getProperty("server.utc.time", "01") + "',LocalTimeZoneUtc) AND b.NeighbourhoodId=? AND b.Processed!=1");
		q.setParameter(1, neighborhoodId);
		List<Object[]> dealzList = q.getResultList();
		return dealzList;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantDealz> getAllDealz() throws DAOException {
		Query query = getEntityManager().createNativeQuery(
				"SELECT * FROM merchantdealz  WHERE DealType=1 AND status=1 AND EndDate>CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01")
						+ "',LocalTimeZoneUtc) AND  StartDate<=CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01")
						+ "',LocalTimeZoneUtc) AND Processed NOT IN(0,1)", MerchantDealz.class);
		List<MerchantDealz> merchantDealzs = query.getResultList();
		return merchantDealzs;
	}

	@SuppressWarnings("unchecked")
	public List<MerchantDealz> getDealToPostOnGcdpage() throws DAOException {
		Query query = getEntityManager().createNativeQuery(
				"SELECT * FROM merchantdealz  WHERE DealType=1 AND status=1 AND AdminSocialPostedStatus NOT IN(0,1) AND EndDate>CONVERT_TZ(NOW(),'"
						+ getProperty("server.utc.time", "01") + "',LocalTimeZoneUtc) AND  StartDate<=CONVERT_TZ(NOW(),'"
						+ getProperty("server.utc.time", "01") + "',LocalTimeZoneUtc)", MerchantDealz.class);
		List<MerchantDealz> merchantDealzs = query.getResultList();
		return merchantDealzs;
	}

	@SuppressWarnings("unchecked")
	public List<AdminTwitterOAuth> getAdminTwitterTokens() {
		Query query = getEntityManager().createQuery("from " + AdminTwitterOAuth.class.getName(), AdminTwitterOAuth.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<AdminFBAccessToken> getAdminFBTokens() {
		Query query = getEntityManager().createQuery("from " + AdminFBAccessToken.class.getName(), AdminFBAccessToken.class);
		return query.getResultList();
	}
}
