package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.MenuDto;
import com.infp.ciat.category.controller.dto.MenuSaveRequestDto;
import com.infp.ciat.category.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    public MenuDto create(MenuSaveRequestDto requestDto) {
        return new MenuDto(menuRepository.save(requestDto.toEntity()));
    }

    public List<MenuDto> getList() {
        return menuRepository.findAll()
                .stream()
                .map(m -> MenuDto.builder()
                        .id(m.getId())
                        .uid(m.getUid())
                        .name(m.getName())
                        .icon(m.getIcon())
                        .orders(m.getOrders())
                        .isActivated(m.getIsActivated())
                        .build())
                .collect(Collectors.toList());
    }

}
