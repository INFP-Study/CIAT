package com.infp.ciat.category.controller;

import com.infp.ciat.category.controller.dto.MenuDto;
import com.infp.ciat.category.controller.dto.MenuSaveRequestDto;
import com.infp.ciat.category.entity.Menu;
import com.infp.ciat.category.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping("/menu")
    public ResponseEntity<MenuDto> newCategory(@RequestBody MenuSaveRequestDto requestDto) {
        MenuDto newMenu = menuService.create(requestDto);
        return new ResponseEntity<>(newMenu, HttpStatus.CREATED);
    }
}
