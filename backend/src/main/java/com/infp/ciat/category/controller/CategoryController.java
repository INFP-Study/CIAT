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
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/api/v1/category")
    public ResponseEntity<CategoryDto> newCategory(@RequestBody CategorySaveRequestDto requestDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        CategoryDto newCategory = categoryService.create(requestDto, principalDetails.getAccount());

        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/category")
    public ResponseEntity<List<CategoryDto>> categoryList() {
        return new ResponseEntity<>(categoryService.getList(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/category/{id}")
    public ResponseEntity<CategoryDto> getOneCategory(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.getDetail(id), HttpStatus.OK);
    }

    @PutMapping("/api/v1/category/{id}")
    public ResponseEntity<Long> updateCategory(@PathVariable Long id, @RequestBody CategoryUpdateRequestDto requestDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        Long updateResult = categoryService.update(id, requestDto, principalDetails.getAccount());
        return new ResponseEntity<>(updateResult, HttpStatus.OK);
    }

    @PatchMapping("/api/v1/category/{id}")
    public ResponseEntity<Long> deleteCategory(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.delete(id), HttpStatus.OK);
    }

}
