package com.ceostocks.application.ecom;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.ceostocks.application.mapper.CategoryDTOMapper;
import com.ceostocks.common.annotation.CeoStocksReadOnlyTxn;
import com.ceostocks.common.annotation.CeoStocksReqNewTxn;
import com.ceostocks.common.dto.CategoryDTO;
import com.ceostocks.common.dto.SubCategoryDTO;
import com.ceostocks.model.ecom.Category;
import com.ceostocks.services.ecom.CategoriesService;

public class CategoriesApplicationImpl implements CategoriesApplication {

	@Autowired
	private CategoriesService categoriesService;

	@Override
	@CeoStocksReqNewTxn
	public CategoryDTO saveCategory(Category productCategory) {
		productCategory = categoriesService.saveCategory(productCategory);
		return CategoryDTOMapper.categoryEntityToDtoMapper(productCategory);
	}

	@Override
	@CeoStocksReadOnlyTxn
	public CategoryDTO searchCategory(Integer start, Integer count) {
		List<Category> productCategories = categoriesService.searchCategory(start, count);
		CategoryDTO categoryDTO = CategoryDTOMapper.categoryEntityListToDtoMapper(productCategories);
		categoryDTO.setTotal(categoriesService.totalCategories());
		return categoryDTO;
	}

	@Override
	@CeoStocksReadOnlyTxn
	public Map<String, String> getCategoryMap() {
		Map<String, String> categoryMap = new HashMap<String, String>();
		List<Category> categories = categoriesService.searchCategory(-1, -1);
		if (categories != null) {
			categories.stream().forEach(ctg -> categoryMap.put(ctg.getCategoryId().toString(), ctg.getCategoryName()));
		}
		return categoryMap;
	}

	@Override
	@CeoStocksReadOnlyTxn
	public SubCategoryDTO searchSubCategory(Integer start, Integer count) {

		return null;
	}

	@Override
	@CeoStocksReqNewTxn
	public SubCategoryDTO saveSubCategory(SubCategoryDTO subCategoryDTO) {
		return null;
	}
}
