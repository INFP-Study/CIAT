package com.infp.ciat.category.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategoryUpdateRequestDto;
import com.infp.ciat.category.controller.dto.MenuDto;
import com.infp.ciat.category.controller.dto.MenuUpdateRequestDto;
import com.infp.ciat.common.BaseTimeEntity;
import com.infp.ciat.user.entity.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity
public class Menu extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String uid;

    private String name;

    private String icon;

    private String url;

    private Long orders;

    private String showYn;

    //categoryList.size() == 0 일 경우
    //private String isGetCategory; // T or F
    //menu 0 category 0 F > T
    //menu 0

    @OneToMany(mappedBy = "menu", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnoreProperties({"menu"})
    private List<Category> categoryList;

    @ManyToOne
    @JoinColumn(name = "accountId")
    @JsonIgnore
    private Account account;

    @ManyToOne
    @JoinColumn(name = "updated_account_id")
    @JsonIgnore
    private Account updater;

    @Builder
    public Menu(/*String uid, */String name, String icon, String url, Long orders, String showYn, Account account) {
//        this.uid = uid;
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.orders = orders;
        this.showYn = showYn;
        this.account = account;
    }

    public MenuDto fromEntity() {
        return MenuDto.builder()
                .id(id)
//                .uid(uid)
                .name(name)
                .icon(icon)
                .url(url)
                .orders(orders)
                .categoryList(categoryList)
                .build();
    }

    public void update(MenuUpdateRequestDto requestDto) {
        this.name = requestDto.getName();
        this.icon = requestDto.getIcon();
        this.url = requestDto.getUrl();
        this.orders = requestDto.getOrders();
        this.updater = requestDto.getUpdater();
    }

    public void delete() {
        this.showYn = "N";
    }
}
