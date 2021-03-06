package com.infp.ciat.user.repository;

import com.infp.ciat.user.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

  // select * from account where email = ?
  Optional<Account> findByEmail(String email);
//  Optional<Account> findByName(String nickname);
}
