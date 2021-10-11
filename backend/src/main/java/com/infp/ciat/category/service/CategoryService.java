package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategorySaveRequestDto;
import com.infp.ciat.category.entity.Category;

import java.util.List;

public interface CategoryService {

    Category createNewCategory(CategorySaveRequestDto requestDto);
}
