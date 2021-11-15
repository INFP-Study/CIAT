package com.infp.ciat.category.controller.dto;

import com.infp.ciat.category.entity.Category;
import com.infp.ciat.category.entity.Menu;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class MenuSaveRequestDto {

    private String uid;
    private String name;
    private String icon;
    private String url;
    private Long orders;
    private String showYn;

    @Builder
    public MenuSaveRequestDto(String uid, String name, String icon, String url, Long orders, String showYn) {
        this.uid = uid;
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.orders = orders;
        this.showYn = showYn;
    }

    public Menu toEntity() {
        return Menu.builder()
                .uid(uid)
                .name(name)
                .icon(icon)
                .url(url)
                .orders(orders)
                .showYn(showYn)
                .build();
    }
}
