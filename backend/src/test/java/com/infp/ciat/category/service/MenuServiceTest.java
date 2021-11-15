package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.*;
import com.infp.ciat.category.entity.Category;
import com.infp.ciat.category.entity.Menu;
import com.infp.ciat.category.repository.CategoryRepository;
import com.infp.ciat.category.repository.MenuRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private MenuRepository menuRepository;

    @AfterEach
    void tearDown() {
        menuRepository.deleteAll();
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
        String showYn = "Y";

        MenuSaveRequestDto requestDto = MenuSaveRequestDto.builder()
                .uid(uid)
                .name(name)
                .icon(icon)
                .url(url)
                .orders(orders)
                .showYn(showYn)
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
        assertThat(all.get(0).getShowYn()).isEqualTo(showYn);
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
                .showYn("Y")
                .build();
        MenuSaveRequestDto requestDto2 = MenuSaveRequestDto.builder()
                .uid("M001")
                .name("테스트2")
                .icon("test2")
                .url("/test2")
                .orders(2L)
                .showYn("N")
                .build();

        menuService.create(requestDto);
        menuService.create(requestDto2);

        // when
        List<MenuDto> all = menuService.getList();

        // then
        assertThat(all.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("메뉴 하나 조회")
    public void getOneMenu() {
        // given
        String uid = "M001";
        String name = "테스트1";
        String icon = "test";
        String url = "/test";
        Long orders = 1L;
        String showYn = "Y";

        Menu savedMenu = menuRepository.save(Menu.builder()
                .uid(uid)
                .name(name)
                .icon(icon)
                .url(url)
                .orders(orders)
                .showYn(showYn)
                .build());

        // when
        MenuDto detail = menuService.getDetail(savedMenu.getId());

        // then
        assertThat(detail.getUid()).isEqualTo(uid);
        assertThat(detail.getName()).isEqualTo(name);
        assertThat(detail.getIcon()).isEqualTo(icon);
        assertThat(detail.getUrl()).isEqualTo(url);
        assertThat(detail.getOrders()).isEqualTo(orders);
        assertThat(detail.getShowYn()).isEqualTo(showYn);
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
                .showYn("Y")
                .build());

        Long updateId = savedMenu.getId();
        String newName = "test22";
        String showYn = "N";

        MenuUpdateRequestDto requestDto = MenuUpdateRequestDto.builder()
                .name(newName)
                .icon("test")
                .url("/test")
                .orders(1L)
                .showYn(showYn)
                .build();

        // when
        menuService.update(updateId, requestDto);

        // then
        List<Menu> all = menuRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(newName);
        assertThat(all.get(0).getShowYn()).isEqualTo(showYn);
    }

    @Test
    @DisplayName("메뉴 삭제")
    public void deleteMenu() {
        // given
        Menu savedMenu1 = menuRepository.save(Menu.builder()
                .uid("M001")
                .name("테스트1")
                .icon("test")
                .url("/test")
                .orders(1L)
                .showYn("Y")
                .build());
        Menu savedMenu2 = menuRepository.save(Menu.builder()
                .uid("M002")
                .name("테스트2")
                .icon("test2")
                .url("/test2")
                .orders(2L)
                .showYn("N")
                .build());

        // when
        menuService.delete(savedMenu1.getId());

        // then
        String updatedShowYn = savedMenu1.getShowYn();
        List<Menu> all = menuRepository.findAll();
        assertThat(all.get(0).getShowYn()).isEqualTo("N");
        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> menuService.delete(savedMenu2.getId()));
        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
    }

    @Test
    @DisplayName("메뉴 및 카테고리 순서대로 조회")
    public void getMenuAndCatInOrder() {
        // given
        MenuSaveRequestDto requestDto = MenuSaveRequestDto.builder()
                .uid("M001")
                .name("hello")
                .icon("icon")
                .url("/url")
                .orders(2L)
                .showYn("Y")
                .build();
        MenuSaveRequestDto requestDto2 = MenuSaveRequestDto.builder()
                .uid("M002")
                .name("hello")
                .icon("icon")
                .url("/url")
                .orders(1L)
                .showYn("Y")
                .build();
        menuService.create(requestDto);
        menuService.create(requestDto2);

        Menu menu = menuRepository.findAll().get(0);

        CategorySaveRequestDto catRequestDto = CategorySaveRequestDto.builder()
                .uid("M001C001")
                .name("테스트1")
                .icon("test")
                .url("/test")
                .orders(2L)
                .showYn("Y")
                .menu(menu)
                .build();
        CategorySaveRequestDto catRequestDto2 = CategorySaveRequestDto.builder()
                .uid("M001C002")
                .name("테스트2")
                .icon("test2")
                .url("/test2")
                .orders(3L)
                .showYn("N")
                .menu(menu)
                .build();
        CategorySaveRequestDto catRequestDto3 = CategorySaveRequestDto.builder()
                .uid("M001C003")
                .name("테스트2")
                .icon("test2")
                .url("/test2")
                .orders(1L)
                .showYn("N")
                .menu(menu)
                .build();

        categoryRepository.save(catRequestDto.toEntity());
        categoryRepository.save(catRequestDto2.toEntity());
        categoryRepository.save(catRequestDto3.toEntity());

        // when
        List<MenuDto> list = menuService.getList();
        List<Category> categoryList = list.get(1).getCategoryList();

        // then
        assertThat(list.get(0).getUid()).isEqualTo("M002");
        assertThat(list.get(1).getUid()).isEqualTo("M001");

        assertThat(categoryList.get(0).getUid()).isEqualTo("M001C003");
        assertThat(categoryList.get(1).getUid()).isEqualTo("M001C001");
        assertThat(categoryList.get(2).getUid()).isEqualTo("M001C002");
    }
}
