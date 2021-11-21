package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategorySaveRequestDto;
import com.infp.ciat.category.controller.dto.CategoryUpdateRequestDto;
import com.infp.ciat.category.entity.Category;
import com.infp.ciat.category.repository.CategoryRepository;
import com.infp.ciat.user.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto create(CategorySaveRequestDto requestDto, Account account) {
        requestDto.insertAccount(account);
        return new CategoryDto(categoryRepository.save(requestDto.toEntity()));
    }

    @Override
    public List<CategoryDto> getList() {
        return categoryRepository.findAll()
                .stream()
                .map(c -> CategoryDto.builder()
                        .id(c.getId())
//                        .uid(c.getUid())
                        .name(c.getName())
                        .icon(c.getIcon())
                        .url(c.getUrl())
                        .orders(c.getOrders())
                        .menuId(c.getMenu().getId())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getDetail(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 게시글이 없습니다."))
                .fromEntity();
    }

    @Transactional
    @Override
    public Long update(Long id, CategoryUpdateRequestDto requestDto, Account account) {
        Category targetCategory = categoryRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 게시글이 없습니다."));
        requestDto.addUpdater(account);
        targetCategory.update(requestDto);

        return targetCategory.getId();
    }

    @Transactional
    @Override
    public Long delete(Long id) {
        Category targetCategory = categoryRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 게시글이 없습니다."));
        targetCategory.delete();

        return id;
    }
}
