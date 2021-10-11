package com.infp.ciat.user.controller.dto;

import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.entity.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/***
 * 스프링시큐리티가 인식하는 UserContext로 변환
 */
public class AccountContext extends User {
    public AccountContext(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    public static AccountContext FromAccountToAccountContext(Account account) {
        return new AccountContext(
                account.getEmail(),
                account.getPassword(),
                parseAuthorities(account.getRole())
        );
    }

    /***
     * role을 collection으로 변환
     * @param role
     * @return
     */
    private static List<SimpleGrantedAuthority> parseAuthorities(Role role){
        return Arrays.asList(role).stream()
                .map(r -> new SimpleGrantedAuthority(r.getRole()))
                .collect(Collectors.toList());
    }
}
