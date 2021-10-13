package com.infp.ciat.category.controller.dto;

import com.infp.ciat.category.entity.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CategorySaveRequestDto {

    private String uid;
    private String name;
    private String icon;
    private String url;
    private Long orders;
    private String isActivated;

    @Builder
    public CategorySaveRequestDto(String uid, String name, String icon, String url, Long orders, String isActivated) {
        this.uid = uid;
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.orders = orders;
        this.isActivated = isActivated;
    }

    public Category toEntity() {
        return Category.builder()
                .uid(uid)
                .name(name)
                .icon(icon)
                .url(url)
                .orders(orders)
                .isActivated(isActivated)
                .build();
    }
}
