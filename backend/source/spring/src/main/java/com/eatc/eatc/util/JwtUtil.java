package com.eatc.eatc.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;

/**
 * 간단한 JWT 토큰 생성 유틸리티
 */
public class JwtUtil {
    // 애플리케이션이 실행되는 동안 사용하는 비밀키
    private static final Key KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    // 토큰 만료 시간(1시간)
    private static final long EXPIRATION_MS = 3600_000;

    /**
     * 주어진 사용자 ID로 JWT 토큰을 생성한다.
     */
    public static String generateToken(String userId) {
        Date now = new Date();
        Date exp = new Date(now.getTime() + EXPIRATION_MS);
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(KEY)
                .compact();
    }
}
