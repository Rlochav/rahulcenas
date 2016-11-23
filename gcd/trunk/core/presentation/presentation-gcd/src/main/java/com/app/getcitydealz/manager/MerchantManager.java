package com.app.getcitydealz.manager;

import static com.app.mvc.util.UrlSortnerUtil.getSortUrl;
import static com.app.utility.common.AppPropertyBuilder.getProperty;
import static com.app.utility.common.StringUtil.getWithoutSpecial;
import static org.springframework.util.CollectionUtils.isEmpty;
import static org.springframework.util.StringUtils.isEmpty;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.deal.dto.DealzDTO;
import com.app.getcitydealz.dao.MerchantDAO;
import com.app.getcitydealz.dto.EmbedsDTO;
import com.app.getcitydealz.dto.HotDealBannerDTO;
import com.app.getcitydealz.dto.LocationDTO;
import com.app.getcitydealz.dto.MerchantCategoryDTO;
import com.app.getcitydealz.dto.MerchantDTO;
import com.app.getcitydealz.dto.SocialConnectionsDTO;
import com.app.getcitydealz.dto.SubCategoryDTO;
import com.app.login.dto.UserInfo;
import com.app.model.base.Base;
import com.app.model.citiesnstate.Cities;
import com.app.model.getcitydealz.AdminSocialLink;
import com.app.model.getcitydealz.AdminSocialLinkPK;
import com.app.model.getcitydealz.MerchantCategory;
import com.app.model.getcitydealz.MerchantCategoryPK;
import com.app.model.getcitydealz.MerchantDealz;
import com.app.model.getcitydealz.MerchantDealzPK;
import com.app.model.getcitydealz.MerchantEmbeds;
import com.app.model.getcitydealz.MerchantFeatureLink;
import com.app.model.getcitydealz.MerchantFeatureLinkPK;
import com.app.model.getcitydealz.MerchantLocation;
import com.app.model.getcitydealz.MerchantLocationPK;
import com.app.model.getcitydealz.MerchantMaster;
import com.app.model.getcitydealz.MerchantSubCategory;
import com.app.model.getcitydealz.MerchantSubCategoryPK;
import com.app.model.getcitydealz.NeighborhoodMaster;
import com.app.model.getcitydealz.NeighborhoodMasterPK;
import com.app.model.merchantlevel.MerchantLevel;
import com.app.model.merchantlevel.MerchantLevelPK;
import com.app.model.salesperson.SalesPerson;
import com.app.model.socialconnections.AdminFBAccessToken;
import com.app.model.socialconnections.AdminTwitterOAuth;
import com.app.model.socialconnections.FBAccessTokeMerchantLink;
import com.app.model.socialconnections.SocialConnections;
import com.app.model.socialconnections.SocialConnectionsPK;
import com.app.model.socialconnections.TwitterOAuth;
import com.app.model.socialconnections.TwitterOAuthdetails;
import com.app.model.socialconnections.TwitterOAuthdetailsPK;
import com.app.model.subscriber.Subscribers;
import com.app.model.user.UserMaster;
import com.app.persistence.DefaultKeyGenerator;
import com.app.persistence.exception.DAOException;
import com.app.persistence.factory.JPADAOFactory;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.DateUtil;
import com.app.utility.common.IntUtil;
import com.app.utility.common.StringUtil;

@Repository
public class MerchantManager {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public MerchantDAO<Base<Serializable>, Serializable> loadDAO() throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> loginDAO = null;
		try {
			loginDAO = (MerchantDAO<Base<Serializable>, Serializable>) JPADAOFactory.getDAOFactory(JPADAOFactory.DEFAULT).getDAO(MerchantDAO.class);
			loginDAO.setEntityManager(entityManager);
		} catch (BaseException e) {
			throw e;
		}
		return loginDAO;
	}

	public MerchantDTO doRegisterMerchant(UserInfo userInfo, MerchantDTO merchantDTO) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		Integer merchantId = IntUtil.getInteger(merchantDTO.getMerchantId());
		MerchantMaster merchantMaster = null;
		MerchantLevel merchantLevel = null;

		try {
			if (merchantId != null) {
				merchantMaster = entityManager.find(MerchantMaster.class, merchantId);
			}

			// For UserId unique
			if (merchantDTO.getGetCityDealzName() != null && !merchantDTO.getGetCityDealzName().trim().isEmpty()) {
				if (dao.isUserIdExist(merchantDTO.getGetCityDealzName()))
					throw new BusinessException("This Get City Dealz Name already taken some one.Please try another.", BusinessException.BUSSINESS_TYP);
			} else
				throw new BusinessException("Get City Dealz Name is mandatory.", BusinessException.BUSSINESS_TYP);

			// For EMailId unique
			if (merchantDTO.getEmailId() != null && !merchantDTO.getEmailId().trim().isEmpty()) {
				if (dao.isEmailIsRegistered(merchantDTO.getEmailId()))
					throw new BusinessException("e-Mail Id is already associated with existing account", BusinessException.BUSSINESS_TYP);
			} else
				throw new BusinessException("e-Mail Id is mandatory.", BusinessException.BUSSINESS_TYP);

			if (merchantMaster == null) {
				String nextKey = DefaultKeyGenerator.getNextGeneratedKey("merchantId", entityManager);
				merchantMaster = new MerchantMaster();
				merchantMaster.setMerchantId(IntUtil.getInteger(nextKey));
				merchantDTO.setMerchantId(nextKey);
				// Merchant Level
				merchantLevel = new MerchantLevel();
				merchantLevel.setMerchantLevelPK(new MerchantLevelPK(IntUtil.getInteger(nextKey), IntUtil.getInteger(merchantDTO.getSubscriptionLevel())));
				merchantLevel.setCreatedBy(0);
				merchantLevel.setCreatedDate(new Date());
				merchantLevel.setUpdatedBy(0);
				merchantLevel.setUpdatedDate(new Date());
				entityManager.merge(merchantLevel);
				merchantMaster.setCreatedBy(0);
				merchantMaster.setCreatedDate(new Date());
			}
			merchantMaster.setStatus(1);
			merchantMaster.setMasterCategory(IntUtil.getInteger(merchantDTO.getMasterCategory()));
			merchantMaster.setUserId(merchantDTO.getGetCityDealzName());
			merchantMaster.setPassword(merchantDTO.getPassword());
			merchantMaster.setMerchantName(merchantDTO.getMerchantName());
			merchantMaster.setContactFirstName(merchantDTO.getContactFirstName());
			merchantMaster.setContactLastName(merchantDTO.getContactLastName());
			merchantMaster.setContactPhone(merchantDTO.getContactPhone());
			merchantMaster.setContactAltPhone(merchantDTO.getContactAlternatePhone());
			merchantMaster.setAddress1(merchantDTO.getAddress1());
			merchantMaster.setAddress2(merchantDTO.getAddress2());
			merchantMaster.setAddress3(merchantDTO.getAddress3());
			merchantMaster.setCity(IntUtil.getInteger(merchantDTO.getCity()));
			merchantMaster.setState(merchantDTO.getState());
			merchantMaster.setZip(merchantDTO.getZipCode());
			merchantMaster.setEmailId(merchantDTO.getEmailId());
			merchantMaster.setSalesPerson(merchantDTO.getSalesPerson());
			merchantMaster.setDailyDealenName(merchantDTO.getDailyDealenName());
			merchantMaster.setTestDrive(merchantDTO.getTestDrive());
			merchantMaster.setGoogleAnalyticId(merchantDTO.getGoogleAnalyticsId());
			merchantMaster.setBlogTemplateId(merchantDTO.getBlogTemplateId());
			merchantMaster.setWebsiteUrl(merchantDTO.getWebsiteUrl());
			merchantMaster.setNeighborhoodName(IntUtil.getInteger(merchantDTO.getNeighborhoodName()));
			merchantMaster.setCityToDispaly(merchantDTO.getCityToDisplay());

			merchantMaster.setBillingAddress1(merchantDTO.getbAddress1());
			merchantMaster.setBillingAddress2(merchantDTO.getbAddress2());
			merchantMaster.setBillingAddress3(merchantDTO.getbAddress3());
			merchantMaster.setBillingCity(merchantDTO.getbCity());
			merchantMaster.setBillingState(merchantDTO.getbState());

			merchantMaster.setNeighborhoodAddress(merchantDTO.getNeighborhoodAddress());
			merchantMaster.setNeighborhoodCity(merchantDTO.getNeighborhoodCity());
			merchantMaster.setNeighborhoodZip(merchantDTO.getNeighborhoodZip());
			merchantMaster.setNeighborhoodState(merchantDTO.getNeighborhoodState());

			merchantMaster.setBusinessHours(merchantDTO.getBusinessHours());

			merchantMaster.setMerchantUrl(getWithoutSpecial(merchantDTO.getGetCityDealzName()));

			// MerchantCategory
			List<MerchantCategory> merchantCategoryList = dao.getMerchantCategory(merchantMaster.getMerchantId());
			Map<String, MerchantCategory> savedmerchantCategoryMap = new HashMap<String, MerchantCategory>();
			if (merchantCategoryList != null && merchantCategoryList.size() > 0) {
				for (MerchantCategory mCtg : merchantCategoryList) {
					savedmerchantCategoryMap.put("" + mCtg.getMerchantCategoryPK().getMerchantId() + "_" + mCtg.getMerchantCategoryPK().getMasterCategory()
							+ "_" + mCtg.getMerchantCategoryPK().getCategoryId(), mCtg);
				}
			}

			List<MerchantSubCategory> merchantSubCategories = dao.getMerchantSubCategory(merchantMaster.getMerchantId());
			Map<String, MerchantSubCategory> savedmSubCategoryMap = new HashMap<String, MerchantSubCategory>();
			if (!isEmpty(merchantSubCategories)) {
				for (MerchantSubCategory mSCtg : merchantSubCategories) {
					entityManager.remove(mSCtg);
				}
			}

			if (merchantDTO.getMerchantCategories() != null) {
				for (MerchantCategoryDTO mCtgDto : merchantDTO.getMerchantCategories()) {
					if (mCtgDto != null) {
						MerchantCategory merchantCategory = entityManager.find(MerchantCategory.class, new MerchantCategoryPK(merchantMaster.getMerchantId(),
								IntUtil.getInteger(mCtgDto.getMasterCategory()), IntUtil.getInteger(mCtgDto.getCategoryId())));
						if (merchantCategory == null) {
							merchantCategory = new MerchantCategory();
							merchantCategory.setCreatedDate(new Date());
							merchantCategory.setCreatedBy(userInfo.getUserIndex());
						}
						merchantCategory.setMerchantCategoryPK(new MerchantCategoryPK(merchantMaster.getMerchantId(), IntUtil.getInteger(mCtgDto
								.getMasterCategory()), IntUtil.getInteger(mCtgDto.getCategoryId())));
						merchantCategory.setUpdatedBy(userInfo.getUserIndex());
						merchantCategory.setUpdatedDate(new Date());

						// SubCategory start

						if (mCtgDto.getSubCatgoryId() != null) {
							for (String subCtgId : mCtgDto.getSubCatgoryId().split(",")) {
								if (mCtgDto != null) {
									MerchantSubCategory mSCategory = entityManager.find(
											MerchantSubCategory.class,
											new MerchantSubCategoryPK(IntUtil.getInteger(mCtgDto.getCategoryId()), IntUtil.getInteger(subCtgId), IntUtil
													.getInteger(merchantDTO.getMerchantId())));
									if (mSCategory == null) {
										mSCategory = new MerchantSubCategory();
										mSCategory.setCreatedDate(new Date());
										mSCategory.setCreatedBy(userInfo.getUserIndex());
									}
									mSCategory.setMerchantSubCategoryPK(new MerchantSubCategoryPK(IntUtil.getInteger(mCtgDto.getCategoryId()), IntUtil
											.getInteger(subCtgId), IntUtil.getInteger(merchantDTO.getMerchantId())));
									mSCategory.setCategoryType(IntUtil.getInteger(mCtgDto.getCategoryType()));
									mSCategory.setUpdatedBy(userInfo.getUserIndex());
									mSCategory.setUpdatedDate(new Date());
									entityManager.merge(mSCategory);
									if (savedmSubCategoryMap.containsKey("" + mSCategory.getMerchantSubCategoryPK().getCategoryId() + "_"
											+ mSCategory.getMerchantSubCategoryPK().getSubCategoryId())) {
										savedmSubCategoryMap.remove("" + mSCategory.getMerchantSubCategoryPK().getCategoryId() + "_"
												+ mSCategory.getMerchantSubCategoryPK().getSubCategoryId());
									}
								}
							}
						}

						for (String key : savedmSubCategoryMap.keySet()) {
							entityManager.remove(savedmSubCategoryMap.get(key));
						}
						// SubCategory end
						entityManager.merge(merchantCategory);

						if (savedmerchantCategoryMap.containsKey("" + merchantMaster.getMerchantId() + "_" + IntUtil.getInteger(mCtgDto.getMasterCategory())
								+ "_" + IntUtil.getInteger(mCtgDto.getCategoryId()))) {
							savedmerchantCategoryMap.remove("" + merchantMaster.getMerchantId() + "_" + IntUtil.getInteger(mCtgDto.getMasterCategory()) + "_"
									+ IntUtil.getInteger(mCtgDto.getCategoryId()));
						}
					}
				}
			}

			for (String key : savedmerchantCategoryMap.keySet()) {
				entityManager.remove(savedmerchantCategoryMap.get(key));
			}

			List<MerchantFeatureLink> mFeatureList = dao.getMerchentFeatuer(merchantMaster.getMerchantId());
			Map<String, MerchantFeatureLink> savedMFeatureMap = new HashMap<String, MerchantFeatureLink>();
			if (mFeatureList != null) {
				for (MerchantFeatureLink mf : mFeatureList) {
					savedMFeatureMap.put("" + mf.getMerchantFeaturePK().getMerchantId() + "_" + mf.getMerchantFeaturePK().getFeatureId(), mf);
				}
			}
			if (merchantDTO.getmFeatureList() != null) {
				for (String sMerchantFeature : merchantDTO.getmFeatureList()) {
					if (sMerchantFeature != null && !sMerchantFeature.trim().equals("")) {

						MerchantFeatureLink MerchantFeature = entityManager.find(MerchantFeatureLink.class,
								new MerchantFeatureLinkPK(merchantMaster.getMerchantId(), IntUtil.getInteger(sMerchantFeature)));
						if (MerchantFeature == null) {
							MerchantFeature = new MerchantFeatureLink();
							MerchantFeature
									.setMerchantFeaturePK(new MerchantFeatureLinkPK(merchantMaster.getMerchantId(), IntUtil.getInteger(sMerchantFeature)));
							MerchantFeature.setCreatedDate(new Date());
							MerchantFeature.setCreatedBy(userInfo.getUserIndex());
						}

						MerchantFeature.setUpdatedBy(userInfo.getUserIndex());
						MerchantFeature.setUpdatedDate(new Date());
						entityManager.merge(MerchantFeature);

						if (savedMFeatureMap.containsKey("" + MerchantFeature.getMerchantFeaturePK().getMerchantId() + "_"
								+ MerchantFeature.getMerchantFeaturePK().getFeatureId())) {
							savedMFeatureMap.remove("" + MerchantFeature.getMerchantFeaturePK().getMerchantId() + "_"
									+ MerchantFeature.getMerchantFeaturePK().getFeatureId());
						}
					}
				}
			}

			for (String key : savedMFeatureMap.keySet()) {
				entityManager.remove(savedMFeatureMap.get(key));
			}

			merchantMaster.setUpdatedBy(userInfo.getUserIndex());
			merchantMaster.setUpdatedDate(new Date());

			entityManager.merge(merchantMaster);
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		return merchantDTO;
	}

	public MerchantDTO updateMyProfile(UserInfo userInfo, MerchantDTO merchantDTO) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		MerchantMaster merchantMaster = entityManager.find(MerchantMaster.class, IntUtil.getInteger(merchantDTO.getMerchantId()));

		merchantMaster.setCreatedBy(0);
		merchantMaster.setCreatedDate(new Date());
		if (merchantDTO.getUserId() != null && !merchantDTO.getUserId().trim().isEmpty())
			merchantMaster.setUserId(merchantDTO.getUserId());
		merchantMaster.setMerchantName(merchantDTO.getMerchantName());
		merchantMaster.setContactFirstName(merchantDTO.getContactFirstName());
		merchantMaster.setContactLastName(merchantDTO.getContactLastName());
		merchantMaster.setContactPhone(merchantDTO.getContactPhone());
		merchantMaster.setContactAltPhone(merchantDTO.getContactAlternatePhone());
		merchantMaster.setAddress1(merchantDTO.getAddress1());
		merchantMaster.setAddress2(merchantDTO.getAddress2());
		merchantMaster.setAddress3(merchantDTO.getAddress3());
		merchantMaster.setWebsiteUrl(merchantDTO.getWebsiteUrl());
		if (merchantDTO.getEmailId() != null && !merchantDTO.getEmailId().trim().isEmpty())
			merchantMaster.setEmailId(merchantDTO.getEmailId());
		if (merchantDTO.getPassword() != null && !merchantDTO.getPassword().trim().isEmpty())
			merchantMaster.setPassword(merchantDTO.getPassword());
		merchantMaster.setCity(IntUtil.getInteger(merchantDTO.getCityId()));
		merchantMaster.setState(merchantDTO.getState());
		merchantMaster.setZip(merchantDTO.getZipCode());
		merchantMaster.setSalesPerson(merchantDTO.getSalesPerson());
		merchantMaster.setDailyDealenName(merchantDTO.getDailyDealenName());
		merchantMaster.setTestDrive(merchantDTO.getTestDrive());
		merchantMaster.setGoogleAnalyticId(merchantDTO.getGoogleAnalyticsId());
		merchantMaster.setMasterCategory(IntUtil.getInteger(merchantDTO.getMasterCategory()));
		merchantMaster.setNeighborhoodName(IntUtil.getInteger(merchantDTO.getNeighborhoodName()));
		merchantMaster.setBusinessHours(merchantDTO.getBusinessHours());
		merchantMaster.setCityToDispaly(merchantDTO.getCityToDisplay());

		merchantMaster.setNeighborhoodAddress(merchantDTO.getNeighborhoodAddress());
		merchantMaster.setNeighborhoodCity(merchantDTO.getNeighborhoodCity());
		merchantMaster.setNeighborhoodZip(merchantDTO.getNeighborhoodZip());
		merchantMaster.setNeighborhoodState(merchantDTO.getNeighborhoodState());

		// MerchantCategory
		List<MerchantCategory> merchantCategoryList = dao.getMerchantCategory(merchantMaster.getMerchantId());
		Map<String, MerchantCategory> savedmerchantCategoryMap = new HashMap<String, MerchantCategory>();
		if (merchantCategoryList != null && merchantCategoryList.size() > 0) {
			for (MerchantCategory mCtg : merchantCategoryList) {
				savedmerchantCategoryMap.put("" + mCtg.getMerchantCategoryPK().getMerchantId() + "_" + mCtg.getMerchantCategoryPK().getMasterCategory() + "_"
						+ mCtg.getMerchantCategoryPK().getCategoryId(), mCtg);
			}
		}

		List<MerchantSubCategory> merchantSubCategories = dao.getMerchantSubCategory(IntUtil.getInteger(merchantDTO.getMerchantId()));
		if (!isEmpty(merchantSubCategories)) {
			for (MerchantSubCategory mSCtg : merchantSubCategories) {
				entityManager.remove(mSCtg);
			}
		}

		if (merchantDTO.getMerchantCategories() != null) {
			for (MerchantCategoryDTO mCtgDto : merchantDTO.getMerchantCategories()) {
				if (mCtgDto != null) {
					MerchantCategory merchantCategory = entityManager.find(MerchantCategory.class, new MerchantCategoryPK(merchantMaster.getMerchantId(),
							IntUtil.getInteger(mCtgDto.getMasterCategory()), IntUtil.getInteger(mCtgDto.getCategoryId())));
					if (merchantCategory == null) {
						merchantCategory = new MerchantCategory();
						merchantCategory.setCreatedDate(new Date());
						merchantCategory.setCreatedBy(userInfo.getUserIndex());
					}
					merchantCategory.setMerchantCategoryPK(new MerchantCategoryPK(merchantMaster.getMerchantId(), IntUtil.getInteger(mCtgDto
							.getMasterCategory()), IntUtil.getInteger(mCtgDto.getCategoryId())));
					merchantCategory.setUpdatedBy(userInfo.getUserIndex());
					merchantCategory.setUpdatedDate(new Date());

					if (mCtgDto.getSubCatgoryId() != null) {
						for (String subCtgId : mCtgDto.getSubCatgoryId().split(",")) {
							if (mCtgDto != null) {
								MerchantSubCategory mSCategory = entityManager.find(
										MerchantSubCategory.class,
										new MerchantSubCategoryPK(IntUtil.getInteger(mCtgDto.getCategoryId()), IntUtil.getInteger(subCtgId), merchantMaster
												.getMerchantId()));
								if (mSCategory == null) {
									mSCategory = new MerchantSubCategory();
									mSCategory.setCreatedDate(new Date());
									mSCategory.setCreatedBy(userInfo.getUserIndex());
								}
								mSCategory.setMerchantSubCategoryPK(new MerchantSubCategoryPK(IntUtil.getInteger(mCtgDto.getCategoryId()), IntUtil
										.getInteger(subCtgId), merchantMaster.getMerchantId()));
								mSCategory.setCategoryType(IntUtil.getInteger(mCtgDto.getCategoryType()));
								mSCategory.setUpdatedBy(userInfo.getUserIndex());
								mSCategory.setUpdatedDate(new Date());
								entityManager.merge(mSCategory);

							}
						}
					}
					// SubCategory end
					entityManager.merge(merchantCategory);

					if (savedmerchantCategoryMap.containsKey("" + merchantMaster.getMerchantId() + "_" + IntUtil.getInteger(mCtgDto.getMasterCategory()) + "_"
							+ IntUtil.getInteger(mCtgDto.getCategoryId()))) {
						savedmerchantCategoryMap.remove("" + merchantMaster.getMerchantId() + "_" + IntUtil.getInteger(mCtgDto.getMasterCategory()) + "_"
								+ IntUtil.getInteger(mCtgDto.getCategoryId()));
					}
				}
			}
		}

		for (String key : savedmerchantCategoryMap.keySet()) {
			entityManager.remove(savedmerchantCategoryMap.get(key));
		}

		List<MerchantFeatureLink> mFeatureList = dao.getMerchentFeatuer(merchantMaster.getMerchantId());
		Map<String, MerchantFeatureLink> savedMFeatureMap = new HashMap<String, MerchantFeatureLink>();
		if (mFeatureList != null) {
			for (MerchantFeatureLink mf : mFeatureList) {
				savedMFeatureMap.put("" + mf.getMerchantFeaturePK().getMerchantId() + "_" + mf.getMerchantFeaturePK().getFeatureId(), mf);
			}
		}
		if (merchantDTO.getmFeatureList() != null) {
			for (String sMerchantFeature : merchantDTO.getmFeatureList()) {
				if (sMerchantFeature != null && !sMerchantFeature.trim().equals("")) {

					MerchantFeatureLink MerchantFeature = entityManager.find(MerchantFeatureLink.class,
							new MerchantFeatureLinkPK(merchantMaster.getMerchantId(), IntUtil.getInteger(sMerchantFeature)));
					if (MerchantFeature == null) {
						MerchantFeature = new MerchantFeatureLink();
						MerchantFeature.setMerchantFeaturePK(new MerchantFeatureLinkPK(merchantMaster.getMerchantId(), IntUtil.getInteger(sMerchantFeature)));
						MerchantFeature.setCreatedDate(new Date());
						MerchantFeature.setCreatedBy(userInfo.getUserIndex());
					}

					MerchantFeature.setUpdatedBy(userInfo.getUserIndex());
					MerchantFeature.setUpdatedDate(new Date());
					entityManager.merge(MerchantFeature);

					if (savedMFeatureMap.containsKey("" + MerchantFeature.getMerchantFeaturePK().getMerchantId() + "_"
							+ MerchantFeature.getMerchantFeaturePK().getFeatureId())) {
						savedMFeatureMap.remove("" + MerchantFeature.getMerchantFeaturePK().getMerchantId() + "_"
								+ MerchantFeature.getMerchantFeaturePK().getFeatureId());
					}
				}
			}
		}

		for (String key : savedMFeatureMap.keySet()) {
			entityManager.remove(savedMFeatureMap.get(key));
		}

		merchantMaster.setUpdatedBy(0);
		merchantMaster.setUpdatedDate(new Date());

		entityManager.merge(merchantMaster);
		return merchantDTO;
	}

	public MerchantDTO getMerchantDetailById(String merchantId, String merchantUrl) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		MerchantDTO merchantDTO = new MerchantDTO();
		MerchantMaster mMaster = null;
		if (merchantId == null)
			mMaster = dao.getMerchantMatsterByUrl(merchantUrl);
		else
			mMaster = entityManager.find(MerchantMaster.class, IntUtil.getInteger(merchantId));
		merchantDTO.setMerchantId(mMaster.getMerchantId() + "");
		merchantDTO.setEmailId(mMaster.getEmailId());
		merchantDTO.setUserId(mMaster.getUserId());
		merchantDTO.setMerchantName(mMaster.getMerchantName());
		merchantDTO.setUrlMerchant(mMaster.getMerchantUrl());
		merchantDTO.setContactFirstName(mMaster.getContactFirstName());
		merchantDTO.setContactLastName(mMaster.getContactLastName());
		merchantDTO.setContactPhone(mMaster.getContactPhone());
		merchantDTO.setAddress1(mMaster.getAddress1());
		merchantDTO.setAddress2(mMaster.getAddress2());
		merchantDTO.setAddress3(mMaster.getAddress3());
		merchantDTO.setBusinessHours(mMaster.getBusinessHours());

		NeighborhoodMaster nMaster1 = entityManager.find(NeighborhoodMaster.class, new NeighborhoodMasterPK(mMaster.getCity(), mMaster.getNeighborhoodName()));
		if (nMaster1 != null) {
			merchantDTO.setNeighborhoodText(nMaster1.getNeighborhoodName());
		}

		List<MerchantLocation> merchantLocations = dao.getMerchantAllLoction(mMaster.getMerchantId());
		if (merchantLocations != null && merchantLocations.size() > 0) {
			for (MerchantLocation loc : merchantLocations) {
				LocationDTO dto = new LocationDTO();
				NeighborhoodMaster nMaster = entityManager.find(NeighborhoodMaster.class, new NeighborhoodMasterPK(mMaster.getCity(), loc.getNeighborhoodid()));
				if (nMaster != null) {
					dto.setNeighborhoodName(nMaster.getNeighborhoodName());
				}
				dto.setLocationId(loc.getMerchantLocationPK().getLocationId() + "");
				dto.setAddress1(loc.getAddress1());
				dto.setAddress2(loc.getAddress2());
				dto.setAddress3(loc.getAddress3());
				dto.setLocationHours(loc.getLocationHours());
				dto.setContactFirstName(loc.getContactFirstName());
				dto.setContactLastName(loc.getContactLastName());
				dto.setEmailAddress(loc.getEmail());
				dto.setLocationName(loc.getLocationName());
				dto.setCity(loc.getCity());
				dto.setState(loc.getState());
				dto.setZipCode(loc.getZipCode());
				dto.setLocationContact(loc.getLocationPhone());
				dto.setLocationPhone(loc.getLocationPhone());
				dto.setNeighborhood(loc.getNeighborhoodid() + "");
				if (merchantDTO.getLocationDTOs() == null)
					merchantDTO.setLocationDTOs(new ArrayList<LocationDTO>());
				merchantDTO.getLocationDTOs().add(dto);
			}
		}

		Cities cities = entityManager.find(Cities.class, mMaster.getCity());
		if (mMaster.getCityToDispaly() == null)
			merchantDTO.setCity(cities.getCityName());
		else
			merchantDTO.setCity(mMaster.getCityToDispaly());
		merchantDTO.setCityToDisplay(mMaster.getCityToDispaly());

		merchantDTO.setCityId(IntUtil.getString(mMaster.getCity()));
		merchantDTO.setState(mMaster.getState());
		merchantDTO.setWebsiteUrl(mMaster.getWebsiteUrl());
		merchantDTO.setZipCode(mMaster.getZip());
		merchantDTO.setSalesPerson(mMaster.getSalesPerson());
		merchantDTO.setDailyDealenName(mMaster.getDailyDealenName());
		merchantDTO.setTestDrive(mMaster.getTestDrive());
		merchantDTO.setGoogleAnalyticsId(mMaster.getGoogleAnalyticId());
		merchantDTO.setBlogTemplateId(mMaster.getBlogTemplateId());
		merchantDTO.setContactAlternatePhone(mMaster.getContactAltPhone());
		merchantDTO.setBlogTemplateId(mMaster.getBlogTemplateId());
		merchantDTO.setPassword(mMaster.getPassword());
		merchantDTO.setNeighborhoodName(IntUtil.getString(mMaster.getNeighborhoodName()));
		merchantDTO.setBusinessHours(mMaster.getBusinessHours());

		merchantDTO.setLogoId(dao.getLogoId(IntUtil.getInteger(merchantDTO.getMerchantId())));

		merchantDTO.setLogoImagePath(dao.getLogoInfo(IntUtil.getInteger(merchantDTO.getMerchantId())));

		merchantDTO.setmFeatureList(new ArrayList<String>());
		List<MerchantFeatureLink> mFeatList = dao.getMerchentFeatuer(mMaster.getMerchantId());
		String merchantFeature = "";
		if (mFeatList != null && mFeatList.size() > 0) {
			for (MerchantFeatureLink mf : mFeatList) {
				merchantFeature += IntUtil.getString(mf.getMerchantFeaturePK().getFeatureId()) + ",";
			}
		}
		merchantDTO.setMerchantFeature(merchantFeature);
		List<MerchantCategory> mCtgList = dao.getMerchantCategory(mMaster.getMerchantId());
		if (mCtgList != null && mCtgList.size() > 0) {
			MerchantCategory mCtg1 = mCtgList.get(0);
			merchantDTO.setMasterCategory(IntUtil.getString(mCtg1.getMerchantCategoryPK().getMasterCategory()));
			merchantDTO.setMasterCategoryText(dao.getMasterCategoryNameById(mCtg1.getMerchantCategoryPK().getMasterCategory()));
			merchantDTO.setCategory1(IntUtil.getString(mCtg1.getMerchantCategoryPK().getCategoryId()));
			merchantDTO.setCategory1Text(dao.getCategoryNameById(mCtg1.getMerchantCategoryPK().getCategoryId()));

			merchantDTO.setSubCategory1Text(dao.getSubCategoryNameById(mMaster.getMerchantId() + "", mCtg1.getMerchantCategoryPK().getCategoryId()));

			if (mCtgList.size() >= 2) {
				MerchantCategory mCtg2 = mCtgList.get(1);
				merchantDTO.setCategory2(IntUtil.getString(mCtg2.getMerchantCategoryPK().getCategoryId()));
				merchantDTO.setCategory2Text(dao.getCategoryNameById(mCtg2.getMerchantCategoryPK().getCategoryId()));

				merchantDTO.setSubCategory2Text(dao.getSubCategoryNameById(mMaster.getMerchantId() + "", mCtg2.getMerchantCategoryPK().getCategoryId()));

			}

		}
		return merchantDTO;
	}

	public Map<String, String> getMasterCategory(UserInfo userInfo) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		Map<String, String> retMap = null;
		try {
			retMap = merchantDAO.getMasterCategory(userInfo);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	public Map<String, String> getCategory(UserInfo userInfo) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		Map<String, String> retMap = null;
		try {
			retMap = merchantDAO.getCategory(userInfo);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	public LocationDTO saveEditLocation(Integer merchantId, LocationDTO locationDTO) throws BaseException {
		MerchantLocation merchantLocation = null;
		Integer locationId = IntUtil.getInteger(locationDTO.getLocationId());
		if (locationId != null)
			merchantLocation = entityManager.find(MerchantLocation.class, new MerchantLocationPK(merchantId, locationId));

		if (merchantLocation == null) {
			merchantLocation = new MerchantLocation();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("mLocationId", entityManager);
			locationDTO.setLocationId(nextKey);
			merchantLocation.setMerchantLocationPK(new MerchantLocationPK(merchantId, IntUtil.getInteger(nextKey)));
			merchantLocation.setCreatedBy(merchantId);
			merchantLocation.setCreatedDate(new Date());
		}
		merchantLocation.setContactFirstName(locationDTO.getContactFirstName());
		merchantLocation.setContactLastName(locationDTO.getContactLastName());
		merchantLocation.setLocationPhone(locationDTO.getLocationPhone());
		merchantLocation.setLocationName(locationDTO.getLocationName());
		merchantLocation.setCity(locationDTO.getCity());
		merchantLocation.setState(locationDTO.getState());
		merchantLocation.setZipCode(locationDTO.getZipCode());
		merchantLocation.setLocationDesc(locationDTO.getLocationDesc());
		merchantLocation.setLocationHours(locationDTO.getLocationHours());
		merchantLocation.setEmail(locationDTO.getEmailAddress());
		merchantLocation.setLocationDesc(locationDTO.getLocationDesc());
		merchantLocation.setLocationHours(locationDTO.getLocationHours());
		merchantLocation.setAddress1(locationDTO.getAddress1());
		merchantLocation.setAddress2(locationDTO.getAddress2());
		merchantLocation.setAddress3(locationDTO.getAddress3());
		merchantLocation.setUpdatedBy(merchantId);
		merchantLocation.setUpdatedDate(new Date());
		merchantLocation.setNeighborhoodid(IntUtil.getInteger(locationDTO.getNeighborhoodName()));
		entityManager.merge(merchantLocation);
		return locationDTO;
	}

	public LocationDTO getAdditionLocationByMerchant(UserInfo userInfo) throws BaseException {
		LocationDTO locationDTO = new LocationDTO();
		try {
			List<MerchantLocation> lDTOs = loadDAO().getAdditionLocationByMerchant(userInfo);
			if (lDTOs != null && lDTOs.size() > 0) {
				for (MerchantLocation mLocation : lDTOs) {
					LocationDTO dto = new LocationDTO();
					NeighborhoodMaster nMaster = entityManager.find(NeighborhoodMaster.class, new NeighborhoodMasterPK(IntUtil.getInteger(userInfo.getCity()),
							mLocation.getNeighborhoodid()));
					if (nMaster != null)
						dto.setNeighborhoodName(nMaster.getNeighborhoodName());
					dto.setLocationId(IntUtil.getString(mLocation.getMerchantLocationPK().getLocationId()));
					dto.setLocationName(mLocation.getLocationName());
					dto.setEmailAddress(mLocation.getEmail());
					dto.setLocationPhone(mLocation.getLocationPhone());
					dto.setLocationHours(mLocation.getLocationHours());
					dto.setContactFirstName(mLocation.getContactFirstName());
					dto.setContactLastName(mLocation.getContactLastName());
					dto.setCity(mLocation.getCity());
					dto.setState(mLocation.getState());
					dto.setZipCode(mLocation.getZipCode());
					dto.setAddress1(mLocation.getAddress1());
					dto.setAddress2(mLocation.getAddress2());
					dto.setAddress3(mLocation.getAddress3());
					if (locationDTO.getLocationDTOs() == null)
						locationDTO.setLocationDTOs(new ArrayList<LocationDTO>());
					locationDTO.getLocationDTOs().add(dto);
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		}
		return locationDTO;
	}

	public MerchantDTO updateEmailPwd(UserInfo userInfo, MerchantDTO merchantDTO) throws BaseException {
		MerchantMaster merchantMaster = entityManager.find(MerchantMaster.class, userInfo.getUserIndex());
		merchantMaster.setMerchantName(merchantDTO.getMerchantName());
		if (merchantDTO.getPassword() != null && !merchantDTO.getPassword().trim().isEmpty())
			merchantMaster.setPassword(merchantDTO.getPassword());
		merchantMaster.setEmailId(merchantDTO.getEmailId());
		entityManager.merge(merchantMaster);
		return merchantDTO;
	}

	public String getLogoInfo(UserInfo userInfo) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		String logoInfo = merchantDAO.getLogoInfo(userInfo.getUserIndex());
		return logoInfo;
	}

	public LocationDTO getLocationDetailsById(UserInfo userInfo, String locationId) throws BaseException {
		LocationDTO locationDTO = null;
		Integer locId = IntUtil.getInteger(locationId);
		MerchantLocation merchantLocation = null;
		if (locId != null) {
			locationDTO = new LocationDTO();
			merchantLocation = entityManager.find(MerchantLocation.class, new MerchantLocationPK(userInfo.getUserIndex(), locId));
			locationDTO.setContactFirstName(merchantLocation.getContactFirstName());
			locationDTO.setContactLastName(merchantLocation.getContactLastName());
			locationDTO.setLocationName(merchantLocation.getLocationName());
			locationDTO.setAddress1(merchantLocation.getAddress1());
			locationDTO.setAddress2(merchantLocation.getAddress2());
			locationDTO.setAddress3(merchantLocation.getAddress3());
			locationDTO.setEmailAddress(merchantLocation.getEmail());
			locationDTO.setCity(merchantLocation.getCity());
			locationDTO.setState(merchantLocation.getState());
			locationDTO.setZipCode(merchantLocation.getZipCode());
			locationDTO.setLocationPhone(merchantLocation.getLocationPhone());
			locationDTO.setLocationDesc(merchantLocation.getLocationDesc());
			locationDTO.setLocationHours(merchantLocation.getLocationHours());
			locationDTO.setLocationId(merchantLocation.getMerchantLocationPK().getLocationId() + "");
			locationDTO.setNeighborhoodName(merchantLocation.getNeighborhoodid() + "");
		}
		return locationDTO;
	}

	public SocialConnectionsDTO saveSocialConnection(UserInfo userInfo, SocialConnectionsDTO socialConnectionsDTO) throws BaseException {
		Integer connectionId = IntUtil.getInteger(socialConnectionsDTO.getConnectionId());
		Integer merchantId = IntUtil.getInteger(socialConnectionsDTO.getMerchantId());
		Integer twitterOAuthdetailsId = IntUtil.getInteger(socialConnectionsDTO.getTwitterOAuthdetailsId());
		SocialConnections socialConnections = null;
		TwitterOAuthdetails twitterOAuthdetails = null;
		if (connectionId != null)
			socialConnections = entityManager.find(SocialConnections.class, new SocialConnectionsPK(connectionId, merchantId));
		if (twitterOAuthdetailsId != null)
			twitterOAuthdetails = entityManager.find(TwitterOAuthdetails.class, new TwitterOAuthdetailsPK(twitterOAuthdetailsId, merchantId));

		if (socialConnections == null) {
			socialConnections = new SocialConnections();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("socialConnId", entityManager);

			socialConnections.setSocialConnectionsPK(new SocialConnectionsPK(IntUtil.getInteger(nextKey), merchantId));
			socialConnectionsDTO.setConnectionId(nextKey);
			socialConnections.setCreatedBy(userInfo.getUserIndex());
			socialConnections.setCreatedDate(new Date());
		}
		socialConnections.setFacebookFanPage(socialConnectionsDTO.getFacebookFanPage());
		socialConnections.setFacebookFanPageChk(socialConnectionsDTO.getFacebookFanPagechk());
		socialConnections.setTwitterAccount(socialConnectionsDTO.getTwitterAccount());
		socialConnections.setTwitterAccountChk(socialConnectionsDTO.getTwitterAccountchk());
		socialConnections.setFourSquareAccount(socialConnectionsDTO.getFourSquareAccount());
		socialConnections.setFourSquareAccountChk(socialConnectionsDTO.getFourSquareAccountchk());
		socialConnections.setYelpAccount(socialConnectionsDTO.getYelpAccount());
		socialConnections.setYelpAccountChk(socialConnectionsDTO.getYelpAccountchk());
		socialConnections.setFlickerAccount(socialConnectionsDTO.getFlickerAccount());
		socialConnections.setFlickerAccountChk(socialConnectionsDTO.getFlickerAccountchk());
		socialConnections.setYoutubeAccount(socialConnectionsDTO.getYoutubeAccount());
		socialConnections.setYoutubeAccountChk(socialConnectionsDTO.getYoutubeAccountchk());
		socialConnections.setLinkedinProfile(socialConnectionsDTO.getLinkedinProfile());
		socialConnections.setLinkedinProfileChk(socialConnectionsDTO.getLinkedinProfilechk());
		socialConnections.setTripAdvisorAccount(socialConnectionsDTO.getTripAdvisorAccount());
		socialConnections.setTripAdvisorAccountChk(socialConnectionsDTO.getTripAdvisorAccountchk());
		socialConnections.setMeetupAccount(socialConnectionsDTO.getMeetupAccount());
		socialConnections.setMeetupAccountChk(socialConnectionsDTO.getMeetupAccountchk());
		socialConnections.setOpenTableAccount(socialConnectionsDTO.getOpenTableAccount());
		socialConnections.setOpenTableAccountChk(socialConnectionsDTO.getOpenTableAccountchk());
		socialConnections.setPinterestAccount(socialConnectionsDTO.getPinterestAccount());
		socialConnections.setPinterestAccountChk(socialConnectionsDTO.getPinterestAccountchk());
		socialConnections.setgPlusAccount(socialConnectionsDTO.getgPlusAccount());
		socialConnections.setgPlusAccountChk(socialConnectionsDTO.getgPlusAccountchk());
		socialConnections.setTumblrAccount(socialConnectionsDTO.getTumblrAccount());
		socialConnections.setTumblrAccountChk(socialConnectionsDTO.getTumblrAccountchk());
		socialConnections.setEtsyAccount(socialConnectionsDTO.getEtsyAccount());
		socialConnections.setEtsyAccountChk(socialConnectionsDTO.getEtsyAccountchk());
		socialConnections.setInstagramAccount(socialConnectionsDTO.getInstagramAccount());
		socialConnections.setInstagramAccountChk(socialConnectionsDTO.getInstagramAccountchk());

		socialConnections.setUpdatedBy(userInfo.getUserIndex());
		socialConnections.setUpdatedDate(new Date());
		entityManager.merge(socialConnections);

		if (twitterOAuthdetails == null) {
			twitterOAuthdetails = new TwitterOAuthdetails();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("socialConnId", entityManager);
			twitterOAuthdetails.setTwitterOAuthdetailsPK(new TwitterOAuthdetailsPK(IntUtil.getInteger(nextKey), merchantId));
			twitterOAuthdetails.setCreatedBy(userInfo.getUserIndex());
			twitterOAuthdetails.setCreatedDate(new Date());
		}
		twitterOAuthdetails.setConsumerKey(socialConnectionsDTO.getConsumerKey());
		twitterOAuthdetails.setoAuthSecret(socialConnectionsDTO.getoAuthSecret());
		twitterOAuthdetails.setoAuthToken(socialConnectionsDTO.getoAuthToken());
		twitterOAuthdetails.setConsumerSecret(socialConnectionsDTO.getConsumerSecret());

		twitterOAuthdetails.setUpdatedBy(userInfo.getUserIndex());
		twitterOAuthdetails.setUpdatedDate(new Date());
		entityManager.merge(twitterOAuthdetails);

		return socialConnectionsDTO;
	}

	public SocialConnectionsDTO getMySocialConnections(String merchantId) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		SocialConnectionsDTO socialConnectionsDTO = null;
		SocialConnections socialConnections = merchantDAO.getMySocialConnections(IntUtil.getInteger(merchantId));
		if (socialConnections != null) {
			socialConnectionsDTO = new SocialConnectionsDTO();
			socialConnectionsDTO.setMerchantId(merchantId);
			socialConnectionsDTO.setConnectionId(socialConnections.getSocialConnectionsPK().getSocialConnectionId() + "");
			socialConnectionsDTO.setFacebookFanPage(socialConnections.getFacebookFanPage());
			socialConnectionsDTO.setFacebookFanPagechk(socialConnections.getFacebookFanPageChk());

			FBAccessTokeMerchantLink link = entityManager.find(FBAccessTokeMerchantLink.class, socialConnections.getSocialConnectionsPK()
					.getSocialConnectionId());
			if (link != null)
				socialConnectionsDTO.setFbPostDealzTo(link.getName());
			socialConnectionsDTO.setTwitterAccount(socialConnections.getTwitterAccount());
			socialConnectionsDTO.setTwitterAccountchk(socialConnections.getTwitterAccountChk());

			socialConnectionsDTO.setFourSquareAccount(socialConnections.getFourSquareAccount());
			socialConnectionsDTO.setFourSquareAccountchk(socialConnections.getFourSquareAccountChk());

			socialConnectionsDTO.setYelpAccount(socialConnections.getYelpAccount());
			socialConnectionsDTO.setYelpAccountchk(socialConnections.getYelpAccountChk());

			socialConnectionsDTO.setFlickerAccount(socialConnections.getFlickerAccount());
			socialConnectionsDTO.setFlickerAccountchk(socialConnections.getFlickerAccountChk());

			socialConnectionsDTO.setYoutubeAccount(socialConnections.getYoutubeAccount());
			socialConnectionsDTO.setYoutubeAccountchk(socialConnections.getYoutubeAccount());

			socialConnectionsDTO.setLinkedinProfile(socialConnections.getLinkedinProfile());
			socialConnectionsDTO.setLinkedinProfilechk(socialConnections.getLinkedinProfileChk());

			socialConnectionsDTO.setTripAdvisorAccount(socialConnections.getTripAdvisorAccount());
			socialConnectionsDTO.setTripAdvisorAccountchk(socialConnections.getTripAdvisorAccountChk());

			socialConnectionsDTO.setMeetupAccount(socialConnections.getMeetupAccount());
			socialConnectionsDTO.setMeetupAccountchk(socialConnections.getMeetupAccountChk());

			socialConnectionsDTO.setOpenTableAccount(socialConnections.getOpenTableAccount());
			socialConnectionsDTO.setOpenTableAccountchk(socialConnections.getOpenTableAccountChk());

			socialConnectionsDTO.setPinterestAccount(socialConnections.getPinterestAccount());
			socialConnectionsDTO.setPinterestAccountchk(socialConnections.getPinterestAccountChk());

			socialConnectionsDTO.setgPlusAccount(socialConnections.getgPlusAccount());
			socialConnectionsDTO.setgPlusAccountchk(socialConnections.getgPlusAccountChk());

			socialConnectionsDTO.setEtsyAccount(socialConnections.getEtsyAccount());
			socialConnectionsDTO.setEtsyAccountchk(socialConnections.getEtsyAccountChk());

			socialConnectionsDTO.setTumblrAccount(socialConnections.getTumblrAccount());
			socialConnectionsDTO.setTumblrAccountchk(socialConnections.getTumblrAccountChk());

			socialConnectionsDTO.setInstagramAccount(socialConnections.getInstagramAccount());
			socialConnectionsDTO.setInstagramAccountchk(socialConnections.getInstagramAccountChk());

			socialConnectionsDTO.setTwitterScreenName(socialConnections.getTwitterScreenName());

		}

		TwitterOAuthdetails twitterOAuthdetails = merchantDAO.getMyTwitterOAuthdetails(IntUtil.getInteger(merchantId));
		if (twitterOAuthdetails != null) {
			socialConnectionsDTO.setTwitterOAuthdetailsId(twitterOAuthdetails.getTwitterOAuthdetailsPK().getTwitterOAuthdetails() + "");
			socialConnectionsDTO.setConsumerKey(twitterOAuthdetails.getConsumerKey());
			socialConnectionsDTO.setoAuthToken(twitterOAuthdetails.getoAuthToken());
			socialConnectionsDTO.setoAuthSecret(twitterOAuthdetails.getoAuthSecret());
			socialConnectionsDTO.setConsumerSecret(twitterOAuthdetails.getConsumerSecret());
		}
		return socialConnectionsDTO;
	}

	public LocationDTO deleteMerchantAdditionLocation(Integer merchantId, String locationId) throws BaseException {
		LocationDTO locationDTO = null;
		MerchantLocation merchantLocation = null;
		Integer iLocId = IntUtil.getInteger(locationId);
		if (iLocId != null) {
			locationDTO = new LocationDTO();
			merchantLocation = entityManager.find(MerchantLocation.class, new MerchantLocationPK(merchantId, iLocId));
			entityManager.remove(merchantLocation);
		}
		return locationDTO;
	}

	public List<String> getMediaFiles(UserInfo userInfo) throws BaseException {
		List<String> mediaFiles = loadDAO().getMediaFiles(userInfo);
		return mediaFiles;
	}

	public Map<String, String> getSubCategoryMapByCategoryId(UserInfo userInfo, String categoryId) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		Map<String, String> retMap = null;
		try {
			retMap = merchantDAO.getSubCategoryMapByCategoryId(userInfo, categoryId);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	public DealzDTO getMyAllHotDealz(UserInfo userInfo, String dealType) throws BaseException {
		DealzDTO dealzDTO = new DealzDTO();
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		List<MerchantDealz> dealzs = merchantDAO.getAllDealz(userInfo, IntUtil.getInteger(dealType));
		if (dealzs != null) {
			for (MerchantDealz deal : dealzs) {
				if (deal != null) {
					DealzDTO dto = new DealzDTO();
					dto.setDealId(deal.getMerchantDealzPK().getDealzId() + "");
					dto.setCreateDateText(DateUtil.parseDateToString((Date) deal.getCreatedDate(), userInfo.getDateFormat()));
					dto.setTitle(deal.getTitle());

					dto.setMerchantId(deal.getMerchantDealzPK().getMerchantId() + "");
					dto.setStatusText(getDealStatus(dealType, deal, merchantDAO));
					dto.setDescription(deal.getDescription());
					if (dealzDTO.getDealzDTOs() == null)
						dealzDTO.setDealzDTOs(new ArrayList<DealzDTO>());
					dealzDTO.getDealzDTOs().add(dto);
				}
			}
		}

		return dealzDTO;
	}

	public String getDealStatus(String dealType, MerchantDealz deal, MerchantDAO merchantDAO) {
		String status = "";
		if (dealType.equals("2") && deal.getStatus() != 666) {
			if (deal.getPayed() == 1 && deal.getStartDate().compareTo(merchantDAO.getDate(deal.getLocalTimeZoneUtc())) > 0)
				status = "Pending";
			else if (deal.getPayed() == 1 && deal.getEndDate().compareTo(merchantDAO.getDate(deal.getLocalTimeZoneUtc())) < 0)
				status = "Expired";
			else if (deal.getPayed() == 0)
				status = "Payment Pending";
			else
				status = "Active";
		} else if (deal.getStatus() == 666) {
			status = "Draft";
		} else if (deal.getStatus() != 666) {
			status = "Active";
			if (deal.getStartDate().compareTo(merchantDAO.getDate(deal.getLocalTimeZoneUtc())) > 0)
				status = "Pending";
			if (deal.getEndDate().compareTo(merchantDAO.getDate(deal.getLocalTimeZoneUtc())) < 0)
				status = "Expired";
		}
		return status;
	}

	public DealzDTO getDealzDetailById(UserInfo userInfo, String dealId, String dealType) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		DealzDTO dealzDTO = null;
		List<MerchantDealz> merchantDealzs = merchantDAO.getDealzDetailById(userInfo, dealId, dealType);
		if (merchantDealzs != null && merchantDealzs.size() > 0) {
			for (MerchantDealz dealz : merchantDealzs) {
				dealzDTO = new DealzDTO();
				MerchantMaster mMaster = entityManager.find(MerchantMaster.class, dealz.getMerchantDealzPK().getMerchantId());
				dealzDTO.setMerchantName(mMaster.getMerchantName());
				dealzDTO.setMerchantId(dealz.getMerchantDealzPK().getMerchantId() + "");
				dealzDTO.setUseLogo(dealz.getUseLogo() + "");
				dealzDTO.setDealId(dealz.getMerchantDealzPK().getDealzId() + "");
				if (dealz.getUseLogo() != null && dealz.getUseLogo() == 1) {
					dealzDTO.setImagePath(loadDAO().getLogoInfo(dealz.getMerchantDealzPK().getMerchantId()));
				} else {
					String fileName = (String) merchantDAO.getDocument(dealz.getMerchantDealzPK().getDealzId() + "");
					if (fileName != null)
						dealzDTO.setImagePath(fileName);

				}
				dealzDTO.setTitle(dealz.getTitle());

				dealzDTO.setCity(dealz.getMerchantDealzPK().getCitySectionId() + "");
				dealzDTO.setRestriction(dealz.getRestrictions());
				dealzDTO.setStartDate(DateUtil.parseDateToString((Date) dealz.getStartDate(), userInfo.getDateTimeFormat()));
				dealzDTO.setEndDate(DateUtil.parseDateToString((Date) dealz.getEndDate(), userInfo.getDateTimeFormat()));
				dealzDTO.setAmountSaved(dealz.getAmountSaving());
				dealzDTO.setDescription(dealz.getDescription());
				dealzDTO.setDealCode(dealz.getCode());
				dealzDTO.setLatitude(dealz.getLatitude());
				dealzDTO.setLongitude(dealz.getLongitude());
				dealzDTO.setOrderNo(IntUtil.getString(dealz.getHotDealOrder()));
				dealzDTO.setHotDealLink(dealz.getHotDealLink());
				if (dealz.getUseLogo() != null && dealz.getUseLogo() == 1) {
					dealzDTO.setImagePath(loadDAO().getLogoInfo(dealz.getMerchantDealzPK().getMerchantId()));
				} else {
					String fileName = (String) merchantDAO.getDocument(dealz.getMerchantDealzPK().getDealzId() + "");
					if (fileName != null)
						dealzDTO.setImagePath(fileName);

				}
			}
		}
		return dealzDTO;
	}

	public List<String> getMySocialConnection(UserInfo userInfo) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		List<String> connections = null;
		SocialConnections mConn = merchantDAO.getMySocialConnection(userInfo.getUserIndex());
		if (mConn != null) {
			connections = new ArrayList<String>();
			if (mConn.getFacebookFanPage() != null)
				connections.add(mConn.getFacebookFanPage());
			if (mConn.getFlickerAccount() != null)
				connections.add(mConn.getFlickerAccount());
			if (mConn.getFourSquareAccount() != null)
				connections.add(mConn.getFourSquareAccount());
			if (mConn.getLinkedinProfile() != null)
				connections.add(mConn.getLinkedinProfile());
			if (mConn.getMeetupAccount() != null)
				connections.add(mConn.getMeetupAccount());
			if (mConn.getOpenTableAccount() != null)
				connections.add(mConn.getOpenTableAccount());
			if (mConn.getPinterestAccount() != null)
				connections.add(mConn.getPinterestAccount());
			if (mConn.getTripAdvisorAccount() != null)
				connections.add(mConn.getTripAdvisorAccount());
			if (mConn.getTwitterAccount() != null)
				connections.add(mConn.getTwitterAccount());
			if (mConn.getYelpAccount() != null)
				connections.add(mConn.getYelpAccount());
			if (mConn.getYoutubeAccount() != null)
				connections.add(mConn.getYoutubeAccount());
		}
		return connections;
	}

	public DealzDTO getMyLatestDeal(Integer userIndex) throws BaseException {
		UserInfo userInfo = new UserInfo();
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		DealzDTO dealzDTO = null;
		List<MerchantDealz> merchantDealzs = merchantDAO.getMyLatestDeal(userIndex);
		if (merchantDealzs != null && merchantDealzs.size() > 0) {
			dealzDTO = new DealzDTO();
			for (MerchantDealz dealz : merchantDealzs) {
				if (dealz != null) {
					DealzDTO dto = new DealzDTO();
					dto.setDealId(dealz.getMerchantDealzPK().getDealzId() + "");
					dto.setTitle(dealz.getTitle());
					dto.setRestriction(dealz.getRestrictions());
					dto.setStartDate(DateUtil.parseDateToString((Date) dealz.getStartDate(), userInfo.getDateFormat()));
					dto.setEndDate(DateUtil.parseDateToString((Date) dealz.getEndDate(), userInfo.getDateFormat()));
					dto.setAmountSaved(dealz.getAmountSaving());
					dto.setDescription(dealz.getDescription());
					dto.setDealCode(dealz.getCode());
					dto.setDealCode(dealz.getCode());
					dto.setStatus(getDealStatus(dealz.getDealType() + "", dealz, merchantDAO));
					if (dealzDTO.getDealzDTOs() == null)
						dealzDTO.setDealzDTOs(new ArrayList<DealzDTO>());
					dealzDTO.getDealzDTOs().add(dto);
				}
			}
		}
		userInfo.setUserIndex(userIndex);
		if (dealzDTO == null)
			dealzDTO = new DealzDTO();
		SocialConnections con = loadDAO().getMySocialConnection(userInfo.getUserIndex());
		if (con != null) {
			FBAccessTokeMerchantLink link = entityManager.find(FBAccessTokeMerchantLink.class, con.getSocialConnectionsPK().getSocialConnectionId());
			if (link != null) {
				Date date = link.getUpdatedDate();
				Calendar dateInsctance = Calendar.getInstance();
				dateInsctance.setTime(date);
				dateInsctance.add(Calendar.MONTH, 2);
				Date after = dateInsctance.getTime();
				dealzDTO.setAccessTokenExpireDate(DateUtil.parseDateToString(after, userInfo.getDateFormat()));
			}
		} else {
			dealzDTO.setAccessTokenExpireDate("Date not Defined");
		}

		return dealzDTO;
	}

	public Map<String, String> getSubscriptionLevel(UserInfo userInfo) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		Map<String, String> retMap = null;
		try {
			retMap = merchantDAO.getSubscriptionLevel(userInfo);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	public Map<String, String> getFeatureMap(UserInfo userInfo) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		Map<String, String> retMap = null;
		try {
			retMap = merchantDAO.getFeatureMap(userInfo);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	public Map<String, String> getNeighborhoodMap(UserInfo userInfo) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		Map<String, String> retMap = null;
		try {
			retMap = merchantDAO.getNeighborhoodMap(userInfo);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	public Map<String, String> getSalesPersonMap(UserInfo userInfo) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		Map<String, String> retMap = null;
		try {
			retMap = merchantDAO.getSalesPersonMap(userInfo);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	@SuppressWarnings("unchecked")
	public MerchantDTO getAllMerchantList(UserInfo userInfo, String start, String order) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		Map<Integer, Object> retMap = dao.getAllMerchantList(userInfo, start, order);
		MerchantDTO merchantDTO = new MerchantDTO();
		if (retMap != null && retMap.containsKey(1) && retMap.containsKey(2)) {
			List<MerchantMaster> merchantMasters = (List<MerchantMaster>) retMap.get(1);
			Map<String, String> neighborhoodMap = getNeighborhoodMap(userInfo);
			Map<String, String> ctgMap = getCategory(userInfo);
			Map<String, String> levelMap = getSubscriptionLevel(userInfo);
			for (MerchantMaster mMaster : merchantMasters) {
				MerchantDTO dto = new MerchantDTO();
				dto.setMerchantId(mMaster.getMerchantId() + "");
				dto.setMerchantName(mMaster.getMerchantName());
				dto.setAddress1(mMaster.getAddress1());
				dto.setAddress2(mMaster.getAddress2());
				dto.setAddress3(mMaster.getAddress3());
				dto.setStatusText(mMaster.getDeactivateDate() != null ? "No" : "Yes");
				dto.setNeighborhoodName(neighborhoodMap.get(mMaster.getNeighborhoodName() + ""));

				MerchantLevel merchantLevel = dao.getMerchantLevelByMerchant(mMaster.getMerchantId());
				List<MerchantCategory> merchantCategory = dao.getMerchantCtgByMerchant(mMaster.getMerchantId());

				if (merchantLevel != null)
					dto.setSubscriptionLevel(levelMap.get(merchantLevel.getMerchantLevelPK().getLevelId() + ""));
				if (merchantCategory != null && merchantCategory.size() > 0)
					dto.setCategory1Text(ctgMap.get(merchantCategory.get(0).getMerchantCategoryPK().getCategoryId() + ""));
				if (merchantCategory != null && merchantCategory.size() > 1)
					dto.setCategory2Text(ctgMap.get(merchantCategory.get(1).getMerchantCategoryPK().getCategoryId() + ""));

				if (merchantDTO.getMerchantDTOs() == null)
					merchantDTO.setMerchantDTOs(new ArrayList<MerchantDTO>());
				merchantDTO.getMerchantDTOs().add(dto);
			}
			merchantDTO.setCounts((BigInteger) retMap.get(2) + "");
		}
		return merchantDTO;
	}

	public MerchantDTO getMerchantDetailsById(UserInfo userInfo, String merchantId) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		Map<String, String> neighMap = dao.getNeighborhoodMap(userInfo);
		MerchantDTO merchantDTO = new MerchantDTO();
		MerchantMaster mMaster = entityManager.find(MerchantMaster.class, IntUtil.getInteger(merchantId));
		merchantDTO.setMerchantId(mMaster.getMerchantId() + "");
		merchantDTO.setEmailId(mMaster.getEmailId());
		merchantDTO.setUserId(mMaster.getUserId());
		merchantDTO.setMerchantName(mMaster.getMerchantName());
		merchantDTO.setContactFirstName(mMaster.getContactFirstName());
		merchantDTO.setContactLastName(mMaster.getContactLastName());
		merchantDTO.setContactPhone(mMaster.getContactPhone());
		merchantDTO.setAddress1(mMaster.getAddress1());
		merchantDTO.setAddress2(mMaster.getAddress2());
		merchantDTO.setAddress3(mMaster.getAddress3());
		merchantDTO.setCity(IntUtil.getString(mMaster.getCity()));
		merchantDTO.setState(mMaster.getState());
		merchantDTO.setZipCode(mMaster.getZip());
		merchantDTO.setDailyDealenName(mMaster.getDailyDealenName());
		merchantDTO.setTestDrive(mMaster.getTestDrive());
		merchantDTO.setGoogleAnalyticsId(mMaster.getGoogleAnalyticId());
		merchantDTO.setBlogTemplateId(mMaster.getBlogTemplateId());
		merchantDTO.setContactAlternatePhone(mMaster.getContactAltPhone());
		merchantDTO.setBlogTemplateId(mMaster.getBlogTemplateId());
		merchantDTO.setPassword(mMaster.getPassword());
		merchantDTO.setDeactivateDate(DateUtil.parseDateToString(mMaster.getDeactivateDate(), userInfo.getDateFormat()));
		merchantDTO.setCreateDateText(DateUtil.parseDateToString(mMaster.getCreatedDate(), userInfo.getDateTimeFormat()));
		userInfo.setLogoId(dao.getLogoId(IntUtil.getInteger(merchantId)));

		if (neighMap != null)
			merchantDTO.setNeighborhoodName(neighMap.get(mMaster.getNeighborhoodName() + ""));

		if (mMaster.getSalesPerson() != null) {
			SalesPerson salesPerson = entityManager.find(SalesPerson.class, IntUtil.getInteger(mMaster.getSalesPerson()));
			if (salesPerson != null)
				merchantDTO.setSalesPerson(salesPerson.getSalesPersonFirstName() + " " + salesPerson.getSalesPersonLastName());
		}
		merchantDTO.setmFeatureList(new ArrayList<String>());
		List<MerchantFeatureLink> mFeatList = dao.getMerchentFeatuer(mMaster.getMerchantId());
		if (mFeatList != null && mFeatList.size() > 0) {
			for (MerchantFeatureLink mf : mFeatList) {
				merchantDTO.getmFeatureList().add(IntUtil.getString(mf.getMerchantFeaturePK().getFeatureId()));
			}
		}

		List<MerchantCategory> mCtgList = dao.getMerchantCategory(mMaster.getMerchantId());
		if (mCtgList != null && mCtgList.size() > 0) {
			MerchantCategory mCtg1 = mCtgList.get(0);
			merchantDTO.setMasterCategory(IntUtil.getString(mCtg1.getMerchantCategoryPK().getMasterCategory()));
			merchantDTO.setMasterCategoryText(dao.getMasterCategoryNameById(mCtg1.getMerchantCategoryPK().getMasterCategory()));
			merchantDTO.setCategory1(IntUtil.getString(mCtg1.getMerchantCategoryPK().getCategoryId()));
			merchantDTO.setCategory1Text(dao.getCategoryNameById(mCtg1.getMerchantCategoryPK().getCategoryId()));
			merchantDTO.setSubCategory1Text(dao.getSubCategoryNameById(merchantId, mCtg1.getMerchantCategoryPK().getCategoryId()));

			if (mCtgList.size() >= 2) {
				MerchantCategory mCtg2 = mCtgList.get(1);
				merchantDTO.setCategory2(IntUtil.getString(mCtg2.getMerchantCategoryPK().getCategoryId()));
				merchantDTO.setCategory2Text(dao.getCategoryNameById(mCtg2.getMerchantCategoryPK().getCategoryId()));
				merchantDTO.setSubCategory2Text(dao.getSubCategoryNameById(merchantId, mCtg2.getMerchantCategoryPK().getCategoryId()));
			}
		}
		return merchantDTO;
	}

	public Map<String, String> getSubCategoryMap(String merchantId, String categoryId) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		Map<String, String> retMap = null;
		try {
			retMap = merchantDAO.getSubCategoryMap(merchantId, categoryId);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	public List<MerchantCategoryDTO> getSelectedSubCategories(String mershantId, String categoryId, Integer type) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		List<MerchantCategoryDTO> retMap = null;
		try {
			return merchantDAO.getSelectedSubCategories(mershantId, categoryId, type);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public List<SubCategoryDTO> getSubCategoryListByCategoryId(UserInfo userInfo, String categoryId) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		List<SubCategoryDTO> retList = null;
		try {
			List<Object[]> subCategories = merchantDAO.getSubCategoryListByCategoryId(userInfo, categoryId);

			Iterator<?> itr = subCategories.iterator();
			while (itr.hasNext()) {
				Object[] o = (Object[]) itr.next();
				SubCategoryDTO dto = new SubCategoryDTO();
				dto.setSubCategoryId((Integer) o[0] + "");
				dto.setSubCategoryName((String) o[1]);
				dto.setCounts(((BigInteger) o[2]).toString());
				if (retList == null)
					retList = new ArrayList<SubCategoryDTO>();
				retList.add(dto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return retList;
	}

	public DealzDTO getHighestRatedDealz(UserInfo userInfo) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> merchantDAO = loadDAO();
		List<Object[]> dealzDTOs = merchantDAO.getHighestRatedDealz(userInfo);
		DealzDTO dealzDTO = null;
		if (dealzDTOs != null) {
			dealzDTO = new DealzDTO();
			for (Object[] o : dealzDTOs) {
				DealzDTO dto = new DealzDTO();
				dto.setDealId(o[0] + "");
				dto.setUrlTitle(((String) o[1]).replaceAll("[^a-zA-Z0-9]", "-"));
				dto.setTitle((String) o[1]);
				if (dealzDTO.getDealzDTOs() == null)
					dealzDTO.setDealzDTOs(new ArrayList<DealzDTO>());
				dealzDTO.getDealzDTOs().add(dto);
			}
		}
		return dealzDTO;
	}

	public String unSubscribedEmailById(String subscriptionId) throws BaseException {
		if (subscriptionId != null) {
			Subscribers s = loadDAO().getSubscriberByEmailId(subscriptionId);
			if (s != null) {
				s.setIsActive(1);
				entityManager.merge(s);
			}
		} else {
			// throw new
			// BusinessException("e-Mail Id is already associated with existing account",
			// BusinessException.BUSSINESS_TYP);
		}
		return "success";
	}

	public String saveFBAccessToken(Integer userIndex, String accessToken, String params) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		SocialConnections con = dao.getMySocialConnection(userIndex);
		if (con == null) {
			con = new SocialConnections();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("socialConnId", entityManager);

			con.setSocialConnectionsPK(new SocialConnectionsPK(IntUtil.getInteger(nextKey), userIndex));
			con.setCreatedBy(userIndex);
			con.setCreatedDate(new Date());
		}
		con.setUpdatedBy(userIndex);
		con.setUpdatedDate(new Date());
		entityManager.merge(con);
		if (con != null) {
			FBAccessTokeMerchantLink link = entityManager.find(FBAccessTokeMerchantLink.class, con.getSocialConnectionsPK().getSocialConnectionId());
			if (link == null) {
				link = new FBAccessTokeMerchantLink();
				link.setConnectionId(con.getSocialConnectionsPK().getSocialConnectionId());
				link.setCreatedBy(userIndex);
				link.setCreatedDate(new Date());

			}
			link.setName(params);
			link.setAccessToken(accessToken);
			link.setUpdatedBy(userIndex);
			link.setUpdatedDate(new Date());
			entityManager.merge(link);
		}
		return "success";
	}

	public String getMyAccessToken(Integer merchantId) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		SocialConnections con = dao.getMySocialConnection(merchantId);
		FBAccessTokeMerchantLink link = null;
		if (con != null) {
			link = entityManager.find(FBAccessTokeMerchantLink.class, con.getSocialConnectionsPK().getSocialConnectionId());
		}
		if (link == null)
			return null;
		return link.getAccessToken();
	}

	public Map<Integer, String> checkUserCanPost(UserInfo userInfo) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		Map<Integer, String> flag = dao.checkUserCanPost(userInfo);
		return flag;
	}

	public String getMyLevel(UserInfo userInfo) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		String levelId = dao.getMyLevel(userInfo);
		return levelId;
	}

	public String updateMerchantLevel(UserInfo userInfo, String currentLevel, String changedLevel) throws BaseException {
		MerchantLevel merchantLevel = entityManager.find(MerchantLevel.class, new MerchantLevelPK(userInfo.getUserIndex(), IntUtil.getInteger(currentLevel)));
		entityManager.remove(merchantLevel);

		merchantLevel = new MerchantLevel();
		merchantLevel.setMerchantLevelPK(new MerchantLevelPK(userInfo.getUserIndex(), IntUtil.getInteger(changedLevel)));
		merchantLevel.setCreatedBy(userInfo.getUserIndex());
		merchantLevel.setCreatedDate(new Date());
		merchantLevel.setUpdatedBy(userInfo.getUserIndex());
		merchantLevel.setUpdatedDate(new Date());
		entityManager.merge(merchantLevel);
		return changedLevel;
	}

	public HotDealBannerDTO getHotDealDetails(UserInfo userInfo) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		HotDealBannerDTO bannerDTO = null;
		List<MerchantDealz> dealzs = dao.getAllHotDeals(userInfo);
		if (dealzs != null && dealzs.size() > 0) {
			bannerDTO = new HotDealBannerDTO();
			for (MerchantDealz deal : dealzs) {
				HotDealBannerDTO dto = new HotDealBannerDTO();
				dto.setDealId(deal.getMerchantDealzPK().getDealzId() + "");
				if (deal.getUseLogo() != null && deal.getUseLogo() == 1) {
					dto.setImagePath(loadDAO().getLogoInfo(deal.getMerchantDealzPK().getMerchantId()));
				} else {
					String fileName = (String) dao.getDocument(deal.getMerchantDealzPK().getDealzId() + "");
					if (fileName != null)
						dto.setImagePath(fileName);

				}
				dto.setUrl(deal.getHotDealLink());
				dto.setImageAlt(deal.getTitle());
				dto.setMerchantId(deal.getMerchantDealzPK().getMerchantId() + "");
				MerchantMaster mMaster = entityManager.find(MerchantMaster.class, deal.getMerchantDealzPK().getMerchantId());
				dto.setMerchantName(mMaster.getMerchantName());
				if (bannerDTO.getBannerDTOs() == null)
					bannerDTO.setBannerDTOs(new ArrayList<HotDealBannerDTO>());
				bannerDTO.getBannerDTOs().add(dto);
			}
		}
		return bannerDTO;
	}

	public MerchantDTO getMerchantDetailByEmailId(String emailId) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		MerchantDTO merchantDTO = null;
		MerchantMaster mMaster = dao.getMerchantDetailByEmailId(emailId);
		if (mMaster != null) {
			merchantDTO = new MerchantDTO();
			merchantDTO.setMerchantId(mMaster.getMerchantId() + "");
			merchantDTO.setEmailId(mMaster.getEmailId());
			merchantDTO.setUserId(mMaster.getUserId());
			merchantDTO.setMerchantName(mMaster.getMerchantName());
			merchantDTO.setPassword(mMaster.getPassword());
			merchantDTO.setLoginUrl(AppPropertyBuilder.getProperty("merchantLoginUrl", "01"));
		}
		return merchantDTO;
	}

	public MerchantDTO getAdminDetailsByEmailId(String emailId) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		MerchantDTO merchantDTO = null;
		UserMaster mMaster = dao.getAdminDetailsByEmailId(emailId);
		if (mMaster != null) {
			merchantDTO = new MerchantDTO();
			merchantDTO.setMerchantId(mMaster.getUserIndex() + "");
			merchantDTO.setEmailId(mMaster.getEmailId());
			merchantDTO.setUserId(mMaster.getUserId());
			merchantDTO.setMerchantName(mMaster.getFirstName());
			merchantDTO.setPassword(mMaster.getPassword());
			merchantDTO.setLoginUrl(AppPropertyBuilder.getProperty("adminLoginUrl", "01"));
		}
		return merchantDTO;
	}

	public List<LocationDTO> saveMerchantLocations(String mId, List<LocationDTO> locationDTOs) throws BaseException {
		Integer merchantId = IntUtil.getInteger(mId);
		for (LocationDTO locationDTO : locationDTOs) {
			MerchantLocation merchantLocation = null;
			Integer locationId = IntUtil.getInteger(locationDTO.getLocationId());
			if (locationId != null)
				merchantLocation = entityManager.find(MerchantLocation.class, new MerchantLocationPK(merchantId, locationId));

			if (merchantLocation == null) {
				merchantLocation = new MerchantLocation();
				String nextKey = DefaultKeyGenerator.getNextGeneratedKey("mLocationId", entityManager);
				locationDTO.setLocationId(nextKey);
				merchantLocation.setMerchantLocationPK(new MerchantLocationPK(merchantId, IntUtil.getInteger(nextKey)));
				merchantLocation.setCreatedBy(merchantId);
				merchantLocation.setCreatedDate(new Date());
			}
			merchantLocation.setContactFirstName(locationDTO.getContactFirstName());
			merchantLocation.setContactLastName(locationDTO.getContactLastName());
			merchantLocation.setLocationPhone(locationDTO.getLocationPhone());
			merchantLocation.setLocationName(locationDTO.getLocationName());
			merchantLocation.setCity(locationDTO.getCity());
			merchantLocation.setState(locationDTO.getState());
			merchantLocation.setZipCode(locationDTO.getZipCode());
			merchantLocation.setLocationDesc(locationDTO.getLocationDesc());
			merchantLocation.setLocationHours(locationDTO.getLocationHours());
			merchantLocation.setEmail(locationDTO.getEmailAddress());
			merchantLocation.setLocationDesc(locationDTO.getLocationDesc());
			merchantLocation.setLocationHours(locationDTO.getLocationHours());
			merchantLocation.setAddress1(locationDTO.getAddress1());
			merchantLocation.setAddress2(locationDTO.getAddress2());
			merchantLocation.setAddress3(locationDTO.getAddress3());
			merchantLocation.setUpdatedBy(merchantId);
			merchantLocation.setUpdatedDate(new Date());
			merchantLocation.setNeighborhoodid(IntUtil.getInteger(locationDTO.getNeighborhood()));
			entityManager.merge(merchantLocation);
		}
		return locationDTOs;
	}

	public EmbedsDTO saveMerchantEmbeds(UserInfo userInfo, EmbedsDTO embedsDTO) {
		MerchantEmbeds merchantEmbeds = null;
		Integer embedId = IntUtil.getInteger(embedsDTO.getEmbedId());
		if (embedId != null)
			merchantEmbeds = entityManager.find(MerchantEmbeds.class, embedId);

		if (merchantEmbeds == null) {
			merchantEmbeds = new MerchantEmbeds();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("mEmbeds", entityManager);
			embedsDTO.setEmbedId(nextKey);
			merchantEmbeds.setEmbedId(IntUtil.getInteger(nextKey));
			merchantEmbeds.setMerchantId(userInfo.getUserIndex());
			merchantEmbeds.setCreatedBy(userInfo.getUserIndex());
			merchantEmbeds.setCreatedDate(new Date());
			merchantEmbeds.setEmbedContent(embedsDTO.getEmbedContent());

		}
		merchantEmbeds.setIsShowOnPage(Boolean.parseBoolean(embedsDTO.getShowOnPage()));
		merchantEmbeds.setEmbedTitle(embedsDTO.getEmbedTitle());
		merchantEmbeds.setUpdatedBy(userInfo.getUserIndex());
		merchantEmbeds.setUpdatedDate(new Date());
		entityManager.merge(merchantEmbeds);

		return embedsDTO;
	}

	public List<EmbedsDTO> getMerchantEmbeds(Integer merchantId) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<MerchantEmbeds> embeds = dao.getMerchantEmbeds(merchantId);
		List<EmbedsDTO> embedsDTOs = new ArrayList<EmbedsDTO>();
		UserInfo userInfo = new UserInfo();
		if (!isEmpty(embeds)) {
			for (MerchantEmbeds em : embeds) {
				EmbedsDTO embedsDTO = new EmbedsDTO();
				embedsDTO.setEmbedId(em.getEmbedId() + "");
				embedsDTO.setEmbedTitle(em.getEmbedTitle());
				embedsDTO.setEmbedContent(em.getEmbedContent());
				embedsDTO.setShowOnPage(em.getIsShowOnPage() == true ? "Yes" : "No");
				embedsDTO.setCreateDateText(DateUtil.parseDateToString(em.getCreatedDate(), userInfo.getDateFormat()));
				embedsDTOs.add(embedsDTO);
			}
		}
		return embedsDTOs;
	}

	public EmbedsDTO deleteEmbed(Integer embedId) {
		EmbedsDTO eDto = new EmbedsDTO();
		eDto.setEmbedId(embedId + "");
		MerchantEmbeds merchantEmbeds = null;
		if (embedId != null) {
			merchantEmbeds = entityManager.find(MerchantEmbeds.class, embedId);
			entityManager.remove(merchantEmbeds);
		}
		return eDto;
	}

	public EmbedsDTO updateEmbed(EmbedsDTO embedsDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	public String verifyRegisterForm(String userId, String emailId) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		// For UserId unique
		if (!isEmpty(userId)) {
			if (dao.isUserIdExist(userId))
				throw new BusinessException("This Get City Dealz Name already taken some one.Please try another.", BusinessException.BUSSINESS_TYP);
		} else
			throw new BusinessException("Get City Dealz Name is mandatory.", BusinessException.BUSSINESS_TYP);

		// For EMailId unique
		if (!isEmpty(emailId)) {
			if (dao.isEmailIsRegistered(emailId))
				throw new BusinessException("e Mail Id is already associated with existing account", BusinessException.BUSSINESS_TYP);
		} else
			throw new BusinessException("e Mail Id is mandatory.", BusinessException.BUSSINESS_TYP);
		return null;
	}

	public void saveTwitterDetails(UserInfo userInfo, String userId, String screenName, String token, String tokenSecret) throws BaseException {
		SocialConnectionsDTO dto = getMySocialConnections(userInfo.getUserIndex() + "");
		TwitterOAuth twitterOAuth = entityManager.find(TwitterOAuth.class, userInfo.getUserIndex());
		if (twitterOAuth == null) {
			twitterOAuth = new TwitterOAuth();
			twitterOAuth.setCreatedBy(userInfo.getUserIndex());
			twitterOAuth.setCreatedDate(new Date());
		}
		twitterOAuth.setMerchantId(userInfo.getUserIndex());
		twitterOAuth.setUserId(userId);
		twitterOAuth.setScreenName(screenName);
		twitterOAuth.setAccessToken(token);
		twitterOAuth.setAccessTokenSecret(tokenSecret);
		twitterOAuth.setUpdatedBy(userInfo.getUserIndex());
		twitterOAuth.setUpdatedDate(new Date());

		entityManager.merge(twitterOAuth);

		SocialConnections connections = entityManager.find(SocialConnections.class,
				new SocialConnectionsPK(IntUtil.getInteger(dto.getConnectionId()), userInfo.getUserIndex()));
		connections.setTwitterScreenName(screenName);
		connections.setUpdatedBy(userInfo.getUserIndex());
		connections.setUpdatedDate(new Date());
		entityManager.merge(connections);
	}

	public boolean updateDealz(UserInfo userInfo, String dealzId, String city) throws BaseException {
		try {
			MerchantDealz merchantDealz = entityManager.find(MerchantDealz.class, new MerchantDealzPK(IntUtil.getInteger(dealzId), userInfo.getUserIndex(),
					IntUtil.getInteger(city)));

			Cities cities = entityManager.find(Cities.class, merchantDealz.getMerchantDealzPK().getCitySectionId());

			MerchantMaster merchantMaster = entityManager.find(MerchantMaster.class, userInfo.getUserIndex());
			String titlez = StringUtil.getWithoutSpecial(merchantDealz.getTitle());
			if (merchantDealz.getFbSortUrl() == null)
				merchantDealz.setFbSortUrl(getSortUrl(cities.getCityCode() + getProperty("app.domain.name", "01") + "/"
						+ merchantMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-") + "/deal/" + titlez + "--" + dealzId,
						"campaign=VisitorSharing%26medium=FBShare%26content=" + titlez));

			if (merchantDealz.getTwitSortUrl() == null)
				merchantDealz.setTwitSortUrl(getSortUrl(cities.getCityCode() + getProperty("app.domain.name", "01") + "/"
						+ merchantMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-") + "/deal/" + titlez + "--" + dealzId,
						"campaign=VisitorSharing%26medium=TwitterShare%26content=" + titlez));

			if (merchantDealz.getPinSortUrl() == null)
				merchantDealz.setPinSortUrl(getSortUrl(cities.getCityCode() + getProperty("app.domain.name", "01") + "/"
						+ merchantMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-") + "/deal/" + titlez + "--" + dealzId,
						"campaign=VisitorSharing%26medium=PinterestShare%26content=" + titlez));

			if (merchantDealz.getgPSortUrl() == null)
				merchantDealz.setgPSortUrl(getSortUrl(cities.getCityCode() + getProperty("app.domain.name", "01") + "/"
						+ merchantMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-") + "/deal/" + titlez + "--" + dealzId,
						"campaign=VisitorSharing%26medium=GPlusShare%26content=" + titlez));

			if (merchantDealz.getLinkSortUrl() == null)
				merchantDealz.setLinkSortUrl(getSortUrl(cities.getCityCode() + getProperty("app.domain.name", "01") + "/"
						+ merchantMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-") + "/deal/" + titlez + "--" + dealzId,
						"campaign=VisitorSharing%26medium=LIShare%26content=" + titlez));
			merchantDealz.setStatus(1);
			entityManager.merge(merchantDealz);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return false;
		}
		return true;
	}

	public void saveAdminTwitterDetails(UserInfo userInfo, String userId, String screenName, String token, String tokenSecret) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		AdminSocialLink con = dao.getAdminSocialConnection(userInfo.getUserIndex());
		if (con == null) {
			con = new AdminSocialLink();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("adminSConnId", entityManager);

			con.setAdminSocialLinkPK(new AdminSocialLinkPK(userInfo.getUserIndex(), IntUtil.getInteger(nextKey)));
			con.setCreatedBy(userInfo.getUserIndex());
			con.setCreatedDate(new Date());
		}
		con.setUpdatedBy(userInfo.getUserIndex());
		con.setUpdatedDate(new Date());
		entityManager.merge(con);
		if (con != null) {
			AdminTwitterOAuth link = entityManager.find(AdminTwitterOAuth.class, con.getAdminSocialLinkPK().getLinkId());
			if (link == null) {
				link = new AdminTwitterOAuth();
				link.setConnectionId(con.getAdminSocialLinkPK().getLinkId());
				link.setCreatedBy(userInfo.getUserIndex());
				link.setCreatedDate(new Date());

			}
			link.setUserId(userId);
			link.setAccessToken(token);
			link.setScreenName(screenName);
			link.setAccessTokenSecret(tokenSecret);
			link.setUpdatedBy(userInfo.getUserIndex());
			link.setUpdatedDate(new Date());
			entityManager.merge(link);
		}
	}

	public String saveAdminFBAccessToken(Integer userIndex, String accessToken, String name) throws BaseException {
		MerchantDAO<Base<Serializable>, Serializable> dao = loadDAO();
		AdminSocialLink con = dao.getAdminSocialConnection(userIndex);
		if (con == null) {
			con = new AdminSocialLink();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("adminSConnId", entityManager);

			con.setAdminSocialLinkPK(new AdminSocialLinkPK(userIndex, IntUtil.getInteger(nextKey)));
			con.setCreatedBy(userIndex);
			con.setCreatedDate(new Date());
		}
		con.setUpdatedBy(userIndex);
		con.setUpdatedDate(new Date());
		entityManager.merge(con);
		if (con != null) {
			AdminFBAccessToken link = entityManager.find(AdminFBAccessToken.class, con.getAdminSocialLinkPK().getLinkId());
			if (link == null) {
				link = new AdminFBAccessToken();
				link.setConnectionId(con.getAdminSocialLinkPK().getLinkId());
				link.setCreatedBy(userIndex);
				link.setCreatedDate(new Date());

			}
			link.setName(name);
			link.setAccessToken(accessToken);
			link.setUpdatedBy(userIndex);
			link.setUpdatedDate(new Date());
			entityManager.merge(link);
		}
		return "success";
	}
}
