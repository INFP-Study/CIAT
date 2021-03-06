package com.infp.ciat.category.service;

import com.infp.ciat.category.controller.dto.*;
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
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private MenuRepository menuRepository;

//    @BeforeAll
//    public static void beforeAll() {
//        String jasypt_password = System.getenv("jasypt.encryptor.password");
//        System.setProperty("jasypt.encryptor.password", jasypt_password);
//    }

    @BeforeEach
    void createAccount() {
        SignupRequestDTO signupRequestDTO = SignupRequestDTO.builder()
                .email("test@test.com")
                .password("test_password")
                .nickname("test_nickname")
                .build();

        //when
        accountService.signUp(signupRequestDTO);
    }

    @AfterEach
    void tearDown() {
        menuRepository.deleteAll();
        accountRepository.deleteAll();
    }

    @Test
    @DisplayName("?????? ??????")
    public void createMenu() {
        // given
        String uid = "M001";
        String name = "test menu";
        String icon = "doc";
        String url = "https://www.naver.com";
        Long orders = 3L;
        Account account = accountRepository.findAll().get(0);

        MenuSaveRequestDto requestDto = MenuSaveRequestDto.builder()
//                .uid(uid)
                .name(name)
                .icon(icon)
                .url(url)
                .orders(orders)
                .account(account)
                .build();

        // when
        MenuDto newMenu = menuService.create(requestDto, account);
        System.out.println(newMenu);

        // then
        List<Menu> all = menuRepository.findAll();

//        assertThat(all.get(0).getUid()).isEqualTo(uid);
        assertThat(all.get(0).getName()).isEqualTo(name);
        assertThat(all.get(0).getIcon()).isEqualTo(icon);
        assertThat(all.get(0).getUrl()).isEqualTo(url);
        assertThat(all.get(0).getOrders()).isEqualTo(orders);
    }

    @Test
    @DisplayName("?????? ?????? ??????")
    public void getMenuList() {
        // given
        Account account = accountRepository.findAll().get(0);

        MenuSaveRequestDto requestDto = MenuSaveRequestDto.builder()
//                .uid("M001")
                .name("?????????1")
                .icon("test")
                .url("/test")
                .orders(1L)
                .account(account)
                .build();
        MenuSaveRequestDto requestDto2 = MenuSaveRequestDto.builder()
//                .uid("M001")
                .name("?????????2")
                .icon("test2")
                .url("/test2")
                .orders(2L)
                .account(account)
                .build();

        menuService.create(requestDto, account);
        menuService.create(requestDto2, account);

        // when
        List<MenuDto> all = menuService.getList();

        // then
        assertThat(all.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("?????? ?????? ??????")
    public void getOneMenu() {
        // given
        String uid = "M001";
        String name = "?????????1";
        String icon = "test";
        String url = "/test";
        Long orders = 1L;

        Account account = accountRepository.findAll().get(0);

        Menu savedMenu = menuRepository.save(MenuSaveRequestDto.builder()
//                .uid(uid)
                .name(name)
                .icon(icon)
                .url(url)
                .orders(orders)
                .account(account)
                .build()
                .toEntity());

        // when
        MenuDto detail = menuService.getDetail(savedMenu.getId());

        // then
//        assertThat(detail.getUid()).isEqualTo(uid);
        assertThat(detail.getName()).isEqualTo(name);
        assertThat(detail.getIcon()).isEqualTo(icon);
        assertThat(detail.getUrl()).isEqualTo(url);
        assertThat(detail.getOrders()).isEqualTo(orders);
    }

    @Test
    @DisplayName("?????? ??????")
    public void updateMenu() {
        // given
        Account account = accountRepository.findAll().get(0);

        Menu savedMenu = menuRepository.save(MenuSaveRequestDto.builder()
//                .uid("M001")
                .name("?????????1")
                .icon("test")
                .url("/test")
                .orders(1L)
                .account(account)
                .build()
                .toEntity());

        Long updateId = savedMenu.getId();
        String newName = "test22";

        MenuUpdateRequestDto requestDto = MenuUpdateRequestDto.builder()
                .name(newName)
                .icon("test")
                .url("/test")
                .orders(1L)
                .build();

        // when
        menuService.update(updateId, requestDto, account);

        // then
        List<Menu> all = menuRepository.findAll();
        assertThat(all.get(0).getName()).isEqualTo(newName);
    }

    @Test
    @DisplayName("?????? ??????")
    public void deleteMenu() {
        // given
        Account account = accountRepository.findAll().get(0);

        Menu savedMenu1 = menuRepository.save(MenuSaveRequestDto.builder()
//                .uid("M001")
                .name("?????????1")
                .icon("test")
                .url("/test")
                .orders(1L)
                .account(account)
                .build()
                .toEntity());
        Menu savedMenu2 = menuRepository.save(MenuSaveRequestDto.builder()
//                .uid("M002")
                .name("?????????2")
                .icon("test2")
                .url("/test2")
                .orders(2L)
                .account(account)
                .build()
                .toEntity());

        // when
        System.out.println("???????????? ???????????????.");
        menuService.delete(savedMenu1.getId());
        // then
        List<Menu> all = menuRepository.findAll();
        assertThat(all.get(0).getShowYn()).isEqualTo("N");

        List<Menu> all2 = menuRepository.findAllNotDeleted();
        assertThat(all2.size()).isEqualTo(1);

//        ResponseStatusException exception = assertThrows(ResponseStatusException.class, () -> menuService.delete(savedMenu2.getId()));
//        assertThat(exception.getStatus()).isEqualTo(HttpStatus.NOT_ACCEPTABLE);
    }

    @Test
    @DisplayName("?????? ??? ???????????? ???????????? ??????")
    public void getMenuAndCatInOrder() {
        System.out.println("???????????? ???????????????.");

        // given
        Account account = accountRepository.findAll().get(0);

        MenuSaveRequestDto requestDto = MenuSaveRequestDto.builder()
//                .uid("M001")
                .name("hello")
                .icon("icon")
                .url("/url")
                .orders(2L)
                .account(account)
                .build();
        MenuSaveRequestDto requestDto2 = MenuSaveRequestDto.builder()
//                .uid("M002")
                .name("hello2")
                .icon("icon")
                .url("/url")
                .orders(1L)
                .account(account)
                .build();
        menuRepository.save(requestDto.toEntity());
        menuRepository.save(requestDto2.toEntity());

        // when
        System.out.println(menuRepository.findAll().size());
        List<MenuDto> list = menuService.getList();

        System.out.println("list size : " + list.size());

        // then
        assertThat(list.get(0).getName()).isEqualTo("hello2");
        assertThat(list.get(1).getName()).isEqualTo("hello");
    }
}
