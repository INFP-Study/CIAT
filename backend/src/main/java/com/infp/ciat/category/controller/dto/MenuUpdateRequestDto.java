package com.infp.ciat.category.controller.dto;

import com.infp.ciat.user.entity.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class MenuUpdateRequestDto {

    private String name;
    private String icon;
    private String url;
    private Long orders;
    private Account updater;

    @Builder
    public MenuUpdateRequestDto(String name, String icon, String url, Long orders, Account updater) {
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.orders = orders;
        this.updater = updater;
    }

    public void addUpdater(Account updater) {
        this.updater = updater;
    }

}
