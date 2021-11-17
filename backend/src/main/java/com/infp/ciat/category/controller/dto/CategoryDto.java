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
//    private String uid;
    private String name;
    private String icon;
    private String url;
    private Long orders;
    private String showYn;
    private Menu menu;
    private Account account;
    private Account updater;

    public CategoryDto(Category category) {
        this.id = category.getId();
//        this.uid = category.getUid();
        this.name = category.getName();
        this.icon = category.getIcon();
        this.url = category.getUrl();
        this.orders = category.getOrders();
        this.showYn = category.getShowYn();
        this.menu = category.getMenu();
        this.account = category.getAccount();
        this.updater = category.getUpdater();
    }

    @Builder
    public CategoryDto(Long id,/* String uid,*/ String name, String icon, String url, Long orders, String showYn, Menu menu, Account account, Account updater) {
        this.id = id;
//        this.uid = uid;
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.orders = orders;
        this.showYn = showYn;
        this.menu = menu;
        this.account = account;
        this.updater = updater;
    }

}
