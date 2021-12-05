package com.infp.ciat.user.controller.dto.request;

import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.entity.Role;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class SignupRequestDTO {

    @NotEmpty(message = "이메일은 필수 입력값입니다")
    @Email(message = "이메일 형식에 맞지 않습니다")
    private String email;

    @NotEmpty
    @Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*\\W)(?=\\S+$).{8,20}",
            message = "비밀번호는 영문자와 숫자, 특수기호가 적어도 1개 이상 포함된 8자~20자의 비밀번호여야 합니다.")
    private String password;

    @NotEmpty(message = "이메일은 필수 입력값입니다")
    private String nickname;

    private String provider;

    private String providerId;

    @Builder
    public SignupRequestDTO(String email, String password, String nickname, String provider, String providerId) {
      this.email = email;
      this.password = password;
      this.nickname = nickname;
      this.provider = provider;
      this.providerId = providerId;
    }

  public Account toEntity() {
      return Account.builder()
        .email(email)
        .password(password)
        .nickname(nickname)
        .provider(provider)
        .providerId(providerId)
        .role(Role.ROLE_USER)
        .build();
    }

}
