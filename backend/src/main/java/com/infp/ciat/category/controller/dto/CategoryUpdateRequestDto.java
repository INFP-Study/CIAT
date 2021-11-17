package com.infp.ciat.category.controller.dto;

import com.infp.ciat.category.entity.Menu;
import com.infp.ciat.user.entity.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class CategoryUpdateRequestDto {

    private String name;
    private String icon;
    private String url;
    private Long orders;
    private Menu menu;
    private Account updater;

    @Builder
    public CategoryUpdateRequestDto(String name, String icon, String url, Long orders, Menu menu, Account updater) {
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.orders = orders;
        this.menu = menu;
        this.updater = updater;
    }

    public void addUpdater(Account updater) {
        this.updater = updater;
    }

}
