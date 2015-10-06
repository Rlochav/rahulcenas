package com.ceostocks.application.mapper;

import java.util.List;

import com.ceostocks.common.dto.CategoryDTO;
import com.ceostocks.model.ecom.Category;

public class CategoryDTOMapper {

	public static Category categoryDtoToEntityMapper(CategoryDTO categoryDTO) {
		Category pCtg = new Category();
		pCtg.setCategoryCode(categoryDTO.getCategoryCode());
		pCtg.setCategoryName(categoryDTO.getCategoryName());
		return pCtg;
	}

	public static CategoryDTO categoryEntityToDtoMapper(Category pCtg) {
		CategoryDTO cDto = new CategoryDTO();
		cDto.setCategoryId(pCtg.getCategoryId().toString());
		cDto.setCategoryCode(pCtg.getCategoryCode());
		cDto.setCategoryName(pCtg.getCategoryName());
		/*
		 * cDto.setCreatedBy(pCtg.getCreatedBy().toString());
		 * cDto.setCreatedDate(DateUtil.parseDateToString(pCtg.getCreatedDate(),
		 * DateUtil.dateTimeFormat));
		 * cDto.setUpdatedBy(pCtg.getUpdatedBy().toString());
		 * cDto.setUpdatedDate(DateUtil.parseDateToString(pCtg.getUpdatedDate(),
		 * DateUtil.dateTimeFormat));
		 */
		return cDto;
	}

	public static CategoryDTO categoryEntityListToDtoMapper(List<Category> pCtgs) {
		CategoryDTO dto = new CategoryDTO();
		if (pCtgs != null) {
			pCtgs.forEach(pCtg -> {
				CategoryDTO cDto = new CategoryDTO();
				cDto.setCategoryId(pCtg.getCategoryId().toString());
				cDto.setCategoryCode(pCtg.getCategoryCode());
				cDto.setCategoryName(pCtg.getCategoryName());
				/*
				 * cDto.setCreatedBy(pCtg.getCreatedBy().toString());
				 * cDto.setCreatedDate
				 * (DateUtil.parseDateToString(pCtg.getCreatedDate(),
				 * DateUtil.dateTimeFormat));
				 * cDto.setUpdatedBy(pCtg.getUpdatedBy().toString());
				 * cDto.setUpdatedDate
				 * (DateUtil.parseDateToString(pCtg.getUpdatedDate(),
				 * DateUtil.dateTimeFormat));
				 */
				dto.addCategoryDTO(cDto);
			});
		}

		return dto;
	}
}
