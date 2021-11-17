package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.*;
import com.infp.ciat.category.entity.Category;
import com.infp.ciat.category.entity.Menu;
import com.infp.ciat.category.repository.MenuRepository;
import com.infp.ciat.user.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MenuService {

    @Autowired
    MenuRepository menuRepository;

    @Transactional
    public MenuDto create(MenuSaveRequestDto requestDto, Account account) {
        requestDto.insertAccount(account);
        return new MenuDto(menuRepository.save(requestDto.toEntity()));
    }

    @Transactional(readOnly = true)
    public List<MenuDto> getList() {
        //메뉴 order 순으로 오름차순 정렬
        List<MenuDto> menuDtoList = menuRepository.findAll(Sort.by(Sort.Direction.ASC, "orders"))
                .stream()
                .map(m -> MenuDto.builder()
                        .id(m.getId())
//                        .uid(m.getUid())
                        .name(m.getName())
                        .icon(m.getIcon())
                        .url(m.getUrl())
                        .orders(m.getOrders())
                        .showYn(m.getShowYn())
                        .categoryList(m.getCategoryList())
                        .build())
                .collect(Collectors.toList());

        //메뉴에 속한 Category order 기준으로 오름차순 정렬
        for (MenuDto menuDto : menuDtoList) {
            List<Category> curCategoryList = menuDto.getCategoryList();
            Collections.sort(curCategoryList, Comparator.comparing(Category::getOrders));
        }

        return menuDtoList;
    }

    @Transactional(readOnly = true)
    public MenuDto getDetail(Long id) {
        return menuRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 메뉴가 없습니다."))
                .fromEntity();
    }

    @Transactional
    public Long update(Long id, MenuUpdateRequestDto requestDto, Account account) {
        Menu targetMenu = menuRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 메뉴가 없습니다."));
        requestDto.addUpdater(account);
        targetMenu.update(requestDto);

        return targetMenu.getId();
    }

    @Transactional
    public Long delete(Long id) {
        Menu menu = menuRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "해당 메뉴가 없습니다."));

        if (menu.getShowYn().equals("N")) {
            throw new ResponseStatusException(HttpStatus.NOT_ACCEPTABLE, "이미 삭제된 메뉴입니다.");
        }
        if (menu.getShowYn().equals("Y")) {
            menu.delete();
        }

        return id;
    }
}
