package com.app.login.manager;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.app.commonexception.BusinessException;
import com.app.login.dao.LoginDAO;
import com.app.login.dto.UserInfo;
import com.app.model.base.Base;
import com.app.model.citiesnstate.Cities;
import com.app.model.getcitydealz.MerchantMaster;
import com.app.model.merchantlevel.MerchantLevel;
import com.app.persistence.factory.JPADAOFactory;
import com.app.utility.common.IntUtil;

@Repository("loginManager")
public class LoginManager {

	@PersistenceContext
	private EntityManager entityManager;

	/*
	 * @Autowired private EntityManagerFactory entityManagerFactory;
	 */

	public LoginManager() {

	}

	@SuppressWarnings("unchecked")
	public LoginDAO<Base<Serializable>, Serializable> loadDAO() throws Exception {
		LoginDAO<Base<Serializable>, Serializable> loginDAO = null;
		try {
			loginDAO = (LoginDAO<Base<Serializable>, Serializable>) JPADAOFactory.getDAOFactory(JPADAOFactory.DEFAULT).getDAO(LoginDAO.class);
			loginDAO.setEntityManager(entityManager);
		} catch (Exception e) {
			throw e;
		}
		return loginDAO;
	}

	public UserInfo doLogin(UserInfo userInfo) throws Exception {
		LoginDAO<Base<Serializable>, Serializable> daoObj = loadDAO();
		MerchantMaster mMaster = daoObj.getMerchantMaster(userInfo);
		if (mMaster != null && mMaster.getPassword().equals(userInfo.getPassword())) {
			userInfo.setUserIndex(mMaster.getMerchantId());
			userInfo.setEmailId(mMaster.getEmailId());
			userInfo.setUserName(mMaster.getMerchantName());
			userInfo.setContactFirstName(mMaster.getContactFirstName());
			userInfo.setContactLastName(mMaster.getContactLastName());
			userInfo.setContactPhone(mMaster.getContactPhone());
			userInfo.setAddress1(mMaster.getAddress1());
			userInfo.setAddress2(mMaster.getAddress2());
			userInfo.setAddress3(mMaster.getAddress3());
			userInfo.setCity(IntUtil.getString(mMaster.getCity()));
			Cities cities = entityManager.find(Cities.class, mMaster.getCity());
			userInfo.setCityText(cities.getCityName());
			userInfo.setState(mMaster.getState());
			userInfo.setZipCode(mMaster.getZip());
			userInfo.setSalesPerson(mMaster.getSalesPerson());
			userInfo.setDailyDealenName(mMaster.getDailyDealenName());
			userInfo.setTestDrive(mMaster.getTestDrive());
			userInfo.setGoogleAnalyticsId(mMaster.getGoogleAnalyticId());
			userInfo.setBlogTemplateId(mMaster.getBlogTemplateId());
			userInfo.setContactAlternatePhone(mMaster.getContactAltPhone());
			userInfo.setBlogTemplateId(mMaster.getBlogTemplateId());
			userInfo.setBusinessHours(mMaster.getBusinessHours());
			userInfo.setCityToDisplay(mMaster.getCityToDispaly());
			MerchantLevel merchantLevel = daoObj.getMerchantLevel(mMaster.getMerchantId());
			if (merchantLevel != null)
				userInfo.setUserLevel(IntUtil.getString(merchantLevel.getMerchantLevelPK().getLevelId()));
			if (userInfo.getPassword().equals(mMaster.getPassword())) {

			} else {
				throw new BusinessException("common.msg.000001", BusinessException.BUSSINESS_TYP);
			}
		} else {
			throw new BusinessException("common.msg.000001", BusinessException.BUSSINESS_TYP);
		}
		return userInfo;
	}
}
