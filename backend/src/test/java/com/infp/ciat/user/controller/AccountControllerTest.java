package com.infp.ciat.user.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infp.ciat.user.controller.dto.request.SignupRequestDTO;
import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.repository.AccountRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AccountControllerTest {

  @LocalServerPort
  private int port;

  @Autowired
  private AccountRepository accountRepository;

  @Autowired
  private WebApplicationContext webApplicationContext;

  private MockMvc mockMvc;

  // 매번 테스트가 시작되기 전에 MockMvc 인스턴스를 생성한다
  @BeforeEach
  public void setUp() {
    mockMvc = MockMvcBuilders
      .webAppContextSetup(webApplicationContext)
      .apply(springSecurity())
      .build();
  }

  @BeforeAll
  public static void beforeAll() {
    String jasypt_password = System.getenv("jasypt.encryptor.password");
    System.setProperty("jasypt.encryptor.password", jasypt_password);
  }

  @Test
//  @WithMockUser(roles = "USER")
  public void signup() throws Exception {

    SignupRequestDTO requestDto = SignupRequestDTO.builder()
      .email("test00@test.com")
      .password("test00")
      .nickname("test00")
      .provider("test")
      .providerId("test")
      .build();

    String url = "http://localhost:" + port + "/api/v1/user/signup";

    // when
    // mvc.perform
    // 생성된 MockMvc를 통해 API를 테스트한다.
    mockMvc.perform(post(url)
        .contentType(MediaType.APPLICATION_JSON_UTF8)
        .content(new ObjectMapper().writeValueAsString(requestDto)))
      .andExpect(status().isCreated());

    List<Account> all = accountRepository.findAll();
    assertThat(all.get(0).getEmail()).isEqualTo("test00@test.com");
  }
}
