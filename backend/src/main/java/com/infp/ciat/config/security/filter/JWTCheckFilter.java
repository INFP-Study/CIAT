package com.infp.ciat.config.security.filter;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.google.gson.JsonObject;
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
import java.io.PrintWriter;
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

        JWTVerifyResult verify_result = null;
        try{
            verify_result = this.jwtUtils.verify(authorization.substring("Bearer ".length()));
        }catch(TokenExpiredException ex){
            log.error("[Auth]JWTtoken is expired");
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.setStatus(HttpStatus.UNAUTHORIZED.value());

            PrintWriter out = response.getWriter();
            JsonObject json = new JsonObject();
            json.addProperty("error", "JWT error");
            json.addProperty("error_deatils", "JWT token is expired");
            out.print(json);
            out.flush();
            return;
        }catch(JWTVerificationException ex){
            response.setContentType("application/json");
            response.setCharacterEncoding("utf-8");
            response.setStatus(HttpStatus.BAD_REQUEST.value());

            PrintWriter out = response.getWriter();
            JsonObject json = new JsonObject();
            json.addProperty("error", "JWT error");
            json.addProperty("error_deatils", "JWT Format is not unvalid");
            out.print(json);
            out.flush();
            return;
        }

        Optional<Account> user = accountService.findUserByEmailOrNull(verify_result.getUser());
        if(!user.isPresent()){
            log.error(String.format("[Auth]JWT Token is passed. but %s is not exist", verify_result.getUser()));
            throw new UsernameNotFoundException(String.format("%s is not exist. but try login", verify_result.getUser()));
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
    }
}
