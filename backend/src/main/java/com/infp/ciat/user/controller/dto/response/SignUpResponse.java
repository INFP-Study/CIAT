package com.infp.ciat.user.controller.dto.response;

import lombok.Getter;

/***
 * 회원가입 성공 response body
 */
@Getter
public class SignUpResponse {
    private Long id;

    public SignUpResponse(Long id) {
        this.id = id;
    }
}
