package com.infp.ciat.user.service;

import com.infp.ciat.user.controller.dto.request.SignupRequestDTO;
import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ActiveProfiles;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Transactional
class AccountServiceTest {

  @Autowired
  AccountService accountService;

  @Autowired
  AccountRepository accountRepository;

  @Autowired
  PasswordEncoder passwordEncoder;

  @BeforeAll
  public static void beforeAll() {
    String jasypt_password = System.getenv("jasypt.encryptor.password");
    System.setProperty("jasypt.encryptor.password", jasypt_password);
  }

  @AfterEach
  public void aftereach() {
    try {
      accountRepository.deleteAllInBatch();
    } catch (Exception e){
      // hibernate error 무시
    }
  }


  @Test
  void 회원가입() {

    String email = "test@test.com";
    String password = "test_password";
    String nickname = "test_nickname";


    //given
    SignupRequestDTO signupRequestDTO = SignupRequestDTO.builder()
      .email(email)
      .password(password)
      .nickname(nickname)
      .build();

    //when
    accountService.signUp(signupRequestDTO);
    List<Account> all = accountRepository.findAll();

    //then
    assertThat(all.get(0).getEmail()).isEqualTo(email);
    assertThat(passwordEncoder.matches(password, all.get(0).getPassword())).isTrue();
    assertThat(all.get(0).getNickname()).isEqualTo(nickname);
  }
}
