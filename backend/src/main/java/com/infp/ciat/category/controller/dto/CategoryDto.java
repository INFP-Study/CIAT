package com.infp.ciat.category.controller.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
public class CategoryDto {

    private Long id;
    private String name;
    private Long parentId;
    private List<CategoryDto> subCategories;

    @Builder
    public CategoryDto(Long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }
}
