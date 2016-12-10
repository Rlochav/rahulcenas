package com.app.getcitydealz.manager;

import static java.lang.String.valueOf;
import static org.springframework.util.CollectionUtils.isEmpty;
import static org.springframework.util.StringUtils.isEmpty;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.common.dto.GcdMetaDTO;
import com.app.commonexception.BaseException;
import com.app.commonexception.BusinessException;
import com.app.deal.dto.DealzDTO;
import com.app.getcitydealz.dao.GetCityDealzDAO;
import com.app.getcitydealz.dto.CategoryDTO;
import com.app.getcitydealz.dto.CityDTO;
import com.app.getcitydealz.dto.DealzRateDTO;
import com.app.getcitydealz.dto.DocumentDTO;
import com.app.getcitydealz.dto.IconsDTO;
import com.app.getcitydealz.dto.LocationDTO;
import com.app.getcitydealz.dto.MerchantDTO;
import com.app.getcitydealz.dto.NeighborhoodDTO;
import com.app.getcitydealz.dto.SalesPersonDTO;
import com.app.getcitydealz.dto.SocialConnectionsDTO;
import com.app.getcitydealz.dto.SubCategoryDTO;
import com.app.getcitydealz.dto.SubscriptionDTO;
import com.app.getcitydealz.dto.SubscriptionLevelDTO;
import com.app.login.dto.UserInfo;
import com.app.model.base.Base;
import com.app.model.blog.GcdPost;
import com.app.model.category.Category;
import com.app.model.category.SubCategory;
import com.app.model.category.SubCategoryPK;
import com.app.model.citiesnstate.Cities;
import com.app.model.citiesnstate.States;
import com.app.model.citiesnstate.StatesPK;
import com.app.model.documentsmanagemant.DocumentLink;
import com.app.model.documentsmanagemant.DocumentLinkPK;
import com.app.model.documentsmanagemant.Documents;
import com.app.model.getcitydealz.AccessibiltyIcons;
import com.app.model.getcitydealz.AdminSocialLink;
import com.app.model.getcitydealz.AdminSocialLinkPK;
import com.app.model.getcitydealz.CategoryDealzLink;
import com.app.model.getcitydealz.CategoryDealzLinkPK;
import com.app.model.getcitydealz.DealzRating;
import com.app.model.getcitydealz.DealzSubscriptionDetails;
import com.app.model.getcitydealz.GcdTimeZone;
import com.app.model.getcitydealz.MerchantDealz;
import com.app.model.getcitydealz.MerchantDealzPK;
import com.app.model.getcitydealz.MerchantLocation;
import com.app.model.getcitydealz.MerchantMaster;
import com.app.model.getcitydealz.NeighborhoodDealzLink;
import com.app.model.getcitydealz.NeighborhoodDealzLinkPK;
import com.app.model.getcitydealz.NeighborhoodMaster;
import com.app.model.getcitydealz.NeighborhoodMasterPK;
import com.app.model.getcitydealz.SubCategoryDealzLink;
import com.app.model.getcitydealz.SubCategoryDealzLinkPK;
import com.app.model.levelmaster.LevelMaster;
import com.app.model.metadata.GcdPageManager;
import com.app.model.metadata.GcdRightHandRailsNav;
import com.app.model.metadata.GcdSocialNav;
import com.app.model.salesperson.SalesPerson;
import com.app.model.socialconnections.AdminFBAccessToken;
import com.app.model.socialconnections.AdminTwitterOAuth;
import com.app.model.socialconnections.SocialAccounts;
import com.app.model.socialconnections.SocialConnections;
import com.app.model.subscriber.SubscriberCategoryLink;
import com.app.model.subscriber.SubscriberNeighborhoodsLink;
import com.app.model.subscriber.Subscribers;
import com.app.model.user.UserMaster;
import com.app.model.user.UserSession;
import com.app.mvc.util.GlobalTimeHandler;
import com.app.persistence.DefaultKeyGenerator;
import com.app.persistence.exception.DAOException;
import com.app.persistence.factory.JPADAOFactory;
import com.app.post.dto.PostDTO;
import com.app.social.dto.SocialProfileDTO;
import com.app.utility.common.AppPropertyBuilder;
import com.app.utility.common.DateUtil;
import com.app.utility.common.EmailUtility;
import com.app.utility.common.IntUtil;

@Repository
public class GetCityDealzManager {
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public GetCityDealzDAO<Base<Serializable>, Serializable> loadDAO() throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> loginDAO = null;
		try {
			loginDAO = (GetCityDealzDAO<Base<Serializable>, Serializable>) JPADAOFactory
					.getDAOFactory(JPADAOFactory.DEFAULT).getDAO(GetCityDealzDAO.class);
			loginDAO.setEntityManager(entityManager);
		} catch (BaseException e) {
			throw e;
		}
		return loginDAO;
	}

	public String isDealCodeUniqe(UserInfo userInfo, String dealId, String dealCode) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		/*
		 * if (dealCode != null && !dealCode.trim().isEmpty()) { if
		 * (!dao.isDealCodeUnique(dealId, dealCode)) throw new
		 * BusinessException("This deal code already present in system.",
		 * BusinessException.BUSSINESS_TYP); }
		 */
		return "";
	}

	public DealzDTO saveMerchantDealz(UserInfo userInfo, DealzDTO dealzDTO) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		Integer dealzId = IntUtil.getInteger(dealzDTO.getDealId());
		Integer merchantId = IntUtil.getInteger(dealzDTO.getMerchantId());
		Integer citySectionId = IntUtil.getInteger(userInfo.getCity());

		/*
		 * if (dealzDTO.getDealCode() != null &&
		 * !dealzDTO.getDealCode().trim().isEmpty()) { if
		 * (!dao.isDealCodeUnique(dealzDTO.getDealId(), dealzDTO.getDealCode()))
		 * throw new BusinessException(
		 * "This deal code already present in system.",
		 * BusinessException.BUSSINESS_TYP); }
		 */

		MerchantDealz merchantDealz = null;
		CategoryDealzLink categoryDealzLink = null;
		SubCategoryDealzLink subCategoryDealzLink = null;
		NeighborhoodDealzLink neighborhoodDealzLink = null;
		if (dealzId != null && merchantId != null) {
			merchantDealz = entityManager.find(MerchantDealz.class,
					new MerchantDealzPK(dealzId, merchantId, citySectionId));

		}

		if (merchantDealz == null) {
			merchantDealz = new MerchantDealz();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("deazId", entityManager);
			dealzDTO.setDealId(nextKey);
			merchantDealz
					.setMerchantDealzPK(new MerchantDealzPK(IntUtil.getInteger(nextKey), merchantId, citySectionId));
			merchantDealz.setCreatedBy(userInfo.getUserIndex());
			merchantDealz.setCreatedDate(new Date());
		}
		if (dealzDTO.getDealType().equals("2"))
			merchantDealz.setPayed(1);
		merchantDealz.setLatitude(dealzDTO.getLatitude());
		merchantDealz.setLongitude(dealzDTO.getLongitude());
		merchantDealz.setTitle(dealzDTO.getTitle());
		merchantDealz.setCode(dealzDTO.getDealCode());
		merchantDealz.setRestrictions(dealzDTO.getRestriction());
		merchantDealz.setDealType(IntUtil.getInteger(dealzDTO.getDealType()));
		merchantDealz.setUseLogo(IntUtil.getInteger(dealzDTO.getUseLogo()));
		merchantDealz.setStartDate(DateUtil.stringDateToDate(dealzDTO.getStartDate(), userInfo.getDateTimeFormat()));
		merchantDealz.setEndDate(DateUtil.stringDateToDate(dealzDTO.getEndDate(), userInfo.getDateTimeFormat()));
		merchantDealz.setDescription(dealzDTO.getDescription());
		merchantDealz.setAmountSaving(dealzDTO.getAmountSaved());
		if (dealzDTO.getDealType().equals("1"))
			merchantDealz.setProcessed(666);
		else
			merchantDealz.setProcessed(1);
		if (dealzDTO.getDealType().equals("1"))
			merchantDealz.setAdminSocialPostedStatus(666); // Admin Social
															// Inactive
		merchantDealz.setUpdatedBy(userInfo.getUserIndex());
		merchantDealz.setUpdatedDate(new Date());
		if (dealzDTO.getDealType().equals("1") && !(new Integer(1)).equals(merchantDealz.getStatus()))
			merchantDealz.setStatus(666);
		else
			merchantDealz.setStatus(1);

		GcdTimeZone gcdTimeZone = entityManager.find(GcdTimeZone.class, IntUtil.getInteger(dealzDTO.getTimeZoneId()));

		merchantDealz.setLocalTimeZoneName(gcdTimeZone.getZoneName());
		merchantDealz.setLocalTimeZoneUtc(GlobalTimeHandler.getTimeZoneUtcTime(gcdTimeZone.getZoneName()));

		merchantDealz.setHotDealLink(dealzDTO.getHotDealLink());
		merchantDealz.setHotDealOrder(IntUtil.getInteger(dealzDTO.getOrderNo()));

		List<Object> mCategories = dao.getMerchantCategoriesById(merchantId);
		List<Object> mSubCategories = dao.getMerchantSubCategoriesById(merchantId);
		// category dealz linking
		if (mCategories != null && mCategories.size() > 0) {
			for (Object o : mCategories) {
				categoryDealzLink = new CategoryDealzLink();
				categoryDealzLink.setCategoryDealzLinkPK(new CategoryDealzLinkPK(
						merchantDealz.getMerchantDealzPK().getDealzId(), (Integer) o, merchantId));
				categoryDealzLink.setProcessed(0);
				categoryDealzLink.setProcessed1(0);
				entityManager.merge(categoryDealzLink);
			}
		}

		// sub category dealz linking
		if (mSubCategories != null && mSubCategories.size() > 0) {
			for (Object o : mSubCategories) {
				subCategoryDealzLink = new SubCategoryDealzLink();
				subCategoryDealzLink.setSubCategoryDealzLinkPK(new SubCategoryDealzLinkPK(
						merchantDealz.getMerchantDealzPK().getDealzId(), (Integer) o, merchantId));
				entityManager.merge(subCategoryDealzLink);
			}
		}

		MerchantMaster merchantMaster = entityManager.find(MerchantMaster.class, merchantId);
		neighborhoodDealzLink = new NeighborhoodDealzLink();
		Integer dealzIdx = merchantDealz.getMerchantDealzPK().getDealzId();
		Integer neighName = merchantMaster.getNeighborhoodName();
		if (dealzIdx != null && neighName != null && merchantId != null)
			neighborhoodDealzLink = entityManager.find(NeighborhoodDealzLink.class, new NeighborhoodDealzLinkPK(
					merchantDealz.getMerchantDealzPK().getDealzId(), neighName, merchantId));
		if (neighborhoodDealzLink == null) {
			neighborhoodDealzLink = new NeighborhoodDealzLink();
			neighborhoodDealzLink.setNeighborhoodDealzLinkPK(new NeighborhoodDealzLinkPK(
					merchantDealz.getMerchantDealzPK().getDealzId(), merchantMaster.getNeighborhoodName(), merchantId));
			neighborhoodDealzLink.setCreatedBy(0);
			neighborhoodDealzLink.setCreatedDate(new Date());
		}

		neighborhoodDealzLink.setProcessed(0);
		neighborhoodDealzLink.setProcessed1(0);
		neighborhoodDealzLink.setUpdatedBy(0);
		neighborhoodDealzLink.setUpdatedDate(new Date());
		entityManager.merge(neighborhoodDealzLink);
		entityManager.merge(merchantDealz);

		if (merchantId != null) {
			dealzDTO.setMerchantName(merchantMaster.getMerchantName());
			dealzDTO.setEmails(merchantMaster.getEmailId());
		}
		if (merchantDealz.getUseLogo() != null && merchantDealz.getUseLogo() == 1) {
			dealzDTO.setImagePath(loadDAO().getDealImageId(merchantDealz.getMerchantDealzPK().getMerchantId(), 2,
					merchantDealz.getMerchantDealzPK().getDealzId()));
		} else {
			String fileName = (String) loadDAO().getDealImageId(merchantDealz.getMerchantDealzPK().getMerchantId(), 0,
					merchantDealz.getMerchantDealzPK().getDealzId());
			if (fileName != null)
				dealzDTO.setImagePath(fileName);
		}
		return dealzDTO;
	}

	public List<DealzDTO> getAllDealz(UserInfo userInfo, String cityId, String upcoming, String start)
			throws BaseException {
		List<DealzDTO> retDealzDTOs = null;
		try {

			Map<Integer, Object> retMap = loadDAO().getAllDealz(userInfo, cityId, upcoming, start);
			if (retMap != null && retMap.containsKey(1) && retMap.containsKey(2)) {
				List<MerchantDealz> merchantDealzs = (List<MerchantDealz>) retMap.get(1);
				if (merchantDealzs != null && merchantDealzs.size() > 0) {
					for (MerchantDealz dealz : merchantDealzs) {
						if (dealz == null)
							continue;
						DealzDTO dealzDTO = new DealzDTO();

						if (dealz.getUseLogo() != null && dealz.getUseLogo() == 1) {
							dealzDTO.setImagePath(loadDAO().getLogoInfo(dealz.getMerchantDealzPK().getMerchantId(), 2));
						} else {
							String fileName = (String) loadDAO()
									.getDocument(dealz.getMerchantDealzPK().getDealzId() + "");
							if (fileName != null)
								dealzDTO.setImagePath(fileName);
						}
						dealzDTO.setDealId(IntUtil.getString(dealz.getMerchantDealzPK().getDealzId()));
						dealzDTO.setCurrentRating(
								loadDAO().getCurrentRatingOfDealz(dealz.getMerchantDealzPK().getDealzId()) + "");
						dealzDTO.setTitle(dealz.getTitle());
						dealzDTO.setUrlTitle(dealz.getTitle().replaceAll("[^a-zA-Z0-9]", "-"));
						dealzDTO.setDealCode(dealz.getCode());
						dealzDTO.setStartDate(
								DateUtil.parseDateToString(dealz.getStartDate(), userInfo.getDateFormat()));
						dealzDTO.setEndDate(DateUtil.parseDateToString(dealz.getEndDate(), userInfo.getDateFormat()));
						dealzDTO.setRestriction(dealz.getRestrictions());
						dealzDTO.setDescription(dealz.getDescription());
						dealzDTO.setAmountSaved(dealz.getAmountSaving());
						dealzDTO.setLatitude(dealz.getLatitude());
						dealzDTO.setLongitude(dealz.getLongitude());
						dealzDTO.setMerchantId(dealz.getMerchantDealzPK().getMerchantId() + "");

						Cities cities = entityManager.find(Cities.class, dealz.getMerchantDealzPK().getCitySectionId());
						dealzDTO.setCityName(cities.getCityCode());
						MerchantMaster merchantMaster = entityManager.find(MerchantMaster.class,
								dealz.getMerchantDealzPK().getMerchantId());
						dealzDTO.setMerchantName(merchantMaster.getMerchantName());
						// dealzDTO.setUrlMerchantName(merchantMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]",
						// "-"));
						dealzDTO.setUrlMerchantName(merchantMaster.getMerchantUrl());

						SocialConnections connections = loadDAO()
								.getSocialConnectionsByMerchantId(dealz.getMerchantDealzPK().getMerchantId());
						if (connections != null) {
							SocialConnectionsDTO conDTO = setSocialConnectionDtos(connections);
							if (dealzDTO.getSocialConnectionsDTO() == null)
								dealzDTO.setSocialConnectionsDTO(conDTO);
							conDTO = null;
						} else {
							dealzDTO.setSocialConnectionsDTO(new SocialConnectionsDTO());
						}

						dealzDTO.setFbSortUrl(dealz.getFbSortUrl());
						dealzDTO.setTwitSortUrl(dealz.getTwitSortUrl());
						dealzDTO.setPinSortUrl(dealz.getPinSortUrl());
						dealzDTO.setLinkSortUrl(dealz.getLinkSortUrl());
						dealzDTO.setgPSortUrl(dealz.getgPSortUrl());

						dealzDTO.setCounts(retMap.get(2) + "");

						if (retDealzDTOs == null)
							retDealzDTOs = new ArrayList<DealzDTO>();
						retDealzDTOs.add(dealzDTO);
						dealzDTO = null;
					}
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		}
		return retDealzDTOs;
	}

	public DocumentDTO saveDocumentDetails(UserInfo userInfo, DocumentDTO documentDTO) throws BaseException {
		Documents documents = null;
		DocumentLink documentLink = null;
		Integer iDocId = IntUtil.getInteger(documentDTO.getLogoId());
		Integer merchantId = IntUtil.getInteger(documentDTO.getMerchantId());

		if (merchantId != null && iDocId != null && documentDTO.getDocType() != null) {
			documents = entityManager.find(Documents.class, iDocId);
			documentLink = entityManager.find(DocumentLink.class, new DocumentLinkPK(merchantId, iDocId));
		} else {
			documents = new Documents();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("docxIndex", entityManager);
			documents.setDocId(IntUtil.getInteger(nextKey));
			documentLink = new DocumentLink();
			documentLink.setDocumentLinkPK(new DocumentLinkPK(merchantId, documents.getDocId()));
		}

		documents.setOrignalFileName(documentDTO.getOrignalFileName());
		documents.setContentType(documentDTO.getContentType());
		documents.setParentFolderPath(documentDTO.getParentFolderPath());
		documents.setFileSavedAs(documentDTO.getFileSavedAs());
		documents.setShowOnPage(IntUtil.getInteger(documentDTO.getShowOnPage()));
		documents.setUpdatedBy(userInfo.getUserIndex());
		documents.setUpdatedDate(new Date());
		documents.setCreatedBy(userInfo.getUserIndex());
		documents.setCreatedDate(new Date());
		documents.setDocumentTitle(documentDTO.getDocumentTitle());
		entityManager.merge(documents);

		// DocumentLInk

		documentLink.setDocType(IntUtil.getInteger(documentDTO.getDocType()));
		documentLink.setDealId(IntUtil.getInteger(documentDTO.getDealzId()));
		documentLink.setUpdatedBy(userInfo.getUserIndex());
		documentLink.setUpdatedDate(new Date());
		documentLink.setCreatedBy(userInfo.getUserIndex());
		documentLink.setCreatedDate(new Date());

		entityManager.merge(documentLink);
		return documentDTO;
	}

	public DocumentDTO updateDocumentDetails(UserInfo userInfo, DocumentDTO documentDTO) throws BaseException {
		Documents documents = null;
		Integer iDocId = IntUtil.getInteger(documentDTO.getDocId());
		DocumentLink documentLink = null;
		if (iDocId != null) {
			documents = entityManager.find(Documents.class, iDocId);
			documentLink = entityManager.find(DocumentLink.class,
					new DocumentLinkPK(IntUtil.getInteger(documentDTO.getMerchantId()), iDocId));
		}
		if (documents != null && documentLink != null) {
			documents.setDocumentTitle(documentDTO.getDocumentTitle());
			entityManager.merge(documents);
			// DocumentLInk
			documentLink.setUpdatedBy(userInfo.getUserIndex());
			documentLink.setUpdatedDate(new Date());
			entityManager.merge(documentLink);
		}
		return documentDTO;
	}

	public Map<String, String> getCityMap(UserInfo userInfo) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		Map<String, String> retMap = null;
		try {
			retMap = dao.getCityMap(userInfo);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	public DocumentDTO getDocumentDetailsByMerchantId(String merchantId) throws BaseException {
		DocumentDTO documentDTO = new DocumentDTO();
		UserInfo userInfo = new UserInfo();
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		try {
			List<Object[]> documents = dao.getDocumentDetailsByMerchantId(merchantId);
			if (documents != null && documents.size() > 0) {
				for (Object[] o : documents) {
					DocumentDTO doc = new DocumentDTO();
					doc.setDocId(IntUtil.getString((Integer) o[0]));
					doc.setDocumentTitle((String) o[1]);
					doc.setShowOnPage(IntUtil.getString((Integer) o[2]).equals("0") ? "No" : "Yes");
					doc.setCreateDateText(DateUtil.parseDateToString((Date) o[3], userInfo.getDateFormat()));
					doc.setContentType((String) o[4]);
					if (documentDTO.getDocumentDTOs() == null)
						documentDTO.setDocumentDTOs(new ArrayList<DocumentDTO>());
					documentDTO.getDocumentDTOs().add(doc);
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		}
		return documentDTO;
	}

	public DocumentDTO deleteMediaFile(String merchantId, String docId) throws BaseException {
		DocumentDTO documentDTO = null;
		Documents documents = null;
		DocumentLink documentLink = null;
		Integer iDocId = IntUtil.getInteger(docId);
		if (iDocId != null) {
			documentDTO = new DocumentDTO();
			documents = entityManager.find(Documents.class, iDocId);
			entityManager.remove(documents);
			documentLink = entityManager.find(DocumentLink.class,
					new DocumentLinkPK(IntUtil.getInteger(merchantId), iDocId));
			entityManager.remove(documentLink);
		} else {
			throw new BusinessException(
					"Server encountered an internal error that prevented it from fulfilling this request.Please contact to server administrator.",
					BusinessException.BUSSINESS_TYP);
		}
		return documentDTO;
	}

	public DealzRateDTO rateDealz(UserInfo userInfo, DealzRateDTO dealzRateDTO) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		Integer iDealId = IntUtil.getInteger(dealzRateDTO.getDealId());
		DealzRating dealzRating = null;
		Integer currentRating = dao.getCurrentRatingOfDealz(iDealId);
		if (iDealId != null) {
			if (currentRating == 0)
				dealzRating = new DealzRating();

			else
				dealzRating = entityManager.find(DealzRating.class, iDealId);
			dealzRating.setDealId(iDealId);

			if (dealzRateDTO.getStart1() != null && !dealzRateDTO.getStart1().trim().isEmpty()
					&& dealzRateDTO.getStart1().equals("1") && currentRating == 0) {
				dealzRating.setStart1(IntUtil.getInteger(dealzRateDTO.getStart1()));
				dealzRating.setRatedBy1(dealzRateDTO.getRatedBy1() + "");
				dealzRating.setCurrentRating(1);
			}
			if (dealzRateDTO.getStart2() != null && !dealzRateDTO.getStart2().trim().isEmpty()
					&& dealzRateDTO.getStart2().equals("2")
					&& !(currentRating > IntUtil.getInteger(dealzRateDTO.getStart2()))) {
				if (dealzRating.getRatedBy1() != null && dealzRating.getRatedBy1().equals(dealzRateDTO.getRatedBy2()))
					throw new BusinessException("You already rated.", BusinessException.BUSSINESS_TYP);
				dealzRating.setStart2(IntUtil.getInteger(dealzRateDTO.getStart2()));
				dealzRating.setRatedBy2(dealzRateDTO.getRatedBy2());
				dealzRating.setCurrentRating(2);
			}
			if (dealzRateDTO.getStart3() != null && !dealzRateDTO.getStart3().trim().isEmpty()
					&& dealzRateDTO.getStart3().equals("3")
					&& !(currentRating > IntUtil.getInteger(dealzRateDTO.getStart3()))) {
				if ((dealzRating.getRatedBy2() != null && dealzRating.getRatedBy2().equals(dealzRateDTO.getRatedBy3()))
						|| (dealzRating.getRatedBy1() != null
								&& dealzRating.getRatedBy1().equals(dealzRateDTO.getRatedBy3())))
					throw new BusinessException("You already rated.", BusinessException.BUSSINESS_TYP);
				dealzRating.setStart3(IntUtil.getInteger(dealzRateDTO.getStart3()));
				dealzRateDTO.setRatedBy3(dealzRateDTO.getRatedBy3());
				dealzRating.setCurrentRating(3);
			}
			if (dealzRateDTO.getStart4() != null && !dealzRateDTO.getStart4().trim().isEmpty()
					&& dealzRateDTO.getStart4().equals("4")
					&& !(currentRating > IntUtil.getInteger(dealzRateDTO.getStart4()))) {
				if ((dealzRating.getRatedBy3() != null && dealzRating.getRatedBy3().equals(dealzRateDTO.getRatedBy4()))
						|| (dealzRating.getRatedBy2() != null
								&& dealzRating.getRatedBy2().equals(dealzRateDTO.getRatedBy4()))
						|| (dealzRating.getRatedBy1() != null
								&& dealzRating.getRatedBy1().equals(dealzRateDTO.getRatedBy4())))
					throw new BusinessException("You already rated.", BusinessException.BUSSINESS_TYP);
				dealzRating.setStart4(IntUtil.getInteger(dealzRateDTO.getStart4()));
				dealzRating.setRatedBy4(dealzRateDTO.getRatedBy4());
				dealzRating.setCurrentRating(4);
			}
			if (dealzRateDTO.getStart5() != null && !dealzRateDTO.getStart5().trim().isEmpty()
					&& dealzRateDTO.getStart5().equals("5")
					&& !(currentRating > IntUtil.getInteger(dealzRateDTO.getStart5()))) {
				if ((dealzRating.getRatedBy4() != null && dealzRating.getRatedBy4().equals(dealzRateDTO.getRatedBy5()))
						|| (dealzRating.getRatedBy3() != null
								&& dealzRating.getRatedBy3().equals(dealzRateDTO.getRatedBy5()))
						|| (dealzRating.getRatedBy2() != null
								&& dealzRating.getRatedBy2().equals(dealzRateDTO.getRatedBy5()))
						|| (dealzRating.getRatedBy1() != null
								&& dealzRating.getRatedBy1().equals(dealzRateDTO.getRatedBy5())))
					throw new BusinessException("You already rated.", BusinessException.BUSSINESS_TYP);
				dealzRating.setStart5(IntUtil.getInteger(dealzRateDTO.getStart5()));
				dealzRating.setRatedBy5(dealzRateDTO.getRatedBy5());
				dealzRating.setCurrentRating(5);
			}
			dealzRateDTO.setCurrentRating(dealzRating.getCurrentRating() + "");
			entityManager.merge(dealzRating);
		} else {

		}
		return dealzRateDTO;
	}

	public CategoryDTO saveCategories(UserInfo userInfo, CategoryDTO categoryDTO) throws BaseException {
		Integer categoryId = IntUtil.getInteger(categoryDTO.getCategoryId());
		if (loadDAO().isCategoryExist(categoryDTO.getCategoryName(), categoryId))
			throw new BusinessException("This Category already exist.", BusinessException.BUSSINESS_TYP);
		Category category = null;
		if (categoryId != null)
			category = entityManager.find(Category.class, categoryId);

		if (category == null) {
			category = new Category();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("categoryId", entityManager);
			categoryDTO.setCategoryId(nextKey);
			category.setCategoryId(IntUtil.getInteger(nextKey));
			category.setCreatedBy(userInfo.getUserIndex());
			category.setCreatedDate(new Date());
		}
		if (categoryDTO.getCategoryName() != null && !categoryDTO.getCategoryName().trim().isEmpty())
			category.setCategoryName(categoryDTO.getCategoryName());
		else
			throw new BusinessException("Category Name is missing.", BusinessException.BUSSINESS_TYP);
		category.setUpdatedBy(userInfo.getUserIndex());
		category.setUpdatedDate(new Date());
		entityManager.merge(category);
		return categoryDTO;
	}

	public UserInfo adminDoLogin(UserInfo userInfo) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		UserMaster userMaster = dao.getUserMaster(userInfo);
		if (userMaster != null && userMaster.getPassword().equals(userInfo.getPassword())) {
			userInfo.setUserIndex(userMaster.getUserIndex());
			userInfo.setUserName(userMaster.getFirstName() + " "
					+ (userMaster.getMiddleName() == null ? new String() : userMaster.getMiddleName()) + " "
					+ (userMaster.getLastName() == null ? new String() : userMaster.getLastName()));
			userInfo.setUserId(userMaster.getUserId());
			userInfo.setUserType(userMaster.getUserType() + "");

			// User Session
			UserSession userSession = new UserSession();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("sessionId", entityManager);
			userSession.setSessionId(Long.parseLong(nextKey));
			userSession.setIpAddress(userInfo.getIpAddress());
			userSession.setLastAccessDateTime(new Date());
			userSession.setLastLoginDateTime(new Date());
			entityManager.merge(userSession);
			userInfo.setSessionId(nextKey);
		} else {
			throw new BusinessException("common.msg.000001", BusinessException.BUSSINESS_TYP);
		}
		return userInfo;
	}

	@SuppressWarnings("unchecked")
	public CategoryDTO getAllCategories(UserInfo userInfo, String start) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		Map<Integer, Object> objectMap = dao.getAllCategory(userInfo, start);
		CategoryDTO categoryDTO = new CategoryDTO();
		if (objectMap != null && objectMap.containsKey(1) && objectMap.containsKey(2)) {
			List<Category> categories = (List<Category>) objectMap.get(1);
			if (categories != null && categories.size() > 0) {
				for (Category category : categories) {
					CategoryDTO dto = new CategoryDTO();
					dto.setCategoryId(category.getCategoryId() + "");
					dto.setCategoryName(category.getCategoryName());
					if (dto.getSubCategoryDTOs() == null)
						dto.setSubCategoryDTOs(new ArrayList<SubCategoryDTO>());
					List<SubCategory> subCategories = dao.getSubcategoryByCategory(userInfo, category.getCategoryId());
					if (subCategories != null && subCategories.size() > 0) {
						for (SubCategory subCategory : subCategories) {
							SubCategoryDTO sDto = new SubCategoryDTO();
							sDto.setSubCategoryId(subCategory.getSubCategoryPK().getSubCategoryId() + "");
							sDto.setSubCategoryName(subCategory.getSubCategoryName());
							dto.getSubCategoryDTOs().add(sDto);
						}
					}
					if (categoryDTO.getCategoryDTOs() == null)
						categoryDTO.setCategoryDTOs(new ArrayList<CategoryDTO>());
					categoryDTO.getCategoryDTOs().add(dto);
				}
				categoryDTO.setCount((BigInteger) objectMap.get(2) + "");
			}
		}
		return categoryDTO;
	}

	public SubCategoryDTO getSubCategoryByCategoryId(UserInfo userInfo, String categoryId) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<SubCategory> subCategories = dao.getSubcategoryByCategory(userInfo, IntUtil.getInteger(categoryId));
		SubCategoryDTO subCategoryDTO = new SubCategoryDTO();
		if (subCategories != null && subCategories.size() > 0) {
			for (SubCategory subCategory : subCategories) {
				SubCategoryDTO sDto = new SubCategoryDTO();
				sDto.setSubCategoryId(subCategory.getSubCategoryPK().getSubCategoryId() + "");
				sDto.setSubCategoryName(subCategory.getSubCategoryName());

				if (subCategoryDTO.getSubCategoryDTOs() == null)
					subCategoryDTO.setSubCategoryDTOs(new ArrayList<SubCategoryDTO>());
				subCategoryDTO.getSubCategoryDTOs().add(sDto);
			}
		}
		return subCategoryDTO;
	}

	public SubCategoryDTO saveSubCategory(UserInfo userInfo, SubCategoryDTO subCategoryDTO) throws BaseException {
		Integer subCategoryId = IntUtil.getInteger(subCategoryDTO.getSubCategoryId());
		if (loadDAO().isSubCategoryExist(subCategoryDTO, subCategoryId))
			throw new BusinessException("This Sub-Category already exist.", BusinessException.BUSSINESS_TYP);
		SubCategory subCategory = null;
		if (subCategoryId != null)
			subCategory = entityManager.find(SubCategory.class,
					new SubCategoryPK(subCategoryId, IntUtil.getInteger(subCategoryDTO.getCategoryId())));
		if (subCategory == null) {
			subCategory = new SubCategory();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("subCategoryId", entityManager);
			subCategory.setSubCategoryPK(
					new SubCategoryPK(IntUtil.getInteger(nextKey), IntUtil.getInteger(subCategoryDTO.getCategoryId())));
			subCategory.setCreatedBy(userInfo.getUserIndex());
			subCategory.setCreatedDate(new Date());
		}
		subCategory.setSubCategoryName(subCategoryDTO.getSubCategoryName());
		subCategory.setUpdatedBy(userInfo.getUserIndex());
		subCategory.setUpdatedDate(new Date());
		entityManager.merge(subCategory);
		return subCategoryDTO;
	}

	public NeighborhoodDTO saveNeighborhood(UserInfo userInfo, NeighborhoodDTO neighborhoodDTO) throws BaseException {
		Integer nId = IntUtil.getInteger(neighborhoodDTO.getNeighborhoodId());
		NeighborhoodMaster nMaster = null;
		if (nId != null)
			nMaster = entityManager.find(NeighborhoodMaster.class,
					new NeighborhoodMasterPK(IntUtil.getInteger(userInfo.getCityId()), nId));

		if (nMaster == null) {
			nMaster = new NeighborhoodMaster();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("neighborhoodId", entityManager);
			neighborhoodDTO.setNeighborhoodId(nextKey);
			nMaster.setNeighborhoodMasterPK(
					new NeighborhoodMasterPK(IntUtil.getInteger(userInfo.getCityId()), IntUtil.getInteger(nextKey)));
			nMaster.setCreatedBy(userInfo.getUserIndex());
			nMaster.setCreatedDate(new Date());
		}
		nMaster.setNeighborhoodName(neighborhoodDTO.getNeighborhoodName());
		nMaster.setUpdatedBy(userInfo.getUserIndex());
		nMaster.setUpdatedDate(new Date());
		entityManager.merge(nMaster);
		return neighborhoodDTO;
	}

	public NeighborhoodDTO getAllNeighborhoods(UserInfo userInfo) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<NeighborhoodMaster> neighborhoodMasters = dao.getNeighborhoodMasters(userInfo);
		NeighborhoodDTO neighborhoodDTO = new NeighborhoodDTO();
		if (neighborhoodMasters != null && neighborhoodMasters.size() > 0) {
			for (NeighborhoodMaster nMaster : neighborhoodMasters) {
				NeighborhoodDTO nDto = new NeighborhoodDTO();
				nDto.setNeighborhoodId(nMaster.getNeighborhoodMasterPK().getNeighborhoodId() + "");
				nDto.setNeighborhoodName(nMaster.getNeighborhoodName());

				if (neighborhoodDTO.getNeighborhoodDTOs() == null)
					neighborhoodDTO.setNeighborhoodDTOs(new ArrayList<NeighborhoodDTO>());
				neighborhoodDTO.getNeighborhoodDTOs().add(nDto);
			}
		}
		return neighborhoodDTO;
	}

	public String getCityText(String cityId) throws BaseException {
		Cities cities = entityManager.find(Cities.class, IntUtil.getInteger(cityId));

		return cities.getCityName();
	}

	public MerchantDTO getAllMerchantList(UserInfo userInfo) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<MerchantMaster> merchantMasters = dao.getAllMerchantList(userInfo);
		MerchantDTO merchantDTO = new MerchantDTO();
		if (merchantMasters != null && merchantMasters.size() > 0) {
			for (MerchantMaster mMaster : merchantMasters) {
				MerchantDTO dto = new MerchantDTO();
				dto.setMerchantId(mMaster.getMerchantId() + "");
				dto.setMerchantName(mMaster.getMerchantName());
				dto.setAddress1(mMaster.getAddress1());
				dto.setAddress2(mMaster.getAddress2());
				dto.setAddress3(mMaster.getAddress3());
				dto.setNeighborhoodName("");

				if (merchantDTO.getMerchantDTOs() == null)
					merchantDTO.setMerchantDTOs(new ArrayList<MerchantDTO>());
				merchantDTO.getMerchantDTOs().add(dto);
			}
		}
		return merchantDTO;
	}

	public SalesPersonDTO saveSalesPerson(UserInfo userInfo, SalesPersonDTO salesPersonDTO) throws BaseException {
		Integer spId = IntUtil.getInteger(salesPersonDTO.getSalesPersonId());
		SalesPerson salesPerson = null;
		if (spId != null)
			salesPerson = entityManager.find(SalesPerson.class, spId);

		if (salesPerson == null) {
			salesPerson = new SalesPerson();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("salesPersonId", entityManager);
			salesPerson.setSalesPersonId(IntUtil.getInteger(nextKey));
			salesPersonDTO.setSalesPersonId(nextKey);
			salesPerson.setCreatedBy(userInfo.getUserIndex());
			salesPerson.setCreatedDate(new Date());
		}
		salesPerson.setSalesPersonFirstName(salesPersonDTO.getSalesPersonFirstName());
		salesPerson.setSalesPersonLastName(salesPersonDTO.getSalesPersonLastName());
		salesPerson.setStatus(IntUtil.getInteger(salesPersonDTO.getStatus()));
		salesPerson.setUpdatedBy(userInfo.getUserIndex());
		salesPerson.setUpdatedDate(new Date());
		entityManager.merge(salesPerson);
		return salesPersonDTO;
	}

	public SalesPersonDTO getAllSalesPerson(UserInfo userInfo) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<SalesPerson> salesPersons = dao.getAllSalesPerson(userInfo);
		SalesPersonDTO salesPersonDTO = new SalesPersonDTO();
		if (salesPersons != null && salesPersons.size() > 0) {
			for (SalesPerson salesPerson : salesPersons) {
				SalesPersonDTO dto = new SalesPersonDTO();
				dto.setSalesPersonId(salesPerson.getSalesPersonId() + "");
				dto.setSalesPersonFirstName(salesPerson.getSalesPersonFirstName());
				dto.setSalesPersonLastName(salesPerson.getSalesPersonLastName());
				dto.setStatus(salesPerson.getStatus() == 1 ? "Active" : "InActive");

				if (salesPersonDTO.getSalesPersonDTOs() == null)
					salesPersonDTO.setSalesPersonDTOs(new ArrayList<SalesPersonDTO>());
				salesPersonDTO.getSalesPersonDTOs().add(dto);
			}
		}
		return salesPersonDTO;
	}

	public SalesPersonDTO getSalesPersonById(UserInfo userInfo, String spId) throws BaseException {
		Integer iId = IntUtil.getInteger(spId);
		SalesPersonDTO salesPersonDTO = null;
		if (iId != null) {
			SalesPerson salesPerson = entityManager.find(SalesPerson.class, iId);
			if (salesPerson != null) {
				salesPersonDTO = new SalesPersonDTO();
				salesPersonDTO.setSalesPersonId(salesPerson.getSalesPersonId() + "");
				salesPersonDTO.setSalesPersonFirstName(salesPerson.getSalesPersonFirstName());
				salesPersonDTO.setSalesPersonLastName(salesPerson.getSalesPersonLastName());
				salesPersonDTO.setStatus(salesPerson.getStatus() + "");
			} else {
				throw new BusinessException("Invald Operation.", BusinessException.BUSSINESS_TYP);
			}
		}
		return salesPersonDTO;
	}

	public CityDTO saveCityDetails(UserInfo userInfo, CityDTO cityDTO) throws BaseException {
		Integer iCityId = IntUtil.getInteger(cityDTO.getCityId());
		Cities cities = null;
		if (iCityId != null)
			cities = entityManager.find(Cities.class, iCityId);
		if (cities == null) {
			cities = new Cities();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("cityId", entityManager);
			cityDTO.setCityId(nextKey);
			cities.setCityId(IntUtil.getInteger(nextKey));
			cities.setCreatedBy(userInfo.getUserIndex());
			cities.setCreatedDate(new Date());
		}
		cities.setCityCode(cityDTO.getCityCode());
		cities.setCityName(cityDTO.getCityName());
		cities.setTimeZoneId(cityDTO.getTimeZoneId());
		cities.setUpdatedBy(userInfo.getUserIndex());
		cities.setUpdatedDate(new Date());

		entityManager.merge(cities);

		Integer iStateId = IntUtil.getInteger(cityDTO.getStateId());
		States states = null;
		if (iStateId != null && iCityId != null)
			states = entityManager.find(States.class, new StatesPK(iStateId, iCityId));
		if (states == null) {
			states = new States();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("stateId", entityManager);
			cityDTO.setStateId(nextKey);
			states.setStatesPK(new StatesPK(IntUtil.getInteger(nextKey), cities.getCityId()));
			states.setCreatedBy(userInfo.getUserIndex());
			states.setCreatedDate(new Date());
		}
		states.setStateName(cityDTO.getStateName());
		states.setUpdatedBy(userInfo.getUserIndex());
		states.setUpdatedDate(new Date());
		entityManager.merge(states);
		return cityDTO;
	}

	public CityDTO getAllCityDetails(UserInfo userInfo) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<Cities> cities = dao.getAllCityDetails();
		CityDTO cityDTO = new CityDTO();
		if (cities != null && cities.size() > 0) {
			for (Cities city : cities) {
				CityDTO dto = new CityDTO();
				dto.setCityId(city.getCityId() + "");
				dto.setCityName(city.getCityName());
				dto.setCityCode(city.getCityCode());
				States states = dao.getStateDetailsByCity(city.getCityId());
				dto.setStateId(states.getStatesPK().getStateId() + "");
				dto.setStateName(states.getStateName());
				dto.setTimeZoneId(city.getTimeZoneId());
				if (cityDTO.getCityDTOs() == null)
					cityDTO.setCityDTOs(new ArrayList<CityDTO>());
				cityDTO.getCityDTOs().add(dto);
			}
		}
		return cityDTO;
	}

	public CityDTO getCityDetailsById(String cityId, String stateId) throws BaseException {
		Integer iCityId = IntUtil.getInteger(cityId);
		Integer iStateId = IntUtil.getInteger(stateId);
		States states = null;
		CityDTO cityDTO = null;
		Cities cities = null;
		if (iStateId != null && iCityId != null) {
			cityDTO = new CityDTO();
			cities = entityManager.find(Cities.class, iCityId);
			states = entityManager.find(States.class, new StatesPK(iStateId, iCityId));

			cityDTO.setCityId(cities.getCityId() + "");
			cityDTO.setCityCode(cities.getCityCode());
			cityDTO.setCityName(cities.getCityName());
			cityDTO.setStateId(states.getStatesPK().getStateId() + "");
			cityDTO.setStateName(states.getStateName());
			cityDTO.setTimeZoneId(cities.getTimeZoneId());
		}
		return cityDTO;
	}

	public SubscriptionLevelDTO saveSubscriptionLevelDetails(UserInfo userInfo, SubscriptionLevelDTO levelDTO)
			throws BaseException {
		Integer iLevelId = IntUtil.getInteger(levelDTO.getLevelId());
		LevelMaster levelMaster = null;
		if (iLevelId != null)
			levelMaster = entityManager.find(LevelMaster.class, iLevelId);

		if (levelMaster == null) {
			levelMaster = new LevelMaster();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("levelId", entityManager);
			levelDTO.setLevelId(nextKey);
			levelMaster.setLevelId(IntUtil.getInteger(nextKey));
			levelMaster.setCreatedBy(userInfo.getUserIndex());
			levelMaster.setCreatedDate(new Date());
		}
		levelMaster.setLevelType(levelDTO.getLevelName());
		levelMaster.setQuarterPaymentPrice(levelDTO.getQuarterPaymentPrice());
		levelMaster.setLevelFullYearPrice(levelDTO.getLevelFullYearPrice());
		levelMaster.setUpdatedBy(userInfo.getUserIndex());
		levelMaster.setUpdatedDate(new Date());
		entityManager.merge(levelMaster);
		return levelDTO;
	}

	public SubscriptionLevelDTO getAllLevelDetails(UserInfo userInfo) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<LevelMaster> levelMasters = dao.getAllLevelDetails(userInfo);
		SubscriptionLevelDTO levelDTO = new SubscriptionLevelDTO();
		if (levelMasters != null && levelMasters.size() > 0) {
			for (LevelMaster lMaster : levelMasters) {
				SubscriptionLevelDTO dto = new SubscriptionLevelDTO();
				dto.setLevelId(lMaster.getLevelId() + "");
				dto.setLevelName(lMaster.getLevelType());
				dto.setLevelFullYearPrice(lMaster.getLevelFullYearPrice());
				dto.setQuarterPaymentPrice(lMaster.getQuarterPaymentPrice());

				if (levelDTO.getSubscriptionLevelDTOs() == null)
					levelDTO.setSubscriptionLevelDTOs(new ArrayList<SubscriptionLevelDTO>());
				levelDTO.getSubscriptionLevelDTOs().add(dto);
			}
		}
		return levelDTO;
	}

	public SubscriptionLevelDTO getLevelDetailsById(UserInfo userInfo, String levelId) throws BaseException {
		Integer iLevelId = IntUtil.getInteger(levelId);
		LevelMaster levelMaster = null;
		SubscriptionLevelDTO levelDTO = null;
		if (iLevelId != null) {
			levelDTO = new SubscriptionLevelDTO();
			levelMaster = entityManager.find(LevelMaster.class, iLevelId);
			levelDTO.setLevelId(levelMaster.getLevelId() + "");
			levelDTO.setLevelName(levelMaster.getLevelType());
			levelDTO.setQuarterPaymentPrice(levelMaster.getQuarterPaymentPrice());
			levelDTO.setLevelFullYearPrice(levelMaster.getLevelFullYearPrice());
		}
		return levelDTO;
	}

	public SocialConnectionsDTO saveSConnDetails(UserInfo userInfo, SocialConnectionsDTO connectionsDTO, String flag)
			throws BaseException {
		Integer iConnId = IntUtil.getInteger(connectionsDTO.getConnectionId());
		AdminSocialLink socialLink = null;
		if (iConnId != null)
			socialLink = entityManager.find(AdminSocialLink.class,
					new AdminSocialLinkPK(userInfo.getUserIndex(), iConnId));
		if (socialLink == null) {
			socialLink = new AdminSocialLink();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("adminSConnId", entityManager);
			connectionsDTO.setConnectionId(nextKey);
			socialLink
					.setAdminSocialLinkPK(new AdminSocialLinkPK(userInfo.getUserIndex(), IntUtil.getInteger(nextKey)));
			connectionsDTO.setConnectionId(nextKey);
			socialLink.setCreatedBy(userInfo.getUserIndex());
			socialLink.setCreatedDate(new Date());
		}
		if (flag.equals("1")) {
			socialLink.setFbFanPage(connectionsDTO.getFacebookFanPage());
			socialLink.setTwitterAcc(connectionsDTO.getTwitterAccount());
		}
		if (flag.equals("2")) {
			socialLink.setConsumerKey(connectionsDTO.getConsumerKey());
			socialLink.setConsumerSecret(connectionsDTO.getConsumerSecret());
			socialLink.setoAuthSecret(connectionsDTO.getoAuthSecret());
			socialLink.setoAuthToken(connectionsDTO.getoAuthToken());
		}
		socialLink.setUpdatedBy(userInfo.getUserIndex());
		socialLink.setUpdatedDate(new Date());
		entityManager.merge(socialLink);
		return connectionsDTO;
	}

	public SocialConnectionsDTO getAdminSConnDetails(UserInfo userInfo) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		AdminSocialLink adminSocialLink = dao.getAdminSocialLink(userInfo);
		SocialConnectionsDTO connectionsDTO = null;
		if (adminSocialLink != null) {
			connectionsDTO = new SocialConnectionsDTO();
			connectionsDTO.setConnectionId(adminSocialLink.getAdminSocialLinkPK().getLinkId() + "");
			connectionsDTO.setFacebookFanPage(adminSocialLink.getFbFanPage());
			connectionsDTO.setTwitterAccount(adminSocialLink.getTwitterAcc());
			connectionsDTO.setConsumerKey(adminSocialLink.getConsumerKey());
			connectionsDTO.setConsumerSecret(adminSocialLink.getConsumerSecret());
			connectionsDTO.setoAuthSecret(adminSocialLink.getoAuthSecret());
			connectionsDTO.setoAuthToken(adminSocialLink.getoAuthToken());
			AdminFBAccessToken fb = entityManager.find(AdminFBAccessToken.class,
					adminSocialLink.getAdminSocialLinkPK().getLinkId());
			if (fb != null)
				connectionsDTO.setFbPostDealzTo(fb.getName());
			AdminTwitterOAuth twitterOth = entityManager.find(AdminTwitterOAuth.class,
					adminSocialLink.getAdminSocialLinkPK().getLinkId());
			if (twitterOth != null)
				connectionsDTO.setTwitterScreenName(twitterOth.getScreenName());
		}
		return connectionsDTO;
	}

	public IconsDTO saveIconsDetails(UserInfo userInfo, IconsDTO iconsDTO) throws BaseException {
		Integer iconId = IntUtil.getInteger(iconsDTO.getIconId());
		AccessibiltyIcons icons = null;
		if (iconId != null)
			icons = entityManager.find(AccessibiltyIcons.class, iconId);
		if (icons == null) {
			icons = new AccessibiltyIcons();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("iconId", entityManager);
			iconsDTO.setIconId(nextKey);
			icons.setIconId(IntUtil.getInteger(nextKey));
			icons.setCreatedBy(userInfo.getUserIndex());
			icons.setCreatedDate(new Date());
		}
		icons.setIconName(iconsDTO.getIconName());
		icons.setIconUrl(iconsDTO.getIconUrl());
		icons.setUpdatedBy(userInfo.getUserIndex());
		icons.setUpdatedDate(new Date());
		entityManager.merge(icons);
		return iconsDTO;
	}

	public IconsDTO getAllIconsDetails(UserInfo userInfo) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<AccessibiltyIcons> levelMasters = dao.getAllIconsDetails(userInfo);
		IconsDTO iconsDTO = new IconsDTO();
		if (levelMasters != null && levelMasters.size() > 0) {
			for (AccessibiltyIcons icon : levelMasters) {
				IconsDTO dto = new IconsDTO();
				dto.setIconId(icon.getIconId() + "");
				dto.setIconName(icon.getIconName());
				dto.setIconUrl(icon.getIconUrl());
				dto.setImagePath(loadDAO().getLogoInfo(icon.getIconId(), 11));
				if (iconsDTO.getIconsDTOs() == null)
					iconsDTO.setIconsDTOs(new ArrayList<IconsDTO>());
				iconsDTO.getIconsDTOs().add(dto);
			}
		}
		return iconsDTO;
	}

	public IconsDTO getIconsDetailsById(UserInfo userInfo, String iconIds) throws BaseException {
		Integer iconId = IntUtil.getInteger(iconIds);
		IconsDTO iconsDTO = null;
		AccessibiltyIcons icons = null;
		if (iconId != null) {
			icons = entityManager.find(AccessibiltyIcons.class, iconId);
			iconsDTO = new IconsDTO();
			iconsDTO.setIconId(icons.getIconId() + "");
			iconsDTO.setIconName(icons.getIconName());
			iconsDTO.setIconUrl(loadDAO().getFileName(icons.getIconId(), 11));
			iconsDTO.setImagePath(loadDAO().getLogoInfo(icons.getIconId(), 11));
		}
		return iconsDTO;
	}

	@SuppressWarnings("unchecked")
	public DealzDTO getAllDealzs(UserInfo userInfo, String dealType, String start) throws BaseException {
		DealzDTO retDto = new DealzDTO();
		try {
			Map<Integer, Object> retMap = loadDAO().getAllDealzs(userInfo, dealType, start);
			if (retMap != null && retMap.containsKey(1) && retMap.containsKey(2)) {
				List<MerchantDealz> merchantDealzs = (List<MerchantDealz>) retMap.get(1);
				if (merchantDealzs != null && merchantDealzs.size() > 0) {
					for (MerchantDealz dealz : merchantDealzs) {
						DealzDTO dealzDTO = new DealzDTO();
						MerchantMaster mMaster = entityManager.find(MerchantMaster.class,
								dealz.getMerchantDealzPK().getMerchantId());
						dealzDTO.setMerchantId(mMaster.getMerchantId() + "");
						dealzDTO.setMerchantName(mMaster.getMerchantName());
						dealzDTO.setDealType(dealz.getDealType() + "");
						dealzDTO.setDealId(IntUtil.getString(dealz.getMerchantDealzPK().getDealzId()));
						dealzDTO.setCurrentRating(
								loadDAO().getCurrentRatingOfDealz(dealz.getMerchantDealzPK().getDealzId()) + "");
						String status = "";
						if (dealType.equals("2")) {
							if (dealz.getPayed() == 1 && dealz.getStartDate() != null
									&& dealz.getStartDate().compareTo(new Date()) > 0)
								status = "Pending";
							else if (dealz.getPayed() == 1 && dealz.getEndDate() != null
									&& dealz.getEndDate().compareTo(new Date()) < 0)
								status = "Expired";
							else if (dealz.getPayed() == 0)
								status = "Payment Pending";
							else
								status = "Active";
						} else {
							status = "Active";
							if (dealz.getStartDate() != null && dealz.getStartDate().compareTo(new Date()) > 0)
								status = "Pending";
							if (dealz.getEndDate() != null && dealz.getEndDate().compareTo(new Date()) < 0)
								status = "Expired";
						}
						dealzDTO.setStatusText(status);
						dealzDTO.setTitle(dealz.getTitle());
						dealzDTO.setDealCode(dealz.getCode());
						dealzDTO.setStartDate(
								DateUtil.parseDateToString(dealz.getStartDate(), userInfo.getDateTimeFormat()));
						dealzDTO.setEndDate(
								DateUtil.parseDateToString(dealz.getEndDate(), userInfo.getDateTimeFormat()));
						dealzDTO.setRestriction(dealz.getRestrictions());
						dealzDTO.setDescription(dealz.getDescription());
						dealzDTO.setCreateDateText(
								DateUtil.parseDateToString(dealz.getUpdatedDate(), userInfo.getDateFormat()));
						if (retDto.getDealzDTOs() == null)
							retDto.setDealzDTOs(new ArrayList<DealzDTO>());
						retDto.getDealzDTOs().add(dealzDTO);
					}
					retDto.setCounts((BigInteger) retMap.get(2) + "");
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	public DealzDTO deleteDealById(UserInfo userInfo, DealzDTO dealzDTO) throws BaseException {
		Integer dealId = IntUtil.getInteger(dealzDTO.getDealId());
		Integer merchantId = IntUtil.getInteger(dealzDTO.getMerchantId());
		MerchantDealz merchantDealz = null;
		if (dealId != null && merchantId != null) {
			merchantDealz = loadDAO().getMerchantDealzById(userInfo, dealId);
			entityManager.remove(merchantDealz);
		}
		return dealzDTO;
	}

	public Map<String, String> getCategoryMapByMerchant(UserInfo userInfo, String merchantId) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		Map<String, String> retMap = null;
		try {
			retMap = dao.getCategoryMapByMerchant(userInfo, merchantId);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	public Map<String, String> getSubCategoryMapByMerchant(UserInfo userInfo, String merchantId) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		Map<String, String> retMap = null;
		try {
			retMap = dao.getSubCategoryMapByMerchant(userInfo, merchantId);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	public NeighborhoodDTO getNeighborhoodsAndCountDealz(UserInfo userInfo) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		NeighborhoodDTO retDto = new NeighborhoodDTO();
		try {
			List<Object[]> nMasterObjects = dao.getNeighborhoodsAndCountDealz(userInfo);
			if (nMasterObjects != null && nMasterObjects.size() > 0) {
				Iterator<?> itr = nMasterObjects.iterator();
				while (itr.hasNext()) {
					Object[] o = (Object[]) itr.next();
					NeighborhoodDTO dto = new NeighborhoodDTO();
					dto.setNeighborhoodId(o[0] + "");
					dto.setNeighborhoodName((String) o[1]);
					dto.setCount(((BigInteger) o[2]).toString());
					if (retDto.getNeighborhoodDTOs() == null)
						retDto.setNeighborhoodDTOs(new ArrayList<NeighborhoodDTO>());
					retDto.getNeighborhoodDTOs().add(dto);
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retDto;
	}

	public List<DealzDTO> getAllDealzByNeighborhoodId(UserInfo userInfo, String neighborhoodId) throws BaseException {
		List<DealzDTO> retDealzDTOs = null;
		try {
			List<MerchantDealz> merchantDealzs = loadDAO().getAllDealzByNeighborhoodId(userInfo, neighborhoodId);
			if (merchantDealzs != null && merchantDealzs.size() > 0) {
				for (MerchantDealz dealz : merchantDealzs) {
					DealzDTO dealzDTO = new DealzDTO();
					if (dealz == null)
						continue;
					if (dealz.getUseLogo() != null && dealz.getUseLogo() == 1) {
						dealzDTO.setImagePath(loadDAO().getLogoInfo(dealz.getMerchantDealzPK().getMerchantId(), 2));
					} else {
						String fileName = (String) loadDAO().getDocument(dealz.getMerchantDealzPK().getDealzId() + "");
						if (fileName != null)
							dealzDTO.setImagePath(fileName);
					}

					SocialConnections connections = loadDAO()
							.getSocialConnectionsByMerchantId(dealz.getMerchantDealzPK().getMerchantId());
					if (connections != null) {
						SocialConnectionsDTO conDTO = setSocialConnectionDtos(connections);
						if (dealzDTO.getSocialConnectionsDTO() == null)
							dealzDTO.setSocialConnectionsDTO(conDTO);
						conDTO = null;
					} else {
						dealzDTO.setSocialConnectionsDTO(new SocialConnectionsDTO());
					}

					MerchantMaster mMaster = entityManager.find(MerchantMaster.class,
							dealz.getMerchantDealzPK().getMerchantId());
					dealzDTO.setUrlTitle(dealz.getTitle().replaceAll("[^a-zA-Z0-9]", "-"));
					dealzDTO.setMerchantId(mMaster.getMerchantId() + "");
					// dealzDTO.setUrlMerchantName(mMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]",
					// "-"));
					dealzDTO.setUrlMerchantName(mMaster.getMerchantUrl());
					dealzDTO.setMerchantName(mMaster.getMerchantName());
					dealzDTO.setDealType(dealz.getDealType() + "");
					dealzDTO.setDealId(IntUtil.getString(dealz.getMerchantDealzPK().getDealzId()));
					dealzDTO.setCurrentRating(
							loadDAO().getCurrentRatingOfDealz(dealz.getMerchantDealzPK().getDealzId()) + "");
					dealzDTO.setTitle(dealz.getTitle());
					dealzDTO.setDealCode(dealz.getCode());
					dealzDTO.setStartDate(DateUtil.parseDateToString(dealz.getStartDate(), userInfo.getDateFormat()));
					dealzDTO.setEndDate(DateUtil.parseDateToString(dealz.getEndDate(), userInfo.getDateFormat()));
					dealzDTO.setRestriction(dealz.getRestrictions());
					dealzDTO.setDescription(dealz.getDescription());
					dealzDTO.setCreateDateText(
							DateUtil.parseDateToString(dealz.getUpdatedDate(), userInfo.getDateFormat()));

					Cities cities = entityManager.find(Cities.class, dealz.getMerchantDealzPK().getCitySectionId());
					dealzDTO.setCityName(cities.getCityCode());

					dealzDTO.setFbSortUrl(dealz.getFbSortUrl());
					dealzDTO.setTwitSortUrl(dealz.getTwitSortUrl());
					dealzDTO.setPinSortUrl(dealz.getPinSortUrl());
					dealzDTO.setLinkSortUrl(dealz.getLinkSortUrl());
					dealzDTO.setgPSortUrl(dealz.getgPSortUrl());
					if (retDealzDTOs == null)
						retDealzDTOs = new ArrayList<DealzDTO>();
					retDealzDTOs.add(dealzDTO);
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		}
		return retDealzDTOs;
	}

	public NeighborhoodDTO getNeighborhoodsName(UserInfo userInfo, String neighborhoodId) throws BaseException {
		NeighborhoodMaster nMaster = loadDAO().getNeighborhoodsName(userInfo, neighborhoodId);
		NeighborhoodDTO dto = null;
		if (nMaster != null) {
			dto = new NeighborhoodDTO();
			dto.setNeighborhoodName(nMaster.getNeighborhoodName());
			Cities cities = entityManager.find(Cities.class, nMaster.getNeighborhoodMasterPK().getCityId());
			dto.setCityName(cities.getCityName());
			dto.setCityCode(cities.getCityCode());
		}
		return dto;
	}

	public DealzDTO getAllDealsByMasterCategory(UserInfo userInfo, String masterCategory) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		DealzDTO retDealzDTOs = new DealzDTO();
		try {
			List<MerchantDealz> merchantDealzs = dao.getAllDealsByMasterCategory(userInfo, masterCategory);
			if (merchantDealzs != null && merchantDealzs.size() > 0) {
				for (MerchantDealz dealz : merchantDealzs) {
					if (dealz == null)
						continue;
					DealzDTO dealzDTO = new DealzDTO();
					if (dealz.getUseLogo() != null && dealz.getUseLogo() == 1) {
						dealzDTO.setImagePath(loadDAO().getLogoInfo(dealz.getMerchantDealzPK().getMerchantId(), 2));
					} else {
						String fileName = (String) loadDAO().getDocument(dealz.getMerchantDealzPK().getDealzId() + "");
						if (fileName != null)
							dealzDTO.setImagePath(fileName);
					}

					SocialConnections connections = loadDAO()
							.getSocialConnectionsByMerchantId(dealz.getMerchantDealzPK().getMerchantId());
					if (connections != null) {
						SocialConnectionsDTO conDTO = setSocialConnectionDtos(connections);
						if (dealzDTO.getSocialConnectionsDTO() == null)
							dealzDTO.setSocialConnectionsDTO(conDTO);
						conDTO = null;
					} else {
						dealzDTO.setSocialConnectionsDTO(new SocialConnectionsDTO());
					}

					MerchantMaster mMaster = entityManager.find(MerchantMaster.class,
							dealz.getMerchantDealzPK().getMerchantId());
					dealzDTO.setUrlTitle(dealz.getTitle().replaceAll("[^a-zA-Z0-9]", "-"));
					dealzDTO.setMerchantId(mMaster.getMerchantId() + "");
					// dealzDTO.setUrlMerchantName(mMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]",
					// "-"));
					dealzDTO.setUrlMerchantName(mMaster.getMerchantUrl());
					dealzDTO.setMerchantName(mMaster.getMerchantName());
					dealzDTO.setDealType(dealz.getDealType() + "");
					dealzDTO.setDealId(IntUtil.getString(dealz.getMerchantDealzPK().getDealzId()));
					dealzDTO.setCurrentRating(
							loadDAO().getCurrentRatingOfDealz(dealz.getMerchantDealzPK().getDealzId()) + "");
					dealzDTO.setTitle(dealz.getTitle());
					dealzDTO.setDealCode(dealz.getCode());
					dealzDTO.setStartDate(DateUtil.parseDateToString(dealz.getStartDate(), userInfo.getDateFormat()));
					dealzDTO.setEndDate(DateUtil.parseDateToString(dealz.getEndDate(), userInfo.getDateFormat()));
					dealzDTO.setRestriction(dealz.getRestrictions());
					dealzDTO.setDescription(dealz.getDescription());
					dealzDTO.setCreateDateText(
							DateUtil.parseDateToString(dealz.getUpdatedDate(), userInfo.getDateFormat()));

					Cities cities = entityManager.find(Cities.class, dealz.getMerchantDealzPK().getCitySectionId());
					dealzDTO.setCityName(cities.getCityCode());

					dealzDTO.setFbSortUrl(dealz.getFbSortUrl());
					dealzDTO.setTwitSortUrl(dealz.getTwitSortUrl());
					dealzDTO.setPinSortUrl(dealz.getPinSortUrl());
					dealzDTO.setLinkSortUrl(dealz.getLinkSortUrl());
					dealzDTO.setgPSortUrl(dealz.getgPSortUrl());
					if (retDealzDTOs.getDealzDTOs() == null)
						retDealzDTOs.setDealzDTOs(new ArrayList<DealzDTO>());
					retDealzDTOs.getDealzDTOs().add(dealzDTO);
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		}
		return retDealzDTOs;
	}

	public MerchantDTO deactivateMerchant(UserInfo userInfo, String merchantId) throws BaseException {
		Integer iMerchantId = IntUtil.getInteger(merchantId);
		MerchantMaster merchantMaster = null;
		MerchantDTO merchantDTO = null;
		if (iMerchantId != null) {
			merchantMaster = entityManager.find(MerchantMaster.class, iMerchantId);
			merchantDTO = new MerchantDTO();
			merchantMaster.setStatus(0);
			merchantMaster.setDeactivateDate(new Date());
			merchantMaster.setUpdatedBy(userInfo.getUserIndex());
			merchantMaster.setUpdatedDate(new Date());
			merchantDTO.setStatus("0");
			merchantDTO.setDeactivateDate(DateUtil.parseDateToString(new Date(), userInfo.getDateFormat()));
			entityManager.merge(merchantMaster);
		}

		return merchantDTO;
	}

	public CategoryDTO getAllCategoriesOnly(UserInfo userInfo) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<Object[]> categories = dao.getAllCategoryAndCountDealz(userInfo);

		CategoryDTO categoryDTO = new CategoryDTO();
		if (categories != null) {
			Iterator<?> itr = categories.iterator();
			while (itr.hasNext()) {
				Object[] o = (Object[]) itr.next();
				CategoryDTO dto = new CategoryDTO();
				dto.setCategoryId(o[0] + "");
				dto.setCategoryName((String) o[1]);
				dto.setCounts(((BigInteger) o[2]).toString());
				if (categoryDTO.getCategoryDTOs() == null)
					categoryDTO.setCategoryDTOs(new ArrayList<CategoryDTO>());
				categoryDTO.getCategoryDTOs().add(dto);
			}
		}
		return categoryDTO;
	}

	public List<DealzDTO> getAllDelsByCategoryAndSubCategoryId(UserInfo userInfo, String categoryId,
			String subcategoryId) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<DealzDTO> retList = null;
		try {
			List<MerchantDealz> merchantDealzs = dao.getAllDelsByCategoryAndSubCategoryId(userInfo, categoryId,
					subcategoryId);
			if (merchantDealzs != null && merchantDealzs.size() > 0) {
				for (MerchantDealz dealz : merchantDealzs) {
					if (dealz == null)
						continue;
					DealzDTO dealzDTO = new DealzDTO();
					if (dealz.getUseLogo() != null && dealz.getUseLogo() == 1) {
						dealzDTO.setImagePath(loadDAO().getLogoInfo(dealz.getMerchantDealzPK().getMerchantId(), 2));
					} else {
						String fileName = (String) loadDAO().getDocument(dealz.getMerchantDealzPK().getDealzId() + "");
						if (fileName != null)
							dealzDTO.setImagePath(fileName);
					}

					SocialConnections connections = loadDAO()
							.getSocialConnectionsByMerchantId(dealz.getMerchantDealzPK().getMerchantId());
					if (connections != null) {
						SocialConnectionsDTO conDTO = setSocialConnectionDtos(connections);
						if (dealzDTO.getSocialConnectionsDTO() == null)
							dealzDTO.setSocialConnectionsDTO(conDTO);
						conDTO = null;
					} else {
						dealzDTO.setSocialConnectionsDTO(new SocialConnectionsDTO());
					}

					MerchantMaster mMaster = entityManager.find(MerchantMaster.class,
							dealz.getMerchantDealzPK().getMerchantId());
					dealzDTO.setUrlTitle(dealz.getTitle().replaceAll("[^a-zA-Z0-9]", "-"));
					// dealzDTO.setUrlTitle(dealz.getTitle().replaceAll("[^a-zA-Z0-9]",
					// "-"));
					dealzDTO.setMerchantId(mMaster.getMerchantId() + "");
					dealzDTO.setMerchantName(mMaster.getMerchantName());
					// dealzDTO.setUrlMerchantName(mMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]",
					// "-"));
					dealzDTO.setUrlMerchantName(mMaster.getMerchantUrl());
					dealzDTO.setDealType(dealz.getDealType() + "");
					dealzDTO.setDealId(IntUtil.getString(dealz.getMerchantDealzPK().getDealzId()));
					dealzDTO.setCurrentRating(
							loadDAO().getCurrentRatingOfDealz(dealz.getMerchantDealzPK().getDealzId()) + "");
					dealzDTO.setTitle(dealz.getTitle());
					dealzDTO.setDealCode(dealz.getCode());
					dealzDTO.setStartDate(DateUtil.parseDateToString(dealz.getStartDate(), userInfo.getDateFormat()));
					dealzDTO.setEndDate(DateUtil.parseDateToString(dealz.getEndDate(), userInfo.getDateFormat()));
					dealzDTO.setRestriction(dealz.getRestrictions());
					dealzDTO.setDescription(dealz.getDescription());
					dealzDTO.setCreateDateText(
							DateUtil.parseDateToString(dealz.getUpdatedDate(), userInfo.getDateFormat()));

					Cities cities = entityManager.find(Cities.class, dealz.getMerchantDealzPK().getCitySectionId());
					dealzDTO.setCityName(cities.getCityCode());

					dealzDTO.setFbSortUrl(dealz.getFbSortUrl());
					dealzDTO.setTwitSortUrl(dealz.getTwitSortUrl());
					dealzDTO.setPinSortUrl(dealz.getPinSortUrl());
					dealzDTO.setLinkSortUrl(dealz.getLinkSortUrl());
					dealzDTO.setgPSortUrl(dealz.getgPSortUrl());
					if (retList == null)
						retList = new ArrayList<DealzDTO>();
					retList.add(dealzDTO);
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		}
		return retList;
	}

	public List<DealzDTO> getAllDealzByCategoryId(UserInfo userInfo, String categoryId) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<DealzDTO> retList = null;
		try {
			List<MerchantDealz> merchantDealzs = dao.getAllDealzByCategoryId(userInfo, categoryId);
			if (merchantDealzs != null && merchantDealzs.size() > 0) {
				for (MerchantDealz dealz : merchantDealzs) {
					DealzDTO dealzDTO = new DealzDTO();
					if (dealz == null)
						continue;
					if (dealz.getUseLogo() != null && dealz.getUseLogo() == 1) {
						dealzDTO.setImagePath(loadDAO().getLogoInfo(dealz.getMerchantDealzPK().getMerchantId(), 2));
					} else {
						String fileName = (String) loadDAO().getDocument(dealz.getMerchantDealzPK().getDealzId() + "");
						if (fileName != null)
							dealzDTO.setImagePath(fileName);
					}

					SocialConnections connections = loadDAO()
							.getSocialConnectionsByMerchantId(dealz.getMerchantDealzPK().getMerchantId());
					if (connections != null) {
						SocialConnectionsDTO conDTO = setSocialConnectionDtos(connections);
						if (dealzDTO.getSocialConnectionsDTO() == null)
							dealzDTO.setSocialConnectionsDTO(conDTO);
						conDTO = null;
					} else {
						dealzDTO.setSocialConnectionsDTO(new SocialConnectionsDTO());
					}

					MerchantMaster mMaster = entityManager.find(MerchantMaster.class,
							dealz.getMerchantDealzPK().getMerchantId());
					dealzDTO.setUrlTitle(dealz.getTitle().replaceAll("[^a-zA-Z0-9]", "-"));
					dealzDTO.setMerchantId(mMaster.getMerchantId() + "");
					dealzDTO.setMerchantName(mMaster.getMerchantName());
					// dealzDTO.setUrlMerchantName(mMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]",
					// "-"));
					dealzDTO.setUrlMerchantName(mMaster.getMerchantUrl());
					dealzDTO.setDealType(dealz.getDealType() + "");
					dealzDTO.setDealId(IntUtil.getString(dealz.getMerchantDealzPK().getDealzId()));
					dealzDTO.setCurrentRating(
							loadDAO().getCurrentRatingOfDealz(dealz.getMerchantDealzPK().getDealzId()) + "");
					dealzDTO.setTitle(dealz.getTitle());
					dealzDTO.setDealCode(dealz.getCode());
					dealzDTO.setStartDate(DateUtil.parseDateToString(dealz.getStartDate(), userInfo.getDateFormat()));
					dealzDTO.setEndDate(DateUtil.parseDateToString(dealz.getEndDate(), userInfo.getDateFormat()));
					dealzDTO.setRestriction(dealz.getRestrictions());
					dealzDTO.setDescription(dealz.getDescription());
					dealzDTO.setCreateDateText(
							DateUtil.parseDateToString(dealz.getUpdatedDate(), userInfo.getDateFormat()));

					Cities cities = entityManager.find(Cities.class, dealz.getMerchantDealzPK().getCitySectionId());
					dealzDTO.setCityName(cities.getCityCode());
					dealzDTO.setFbSortUrl(dealz.getFbSortUrl());
					dealzDTO.setTwitSortUrl(dealz.getTwitSortUrl());
					dealzDTO.setPinSortUrl(dealz.getPinSortUrl());
					dealzDTO.setLinkSortUrl(dealz.getLinkSortUrl());
					dealzDTO.setgPSortUrl(dealz.getgPSortUrl());
					if (retList == null)
						retList = new ArrayList<DealzDTO>();
					retList.add(dealzDTO);
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		}
		return retList;
	}

	public MerchantDTO getMerchantListInRange(UserInfo userInfo, String range, Integer flag) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<MerchantMaster> merchantMasters = dao.getMerchantListInRange(userInfo, range, flag);
		MerchantDTO merchantDTO = null;
		if (merchantMasters != null && merchantMasters.size() > 0) {
			merchantDTO = new MerchantDTO();
			for (MerchantMaster mMaster : merchantMasters) {
				MerchantDTO dto = new MerchantDTO();
				dto.setMerchantId(mMaster.getMerchantId() + "");
				dto.setMerchantName(mMaster.getMerchantName());
				// dto.setUrlMerchant(mMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]",
				// "-"));

				Cities cities = entityManager.find(Cities.class, mMaster.getCity());
				dto.setCityText(cities.getCityCode());
				dto.setUrlMerchant(mMaster.getMerchantUrl());

				if (merchantDTO.getMerchantDTOs() == null)
					merchantDTO.setMerchantDTOs(new ArrayList<MerchantDTO>());
				merchantDTO.getMerchantDTOs().add(dto);
			}
		}
		return merchantDTO;
	}

	public List<DealzDTO> getDealzByMerchantId(UserInfo userInfo, String merchantId, Integer start, Integer count)
			throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<DealzDTO> retList = null;
		try {
			List<MerchantDealz> merchantDealzs = dao.getDealzByMerchantId(userInfo, merchantId, start, count);
			if (merchantDealzs != null && merchantDealzs.size() > 0) {
				for (MerchantDealz dealz : merchantDealzs) {
					DealzDTO dealzDTO = new DealzDTO();
					if (dealz == null)
						continue;
					if (dealz.getUseLogo() != null && dealz.getUseLogo() == 1) {
						dealzDTO.setImagePath(loadDAO().getLogoInfo(dealz.getMerchantDealzPK().getMerchantId(), 2));
					} else {
						String fileName = (String) loadDAO().getDocument(dealz.getMerchantDealzPK().getDealzId() + "");
						if (fileName != null)
							dealzDTO.setImagePath(fileName);
					}

					MerchantMaster mMaster = entityManager.find(MerchantMaster.class,
							dealz.getMerchantDealzPK().getMerchantId());
					dealzDTO.setUrlTitle(dealz.getTitle().replaceAll("[^a-zA-Z0-9]", "-"));
					dealzDTO.setMerchantId(mMaster.getMerchantId() + "");
					dealzDTO.setMerchantName(mMaster.getMerchantName());
					// dealzDTO.setUrlMerchantName(mMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]",
					// "-"));
					dealzDTO.setUrlMerchantName(mMaster.getMerchantUrl());
					dealzDTO.setDealType(dealz.getDealType() + "");
					dealzDTO.setDealId(IntUtil.getString(dealz.getMerchantDealzPK().getDealzId()));
					dealzDTO.setCurrentRating(
							loadDAO().getCurrentRatingOfDealz(dealz.getMerchantDealzPK().getDealzId()) + "");
					dealzDTO.setTitle(dealz.getTitle());
					dealzDTO.setDealCode(dealz.getCode());
					dealzDTO.setStartDate(DateUtil.parseDateToString(dealz.getStartDate(), userInfo.getDateFormat()));
					dealzDTO.setEndDate(DateUtil.parseDateToString(dealz.getEndDate(), userInfo.getDateFormat()));
					dealzDTO.setRestriction(dealz.getRestrictions());
					dealzDTO.setDescription(dealz.getDescription());
					dealzDTO.setCreateDateText(
							DateUtil.parseDateToString(dealz.getUpdatedDate(), userInfo.getDateFormat()));

					dealzDTO.setFbSortUrl(dealz.getFbSortUrl());
					dealzDTO.setTwitSortUrl(dealz.getTwitSortUrl());
					dealzDTO.setPinSortUrl(dealz.getPinSortUrl());
					dealzDTO.setLinkSortUrl(dealz.getLinkSortUrl());
					dealzDTO.setgPSortUrl(dealz.getgPSortUrl());

					Cities cities = entityManager.find(Cities.class, dealz.getMerchantDealzPK().getCitySectionId());
					dealzDTO.setCityName(cities.getCityCode());

					if (retList == null)
						retList = new ArrayList<DealzDTO>();
					retList.add(dealzDTO);
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		}
		return retList;
	}

	public List<DealzDTO> getAllDealzWithMerchantInfo(UserInfo userInfo) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<DealzDTO> retDealzDTOs = null;
		try {

			List<MerchantMaster> merchantMasters = dao.getAllMerchantList(userInfo);
			if (merchantMasters != null && merchantMasters.size() > 0) {
				for (MerchantMaster mMaster : merchantMasters) {
					MerchantDealz dealz = dao.getLatestMerchantDealzById(userInfo, mMaster.getMerchantId());
					if (dealz != null) {
						DealzDTO dealzDTO = new DealzDTO();
						dealzDTO.setImagePath(loadDAO().getLogoInfo(dealz.getMerchantDealzPK().getMerchantId(), 2));
						MerchantDTO dto = new MerchantDTO();

						dto.setLogoImagePath(loadDAO().getLogoInfo(dealz.getMerchantDealzPK().getMerchantId(), 2));

						dto.setMerchantName(mMaster.getMerchantName());
						dto.setAddress1(mMaster.getAddress1());
						dto.setAddress2(mMaster.getAddress2());
						dto.setAddress3(mMaster.getAddress3());
						dto.setEmailId(mMaster.getEmailId());
						dto.setWebsiteUrl(mMaster.getWebsiteUrl());
						dto.setCity(IntUtil.getString(mMaster.getCity()));
						Cities cities = entityManager.find(Cities.class, mMaster.getCity());
						if (cities != null)
							dto.setCityText(cities.getCityName());
						dto.setZipCode(mMaster.getZip());

						MerchantDealz mDealz = loadDAO().getMyLatestDeal(mMaster.getMerchantId());
						dto.setLatestDealId(mDealz.getMerchantDealzPK().getDealzId() + "");
						dto.setLatestDealTitle(mDealz.getTitle().replaceAll("[^a-zA-Z0-9]", "-"));
						dto.setUrlTitle(dealz.getTitle().replaceAll("[^a-zA-Z0-9]", "-"));
						dealzDTO.setMerchantDTOs(dto);
						dealzDTO.setMerchantName(dto.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-"));
						dealzDTO.setUrlMerchantName(mMaster.getMerchantUrl());
						dealzDTO.setUrlTitle(dealz.getTitle().replaceAll("[^a-zA-Z0-9]", "-"));
						dealzDTO.setDealId(IntUtil.getString(dealz.getMerchantDealzPK().getDealzId()));
						dealzDTO.setTitle(dealz.getTitle());
						dealzDTO.setLatitude(dealz.getLatitude());
						dealzDTO.setLongitude(dealz.getLongitude());
						userInfo = new UserInfo();
						userInfo.setUserIndex(mMaster.getMerchantId());
						LocationDTO locationDTO = getAdditionLocationByMerchant(userInfo);
						if (locationDTO != null && locationDTO.getLocationDTOs() != null
								&& locationDTO.getLocationDTOs().size() > 0) {
							if (dealzDTO.getLocationDTOs() == null)
								dealzDTO.setLocationDTOs(new ArrayList<LocationDTO>());
							dealzDTO.getLocationDTOs().add(locationDTO);
						}
						if (retDealzDTOs == null)
							retDealzDTOs = new ArrayList<DealzDTO>();
						retDealzDTOs.add(dealzDTO);
					}
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (BaseException e) {
			e.printStackTrace();
			throw e;
		}
		return retDealzDTOs;
	}

	public LocationDTO getAdditionLocationByMerchant(UserInfo userInfo) throws BaseException {
		LocationDTO locationDTO = new LocationDTO();
		try {
			List<MerchantLocation> lDTOs = loadDAO().getAdditionLocationByMerchant(userInfo);
			if (lDTOs != null && lDTOs.size() > 0) {
				for (MerchantLocation mLocation : lDTOs) {
					LocationDTO dto = new LocationDTO();
					dto.setLocationId(IntUtil.getString(mLocation.getMerchantLocationPK().getLocationId()));
					dto.setLocationName(mLocation.getLocationName());
					dto.setEmailAddress(mLocation.getEmail());
					dto.setLocationPhone(mLocation.getLocationPhone());
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

	public CityDTO getCityDetails(String cityId) throws BaseException {
		Cities cities = loadDAO().getCityDetails(cityId);
		CityDTO cityDTO = null;
		if (cities != null) {
			cityDTO = new CityDTO();
			cityDTO.setCityCode(cities.getCityCode());
			cityDTO.setCityId(cities.getCityId() + "");
			cityDTO.setCityName(cities.getCityName());
			States states = loadDAO().getStateDetailsByCity(cities.getCityId());
			cityDTO.setStateName(states.getStateName());
			cityDTO.setTimeZoneId(cities.getTimeZoneId());
		}
		return cityDTO;
	}

	public SubscriptionDTO subscribeDealz(SubscriptionDTO subscriptionDTO) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		Integer merchantId = IntUtil.getInteger(subscriptionDTO.getMerchantId());
		if (merchantId != null && subscriptionDTO.getFirstName() != null && subscriptionDTO.getLastName() != null
				&& subscriptionDTO.getEmailId() != null) {
			if (dao.isAlreadySubscribed(subscriptionDTO.getMerchantId(), subscriptionDTO.getEmailId()))
				throw new BusinessException("You already subscribed this merchant deals.",
						BusinessException.BUSSINESS_TYP);
			DealzSubscriptionDetails details = new DealzSubscriptionDetails();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("subscriptionId", entityManager);
			details.setSubscriptionId(IntUtil.getInteger(nextKey));
			subscriptionDTO.setSubscriptionId(nextKey);
			details.setFirstName(subscriptionDTO.getFirstName());
			details.setLastName(subscriptionDTO.getLastName());
			details.setEmailId(subscriptionDTO.getEmailId());
			details.setMerchantId(IntUtil.getInteger(subscriptionDTO.getMerchantId()));
			details.setIsActive(0);
			details.setCreatedBy(0);
			details.setCreatedDate(new Date());
			details.setUpdatedBy(0);
			details.setUpdatedDate(new Date());
			entityManager.merge(details);
		}
		return subscriptionDTO;
	}

	public DocumentDTO getMediaByMerchantId(String merchantId) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<Object[]> mediaList = dao.getMediaByMerchantId(merchantId);
		DocumentDTO documentDTO = null;
		if (mediaList != null && mediaList.size() > 0) {
			documentDTO = new DocumentDTO();
			for (Object[] o : mediaList) {
				DocumentDTO dto = new DocumentDTO();
				dto.setDocId((Integer) o[0] + "");
				dto.setDocumentTitle((String) o[1]);
				dto.setMerchantId(merchantId);
				if (documentDTO.getDocumentDTOs() == null)
					documentDTO.setDocumentDTOs(new ArrayList<DocumentDTO>());
				documentDTO.getDocumentDTOs().add(dto);
			}
		}
		return documentDTO;
	}

	public List<DocumentDTO> getDocumentData(UserInfo userInfo, Integer docId, String mId) throws BaseException {
		DocumentLink documentLink = null;
		Documents documents = null;
		Integer merchantId = IntUtil.getInteger(mId);
		List<DocumentDTO> documentDTOs = null;
		if (docId != null && merchantId != null) {
			documentLink = entityManager.find(DocumentLink.class, new DocumentLinkPK(merchantId, docId));
			documents = entityManager.find(Documents.class, docId);
			if (documentLink != null && documents != null) {
				DocumentDTO dto = new DocumentDTO();
				dto.setFileSavedAs(documents.getFileSavedAs());
				dto.setOrignalFileName(documents.getOrignalFileName());
				dto.setContentType(documents.getContentType());
				dto.setParentFolderPath(documents.getParentFolderPath());
				if (documentDTOs == null)
					documentDTOs = new ArrayList<DocumentDTO>();
				documentDTOs.add(dto);

			}
		}
		return documentDTOs;
	}

	public Map<String, String> getStateMap(UserInfo userInfo, String cityId) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		Map<String, String> retMap = null;
		try {
			retMap = dao.getStateMap(userInfo, cityId);
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	public PostDTO getPostByMerchantId(String merchantId) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		PostDTO retDto = new PostDTO();
		List<GcdPost> posts = dao.getPostByMerchantId(merchantId);
		if (posts != null) {
			for (GcdPost gcdPost : posts) {
				PostDTO dto = new PostDTO();
				dto.setPostId(gcdPost.getPostId() + "");
				dto.setTitle(gcdPost.getTitle());
				if (retDto.getPostDTOs() == null)
					retDto.setPostDTOs(new ArrayList<PostDTO>());
				retDto.getPostDTOs().add(dto);
			}
		}
		posts = null;
		return retDto;
	}

	public PostDTO getPostContentById(String postId) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		PostDTO retDto = null;
		GcdPost post = dao.getPostContentById(postId);
		if (post != null) {
			retDto = new PostDTO();
			retDto.setPostId(post.getPostId() + "");
			retDto.setTitle(post.getTitle());
			retDto.setPost(post.getPost());
			retDto.setAttachedFileName(loadDAO().getLogoInfo(IntUtil.getInteger(post.getMerchantId()), 10));
		}
		post = null;
		return retDto;
	}

	public DealzDTO getDealzById(String dealzId) throws BaseException {
		UserInfo userInfo = new UserInfo();
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		MerchantDealz dealz = dao.getDealzById(dealzId);
		DealzDTO dealzDTO = null;
		if (dealz != null) {
			dealzDTO = new DealzDTO();
			MerchantMaster mMaster = entityManager.find(MerchantMaster.class,
					dealz.getMerchantDealzPK().getMerchantId());
			SocialConnections connections = loadDAO()
					.getSocialConnectionsByMerchantId(dealz.getMerchantDealzPK().getMerchantId());
			if (dealz.getUseLogo() != null && dealz.getUseLogo() == 1) {
				dealzDTO.setImagePath(loadDAO().getLogoInfo(dealz.getMerchantDealzPK().getMerchantId(), 2));
			} else {
				String fileName = (String) loadDAO().getDocument(dealz.getMerchantDealzPK().getDealzId() + "");
				if (fileName != null)
					dealzDTO.setImagePath(fileName);
			}
			if (connections != null) {
				SocialConnectionsDTO conDTO = setSocialConnectionDtos(connections);
				if (dealzDTO.getSocialConnectionsDTO() == null)
					dealzDTO.setSocialConnectionsDTO(conDTO);
				conDTO = null;
			} else {
				dealzDTO.setSocialConnectionsDTO(new SocialConnectionsDTO());
			}

			MerchantDTO dto = new MerchantDTO();

			dto.setLogoImagePath(loadDAO().getLogoInfo(dealz.getMerchantDealzPK().getMerchantId(), 2));

			dto.setMerchantName(mMaster.getMerchantName());
			dto.setAddress1(mMaster.getAddress1());
			dto.setAddress2(mMaster.getAddress2());
			dto.setAddress3(mMaster.getAddress3());
			dto.setEmailId(mMaster.getEmailId());
			dto.setWebsiteUrl(mMaster.getWebsiteUrl());
			dto.setCity(IntUtil.getString(mMaster.getCity()));
			Cities cities = entityManager.find(Cities.class, mMaster.getCity());
			if (cities != null) {
				dto.setCityText(cities.getCityName());
				dto.setState(mMaster.getState());
			}
			dto.setZipCode(mMaster.getZip());

			MerchantDealz mDealz = loadDAO().getMyLatestDeal(mMaster.getMerchantId());
			dto.setLatestDealId(mDealz.getMerchantDealzPK().getDealzId() + "");
			dto.setLatestDealTitle(mDealz.getTitle());
			dto.setUrlTitle(dealz.getTitle().replaceAll("[^a-zA-Z0-9]", "-"));

			dealzDTO.setMerchantDTOs(dto);

			dealzDTO.setMerchantAddress(
					mMaster.getAddress1() + " " + mMaster.getAddress2() + " " + mMaster.getAddress3() + " "
							+ mMaster.getCity() + " " + mMaster.getState() + " " + " " + mMaster.getZip());
			dealzDTO.setMerchantId(mMaster.getMerchantId() + "");
			// dealzDTO.setUrlMerchantName(mMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]",
			// "-"));
			dealzDTO.setUrlMerchantName(mMaster.getMerchantUrl());
			dealzDTO.setMerchantName(mMaster.getMerchantName());
			dealzDTO.setDealType(dealz.getDealType() + "");
			dealzDTO.setDealId(IntUtil.getString(dealz.getMerchantDealzPK().getDealzId()));
			dealzDTO.setCurrentRating(loadDAO().getCurrentRatingOfDealz(dealz.getMerchantDealzPK().getDealzId()) + "");
			dealzDTO.setTitle(dealz.getTitle());
			dealzDTO.setUrlTitle(dealz.getTitle().replaceAll("[^a-zA-Z0-9]", "-"));
			dealzDTO.setDealCode(dealz.getCode());
			dealzDTO.setStartDate(DateUtil.parseDateToString(dealz.getStartDate(), userInfo.getDateFormat()));
			dealzDTO.setEndDate(DateUtil.parseDateToString(dealz.getEndDate(), userInfo.getDateFormat()));
			dealzDTO.setRestriction(dealz.getRestrictions());
			dealzDTO.setDescription(dealz.getDescription());
			dealzDTO.setCreateDateText(DateUtil.parseDateToString(dealz.getUpdatedDate(), userInfo.getDateFormat()));
			dealzDTO.setLatitude(dealz.getLatitude());
			dealzDTO.setLongitude(dealz.getLongitude());
			dealzDTO.setGoogleAnalytics(mMaster.getGoogleAnalyticId());

			dealzDTO.setFbSortUrl(dealz.getFbSortUrl());
			dealzDTO.setTwitSortUrl(dealz.getTwitSortUrl());
			dealzDTO.setPinSortUrl(dealz.getPinSortUrl());
			dealzDTO.setLinkSortUrl(dealz.getLinkSortUrl());
			dealzDTO.setgPSortUrl(dealz.getgPSortUrl());

			dealzDTO.setCityName(cities.getCityCode());
		}
		dealz = null;
		return dealzDTO;
	}

	public String getCategoryName(String categoryId) throws BaseException {
		Category category = entityManager.find(Category.class, IntUtil.getInteger(categoryId));
		return category.getCategoryName();
	}

	public String getSubCategoryName(String categoryId, String subcategoryId) throws BaseException {
		SubCategory subCategory = entityManager.find(SubCategory.class,
				new SubCategoryPK(IntUtil.getInteger(subcategoryId), IntUtil.getInteger(categoryId)));
		return subCategory.getSubCategoryName();
	}

	public List<CategoryDTO> getListOfCategoryNneighborhoods(UserInfo userInfo) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		CategoryDTO categoryDTO = null;
		List<Category> categories = dao.getAllCategories(userInfo);
		List<NeighborhoodMaster> nMasters = dao.getNeighborhoodMasters(userInfo);

		if (categories != null && categories.size() > 0) {
			categoryDTO = new CategoryDTO();
			for (Category ctg : categories) {
				CategoryDTO dto = new CategoryDTO();
				dto.setCategoryId(ctg.getCategoryId() + "");
				dto.setCategoryName(ctg.getCategoryName());
				if (categoryDTO.getCategoryDTOs() == null)
					categoryDTO.setCategoryDTOs(new ArrayList<CategoryDTO>());
				categoryDTO.getCategoryDTOs().add(dto);
			}
		}
		if (nMasters != null && nMasters.size() > 0) {
			if (categoryDTO == null)
				categoryDTO = new CategoryDTO();
			for (NeighborhoodMaster neg : nMasters) {
				NeighborhoodDTO dto = new NeighborhoodDTO();
				dto.setNeighborhoodId(neg.getNeighborhoodMasterPK().getNeighborhoodId() + "");
				dto.setNeighborhoodName(neg.getNeighborhoodName());
				if (categoryDTO.getNeighborhoodDTOs() == null)
					categoryDTO.setNeighborhoodDTOs(new ArrayList<NeighborhoodDTO>());
				categoryDTO.getNeighborhoodDTOs().add(dto);
			}
		}
		List<CategoryDTO> dtos = new ArrayList<CategoryDTO>();
		if (categoryDTO != null)
			dtos.add(categoryDTO);
		return dtos;
	}

	public String subscribeDealz(UserInfo userInfo, SubscriptionDTO subscriptionDTO, String[] categories,
			String[] neighborhood) throws BaseException {
		Subscribers subscribers = null;
		if (subscriptionDTO != null) {
			if (loadDAO().isSubscriberEmailAvailable(subscriptionDTO.getEmailId()))
				throw new BusinessException("You already register with this email id try another one.",
						BusinessException.BUSSINESS_TYP);
			subscribers = new Subscribers();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("subscriber", entityManager);
			subscribers.setSubscriberId(IntUtil.getInteger(nextKey));
			if (subscriptionDTO.getFirstName() != null)
				subscribers.setFirstName(subscriptionDTO.getFirstName());
			else
				throw new BusinessException("First Name can not be empty.", BusinessException.BUSSINESS_TYP);

			if (subscriptionDTO.getLastName() != null)
				subscribers.setLastName(subscriptionDTO.getLastName());
			else
				throw new BusinessException("Last Name can not be empty.", BusinessException.BUSSINESS_TYP);

			if (subscriptionDTO.getEmailId() != null)
				subscribers.setEmailId(subscriptionDTO.getEmailId());
			else
				throw new BusinessException("Email Id can not be empty.", BusinessException.BUSSINESS_TYP);
			subscribers.setSubscriptionType(IntUtil.getInteger(subscriptionDTO.getSubscriptionType()));
			subscribers.setIsActive(0);
			subscribers.setCreatedBy(0);
			subscribers.setCreatedDate(new Date());
			subscribers.setUpdatedBy(0);
			subscribers.setUpdatedDate(new Date());

			List<SubscriberCategoryLink> cLinks = new ArrayList<SubscriberCategoryLink>();
			if (categories != null) {
				for (String c : categories) {
					SubscriberCategoryLink cLink = new SubscriberCategoryLink();
					String nextKey1 = DefaultKeyGenerator.getNextGeneratedKey("subsCategoryId", entityManager);
					cLink.setCategoryId(IntUtil.getInteger(c));
					cLink.setLinkId(IntUtil.getInteger(nextKey1));
					cLink.setCreatedBy(0);
					cLink.setCreatedDate(new Date());
					cLink.setUpdatedBy(0);
					cLink.setUpdatedDate(new Date());
					cLinks.add(cLink);
				}
			}
			List<SubscriberNeighborhoodsLink> nLinks = new ArrayList<SubscriberNeighborhoodsLink>();
			if (neighborhood != null) {
				for (String n : neighborhood) {
					SubscriberNeighborhoodsLink nLink = new SubscriberNeighborhoodsLink();
					String nextKey2 = DefaultKeyGenerator.getNextGeneratedKey("subsNeighId", entityManager);
					nLink.setLinkId(IntUtil.getInteger(nextKey2));
					nLink.setNeighborhoodId(IntUtil.getInteger(n));
					nLink.setCreatedBy(0);
					nLink.setCreatedDate(new Date());
					nLink.setUpdatedBy(0);
					nLink.setUpdatedDate(new Date());
					nLinks.add(nLink);
				}
			}
			subscribers.setNeighborhoodsLinks(nLinks);
			subscribers.setSubscriberCategoryLinks(cLinks);
		}
		entityManager.flush();
		entityManager.merge(subscribers);

		List<String> rec = Arrays.asList(subscribers.getEmailId());
		List<String> cc = Arrays.asList(AppPropertyBuilder.getProperty("mail.default.to", "01").split(","));
		Map<String, String> ctgMap = loadDAO().getSubscribedCtg(categories);
		Map<String, String> nMaap = loadDAO().getSubscribedNeighbour(neighborhood);
		Map<String, Object> holderMap = new HashMap<String, Object>();
		holderMap.put("Name", subscribers.getFirstName());
		holderMap.put("CtgMap", ctgMap);
		holderMap.put("NMap", nMaap);
		try {
			boolean f = EmailUtility.postMailType2("01", rec, null, null, "Get City Dealz", "subscriptionAlertMail.vm",
					holderMap, 2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "success";
	}

	public SocialConnectionsDTO setSocialConnectionDtos(SocialConnections connections) {
		SocialConnectionsDTO conDTO = new SocialConnectionsDTO();
		conDTO.setConnectionId(connections.getSocialConnectionsPK().getSocialConnectionId() + "");
		conDTO.setFacebookFanPage(connections.getFacebookFanPage());
		conDTO.setTwitterAccount(connections.getTwitterAccount());
		conDTO.setFourSquareAccount(connections.getFourSquareAccount());
		conDTO.setYelpAccount(connections.getYelpAccount());
		conDTO.setFlickerAccount(connections.getFlickerAccount());
		conDTO.setYoutubeAccount(connections.getYoutubeAccount());
		conDTO.setLinkedinProfile(connections.getLinkedinProfile());
		conDTO.setTripAdvisorAccount(connections.getTripAdvisorAccount());
		conDTO.setMeetupAccount(connections.getMeetupAccount());
		conDTO.setOpenTableAccount(connections.getOpenTableAccount());
		conDTO.setPinterestAccount(connections.getPinterestAccount());
		conDTO.setgPlusAccount(connections.getgPlusAccount());

		conDTO.setFacebookFanPagechk(connections.getFacebookFanPageChk());
		conDTO.setTwitterAccountchk(connections.getTwitterAccountChk());
		conDTO.setFourSquareAccountchk(connections.getFourSquareAccountChk());
		conDTO.setYelpAccountchk(connections.getYelpAccountChk());
		conDTO.setFlickerAccountchk(connections.getFlickerAccountChk());
		conDTO.setYoutubeAccountchk(connections.getYoutubeAccountChk());
		conDTO.setLinkedinProfilechk(connections.getLinkedinProfileChk());
		conDTO.setTripAdvisorAccountchk(connections.getTripAdvisorAccountChk());
		conDTO.setMeetupAccountchk(connections.getMeetupAccountChk());
		conDTO.setOpenTableAccountchk(connections.getOpenTableAccountChk());
		conDTO.setPinterestAccountchk(connections.getPinterestAccountChk());
		conDTO.setgPlusAccountchk(connections.getgPlusAccountChk());
		return conDTO;
	}

	public Map<String, String> getTimeZones() throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		Map<String, String> retMap = null;
		try {
			retMap = dao.getTimeZones();
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	public Map<String, String> getAutoQuery(String requestParam) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		Map<String, String> retMap = null;
		try {
			List<Object[]> merchantDealzs = dao.getDealzByTileLike(requestParam);
			if (!isEmpty(merchantDealzs)) {
				retMap = new LinkedHashMap<String, String>();
				for (Object[] o : merchantDealzs) {
					String title1 = ((String) o[0]).replaceAll("[^a-zA-Z0-9]", "-");
					String title2 = ((String) o[0]);
					String dealzId = IntUtil.getString((Integer) o[2]).replaceAll("[^a-zA-Z0-9]", "-");
					retMap.put(((String) o[1]).replaceAll("[^a-zA-Z0-9]", "-") + "/deal/" + title1 + "-" + dealzId,
							title2);
				}
			}

			List<MerchantMaster> merchantMasters = dao.getDealzByMerchantNameLike(requestParam);
			if (!isEmpty(merchantMasters)) {
				if (isEmpty(retMap))
					retMap = new LinkedHashMap<String, String>();
				for (MerchantMaster mMaster : merchantMasters) {
					String mName1 = mMaster.getMerchantName().replaceAll("[^a-zA-Z0-9]", "-");
					String mName2 = mMaster.getMerchantName();
					retMap.put("merchant/" + mMaster.getMerchantUrl(), mName2);
				}
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return retMap;
	}

	public GcdMetaDTO saveMetaNav(UserInfo userInfo, GcdMetaDTO gmDto) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		GcdSocialNav gcdSocialNav = null;
		if (!isEmpty(gmDto.getId()))
			gcdSocialNav = entityManager.find(GcdSocialNav.class, IntUtil.getInteger(gmDto.getId()));

		if (gcdSocialNav == null) {
			gcdSocialNav = new GcdSocialNav();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("metaNav", entityManager);
			gcdSocialNav.setId(IntUtil.getInteger(nextKey));
			gmDto.setId(nextKey);
		}
		gcdSocialNav.setAlign(IntUtil.getInteger(gmDto.getAlign()));
		gcdSocialNav.setImageAlt(gmDto.getImageAlt());
		gcdSocialNav.setType(IntUtil.getInteger(gmDto.getType()));
		gcdSocialNav.setUrl(gmDto.getUrl());
		gcdSocialNav.setShowOnPage(IntUtil.getInteger(gmDto.getShowOnPage()));
		gcdSocialNav.setPageText(gmDto.getPageText());
		gcdSocialNav.setIsEditable(Boolean.parseBoolean(gmDto.getIsEditable()));
		gcdSocialNav.setElementId(gmDto.getElementId());
		gcdSocialNav.setElementClass(gmDto.getElementClass());
		entityManager.merge(gcdSocialNav);
		gmDto.setImagePath(dao.getLogoId(IntUtil.getInteger(gmDto.getId())));
		return gmDto;
	}

	public GcdMetaDTO getMetaByType(Integer type) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		GcdMetaDTO gcdMetaDTO = null;
		try {
			List<GcdSocialNav> gcdSocialNavs = dao.getMetaById(type);
			if (!isEmpty(gcdSocialNavs)) {
				gcdMetaDTO = new GcdMetaDTO();
				for (GcdSocialNav gsn : gcdSocialNavs) {
					GcdMetaDTO dto = new GcdMetaDTO();
					dto.setId(gsn.getId() + "");
					dto.setType(gsn.getType() + "");
					dto.setImageAlt(gsn.getImageAlt());
					dto.setUrl(gsn.getUrl());
					dto.setAlign(gsn.getAlign() + "");
					dto.setImagePath(loadDAO().getLogoInfo(gsn.getId(), 12));
					dto.setShowOnPage(gsn.getShowOnPage() == 1 ? "Yes" : "No");
					dto.setElementId(gsn.getElementId());
					dto.setElementClass(gsn.getElementClass());
					dto.setBreakGroup(valueOf(gsn.getBreakGroup()));
					if (gcdMetaDTO.getGcdMetaDTOs() == null)
						gcdMetaDTO.setGcdMetaDTOs(new ArrayList<GcdMetaDTO>());
					gcdMetaDTO.getGcdMetaDTOs().add(dto);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gcdMetaDTO;
	}

	public GcdMetaDTO getMetaById(Integer metaId) throws BaseException {
		GcdMetaDTO dto = null;
		GcdSocialNav gsn = null;
		if (metaId != null) {
			dto = new GcdMetaDTO();
			gsn = entityManager.find(GcdSocialNav.class, metaId);
			dto.setId(gsn.getId() + "");
			dto.setType(gsn.getType() + "");
			dto.setImageAlt(gsn.getImageAlt());
			dto.setUrl(gsn.getUrl());
			dto.setAlign(gsn.getAlign() + "");
			dto.setImagePath(loadDAO().getLogoInfo(gsn.getId(), 12));
			dto.setShowOnPage(gsn.getShowOnPage() + "");
			dto.setPageText(gsn.getPageText());
			// dto.setIsEditable(gsn.getIsEditable() == false ? "false" :
			// "true");
		}
		return dto;
	}

	public UserInfo getUserInfo(UserMaster userMaster) {
		UserInfo userInfo = new UserInfo();
		userInfo.setUserIndex(userMaster.getUserIndex());
		userInfo.setUserId(userMaster.getUserId());
		userInfo.setContactFirstName(userMaster.getFirstName());
		userInfo.setContactLastName(userMaster.getLastName());
		userInfo.setPassword(userMaster.getPassword());
		userInfo.setEmailId(userMaster.getEmailId());
		return userInfo;
	}

	public List<UserInfo> getUserMasters(UserInfo userInfo) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<UserMaster> userMasters = dao.getUserMasters();
		List<UserInfo> userInfos = new ArrayList<UserInfo>();
		if (!isEmpty(userMasters)) {
			for (UserMaster uMaster : userMasters) {
				userInfos.add(getUserInfo(uMaster));
			}
		}
		return userInfos;
	}

	public UserInfo getAdminDetailsById(String userId) throws BaseException {
		Integer userIndex = IntUtil.getInteger(userId);
		/*
		 * if (userIndex == null) throw new BusinessException("Invalid User Id",
		 * BusinessException.BUSSINESS_TYP);
		 */
		UserMaster userMaster = entityManager.find(UserMaster.class, userIndex);
		return getUserInfo(userMaster);
	}

	public UserInfo saveAdminDetails(UserInfo usermaster) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		UserMaster uMaster = null;
		if (usermaster.getUserIndex() != null)
			uMaster = entityManager.find(UserMaster.class, usermaster.getUserIndex());

		if (uMaster == null) {
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("usermaster", entityManager);
			uMaster = new UserMaster();
			uMaster.setUserIndex(IntUtil.getInteger(nextKey));
			uMaster.setCreatedBy(1);
			uMaster.setCreatedDate(new Date());
			usermaster.setUserIndex(uMaster.getUserIndex());
		}
		uMaster.setFirstName(usermaster.getContactFirstName());
		uMaster.setLastName(usermaster.getContactLastName());
		if (!isEmpty(usermaster.getPassword()))
			uMaster.setPassword(usermaster.getPassword());
		uMaster.setEmailId(usermaster.getEmailId());
		uMaster.setUserId(usermaster.getUserId());
		uMaster.setUpdatedBy(1);
		uMaster.setStatus(1001);
		uMaster.setUpdatedDate(new Date());
		entityManager.merge(uMaster);
		return usermaster;
	}

	public String validateAdminUserIdEmailId(String userId, String emailId, String userIndex) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		if (dao.validateUserId(userId, userIndex))
			throw new BusinessException("User Id already in used.", BaseException.BUSSINESS_TYP);
		if (dao.validateEmailId(emailId, userIndex))
			throw new BusinessException("e-Mail already in used.", BaseException.BUSSINESS_TYP);

		return null;
	}

	public Map<String, String> getAllUserList() throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		Map<String, String> usersMap = dao.getAllUserList();
		return usersMap;
	}

	public SocialProfileDTO saveSocialDetails(SocialProfileDTO dto) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		SocialAccounts socialAccounts = dao.getSocialProfile(dto);
		if (socialAccounts == null) {
			socialAccounts = new SocialAccounts();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("socialProfile", entityManager);
			dto.setId(nextKey);
			socialAccounts.setId(IntUtil.getInteger(nextKey));
			socialAccounts.setEmailId(dto.getEmailId());
			socialAccounts.setCreatedBy(1);
			socialAccounts.setCreatedDate(new Date());
		}
		socialAccounts.setFirstName(dto.getFirstName());
		socialAccounts.setLastName(dto.getLastName());
		socialAccounts.setAccount(dto.getAccount());
		socialAccounts.setUpdatedBy(1);
		socialAccounts.setUpdatedDate(new Date());
		entityManager.merge(socialAccounts);
		return dto;
	}

	public String getNextOrderOfHotDeal() throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		String nextVal = dao.getNextOrderOfHotDeal();
		return nextVal;
	}

	public GcdMetaDTO getPageMetaByPageName(String pageName) throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		GcdPageManager nav = dao.getPageMetaByPageName(pageName);
		GcdMetaDTO dto = new GcdMetaDTO();
		if (nav != null) {
			dto.setPageTitle(nav.getPageTitle());
			dto.setPageText(nav.getPageText());
		}
		return dto;
	}

	public GcdMetaDTO getListOfPages() throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<GcdPageManager> gcdPageManagers = dao.getListOfPages();
		GcdMetaDTO dto = new GcdMetaDTO();
		if (!isEmpty(gcdPageManagers)) {
			for (GcdPageManager m : gcdPageManagers) {
				GcdMetaDTO meta = new GcdMetaDTO();
				meta.setId(m.getId() + "");
				meta.setPageTitle(m.getPageTitle());
				if (dto.getGcdMetaDTOs() == null)
					dto.setGcdMetaDTOs(new ArrayList<GcdMetaDTO>());
				dto.getGcdMetaDTOs().add(meta);
			}
		}
		return dto;
	}

	public GcdMetaDTO getListOfRightHandRails() throws BaseException {
		GetCityDealzDAO<Base<Serializable>, Serializable> dao = loadDAO();
		List<GcdRightHandRailsNav> rails = dao.getListOfRightHandRails();
		GcdMetaDTO dto = new GcdMetaDTO();
		if (!isEmpty(rails)) {
			for (GcdRightHandRailsNav m : rails) {
				GcdMetaDTO meta = new GcdMetaDTO();
				meta.setId(m.getId() + "");
				meta.setPageTitle(m.getSectionTitle());
				meta.setPageText(m.getContent());
				meta.setShowOnPage(m.getShowOnPage() == 1 ? "Yes" : "No");
				if (dto.getGcdMetaDTOs() == null)
					dto.setGcdMetaDTOs(new ArrayList<GcdMetaDTO>());
				dto.getGcdMetaDTOs().add(meta);
			}
		}
		return dto;
	}

	public String saveRightHandRails(GcdMetaDTO dto) throws BaseException {
		GcdRightHandRailsNav nav = null;
		Integer navId = IntUtil.getInteger(dto.getId());
		if (navId != null)
			nav = entityManager.find(GcdRightHandRailsNav.class, navId);

		if (nav == null) {
			nav = new GcdRightHandRailsNav();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("gcdRightNavGen", entityManager);
			nav.setId(IntUtil.getInteger(nextKey));
		}
		nav.setSectionTitle(dto.getPageTitle());
		nav.setAlign(IntUtil.getInteger(dto.getAlign()));
		nav.setShowOnPage(IntUtil.getInteger(dto.getShowOnPage()));
		nav.setContent(dto.getPageText());
		entityManager.merge(nav);
		return "success";
	}

	public String savePageMaster(GcdMetaDTO dto) throws BaseException {
		GcdPageManager gcdPageManager = null;
		Integer pageId = IntUtil.getInteger(dto.getId());
		if (pageId != null)
			gcdPageManager = entityManager.find(GcdPageManager.class, pageId);

		if (gcdPageManager == null) {
			gcdPageManager = new GcdPageManager();
			String nextKey = DefaultKeyGenerator.getNextGeneratedKey("gcdPageGen", entityManager);
			gcdPageManager.setId(IntUtil.getInteger(nextKey));
			gcdPageManager.setCreatedBy(1);
			gcdPageManager.setCreatedDate(new Date());
		}
		gcdPageManager.setPageUrl(dto.getUrl());
		gcdPageManager.setPageTitle(dto.getPageTitle());
		gcdPageManager.setPageText(dto.getPageText());
		gcdPageManager.setUpdatedBy(1);
		gcdPageManager.setUpdatedDate(new Date());
		entityManager.merge(gcdPageManager);
		return "success";
	}

	public GcdMetaDTO getRighHandRailDetailsById(String id) throws BaseException {
		Integer navId = IntUtil.getInteger(id);
		GcdMetaDTO gcdMetaDTO = null;
		if (navId != null) {
			GcdRightHandRailsNav nav = entityManager.find(GcdRightHandRailsNav.class, navId);
			gcdMetaDTO = new GcdMetaDTO();
			gcdMetaDTO.setId(id);
			gcdMetaDTO.setAlign(nav.getAlign() + "");
			gcdMetaDTO.setShowOnPage(nav.getShowOnPage() + "");
			gcdMetaDTO.setPageTitle(nav.getSectionTitle());
			gcdMetaDTO.setPageText(nav.getContent());
		}
		return gcdMetaDTO;
	}

	public GcdMetaDTO getPageDetailsById(String id) throws BaseException {
		Integer navId = IntUtil.getInteger(id);
		GcdMetaDTO gcdMetaDTO = null;
		if (navId != null) {
			GcdPageManager nav = entityManager.find(GcdPageManager.class, navId);
			gcdMetaDTO = new GcdMetaDTO();
			gcdMetaDTO.setId(id);
			gcdMetaDTO.setUrl(nav.getPageUrl());
			gcdMetaDTO.setPageTitle(nav.getPageTitle());
			gcdMetaDTO.setPageText(nav.getPageText());
		}
		return gcdMetaDTO;
	}
}
