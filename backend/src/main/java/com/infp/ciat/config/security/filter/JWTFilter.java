package com.infp.ciat.config.security.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.infp.ciat.config.auth.PrincipalDetails;
import com.infp.ciat.config.security.jwt.JWTUtils;
import com.infp.ciat.user.controller.dto.request.LoginRequestDTO;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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

@Slf4j
public class JWTFilter extends UsernamePasswordAuthenticationFilter {
    private final AuthenticationManager authenticationManager;
    private JWTUtils jwtUtils;

    public JWTFilter(AuthenticationManager authenticationManager, JWTUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        setFilterProcessesUrl("/api/v1/user/signin");
    }

    /***
     * 로그인을 시도하면 호출된다.
     * @param request
     * @param response
     * @return
     * @throws AuthenticationException
     */
    @SneakyThrows
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        ObjectMapper objectMapper = new ObjectMapper();
        LoginRequestDTO loginRequestDTO = objectMapper.readValue(request.getInputStream(), LoginRequestDTO.class);

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                loginRequestDTO.getEmail(),
                loginRequestDTO.getPassword()
        );

        return authenticationManager.authenticate(usernamePasswordAuthenticationToken);
    }

    /***
     * 로그인 성공응답
     * @param request
     * @param response
     * @param chain
     * @param authResult
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        PrincipalDetails user = (PrincipalDetails) authResult.getPrincipal();
        log.info("[Auth]login success. username: " + user.getUsername());

        String jwt_token = this.jwtUtils.generate(
                user.getUsername(),
                user.getAuthorities()
        );

        response.addHeader("Authorization", "Bearer " + jwt_token);
        response.setStatus(HttpStatus.OK.value());
    }

    /***
     * 로그인 실패응답
     * @param request
     * @param response
     * @param failed
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        log.error("[Auth]login failed: " + failed.toString());
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}
