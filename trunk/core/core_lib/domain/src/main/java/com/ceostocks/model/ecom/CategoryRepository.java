package com.ceostocks.model.ecom;

import java.util.List;

import com.ceostocks.common.base.BaseDao;

public interface CategoryRepository extends BaseDao<Category, Integer> {

	List<Category> searchByCriteria(Integer start, Integer count);

	Integer count();
}
