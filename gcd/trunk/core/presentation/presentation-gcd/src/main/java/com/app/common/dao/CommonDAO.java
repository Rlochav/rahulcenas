package com.app.common.dao;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Query;

import com.app.model.base.Base;
import com.app.persistence.JPADAO;

public class CommonDAO<T extends Base<I>, I extends Serializable> extends JPADAO<T, I> {

	@SuppressWarnings("unchecked")
	public List<Object[]> getAllCodeLookUpKeyList() {
		List<Object[]> list = null;
		Query query = getEntityManager().createNativeQuery("SELECT lkupCode,keyCode,key1,key2,key3 FROM codelkup ORDER BY lkupCode ASC");
		list = query.getResultList();
		return list;
	}

}
