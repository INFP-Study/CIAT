package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategorySaveRequestDto;
import com.infp.ciat.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto createNewCategory(CategorySaveRequestDto requestDto) {
        return new CategoryDto(categoryRepository.save(requestDto.toEntity()));
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        return categoryRepository.findAll()
                .stream()
                .map(c -> CategoryDto.builder()
                        .id(c.getId())
                        .uid(c.getUid())
                        .name(c.getName())
                        .icon(c.getIcon())
                        .orders(c.getOrders())
                        .isActivated(c.getIsActivated())
                        .build())
                .collect(Collectors.toList());
    }
}
