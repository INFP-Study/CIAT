package com.infp.ciat.config.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class JWTUtils {
    private String secret_key;
    private Algorithm AL;
    private long lifetime;

  public JWTUtils(@Value("${jwt.secret}")String secret_key) {
    this.secret_key = secret_key;
    this.AL =  Algorithm.HMAC512(secret_key);
    // 10분
    this.lifetime = 600;
  }

  /***
     * jwt 토큰 생성
     * @param username
     * @return
     */
    public String generate(String username, Collection<GrantedAuthority> roles){
        return JWT.create()
                .withSubject(username)
                .withClaim("exp", Instant.now().getEpochSecond() + lifetime)
                .withClaim("roles", roles.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                .sign(AL);
    }

    /***
     * JWT유효성 검사
     * @param token
     * @return
     */
    public JWTVerifyResult verify(String token){
        DecodedJWT decode = JWT.require(AL).build().verify(token);
        return JWTVerifyResult.builder()
                .user(decode.getSubject())
                .build();
    }
}
