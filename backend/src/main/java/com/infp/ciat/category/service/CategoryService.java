package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategorySaveRequestDto;
import com.infp.ciat.category.controller.dto.CategoryUpdateRequestDto;

import java.util.List;

public interface CategoryService {

    CategoryDto create(CategorySaveRequestDto requestDto);

    List<CategoryDto> getList();

    Long update(Long id, CategoryUpdateRequestDto requestDto);

    Long delete(Long id);
}
