package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.CategoryDto;
import com.infp.ciat.category.controller.dto.CategorySaveRequestDto;
import com.infp.ciat.category.controller.dto.CategoryUpdateRequestDto;
import com.infp.ciat.category.controller.dto.MenuSaveRequestDto;
import com.infp.ciat.category.entity.Category;
import com.infp.ciat.category.entity.Menu;
import com.infp.ciat.category.repository.CategoryRepository;
import com.infp.ciat.category.repository.MenuRepository;
import com.infp.ciat.user.controller.dto.request.SignupRequestDTO;
import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.repository.AccountRepository;
import com.infp.ciat.user.service.AccountService;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CategoryServiceTest {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private MenuRepository menuRepository;

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @BeforeAll
    public static void beforeAll() {
        String jasypt_password = System.getenv("jasypt.encryptor.password");
        System.setProperty("jasypt.encryptor.password", jasypt_password);
    }

    @BeforeEach
    void createMenu() {
        SignupRequestDTO signupRequestDTO = SignupRequestDTO.builder()
                .email("test@test.com")
                .password("test_password")
                .nickname("test_nickname")
                .build();

        //when
        accountService.signUp(signupRequestDTO);

        MenuSaveRequestDto menuSaveRequestDto = MenuSaveRequestDto.builder()
//                .uid("M001")
                .name("test menu")
                .icon("test")
                .url("https://www.naver.com")
                .orders(1L)
                .build();

        menuRepository.save(menuSaveRequestDto.toEntity());
    }

    @AfterEach
    void tearDown() {
        categoryRepository.deleteAllInBatch();
        accountRepository.deleteAll();
    }

    @Test
    @DisplayName("카테고리 생성")
    public void createCategory() {
        // given
        String name = "test category";
        String icon = "doc";
        String url = "/test";
        Long orders = 1L;
        Menu menu = menuRepository.findAll().get(0);
        Account account = accountRepository.findAll().get(0);

        CategorySaveRequestDto requestDto = CategorySaveRequestDto.builder()
//                .uid(uid)
                .name(name)
                .icon(icon)
                .url(url)
                .orders(orders)
                .menu(menu)
                .account(account)
                .build();

        // when
        categoryService.create(requestDto, account);

        // then
        List<Category> all = categoryRepository.findAll();

//        assertThat(all.get(0).getUid()).isEqualTo(uid);
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getIcon()).isEqualTo(icon);
        assertThat(all.get(0).getUrl()).isEqualTo(url);
        assertThat(all.get(0).getOrders()).isEqualTo(orders);
    }

    @Test
    @DisplayName("카테고리 전체 조회")
    public void getCategoryList() {
        // given
        Account account = accountRepository.findAll().get(0);

        CategorySaveRequestDto requestDto = CategorySaveRequestDto.builder()
//                .uid("M001C001")
                .name("테스트1")
                .icon("test")
                .url("/test")
                .orders(1L)
                .menu(menuRepository.findAll().get(0))
                .account(account)
                .build();
        CategorySaveRequestDto requestDto2 = CategorySaveRequestDto.builder()
//                .uid("M001C002")
                .name("테스트2")
                .icon("test2")
                .url("/test2")
                .orders(2L)
                .menu(menuRepository.findById(1L).get())
                .account(account)
                .build();

        categoryService.create(requestDto, account);
        categoryService.create(requestDto2, account);

        // when
//        List<CategoryDto> all = categoryService.getList();

        // then
//        assertThat(all.size()).isEqualTo(2);
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
        Menu menu = menuRepository.findAll().get(0);
        Account account = accountRepository.findAll().get(0);

        Category savedCat = categoryRepository.save(Category.builder()
//                .uid(uid)
                .name(name)
                .icon(icon)
                .url(url)
                .orders(orders)
                .menu(menu)
                .account(account)
                .build());

        // when
//        CategoryDto detail = categoryService.getDetail(savedCat.getId());

        // then
//        assertThat(detail.getUid()).isEqualTo(uid);
//        assertThat(detail.getName()).isEqualTo(name);
//        assertThat(detail.getIcon()).isEqualTo(icon);
//        assertThat(detail.getUrl()).isEqualTo(url);
//        assertThat(detail.getOrders()).isEqualTo(orders);
    }

    @Test
    @DisplayName("카테고리 수정")
    public void updateCategory() {
        // given
        Account account = accountRepository.findAll().get(0);

        Category savedCat = categoryRepository.save(Category.builder()
//                .uid("M001C001")
                .name("테스트1")
                .icon("test")
                .url("/test")
                .orders(1L)
                .menu(menuRepository.findAll().get(0))
                .account(account)
                .build());

        Long updateId = savedCat.getId();
        String newName = "test22";

        CategoryUpdateRequestDto requestDto = CategoryUpdateRequestDto.builder()
                .name(newName)
                .icon("test")
                .url("/test")
                .orders(1L)
                .updater(account)
                .build();

        // when
        categoryService.update(updateId, requestDto, account);

        // then
        List<Category> all = categoryRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(newName);
    }

    @Test
    @DisplayName("카테고리 삭제")
    public void deleteCategory() {
        // given
        Account account = accountRepository.findAll().get(0);

        Category savedCat1 = categoryRepository.save(Category.builder()
//                .uid("M001C001")
                .name("테스트1")
                .icon("test")
                .url("/test")
                .orders(1L)
//                .showYn("Y")
                .menu(menuRepository.findAll().get(0))
                .account(account)
                .build());
        Category savedCat2 = categoryRepository.save(Category.builder()
//                .uid("M001C002")
                .name("테스트2")
                .icon("test2")
                .url("/test2")
                .orders(2L)
//                .showYn("Y")
                .menu(menuRepository.findAll().get(0))
                .account(account)
                .build());

        // when
        categoryService.delete(savedCat1.getId());

        // then
        List<Category> all = categoryRepository.findAll();
        assertThat(all.get(0).getShowYn()).isEqualTo("N");

//        List<CategoryDto> all2 = categoryService.getList();
//        assertThat(all2.size()).isEqualTo(1);
    }

}