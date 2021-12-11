package com.infp.ciat.config.security.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.core.GrantedAuthority;
import java.time.Instant;
import java.util.Collection;
import java.util.stream.Collectors;

public class JWTUtils {
    private String secret_key = "sample";
    private Algorithm AL = Algorithm.HMAC512(secret_key);
    private long lifetime = 30;

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
        try{
            DecodedJWT decode = JWT.require(AL).build().verify(token);
            return JWTVerifyResult.builder()
                      .user(decode.getSubject())
                      .status(true)
                      .build();
        }catch(JWTVerificationException ex) {
            DecodedJWT decode = JWT.decode(token);
            return JWTVerifyResult.builder()
                    .user(decode.getSubject())
                    .status(false)
                    .build();
        }
    }
}
