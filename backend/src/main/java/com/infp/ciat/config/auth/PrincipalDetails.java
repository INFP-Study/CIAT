package com.infp.ciat.config.auth;

import com.infp.ciat.user.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

// Authentication 객체에 저장할 수 있는 유일한 타입
public class PrincipalDetails implements UserDetails, OAuth2User {

  private Account account;
  private Map<String, Object> attributes;

  public PrincipalDetails(Account account) {
    this.account = account;
  }

  public PrincipalDetails(Account account, Map<String, Object> attributes) {
    this.account = account;
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

  // account의 권한을 리턴한다.
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
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
