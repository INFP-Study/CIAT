package com.infp.ciat.config.auth;

import com.infp.ciat.user.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;

public class PrincipalDetails implements UserDetails {

  private Account account;

  public PrincipalDetails(Account account) {
    this.account = account;
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
