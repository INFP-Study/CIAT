package com.infp.ciat.category.controller.dto;

import com.infp.ciat.category.entity.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CategorySaveRequestDto {

    private String name;
    private Long parentId;

    @Builder
    public CategorySaveRequestDto(String name, Long parentId) {
        this.name = name;
        this.parentId = parentId;
    }

    public Category toEntity() {
        return Category.builder()
                .name(name)
                .parentId(parentId)
                .build();
    }
}
