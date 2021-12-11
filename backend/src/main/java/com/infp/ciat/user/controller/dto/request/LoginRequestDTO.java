package com.infp.ciat.user.controller.dto.request;

/***
 * 로그인 요청 DTO
 */
public class LoginRequestDTO {
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
}
