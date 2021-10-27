package com.infp.ciat.user.service;

import com.infp.ciat.user.controller.dto.request.SignupRequestDTO;
import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
@Slf4j
public class AccountService {

    private final AccountRepository accountRepository;

    private final PasswordEncoder passwordEncoder;



    /***
     * 회원가입서비스
     *  회원중복검사는 JPA가 수행하여 생략
     *  Role은 default로 USER
     * @param requestdto
     */
    @Transactional
    public Long signUp(SignupRequestDTO requestdto){

      requestdto.setPassword(passwordEncoder.encode(requestdto.getPassword()));
      Account accountEntity = requestdto.toEntity();

      return accountRepository.save(accountEntity).getId();
    }

}
