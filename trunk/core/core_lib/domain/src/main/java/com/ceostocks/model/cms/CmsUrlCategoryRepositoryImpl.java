package com.ceostocks.model.cms;

import java.util.List;

import javax.persistence.TypedQuery;

import com.ceostocks.common.base.BaseDaoJpa;

public class CmsUrlCategoryRepositoryImpl extends BaseDaoJpa<CmsUrlCategory, Integer> implements CmsUrlCategoryRepository {

	public CmsUrlCategoryRepositoryImpl() {
		super(CmsUrlCategory.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<CmsUrlCategory> getCmsUrlsCategoryByType(Integer categoryType) {
		TypedQuery<CmsUrlCategory> typedQuery = getEntityManager().createQuery("from CmsUrlCategory c where c.categoryType=:categoryType",
				CmsUrlCategory.class);
		typedQuery.setParameter("categoryType", categoryType);
		return typedQuery.getResultList();
	}

}
