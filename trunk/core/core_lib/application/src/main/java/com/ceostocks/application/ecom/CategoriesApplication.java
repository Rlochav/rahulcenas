package com.ceostocks.application.ecom;

import java.util.Map;

import com.ceostocks.common.dto.CategoryDTO;
import com.ceostocks.common.dto.SubCategoryDTO;
import com.ceostocks.model.ecom.Category;

public interface CategoriesApplication {

	CategoryDTO saveCategory(Category category);

	CategoryDTO searchCategory(Integer start, Integer count);

	Map<String, String> getCategoryMap();

	SubCategoryDTO searchSubCategory(Integer start, Integer count);

	SubCategoryDTO saveSubCategory(SubCategoryDTO subCategoryDTO);

}
