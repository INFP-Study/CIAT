package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategorySaveRequestDto;

public interface CategoryService {

    CategoryDto createNewCategory(CategorySaveRequestDto requestDto);
}
