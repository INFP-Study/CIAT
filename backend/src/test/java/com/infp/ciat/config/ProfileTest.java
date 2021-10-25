package com.infp.ciat.config;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class ProfileTest {
    @Value("${jwt.secret}")
    private String jwt_secret;

    @Test
    @DisplayName("스프링프로파일 테스트")
    public void print() {
        System.out.println(jwt_secret);
    }

}
