package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.CategoryUpdateRequestDto;
import com.infp.ciat.category.controller.dto.MenuDto;
import com.infp.ciat.category.controller.dto.MenuSaveRequestDto;
import com.infp.ciat.category.controller.dto.MenuUpdateRequestDto;
import com.infp.ciat.category.entity.Category;
import com.infp.ciat.category.entity.Menu;
import com.infp.ciat.category.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

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

    @Transactional
    public Long update(Long id, MenuUpdateRequestDto requestDto) {
        Menu targetMenu = menuRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 게시글이 없습니다."));
        targetMenu.update(requestDto);

        return targetMenu.getId();
    }

}
