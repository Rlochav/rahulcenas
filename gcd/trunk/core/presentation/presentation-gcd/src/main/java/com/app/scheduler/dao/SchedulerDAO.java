package com.app.scheduler.dao;

import static com.app.utility.common.AppPropertyBuilder.getProperty;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.app.model.base.Base;
import com.app.model.getcitydealz.MerchantDealz;
import com.app.model.socialconnections.AdminFBAccessToken;
import com.app.model.socialconnections.AdminTwitterOAuth;
import com.app.model.subscriber.SubscriberCategoryLink;
import com.app.model.subscriber.SubscriberNeighborhoodsLink;
import com.app.model.subscriber.Subscribers;
import com.app.persistence.JPADAO;
import com.app.persistence.exception.DAOException;
import com.app.utility.common.IntUtil;

public class SchedulerDAO<T extends Base<I>, I extends Serializable> extends JPADAO<T, I> {

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
	public String getLogoInfo(Integer mId) throws DAOException {
		Query query = getEntityManager().createNativeQuery(
				"SELECT FileSavedAs FROM documents d INNER JOIN documentlink dl ON d.DocId=dl.DocId WHERE MerchantId=? AND dl.DocType=2");
		query.setParameter(1, mId);
		List<Object> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return (String) rList.get(0);
		return null;
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
	public List<Object[]> getDealzListByCategoryToSend1(Integer categoryId) {
		Query q = getEntityManager()
				.createNativeQuery(
						"SELECT DISTINCT c.MerchantName,a.Title,a.StartDate,a.EndDate,a.AmountSaving,a.Code,a.Description,c.MerchantId,a.DealzId,a.UseLogo,c.MerchantUrl FROM merchantdealz a INNER JOIN merchantmaster c On c.MerchantId=a.MerchantId INNER JOIN categorydealzlink b ON b.dealzId=a.DealzId WHERE a.DealType=1 AND a.status=1 AND StartDate<=CONVERT_TZ(NOW(),'"
								+ getProperty("server.utc.time", "01")
								+ "',LocalTimeZoneUtc) AND EndDate>CONVERT_TZ(NOW(),'"
								+ getProperty("server.utc.time", "01") + "',LocalTimeZoneUtc) AND b.CategoryId=? AND b.Processed1!=1");
		q.setParameter(1, categoryId);
		List<Object[]> dealzList = q.getResultList();
		return dealzList;
	}

	@SuppressWarnings("unchecked")
	public List<Object[]> getDealzListByNhoodToSend1(Integer neighborhoodId) {
		Query q = getEntityManager()
				.createNativeQuery(
						"SELECT DISTINCT c.MerchantName,a.Title,a.StartDate,a.EndDate,a.AmountSaving,a.Code,a.Description,c.MerchantId,a.DealzId,a.UseLogo,c.MerchantUrl FROM merchantdealz a INNER JOIN merchantmaster c On c.MerchantId=a.MerchantId INNER JOIN neighborhooddealzlink b ON b.DealzId=a.DealzId WHERE a.DealType=1 AND a.status=1 AND StartDate<=CONVERT_TZ(NOW(),'"
								+ getProperty("server.utc.time", "01")
								+ "',LocalTimeZoneUtc) AND EndDate>CONVERT_TZ(NOW(),'"
								+ getProperty("server.utc.time", "01") + "',LocalTimeZoneUtc) AND b.NeighbourhoodId=? AND b.Processed1!=1");
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
	public List<SubscriberCategoryLink> getSubscriberCategoryLink(Integer subscriberId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM subscribercategorylink WHERE SubscriberId=?", SubscriberCategoryLink.class);
		query.setParameter(1, subscriberId);
		List<SubscriberCategoryLink> subsCatgLinks = query.getResultList();
		return subsCatgLinks;
	}

	@SuppressWarnings("unchecked")
	public List<SubscriberNeighborhoodsLink> getSubscriberNeighborhoodsLink(Integer subscriberId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM subscriberneighborhoodslink WHERE SubscriberId=?", SubscriberNeighborhoodsLink.class);
		query.setParameter(1, subscriberId);
		List<SubscriberNeighborhoodsLink> subsCatgLinks = query.getResultList();
		return subsCatgLinks;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean updateCategoryDealzLinks(Integer dealzId, Integer categoryId, Integer merchantId, String alias) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence.001");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager
				.createNativeQuery("UPDATE categorydealzlink set Processed" + alias + "=1 WHERE dealzId=? AND merchantId=? AND categoryId=?");
		query.setParameter(1, dealzId);
		query.setParameter(2, merchantId);
		query.setParameter(3, categoryId);
		query.executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public boolean updateNeighborhoodDealzLinks(Integer dealzId, Integer neighborhoodId, Integer merchantId, String alias) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("persistence.001");
		EntityManager entityManager = factory.createEntityManager();
		entityManager.getTransaction().begin();
		Query query = entityManager.createNativeQuery("UPDATE neighborhooddealzlink set Processed" + alias
				+ "=1 WHERE dealzId=? AND merchantId=? AND NeighbourhoodId=?");
		query.setParameter(1, dealzId);
		query.setParameter(2, merchantId);
		query.setParameter(3, neighborhoodId);
		query.executeUpdate();
		entityManager.getTransaction().commit();
		entityManager.close();
		return true;
	}

	@SuppressWarnings("unchecked")
	public boolean isTransactionCompleted(Integer dealzId, Integer subscriberId, Integer subscriptionType) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM subscriberneighborhoodslink WHERE SubscriberId=?", SubscriberNeighborhoodsLink.class);
		query.setParameter(1, subscriberId);
		List<SubscriberNeighborhoodsLink> subsCatgLinks = query.getResultList();
		return true;
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
	public List<AdminFBAccessToken> getAdminFBTokens() {
		Query query = getEntityManager().createQuery("from " + AdminFBAccessToken.class.getName(), AdminFBAccessToken.class);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<AdminTwitterOAuth> getAdminTwitterTokens() {
		Query query = getEntityManager().createQuery("from " + AdminTwitterOAuth.class.getName(), AdminTwitterOAuth.class);
		return query.getResultList();
	}

	public List<MerchantDealz> getTempAllDealz() {
		Query query = getEntityManager().createNativeQuery(
				"SELECT * FROM merchantdealz  WHERE status=1 AND DealType=1 AND EndDate>CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01")
						+ "',LocalTimeZoneUtc) AND StartDate<=CONVERT_TZ(NOW(),'" + getProperty("server.utc.time", "01") + "',LocalTimeZoneUtc)",
				MerchantDealz.class);
		return query.getResultList();
	}
}
