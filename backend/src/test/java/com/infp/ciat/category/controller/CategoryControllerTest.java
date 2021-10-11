package com.infp.ciat.category.controller;

import com.infp.ciat.category.controller.dto.CategorySaveRequestDto;
import com.infp.ciat.category.entity.Category;
import com.infp.ciat.category.repository.CategoryRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CategoryControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    @DisplayName("새_카테고리_추가")
    public void newCategoryTest() {
        // given
        String name = "TEST Category";
        Long parentId = 0L;

        CategorySaveRequestDto requestDto = CategorySaveRequestDto.builder()
                .name(name)
                .parentId(parentId)
                .build();

        String url = "http://localhost:" + port + "/category";

        // when
        ResponseEntity<Category> responseEntity = restTemplate.postForEntity(url, requestDto, Category.class);

        // then
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

        List<Category> all = categoryRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getParentId()).isEqualTo(parentId);
    }

}