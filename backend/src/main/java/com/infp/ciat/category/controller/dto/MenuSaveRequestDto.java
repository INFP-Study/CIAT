package com.infp.ciat.category.controller.dto;

import com.infp.ciat.category.entity.Category;
import com.infp.ciat.category.entity.Menu;
import com.infp.ciat.user.entity.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MenuSaveRequestDto {

//    private String uid;
    private String name;
    private String icon;
    private String url;
    private Long orders;
    private Account account;

    @Builder
    public MenuSaveRequestDto(/*String uid,*/String name, String icon, String url, Long orders, Account account) {
//        this.uid = uid;
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.orders = orders;
        this.account = account;
    }

    public Menu toEntity() {
        return Menu.builder()
//                .uid(uid)
                .name(name)
                .icon(icon)
                .url(url)
                .orders(orders)
                .account(account)
                .build();
    }

    public void insertAccount(Account account) {
        this.account = account;
    }

}
