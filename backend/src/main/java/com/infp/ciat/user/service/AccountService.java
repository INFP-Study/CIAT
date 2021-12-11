package com.infp.ciat.user.service;

import com.infp.ciat.common.exceptions.UserExistException;
import com.infp.ciat.user.controller.dto.request.SignupRequestDTO;
import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
@Slf4j
public class AccountService {
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    /***
     * 회원가입서비스
     *  Role은 default로 USER
     * @param requestdto
     */
    @Transactional
    public Long signUp(SignupRequestDTO requestdto) throws UserExistException {

        // 회원중복 검사
        Optional<Account> find_user = accountRepository.findByEmail(requestdto.getEmail());
        if(find_user.isPresent()) {
            // todo Exception 정의
            log.error(String.format("[회원가입 실패] 이미 %s 회원이 존재합니다", requestdto.getEmail()));
            throw new UserExistException("이미 고객님은 회원가입이 되어 있습니다.");
        }

        requestdto.setPassword(passwordEncoder.encode(requestdto.getPassword()));
        Account accountEntity = requestdto.toEntity();

        return accountRepository.save(accountEntity).getId();
    }

    /***
     * id로 회원검색
     * @param id
     * @return
     */
    public Account findUserById(Long id){
        return accountRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("회원이 존재하지 않습니다"));
    }

    /***
     * email으로 회원검색
     * @param email
     * @return Optional
     */
    public Optional<Account> findUserByEmailOrNull(String email){
        return accountRepository.findByEmail(email);
    }
}
