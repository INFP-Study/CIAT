package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategorySaveRequestDto;
import com.infp.ciat.category.controller.dto.CategoryUpdateRequestDto;
import com.infp.ciat.category.entity.Category;
import com.infp.ciat.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto create(CategorySaveRequestDto requestDto) {
        return new CategoryDto(categoryRepository.save(requestDto.toEntity()));
    }

    @Override
    public List<CategoryDto> getList() {
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

    @Transactional
    @Override
    public Long update(Long id, CategoryUpdateRequestDto requestDto) {
        Category targetCategory = categoryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 게시물입니다."));
        targetCategory.update(requestDto);

        return targetCategory.getId();
    }
}
