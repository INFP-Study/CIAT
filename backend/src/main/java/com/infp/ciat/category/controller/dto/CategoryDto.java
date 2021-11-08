package com.infp.ciat.category.controller.dto;

import com.infp.ciat.category.entity.Category;
import com.infp.ciat.category.entity.Menu;
import com.infp.ciat.user.entity.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class CategoryDto {

    private Long id;
    private String uid;
    private String name;
    private String icon;
    private String url;
    private Long orders;
    private String isActivated;
    private Menu menu;
//    private Account account;

    public CategoryDto(Category category) {
        this.id = category.getId();
        this.uid = category.getUid();
        this.name = category.getName();
        this.icon = category.getIcon();
        this.url = category.getUrl();
        this.orders = category.getOrders();
        this.isActivated = category.getIsActivated();
        this.menu = category.getMenu();
//        this.account = category.getAccount();
    }

    @Builder
    public CategoryDto(Long id, String uid, String name, String icon, String url, Long orders, String isActivated, Menu menu/*, Account account*/) {
        this.id = id;
        this.uid = uid;
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.orders = orders;
        this.isActivated = isActivated;
        this.menu = menu;
//        this.account = account;
    }

}