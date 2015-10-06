package com.ceostocks.services.ecom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ceostocks.model.ecom.Category;
import com.ceostocks.model.ecom.CategoryRepository;

@Service
public class CategoriesServiceImpl implements CategoriesService {

	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {
		categoryRepository.save(category);
		return category;
	}

	@Override
	public List<Category> searchCategory(Integer start, Integer count) {
		return categoryRepository.searchByCriteria(start, count);
	}

	@Override
	public Integer totalCategories() {
		return categoryRepository.count();
	}
}
