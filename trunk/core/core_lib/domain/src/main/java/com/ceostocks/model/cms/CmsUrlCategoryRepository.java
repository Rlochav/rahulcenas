package com.ceostocks.model.cms;

import java.util.List;

import com.ceostocks.common.base.BaseDao;

public interface CmsUrlCategoryRepository extends BaseDao<CmsUrlCategory, Integer> {

	List<CmsUrlCategory> getCmsUrlsCategoryByType(Integer categoryType);

}
