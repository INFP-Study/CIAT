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
    private String showYn;

    @Builder
    public MenuUpdateRequestDto(String name, String icon, String url, Long orders, String showYn) {
        this.name = name;
        this.icon = icon;
        this.url = url;
        this.orders = orders;
        this.showYn = showYn;
    }

}
