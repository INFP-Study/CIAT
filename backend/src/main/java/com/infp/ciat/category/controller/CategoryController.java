package com.infp.ciat.category.controller;

import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategorySaveRequestDto;
import com.infp.ciat.category.controller.dto.CategoryUpdateRequestDto;
import com.infp.ciat.category.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> newCategory(@RequestBody CategorySaveRequestDto requestDto) {
        CategoryDto newCategory = categoryService.createNewCategory(requestDto);

        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> categoryList() {
        return new ResponseEntity<>(categoryService.getAllCategories(), HttpStatus.OK);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Long> updateCategory(@PathVariable Long id, @RequestBody CategoryUpdateRequestDto requestDto) {
        return new ResponseEntity<>(categoryService.updateCategory(id, requestDto), HttpStatus.OK);
    }


}
