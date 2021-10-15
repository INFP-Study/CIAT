package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategorySaveRequestDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createNewCategory(CategorySaveRequestDto requestDto);

    List<CategoryDto> getAllCategories();
}
