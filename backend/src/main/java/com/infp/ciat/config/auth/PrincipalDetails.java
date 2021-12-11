package com.infp.ciat.config.auth;

import com.infp.ciat.user.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/***
 * 인증정보 관리
 */
public class PrincipalDetails implements UserDetails, OAuth2User, Serializable {
  private Account account;
  private Map<String, Object> attributes;

  public PrincipalDetails(Account account) {
    this.account = account;
  }

  /***
   * ouath2 회원가입 생성자
   * @param account
   * @param attributes
   */
  public PrincipalDetails(Account account, Map<String, Object> attributes) {
    this.attributes = attributes;
    this.account = account;

  }

  public Account getAccount() {
    return account;
  }

  // OAuth2User 타입 Map으로 저장된다.
  @Override
  public Map<String, Object> getAttributes() {
    return attributes; // {id:~~~~, name:~~~~, email: ~~~~}
  }


  @Override
  public String getName() {
    return (String) attributes.get("name");
  }

  /***
   * role 리턴
   * @return
   */
  @Override
  public Collection<GrantedAuthority> getAuthorities() {
    Collection<GrantedAuthority> collect = new ArrayList<>();
    collect.add(new GrantedAuthority() {
      @Override
      public String getAuthority() {
        return account.getRole() + "";
      }
    });
    return collect;
  }

  @Override
  public String getPassword() {
    return account.getPassword();
  }

  @Override
  public String getUsername() {
    return account.getEmail();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
