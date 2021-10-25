package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategorySaveRequestDto;
import com.infp.ciat.category.controller.dto.CategoryUpdateRequestDto;
import com.infp.ciat.category.entity.Category;
import com.infp.ciat.category.repository.CategoryRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @AfterEach
    void tearDown() {
        categoryRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("카테고리 생성")
    public void createCategory() {
        // given
        String uid = "M001C001";
        String name = "test category";
        String icon = "doc";
        String url = "https://www.naver.com";
        Long orders = 3L;
        String isActivated = "Y";

        CategorySaveRequestDto requestDto = CategorySaveRequestDto.builder()
                .uid(uid)
                .name(name)
                .icon(icon)
                .url(url)
                .orders(orders)
                .isActivated(isActivated)
                .build();

        // when
        CategoryDto newCategory = categoryService.create(requestDto);
        System.out.println(newCategory);

        // then
        List<Category> all = categoryRepository.findAll();

        assertThat(all.get(0).getUid()).isEqualTo(uid);
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getIcon()).isEqualTo(icon);
        assertThat(all.get(0).getUrl()).isEqualTo(url);
        assertThat(all.get(0).getOrders()).isEqualTo(orders);
        assertThat(all.get(0).getIsActivated()).isEqualTo(isActivated);
    }

    @Test
    @DisplayName("카테고리 전체 조회")
    public void getCategoryList() {
        // given
        CategorySaveRequestDto requestDto = CategorySaveRequestDto.builder()
                .uid("M001C001")
                .name("테스트1")
                .icon("test")
                .url("/test")
                .orders(1L)
                .isActivated("Y")
                .build();
        CategorySaveRequestDto requestDto2 = CategorySaveRequestDto.builder()
                .uid("M001C002")
                .name("테스트2")
                .icon("test2")
                .url("/test2")
                .orders(2L)
                .isActivated("N")
                .build();

        categoryService.create(requestDto);
        categoryService.create(requestDto2);

        // when
        List<CategoryDto> all = categoryService.getList();

        // then

        assertThat(all.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("카테고리 하나 조회")
    public void getOneCategory() {
        // given
        String uid = "M001C001";
        String name = "테스트1";
        String icon = "test";
        String url = "/test";
        Long orders = 1L;
        String isActivated = "Y";

        Category savedCat = categoryRepository.save(Category.builder()
                .uid(uid)
                .name(name)
                .icon(icon)
                .url(url)
                .orders(orders)
                .isActivated(isActivated)
                .build());

        // when
        CategoryDto detail = categoryService.getDetail(savedCat.getId());

        // then
        assertThat(detail.getUid()).isEqualTo(uid);
        assertThat(detail.getName()).isEqualTo(name);
        assertThat(detail.getIcon()).isEqualTo(icon);
        assertThat(detail.getUrl()).isEqualTo(url);
        assertThat(detail.getOrders()).isEqualTo(orders);
        assertThat(detail.getIsActivated()).isEqualTo(isActivated);
    }

    @Test
    @DisplayName("카테고리 수정")
    public void updateCategory() {
        // given
        Category savedCat = categoryRepository.save(Category.builder()
                .uid("M001C001")
                .name("테스트1")
                .icon("test")
                .url("/test")
                .orders(1L)
                .isActivated("Y")
                .build());

        Long updateId = savedCat.getId();
        String newName = "test22";
        String inactivate = "N";

        CategoryUpdateRequestDto requestDto = CategoryUpdateRequestDto.builder()
                .name(newName)
                .icon("test")
                .url("/test")
                .orders(1L)
                .isActivated(inactivate)
                .build();

        // when
        categoryService.update(updateId, requestDto);

        // then
        List<Category> all = categoryRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(newName);
        assertThat(all.get(0).getIsActivated()).isEqualTo(inactivate);
    }

    @Test
    @DisplayName("카테고리 삭제")
    public void deleteCategory() {
        // given
        Category savedCat1 = categoryRepository.save(Category.builder()
                .uid("M001C001")
                .name("테스트1")
                .icon("test")
                .url("/test")
                .orders(1L)
                .isActivated("Y")
                .build());
        Category savedCat2 = categoryRepository.save(Category.builder()
                .uid("M001C002")
                .name("테스트2")
                .icon("test2")
                .url("/test2")
                .orders(2L)
                .isActivated("Y")
                .build());

        // when
        categoryService.delete(savedCat1.getId());

        // then
        List<Category> all = categoryRepository.findAll();
        assertThat(all.size()).isEqualTo(1);
        assertThat(all.get(0).getUid()).isEqualTo("M001C002");
    }

}