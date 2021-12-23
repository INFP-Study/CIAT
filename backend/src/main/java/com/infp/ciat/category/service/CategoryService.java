package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategorySaveRequestDto;
import com.infp.ciat.category.controller.dto.CategoryUpdateRequestDto;
import com.infp.ciat.user.entity.Account;

import java.util.List;

public interface CategoryService {

    CategoryDto create(CategorySaveRequestDto requestDto, Account account);

    List<CategoryDto> getList(Long menuId, Long accountId);

    CategoryDto getDetail(Long categoryId, Long accountId);

    Long update(Long id, CategoryUpdateRequestDto requestDto, Account account);

    Long delete(Long id);
}
