package com.infp.ciat.category.controller.dto;

import com.infp.ciat.category.entity.Category;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CategoryDto {

    private Long id;
//    private String uid;
    private String name;
    private String icon;
    private String url;
    private Long orders;
    private Long menuId;
    private String menuName;

    public CategoryDto(Category category) {
        this.id = category.getId();
//        this.uid = category.getUid();
        this.name = category.getName();
        this.icon = category.getIcon();
        this.url = category.getUrl();
        this.orders = category.getOrders();
        this.menuId = category.getMenu().getId();
        this.menuName = category.getMenu().getName();
    }

    @Builder
    public CategoryDto(Long id,/* String uid,*/ String name, String icon, String url, Long orders, Long menuId, String menuName) {
        this.id = id;
//        this.uid = uid;
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.orders = orders;
        this.menuId = menuId;
        this.menuName = menuName;
    }

}
