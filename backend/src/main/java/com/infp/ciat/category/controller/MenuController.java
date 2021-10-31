package com.infp.ciat.category.controller;

import com.infp.ciat.category.controller.dto.MenuDto;
import com.infp.ciat.category.controller.dto.MenuSaveRequestDto;
import com.infp.ciat.category.controller.dto.MenuUpdateRequestDto;
import com.infp.ciat.category.entity.Menu;
import com.infp.ciat.category.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping("/menu")
    public ResponseEntity<MenuDto> newMenu(@RequestBody MenuSaveRequestDto requestDto) {
        MenuDto newMenu = menuService.create(requestDto);
        return new ResponseEntity<>(newMenu, HttpStatus.CREATED);
    }

    @GetMapping("/menu")
    public ResponseEntity<List<MenuDto>> menuList() {
        return new ResponseEntity<>(menuService.getList(), HttpStatus.OK);
    }

    @PutMapping("/menu/{id}")
    public ResponseEntity<Long> updateMenu(@PathVariable Long id, @RequestBody MenuUpdateRequestDto requestDto) {
        return new ResponseEntity<>(menuService.update(id, requestDto), HttpStatus.OK);
    }
}
