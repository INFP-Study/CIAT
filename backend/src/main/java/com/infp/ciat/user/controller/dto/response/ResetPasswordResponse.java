package com.infp.ciat.user.controller.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResetPasswordResponse {

    private String email;

    private String originCode;

    @Builder
    public ResetPasswordResponse(String email, String originCode) {
        this.email = email;
        this.originCode = originCode;
    }
}
