package com.infp.ciat.category.controller.dto;

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
    private String isActivated;

    @Builder
    public MenuUpdateRequestDto(String name, String icon, String url, Long orders, String isActivated) {
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.orders = orders;
        this.isActivated = isActivated;
    }

}
