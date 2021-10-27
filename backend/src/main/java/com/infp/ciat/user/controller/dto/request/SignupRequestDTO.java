package com.infp.ciat.user.controller.dto.request;

import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
public class SignupRequestDTO {

    @NotEmpty
    private String email;

    @NotEmpty
    private String password;

    @NotEmpty
    private String nickname;

    @Builder
    public SignupRequestDTO(String email, String password, String nickname) {
      this.email = email;
      this.password = password;
      this.nickname = nickname;
    }

  public Account toEntity() {
      return Account.builder()
        .email(email)
        .password(password)
        .nickname(nickname)
        .role(Role.ROLE_USER)
        .build();
    }

}
