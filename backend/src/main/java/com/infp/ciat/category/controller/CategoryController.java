package com.infp.ciat.category.controller;

import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategorySaveRequestDto;
import com.infp.ciat.category.controller.dto.CategoryUpdateRequestDto;
import com.infp.ciat.category.service.CategoryService;
import com.infp.ciat.config.auth.PrincipalDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/api/v1")
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> newCategory(@RequestBody CategorySaveRequestDto requestDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        CategoryDto newCategory = categoryService.create(requestDto, principalDetails.getAccount());

        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @GetMapping("/categories") // 식물관리 제외한 나머지 메뉴
    public ResponseEntity<List<CategoryDto>> categoryList(@RequestParam Long menuId, @RequestBody Long accountId) {
        return new ResponseEntity<>(categoryService.getList(menuId, accountId), HttpStatus.OK);
    }

    @GetMapping("/api/v1/category/{id}")
    public ResponseEntity<CategoryDto> getOneCategory(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.getDetail(id), HttpStatus.OK);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Long> updateCategory(@PathVariable Long id, @RequestBody CategoryUpdateRequestDto requestDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        Long updateResult = categoryService.update(id, requestDto, principalDetails.getAccount());
        return new ResponseEntity<>(updateResult, HttpStatus.OK);
    }

    @PatchMapping("/category/{id}")
    public ResponseEntity<Long> deleteCategory(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.delete(id), HttpStatus.OK);
    }

}
