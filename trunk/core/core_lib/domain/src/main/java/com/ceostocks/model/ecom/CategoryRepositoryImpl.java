package com.ceostocks.model.ecom;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.ceostocks.common.base.BaseDaoJpa;

public class CategoryRepositoryImpl extends BaseDaoJpa<Category, Integer> implements CategoryRepository {

	public CategoryRepositoryImpl() {
		super(Category.class);
	}

	@Override
	public List<Category> searchByCriteria(Integer start, Integer count) {
		TypedQuery<Category> typedQuery = getEntityManager().createQuery("from Category", Category.class);
		if (start > 0 && count > 0) {
			typedQuery.setFirstResult(start);
			typedQuery.setMaxResults(count);
		}
		return typedQuery.getResultList();
	}

	@Override
	public Integer count() {
		Query typedQuery = getEntityManager().createNativeQuery("select count(*) from PRODUCT_CATEGORY");

		return ((BigInteger) typedQuery.getResultList().get(0)).intValue();
	}
}
