package com.infp.ciat.config.security;

import lombok.NoArgsConstructor;

/***
 * 로그인 요청 dto
 */
@NoArgsConstructor
public class RequestLoginDTO {
    private String email;
    private String password;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RequestLoginDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
