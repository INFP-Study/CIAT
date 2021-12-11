package com.infp.ciat.config.security.filter;

import com.infp.ciat.config.auth.PrincipalDetails;
import com.infp.ciat.config.security.jwt.JWTUtils;
import com.infp.ciat.config.security.jwt.JWTVerifyResult;
import com.infp.ciat.user.entity.Account;
import com.infp.ciat.user.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.filter.OncePerRequestFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

/***
 * JWT인증 검사
 */
@Slf4j
public class JWTCheckFilter extends OncePerRequestFilter {
    private final AccountService accountService;
    private final AuthenticationManager authenticationManager;
    private final JWTUtils jwtUtils;

    public JWTCheckFilter(
            AuthenticationManager authenticationManager,
            AccountService accountService,
            JWTUtils jwtUtils)
    {
        this.accountService = accountService;
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain) throws ServletException, IOException
    {
        String authorization = request.getHeader("Authorization");
        if(authorization == null || !authorization.startsWith("Bearer")){
            filterChain.doFilter(request, response);
            return;
        }

        JWTVerifyResult verify_result = this.jwtUtils.verify(authorization.substring("Bearer ".length()));
        if(verify_result.isStatus()){
            Optional<Account> user = accountService.findUserByEmailOrNull(verify_result.getUser());
            if(!user.isPresent()){
                log.error("JWT토큰 검사는 성공했지만 계정이 존재하지 않음(계정이 삭제된 경우)");
                throw new UsernameNotFoundException("사용자가 존재하지 않습니다.");
            }

            // 스프링시큐리티 인증정보 초기화(인가설정 적용을 위해)
            PrincipalDetails principalDetails = new PrincipalDetails(user.get());
            UsernamePasswordAuthenticationToken auth_token = new UsernamePasswordAuthenticationToken(
                    principalDetails,
                    null,
                    principalDetails.getAuthorities()
            );
            SecurityContextHolder.getContext().setAuthentication(auth_token);
            filterChain.doFilter(request, response);
        }else {
            response.setStatus(HttpStatus.FORBIDDEN.value());
        }
    }
}
