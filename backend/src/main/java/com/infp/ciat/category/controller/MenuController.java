package com.infp.ciat.category.controller;

import com.infp.ciat.category.controller.dto.MenuDto;
import com.infp.ciat.category.controller.dto.MenuSaveRequestDto;
import com.infp.ciat.category.controller.dto.MenuUpdateRequestDto;
import com.infp.ciat.category.service.MenuService;
import com.infp.ciat.config.auth.PrincipalDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    MenuService menuService;

    @PostMapping("/api/v1/menu")
    public ResponseEntity<MenuDto> newMenu(@RequestBody MenuSaveRequestDto requestDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        MenuDto newMenu = menuService.create(requestDto, principalDetails.getAccount());
        return new ResponseEntity<>(newMenu, HttpStatus.CREATED);
    }

    @GetMapping("/api/v1/menu")
    public ResponseEntity<List<MenuDto>> menuList() {
        return new ResponseEntity<>(menuService.getList(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/menu/{id}")
    public ResponseEntity<MenuDto> getOneMenu(@PathVariable Long id) {
        return new ResponseEntity<>(menuService.getDetail(id), HttpStatus.OK);
    }

    @PutMapping("/api/v1/menu/{id}")
    public ResponseEntity<Long> updateMenu(@PathVariable Long id, @RequestBody MenuUpdateRequestDto requestDto, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        return new ResponseEntity<>(menuService.update(id, requestDto, principalDetails.getAccount()), HttpStatus.OK);
    }

    @PatchMapping("/api/v1/menu/{id}")
    public ResponseEntity<Long> deleteMenu(@PathVariable Long id) {
        return new ResponseEntity<>(menuService.delete(id), HttpStatus.OK);
    }
}
