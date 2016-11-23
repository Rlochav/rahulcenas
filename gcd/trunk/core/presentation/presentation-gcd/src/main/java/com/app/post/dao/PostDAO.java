package com.app.post.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import com.app.login.dto.UserInfo;
import com.app.model.base.Base;
import com.app.model.blog.GcdPost;
import com.app.persistence.JPADAO;
import com.app.persistence.exception.DAOException;

public class PostDAO<T extends Base<I>, I extends Serializable> extends JPADAO<T, I> {

	@SuppressWarnings("unchecked")
	public List<GcdPost> getMyAllPost(UserInfo userInfo) throws DAOException {
		Query query = getEntityManager().createNativeQuery("SELECT * FROM gcdpost WHERE CRTBy=? ORDER BY UPDdate DESC", GcdPost.class);
		query.setParameter(1, userInfo.getUserIndex());
		List<GcdPost> rList = query.getResultList();
		if (rList != null && rList.size() > 0)
			return rList;
		return null;
	}

}
