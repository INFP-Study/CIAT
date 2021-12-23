package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategorySaveRequestDto;
import com.infp.ciat.category.controller.dto.CategoryUpdateRequestDto;
import com.infp.ciat.category.entity.Category;
import com.infp.ciat.category.repository.CategoryRepository;
import com.infp.ciat.category.repository.MenuRepository;
import com.infp.ciat.user.entity.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final MenuRepository menuRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public CategoryDto create(CategorySaveRequestDto requestDto, Account account) {
        requestDto.insertAccount(account);
        return new CategoryDto(categoryRepository.save(requestDto.toEntity()));
    }

    @Override
    public List<CategoryDto> getList(Long menuId, Long accountId) {

        List<Category> categoryList;

        if ("식물관리".equals(menuRepository.findByIdNotDeleted(menuId).get().getName())) {
            categoryList = categoryRepository.findAllNotDeletedOnlyForPlantMenu(menuId, accountId);
        } else {
            categoryList = categoryRepository.findAllNotDeleted(menuId);
        }

        return categoryList.stream()
                .map(c -> new CategoryDto(c))
                .sorted(Comparator.comparing(CategoryDto::getOrders))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto getDetail(Long categoryId, Long accountId) {

        Optional<Category> category;

        if ("식물관리".equals(categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 메뉴입니다."))
                .getMenu().getName())) {
            category = categoryRepository.findByIdNotDeletedOnlyForPlantMenu(categoryId, accountId);
        } else {
            category = categoryRepository.findByIdNotDeleted(categoryId);
        }

        return category.orElseThrow(()->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "존재하지 않는 카테고리거나 접근 권한이 없습니다."))
                .fromEntity();
    }

    @Transactional
    @Override
    public Long update(Long id, CategoryUpdateRequestDto requestDto, Account account) {
        Category targetCategory = categoryRepository.findByIdNotDeleted(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 게시글이 없습니다."));
        requestDto.addUpdater(account);
        targetCategory.update(requestDto);

        return targetCategory.getId();
    }

    @Transactional
    @Override
    public Long delete(Long id) {
        Category targetCategory = categoryRepository.findByIdNotDeleted(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 게시글이 없습니다."));

        if (targetCategory.getShowYn().equals("N")) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "이미 삭제된 메뉴입니다.");
        }
        targetCategory.delete();

        return id;
    }
}
