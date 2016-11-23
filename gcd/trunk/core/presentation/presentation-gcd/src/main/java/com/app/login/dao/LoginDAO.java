package com.app.login.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import com.app.login.dto.UserInfo;
import com.app.model.base.Base;
import com.app.model.getcitydealz.MerchantMaster;
import com.app.model.merchantlevel.MerchantLevel;
import com.app.persistence.JPADAO;
import com.app.utility.common.IntUtil;

public class LoginDAO<T extends Base<I>, I extends Serializable> extends JPADAO<T, I> {

	@SuppressWarnings("unchecked")
	public MerchantMaster getMerchantMaster(UserInfo userInfo) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantmaster WHERE (EmailId = ? OR UserId=?) AND Status!=0 AND City=?",
				MerchantMaster.class);
		query.setParameter(1, userInfo.getUserId());
		query.setParameter(2, userInfo.getUserId());
		query.setParameter(3, IntUtil.getInteger(userInfo.getCityId()));
		List<MerchantMaster> mMaster = query.getResultList();
		if (mMaster != null && mMaster.size() > 0)
			return mMaster.get(0);
		return null;
	}

	@SuppressWarnings("unchecked")
	public MerchantLevel getMerchantLevel(Integer merchantId) {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM merchantlevel WHERE MerchantId = ?", MerchantLevel.class);
		query.setParameter(1, merchantId);
		List<MerchantLevel> mLevel = query.getResultList();
		if (mLevel != null && mLevel.size() > 0)
			return mLevel.get(0);
		return null;
	}

}
