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
        CategoryDto newCategory = categoryService.create(requestDto);

        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> categoryList() {
        return new ResponseEntity<>(categoryService.getList(), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDto> getOneCategory(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.getDetail(id), HttpStatus.OK);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<Long> updateCategory(@PathVariable Long id, @RequestBody CategoryUpdateRequestDto requestDto) {
        return new ResponseEntity<>(categoryService.update(id, requestDto), HttpStatus.OK);
    }

    @PatchMapping("/category/{id}")
    public ResponseEntity<Long> deleteCategory(@PathVariable Long id) {
        return new ResponseEntity<>(categoryService.delete(id), HttpStatus.OK);
    }

}
