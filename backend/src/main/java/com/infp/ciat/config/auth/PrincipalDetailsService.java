package com.infp.ciat.config.auth;

import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.repository.AccountRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PrincipalDetailsService implements UserDetailsService {

  @Autowired
  private AccountRepository accountRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    Account accountEntity = accountRepository.findByEmail(email);

    if (accountEntity != null) {
      return new PrincipalDetails(accountEntity);
    }

    throw new UsernameNotFoundException("회원이 존재하지 않습니다 -> " + email);
  }

}
