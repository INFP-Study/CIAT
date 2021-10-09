package com.infp.ciat.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infp.ciat.user.controller.dto.request.SignupRequestDTO;
import com.infp.ciat.user.repository.AccountRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class LoginfilterTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    AccountRepository accountRepository;

    @AfterEach
    public void AfterEach() {
        accountRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("회원가입 후 로그인")
    public void SignUp() throws Exception {
        SignupRequestDTO signup_requestdto1 = create_signup_requestdto("test1@test.com", "test1", "password");

        mockMvc.perform(
                post("/signup")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(signup_requestdto1))
                )
                .andExpect(status().isCreated())
                .andDo(print());

        RequestLoginDTO requestLoginDTO1 = new RequestLoginDTO(signup_requestdto1.getEmail(), signup_requestdto1.getPassword());

        mockMvc.perform(
                post("/signin")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(requestLoginDTO1))
                )
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    @DisplayName("회원가입 후 로그인, jwt토큰 확인")
    public void SignUpAndPrintToken() throws Exception {
        SignupRequestDTO signup_requestdto1 = create_signup_requestdto("test1@test.com", "test1", "password");

        mockMvc.perform(
                post("/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(new ObjectMapper().writeValueAsString(signup_requestdto1))
        )
                .andExpect(status().isCreated())
                .andDo(print());

        RequestLoginDTO requestLoginDTO1 = new RequestLoginDTO(signup_requestdto1.getEmail(), signup_requestdto1.getPassword());

        MvcResult signin_result = mockMvc.perform(
                post("/signin")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(new ObjectMapper().writeValueAsString(requestLoginDTO1))
                )
                .andExpect(status().isOk())
                .andReturn();

        String authorization = signin_result.getResponse().getHeader("Authorization");
        assertNotNull(authorization);
        System.out.println("jwt token: " + authorization);
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