package com.ceostocks.services.ecom;

import java.util.List;

import com.ceostocks.model.ecom.Category;

public interface CategoriesService {

	Category saveCategory(Category category);

	List<Category> searchCategory(Integer start, Integer count);

	Integer totalCategories();

}
