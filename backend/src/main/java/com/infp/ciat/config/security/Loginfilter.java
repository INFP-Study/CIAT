package com.infp.ciat.config.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/***
 * 커스텀 로그인 필터
 * 로그인이 성공하면 jwt토큰 발급
 */
@Slf4j
public class Loginfilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;

    public Loginfilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        ObjectMapper objectMapper = new ObjectMapper();
        RequestLoginDTO requestLoginDTO = objectMapper.readValue(request.getInputStream(), RequestLoginDTO.class);

        // 토큰 생성
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                requestLoginDTO.getEmail(),
                requestLoginDTO.getPassword()
        );

        // 인증 요청
        return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        log.debug("로그인 성공");
        // todo - jwt토큰 발급
    }

    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        log.debug("로그인 실패 -> 오류내용");
        log.debug(failed.toString());
        super.unsuccessfulAuthentication(request, response, failed);
    }
}
