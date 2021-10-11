package com.infp.ciat.user.service;

import com.infp.ciat.user.controller.dto.AccountContext;
import com.infp.ciat.user.controller.dto.request.SignupRequestDTO;
import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.entity.Role;
import com.infp.ciat.user.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
@Slf4j
public class AccountService implements UserDetailsService {
    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    /***
     * 회원가입서비스
     *  회원중복검사는 JPA가 수행하여 생략
     *  Role은 default로 USER
     * @param requestdto
     */
    @Transactional
    public Long SignUp(SignupRequestDTO requestdto){
        Account new_account = Account.builder()
                .email(requestdto.getEmail())
                .nickname(requestdto.getNickname())
                .password(passwordEncoder.encode(requestdto.getPassword()))
                .role(Role.ROLE_USER)
                .build();

        return accountRepository.save(new_account).getId();
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account find_user = accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("사용자가 없습니다"));
        log.debug(String.format("%s 계정 로그인 시도", email));
        return AccountContext.FromAccountToAccountContext(find_user);
    }
}
