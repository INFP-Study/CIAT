package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.MenuDto;
import com.infp.ciat.category.controller.dto.MenuSaveRequestDto;
import com.infp.ciat.category.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    public MenuDto create(MenuSaveRequestDto requestDto) {
        return new MenuDto(menuRepository.save(requestDto.toEntity()));
    }

}
