package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.*;
import com.infp.ciat.category.entity.Category;
import com.infp.ciat.category.entity.Menu;
import com.infp.ciat.category.repository.MenuRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    @Autowired
    private MenuRepository menuRepository;

    @AfterEach
    void tearDown() {
        menuRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("메뉴 생성")
    public void createMenu() {
        // given
        String uid = "M001";
        String name = "test menu";
        String icon = "doc";
        String url = "https://www.naver.com";
        Long orders = 3L;
        String isActivated = "Y";

        MenuSaveRequestDto requestDto = MenuSaveRequestDto.builder()
                .uid(uid)
                .name(name)
                .icon(icon)
                .url(url)
                .orders(orders)
                .isActivated(isActivated)
                .build();

        // when
        MenuDto newMenu = menuService.create(requestDto);
        System.out.println(newMenu);

        // then
        List<Menu> all = menuRepository.findAll();

        assertThat(all.get(0).getUid()).isEqualTo(uid);
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getIcon()).isEqualTo(icon);
        assertThat(all.get(0).getUrl()).isEqualTo(url);
        assertThat(all.get(0).getOrders()).isEqualTo(orders);
        assertThat(all.get(0).getIsActivated()).isEqualTo(isActivated);
    }

    @Test
    @DisplayName("메뉴 전체 조회")
    public void getMenuList() {
        // given
        MenuSaveRequestDto requestDto = MenuSaveRequestDto.builder()
                .uid("M001")
                .name("테스트1")
                .icon("test")
                .url("/test")
                .orders(1L)
                .isActivated("Y")
                .build();
        MenuSaveRequestDto requestDto2 = MenuSaveRequestDto.builder()
                .uid("M001")
                .name("테스트2")
                .icon("test2")
                .url("/test2")
                .orders(2L)
                .isActivated("N")
                .build();

        menuService.create(requestDto);
        menuService.create(requestDto2);

        // when
        List<MenuDto> all = menuService.getList();

        // then
        assertThat(all.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("메뉴 수정")
    public void updateMenu() {
        // given
        Menu savedMenu = menuRepository.save(Menu.builder()
                .uid("M001")
                .name("테스트1")
                .icon("test")
                .url("/test")
                .orders(1L)
                .isActivated("Y")
                .build());

        Long updateId = savedMenu.getId();
        String newName = "test22";
        String inactivate = "N";

        MenuUpdateRequestDto requestDto = MenuUpdateRequestDto.builder()
                .name(newName)
                .icon("test")
                .url("/test")
                .orders(1L)
                .isActivated(inactivate)
                .build();

        // when
        menuService.update(updateId, requestDto);

        // then
        List<Menu> all = menuRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(newName);
        assertThat(all.get(0).getIsActivated()).isEqualTo(inactivate);
    }
}
