package com.infp.ciat.category.entity;

import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategoryUpdateRequestDto;
import com.infp.ciat.common.BaseTimeEntity;
import com.infp.ciat.user.entity.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uid;

    private String name;

    private String icon;

    private String url;

    private Long orders;

    private String isActivated;

    @ManyToOne
    @JoinColumn(name = "menu_uid")
    private Menu menu;

//    @ManyToOne
//    @JoinColumn(name = "accountId")
//    private Account account;

    @Builder
    public Category(String uid, String name, String icon, String url, Long orders, String isActivated, Menu menu/*, Account account*/) {
        this.uid = uid;
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.orders = orders;
        this.isActivated = isActivated;
        this.menu = menu;
//        this.account = account;
    }

    public CategoryDto fromEntity() {
        return CategoryDto.builder()
                .uid(uid)
                .name(name)
                .icon(icon)
                .url(url)
                .orders(orders)
                .isActivated(isActivated)
                .menu(menu)
//                .account(account)
                .build();
    }

    public void update(CategoryUpdateRequestDto requestDto) {
        this.name = requestDto.getName();
        this.icon = requestDto.getIcon();
        this.url = requestDto.getUrl();
        this.orders = requestDto.getOrders();
        this.isActivated = requestDto.getIsActivated();
        this.menu = requestDto.getMenu();
//        this.account = requestDto.getAccount();
    }

}
