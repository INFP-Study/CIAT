package com.infp.ciat.config.security.jwt;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/***
 * JWT 유효성검사 결과
 */
@Getter
@NoArgsConstructor
public class JWTVerifyResult {
    private String user;

    @Builder
    public JWTVerifyResult(String user) {
        this.user = user;
    }
}
