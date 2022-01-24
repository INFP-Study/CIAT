package com.infp.ciat.user.controller.dto.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ResetPasswordRequestDTO {

    private String email;

    @Builder
    public ResetPasswordRequestDTO(String email) {
        this.email = email;
    }
}
