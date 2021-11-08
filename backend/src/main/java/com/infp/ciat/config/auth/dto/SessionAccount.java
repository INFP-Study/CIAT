package com.infp.ciat.config.auth.dto;


import com.infp.ciat.user.entity.Account;
import lombok.Getter;

import java.io.Serializable;

/**
 * 직렬화 기능을 가진 세션 Dto
 * 유저 정보를 세션에 등록하기 위한 객체
 * 인증된 사용자 정보만 필요하다.
 */
@Getter
public class SessionAccount implements Serializable {

  private String nickname;
  private String email;
  // 비밀번호??

  public SessionAccount(Account account) {
    this.nickname = account.getNickname();
    this.email = account.getEmail();
  }
}
