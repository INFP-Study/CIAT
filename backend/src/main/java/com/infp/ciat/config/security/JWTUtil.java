package com.infp.ciat.config.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

@Component
public class JWTUtil {
    private String secret;
    private Algorithm AL;
    private long lifetime;
    private String issuer = "Springsecurity";
    private String timezone = "Asia/Seoul";

    /***
     * 생성자 주입
     * @param secret
     * @param lifetime
     */
    @Autowired
    public JWTUtil(
            @Value("${jwt.secret}") String secret,
            @Value("${jwt.lifetime}") long lifetime
    ) {
        this.secret = secret;
        this.AL = Algorithm.HMAC512(secret);
        this.lifetime = lifetime;
    }

    public Algorithm getAL() {
        return AL;
    }

    /***
     * JWT 토큰 생성
     * @param userId
     * @return
     */
    public String GenerateToken(String userId){
        ZonedDateTime now = GetNow();

        return JWT.create()
                .withIssuer(issuer)
                .withSubject(issuer)
                .withIssuedAt(FromZonedatetimeToDate(now))
                .withExpiresAt(FromZonedatetimeToDate(CaculateExpired(now)))
                .sign(AL);
    }

    /***
     * 시간계산
     * @param issuedat
     */
    private ZonedDateTime CaculateExpired(ZonedDateTime issuedat) {
        return issuedat.plus(lifetime, ChronoUnit.HOURS);
    }

    /***
     * 현재시간 조회(UTC+9)
     * @return ZoneDateTime
     */
    private ZonedDateTime GetNow() {
        return ZonedDateTime.now(ZoneId.of(timezone));
    }

    /***
     * 시간타입 변환(ZoneDateTime -> Date)
     * @param zonedDateTime
     * @return Date
     */
    private Date FromZonedatetimeToDate(ZonedDateTime zonedDateTime) {
        return Date.from(
            Instant.from(
                zonedDateTime
                        .toInstant()
                        .atZone(ZoneId.of(timezone)
                ))
        );
    }
}
