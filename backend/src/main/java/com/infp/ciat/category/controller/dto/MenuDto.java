package com.infp.ciat.category.controller.dto;

import com.infp.ciat.category.entity.Category;
import com.infp.ciat.category.entity.Menu;
import com.infp.ciat.user.entity.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class MenuDto {

    private Long id;
//    private String uid;
    private String name;
    private String icon;
    private String url;
    private Long orders;
    private List<Category> categoryList;

    public MenuDto(Menu menu) {
        this.id = menu.getId();
//        this.uid = menu.getUid();
        this.name = menu.getName();
        this.icon = menu.getIcon();
        this.url = menu.getUrl();
        this.orders = menu.getOrders();
        this.categoryList = menu.getCategoryList();
    }

    @Builder
    public MenuDto(Long id,/* String uid,*/ String name, String icon, String url, Long orders, List<Category> categoryList) {
        this.id = id;
//        this.uid = uid;
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.orders = orders;
        this.categoryList = categoryList;
    }
}
