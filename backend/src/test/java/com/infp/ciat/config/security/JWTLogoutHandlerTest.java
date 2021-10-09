package com.infp.ciat.config.security;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
class JWTLogoutHandlerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("로그아웃 API 호출")
    public void Logout() throws Exception {
        mockMvc.perform(post("/logout"))
                .andExpect(status().isOk());
    }
}