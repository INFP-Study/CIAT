package com.infp.ciat.user.service;

import com.infp.ciat.user.controller.dto.request.SignupRequestDTO;
import static org.junit.jupiter.api.Assertions.*;

import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.transaction.annotation.Transactional;


//@ExtendWith(SpringExtension.class)
@SpringBootTest(properties = "spring.config.location=classpath:application-test.yml")
@Transactional
class AccountServiceTest {

    @Autowired
    AccountService accountService;

    @Autowired
    AccountRepository accountRepository;

    @AfterEach
    public void aftereach() {
        try {
            accountRepository.deleteAllInBatch();
        } catch (Exception e){
            // hibernate error 무시
        }
    }

    @Test
    @DisplayName("한명 회원가입 테스트")
    public void signin_one(){
        SignupRequestDTO signup_requestdto = create_signup_requestdto("test1@test.com", "test1", "password");
        accountService.SignUp(signup_requestdto);

    }

    @Test
    @DisplayName("두명 회원가입 테스트")
    public void signin_two(){
        SignupRequestDTO signup_requestdto1 = create_signup_requestdto("test1@test.com", "test1", "password");
        accountService.SignUp(signup_requestdto1);

        SignupRequestDTO signup_requestdto2 = create_signup_requestdto("test2@test.com", "test2", "password");
//        assertThrows(DataIntegrityViolationException.class, () -> accountService.SignUp(signup_requestdto2));
        accountService.SignUp(signup_requestdto2);
    }

    @Test
    @DisplayName("중복 회원가입")
    public void signin_duplicate(){
        SignupRequestDTO signup_requestdto1 = create_signup_requestdto("test1@test.com", "test1", "password");
        accountService.SignUp(signup_requestdto1);

        SignupRequestDTO signup_requestdto2 = create_signup_requestdto("test1@test.com", "test1", "password");
        assertThrows(DataIntegrityViolationException.class, () -> accountService.SignUp(signup_requestdto2));
    }

    /***
     * 회원가입 요청 DTO 생성
     * @param email
     * @param nickname
     * @param password
     * @return
     */
    private SignupRequestDTO create_signup_requestdto(String email, String nickname, String password) {
        SignupRequestDTO signupRequestDTO = new SignupRequestDTO();
        signupRequestDTO.setEmail(email);
        signupRequestDTO.setNickname(nickname);
        signupRequestDTO.setPassword(password);

        return signupRequestDTO;
    }

}