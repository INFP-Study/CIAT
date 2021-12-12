package com.infp.ciat.category.controller;

import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategorySaveRequestDto;
import com.infp.ciat.category.controller.dto.CategoryUpdateRequestDto;
import com.infp.ciat.category.service.CategoryService;
import com.infp.ciat.config.auth.PrincipalDetails;
import com.infp.ciat.user.entity.Account;
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

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> categoryList(@RequestParam Long menuId, @AuthenticationPrincipal PrincipalDetails principalDetails) {

        Long accountId = getLoginedUserId(principalDetails);

        return new ResponseEntity<>(categoryService.getList(menuId, accountId), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDto> getOneCategory(@PathVariable Long id, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        Long accountId = getLoginedUserId(principalDetails);
        return new ResponseEntity<>(categoryService.getDetail(id, accountId), HttpStatus.OK);
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

    private Long getLoginedUserId(PrincipalDetails principalDetails) {

        return principalDetails == null ? 0L : principalDetails.getAccount().getId();
    }

}
