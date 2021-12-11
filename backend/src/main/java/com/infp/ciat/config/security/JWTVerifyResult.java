package com.infp.ciat.config.security;

import lombok.Builder;
import lombok.NoArgsConstructor;

/***
 * JWT 유효성검사 결과
 */
@NoArgsConstructor
public class JWTVerifyResult {
    private String user;
    private boolean status;

    @Builder
    public JWTVerifyResult(String user, boolean status) {
        this.user = user;
        this.status = status;
    }

    public String getUser() {
        return user;
    }

    public boolean isStatus() {
        return status;
    }
}
