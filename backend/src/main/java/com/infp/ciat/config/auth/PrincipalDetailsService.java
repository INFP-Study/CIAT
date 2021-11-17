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
    log.info(String.format("[loadUserByUsername]: request_email -> %s", email));
    Account accountEntity = accountRepository.findByEmail(email).get(); // Optional 로 변경했을 시에


    if(accountEntity == null) {
      throw new UsernameNotFoundException(String.format("회원이 존재하지 않습니다 -> " + email));
    }

    return new PrincipalDetails(accountEntity);
  }

}
